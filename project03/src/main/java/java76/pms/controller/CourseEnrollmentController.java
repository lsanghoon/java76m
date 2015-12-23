package java76.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.CourseEnrollment;
import java76.pms.service.support.DefaultCourseEnrollmentService;

@Controller
@RequestMapping("/enroll/*")
public class CourseEnrollmentController {

	@Autowired DefaultCourseEnrollmentService enrollService;

	@RequestMapping("list")
	public String list(Model model) throws Exception {

		List<CourseEnrollment> list = enrollService.getEnrollmentList();

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

		enrollService.enroll(enroll);

		return "redirect:list.do";

	}
	@RequestMapping("detail")
	public String detail(
			String email,
			Model model) throws Exception {

		CourseEnrollment enroll = enrollService.retrieveByEmail(email);
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

		enrollService.change(enroll);

		return "redirect:list.do";
	}

	@RequestMapping("delete")
	public String delete(String email) throws Exception {
		enrollService.remove(email);
		return "redirect:list.do";
	}

	@RequestMapping("reject")
	public String reject(String email) throws Exception {
		enrollService.reject(email);
		return "redirect:list.do";
	}

	@RequestMapping("approve")
	public String approve(String email) throws Exception {
		enrollService.approve(email);
		return "redirect:list.do";
	}
}

// 여러개의 작업을 한 단위로 묶어서 다뤄야 할 경우
// ----------
// (data manipulation작업) => insert, update, delete
// 수강신청 -> 승인 -> 수강신청 상태변경
// 							 -> 학생 테이블에 입력
//								  한 단위 = Transaction
