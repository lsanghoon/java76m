package java76.pms.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java76.pms.dao.CourseEnrollmentDao;
import java76.pms.domain.CourseEnrollment;
import java76.pms.domain.Student;

@Service
public class CourseEnrollmentService {
	@Autowired StudentService studentService;
	@Autowired CourseEnrollmentDao enrollDao;

	@Autowired PlatformTransactionManager txManager;

	public void enroll(CourseEnrollment enroll) {
		enrollDao.insert(enroll);
	}

	public void change(CourseEnrollment enroll) {
		enrollDao.update(enroll);
	}

	public void remove(String email) {
		enrollDao.delete(email);
	}

	public CourseEnrollment retrieveByEmail(String email) {
		return enrollDao.selectOne(email);
	}

	public List<CourseEnrollment> getEnrollmentList() {
		return enrollDao.selectList();
	}

	public void reject(String email) {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		paramMap.put("status", CourseEnrollment.STATUS_REJECT);

		enrollDao.updateForStatus(paramMap);
	}

	public void approve(String email) {
		DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
		txDef.setName("t1");	
		txDef.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(txDef);
		try {
			HashMap<String,Object> paramMap = new HashMap<>();
			paramMap.put("email", email);
			paramMap.put("status", CourseEnrollment.STATUS_APPROVE);

			enrollDao.updateForStatus(paramMap);

			CourseEnrollment enroll = enrollDao.selectOne(email);

			Student student = new Student();
			student.setEmail(enroll.getEmail());
			student.setName(enroll.getName());
			student.setTel(enroll.getTel());

			studentService.register(student);
			txManager.commit(txStatus);

		} catch (Exception e) {
			// 예외가 발생한다면, 트랜잭션에 묶인 작업을 모두 취소한다.
			txManager.rollback(txStatus);
		}
	}
}
