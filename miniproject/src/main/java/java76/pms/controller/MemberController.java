package java76.pms.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.dao.MemberDao;
import java76.pms.domain.Member;
import java76.pms.util.MultipartHelper;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	public static final String SAVED_DIR = "/file";
	
	@Autowired MemberDao memberDao;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public String list(
			Model model) throws Exception {

		List<Member> members = memberDao.selectList();

		model.addAttribute("members", members);

		return "member/MemberList";

	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {

		return "member/MemberAdd";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(Member member) throws Exception {
		
		
		member.setPhoto(null);
		memberDao.insert(member);

		return "redirect:../article/list.do";

	}

	@RequestMapping("detail")
	public String detail(
			String email,
			Model model,
			HttpSession session) throws Exception {

		System.out.println(email);
		Member member = memberDao.selectOne(email);
		model.addAttribute("member", member);

		return "member/MemberDetail";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String post(
			Member member,
			MultipartFile photofile,
			Model model) throws Exception {

		if (photofile.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename());  
			File attachfile = new File(
					servletContext.getRealPath(SAVED_DIR) + "/" + newFileName);
			
			photofile.transferTo(attachfile);
			member.setPhoto(newFileName);

		} else if (member.getPhoto().length() == 0) {
			member.setPhoto(null);
		}

		if (memberDao.update(member) <= 0) {
			model.addAttribute("errorCode", "401");
			return "member/MemberAuthError";
		} 

		return "redirect:../article/list.do";
	}

	@RequestMapping("delete")
	public String delete(
			HttpSession session,
			String email,
			Model model) throws Exception {

		if (memberDao.delete(email) <= 0) {
			model.addAttribute("errorCode", "401");
			return "member/MemberAuthError";
		}
		session.invalidate();
		return "redirect:../article/list.do";
	}
	
}
