package java76.pms.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.domain.Student;
import java76.pms.service.StudentService;
import java76.pms.util.MultipartHelper;
import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/student/*")
public class StudentController {
	public static final String SAVED_DIR = "/file";
	
	@Autowired StudentService studentService;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public String list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="10") int pageSize,
			@RequestParam(defaultValue="email") String keyword,
			@RequestParam(defaultValue="asc") String align,
			Model model) throws Exception {

		List<Student> students = studentService.getStudentList(pageNo,pageSize,keyword,align);

		model.addAttribute("students", students);

		return "student/StudentList";

	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "student/StudentForm";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			Student student,
			MultipartFile photofile) throws Exception {

		if (photofile.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename());  
			File attachfile = new File(
					servletContext.getRealPath(SAVED_DIR) + "/" + newFileName);

			photofile.transferTo(attachfile);
			student.setPhoto(newFileName);

			makeThumbnailImage(
					servletContext.getRealPath(SAVED_DIR) + "/" + newFileName, 
					servletContext.getRealPath(SAVED_DIR) + "/s-" + newFileName);
		}

		studentService.register(student);

		return "redirect:list.do";

	}

	@RequestMapping("detail")
	public String detail(
			String email,
			Model model) 
					throws Exception {

		Student student = studentService.retrieve(email);
		model.addAttribute("student", student);

		return "student/StudentDetail";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String post(
			Student student,
			MultipartFile photofile,
			Model model) throws Exception {

		if (photofile.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename());  
			File attachfile = new File(
					servletContext.getRealPath(SAVED_DIR) + "/" + newFileName);
			
			photofile.transferTo(attachfile);
			student.setPhoto(newFileName);
			
			makeThumbnailImage(
					servletContext.getRealPath(SAVED_DIR) + "/" + newFileName, 
					servletContext.getRealPath(SAVED_DIR) + "/s-" + newFileName);

		} else if (student.getPhoto().length() == 0) {
			student.setPhoto(null);
		}

		studentService.change(student);

		return "redirect:list.do";
	}

	@RequestMapping("delete")
	public String delete(
			String email,
			Model model) throws Exception {

		studentService.remove(email);

		return "redirect:list.do";
	}

	private void makeThumbnailImage(String originPath, String thumbPath) 
			throws IOException {
		Thumbnails.of(new File(originPath))
		.size(60,60)
		.outputQuality(1.0)
		.toFile(new File(thumbPath));
	}

}
