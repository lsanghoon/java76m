package java76.pms.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.dao.CourseEnrollmentDao;
import java76.pms.dao.StudentDao;
import java76.pms.domain.CourseEnrollment;
import java76.pms.domain.Student;

@Controller
@RequestMapping("/enroll/*")
public class CourseEnrollmentController {

	@Autowired CourseEnrollmentDao enrllDao;
	@Autowired StudentDao studentDao;

	@Autowired PlatformTransactionManager txManager;

	@RequestMapping("list")
	public String list(Model model) throws Exception {

		List<CourseEnrollment> list = enrllDao.selectList();

		model.addAttribute("enrolls", list);

		return "enroll/EnrollList";

	}

	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "enroll/EnrollForm";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			String name,
			String email,
			String tel) throws Exception {

		CourseEnrollment enroll = new CourseEnrollment();
		enroll.setName(name);
		enroll.setEmail(email);
		enroll.setTel(tel);

		enrllDao.insert(enroll);

		return "redirect:list.do";

	}
	@RequestMapping("detail")
	public String detail(
			String email,
			Model model) throws Exception {

		CourseEnrollment enroll = enrllDao.selectOne(email);
		model.addAttribute("enroll", enroll);

		return "enroll/EnrollDetail";
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String post(
			String name,
			String email,
			String tel) throws Exception {

		CourseEnrollment enroll = new CourseEnrollment();
		enroll.setName(name);
		enroll.setEmail(email);
		enroll.setTel(tel);

		enrllDao.update(enroll);

		return "redirect:list.do";
	}

	@RequestMapping("delete")
	public String delete(
			String email,
			Model model) throws Exception {

		enrllDao.delete(email);
		return "redirect:list.do";
	}

	@RequestMapping("reject")
	public String reject(String email) throws Exception {

		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		paramMap.put("status", CourseEnrollment.STATUS_REJECT);
		enrllDao.updateForStatus(paramMap);

		return "redirect:list.do";
	}

	@RequestMapping("approve")
	public String approve(String email) throws Exception {
		// 트랜잭션 관리정책을 정의한다.
		DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
		// => 트랜잭션 이름 설정
		txDef.setName("t1");	
		// => 트랜잭션 사용 정책 설정 :
		// 		예) PROPAGATION_REQUIRED : 필수 사용으로 설정.
		txDef.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		// 트랜젝션 관리자로부터 트랜잭션 상태 정보를 다루는 도구를 얻는다.
		TransactionStatus txStatus = txManager.getTransaction(txDef);
		try {
			// 수강신청 정보를 승인 상태로 변경한다
			HashMap<String,Object> paramMap = new HashMap<>();
			paramMap.put("email", email);
			paramMap.put("status", CourseEnrollment.STATUS_APPROVE);
			enrllDao.updateForStatus(paramMap);

			CourseEnrollment enroll = enrllDao.selectOne(email);

			// 수강 신청자 정보를 학생 테이블에 입력한다.
			Student student = new Student();
			student.setEmail(enroll.getEmail());
			student.setName(enroll.getName()/* + "12345678901234567890"*/);
			student.setTel(enroll.getTel());

			studentDao.insert(student);
			
			// 작업을 정상적으로 수행했다면 트랜잭션에 묶인 작업 반영하라.
			// => 임시 DB에 저장되어 있는 작업 결과를 실제 DB로 옮긴다.
			txManager.commit(txStatus);
			
		} catch (Exception e) {
			// 예외가 발생한다면, 트랜잭션에 묶인 작업을 모두 취소한다.
			txManager.rollback(txStatus);
		}
		return "redirect:list.do";
	}
}

// 여러개의 작업을 한 단위로 묶어서 다뤄야 할 경우
// ----------
// (data manipulation작업) => insert, update, delete
// 수강신청 -> 승인 -> 수강신청 상태변경
// 							 -> 학생 테이블에 입력
//								  한 단위 = Transaction
