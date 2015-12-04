package java76.pms.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.annotation.RequestMapping;
import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;
import java76.pms.util.MultipartHelper;
import net.coobird.thumbnailator.Thumbnails;

@Component
public class StudentController {
	public static final String SAVED_DIR = "/file";
	@Autowired StudentDao studentDao;

	@RequestMapping("/student/list.do")
	public String list(int pageNo, int pageSize, String keyword, String align,
			HttpServletRequest request) throws Exception {

		if (pageNo < 0)	pageNo = 1;
		if (pageSize < 0) pageSize = 10;
		if (keyword == null) keyword = "no";
		if (align == null) align = "desc";

		List<Student> students = 
				studentDao.selectList(pageNo, pageSize, keyword, align);
		request.setAttribute("students", students);

		return	"/student/StudentList.jsp";
	}

	@RequestMapping("/student/add.do")
	public String add(
			String name, 
			String email, 
			String tel, 
			String cid,
			FileItem photofile,
			String password,
			HttpServletRequest request) throws Exception {

		String newFileName = null;

		if (photofile != null) {
			newFileName = MultipartHelper.generateFilename(photofile.getName());  
			ServletContext servletContext = request.getServletContext();
			File attachfile = new File(
					servletContext.getRealPath(SAVED_DIR) + "/" + newFileName);
			photofile.write(attachfile);
			
			//썸네일
			Thumbnails
			.of(attachfile.getPath())
			.outputQuality(1.0)
			.size(60,60)
			.toFile(servletContext.getRealPath(SAVED_DIR) + "/thumbnail/s-" + newFileName);
		}

		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setTel(tel);
		student.setCid(cid);
		student.setPhoto(newFileName);
		student.setPassword(password);

		studentDao.insert(student);

		return "redirect:list.do";
	}

	@RequestMapping("/student/detail.do")
	public String detail(int no,	HttpServletRequest request) throws Exception {

		Student student = studentDao.selectOne(no);

		request.setAttribute("student", student);
		return "/student/StudentDetail.jsp";

	}

	@RequestMapping("/student/update.do")
	public String update(
			int no,	
			String name, 
			String email, 
			String tel, 
			String cid,	
			String photoFile,	
			FileItem photo,	
			HttpServletRequest request) throws Exception {

		String newFileName = null;

		if (photo != null) {
			newFileName = MultipartHelper.generateFilename(photo.getName());  
			ServletContext servletContext = request.getServletContext();
			File attachfile = new File(
					servletContext.getRealPath(SAVED_DIR) + "/" + newFileName);
			photo.write(attachfile);
			
			Thumbnails
			.of(attachfile.getPath())
			.outputQuality(1.0)
			.size(60,60)
			.toFile(servletContext.getRealPath(SAVED_DIR) + "/thumbnail/s-" + newFileName);
		}

		Student student = new Student();
		student.setNo(no);
		student.setName(name);
		student.setEmail(email);
		student.setTel(tel);
		student.setCid(cid);

		if (newFileName != null) {
      student.setPhoto(newFileName);
    } else if (newFileName == null && photoFile.length() > 0) {
      student.setPhoto(photoFile);
    }
		

		if (studentDao.update(student) <= 0) {
			request.setAttribute("errorCode", "401");
			return "/student/StudentAuthError.jsp";
		}

		return "redirect:list.do";
	}

	@RequestMapping("/student/delete.do")
	public String delete(int no, HttpServletRequest request) throws Exception {

		if(studentDao.delete(no) <= 0) {
			request.setAttribute("errorCode", "401");
			return "/student/StudentAuthError.jsp";
		}

		return "redirect:list.do";
	}
}
