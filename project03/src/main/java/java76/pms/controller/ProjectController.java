package java76.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java76.pms.domain.Project;
import java76.pms.service.support.DefaultProjectService;

@Controller
@RequestMapping("/project/*")
public class ProjectController {  
	@Autowired DefaultProjectService projectService;

	@RequestMapping("list")
	public String list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="10") int pageSize,
			@RequestParam(defaultValue="no") String keyword,
			@RequestParam(defaultValue="desc") String align,
			Model model) throws Exception {

		List<Project> projects = projectService.getProjectList(pageNo, pageSize, keyword, align);

		model.addAttribute("projects", projects);

		return "project/ProjectList";
	}

	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "project/ProjectForm";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(Project project) throws Exception {

		projectService.register(project); 

		return "redirect:list.do";
	}

	@RequestMapping("detail")
	public String detail(
			int no,
			Model model) throws Exception {

		Project project = projectService.retrieve(no);
		model.addAttribute("project", project);

		return "project/ProjectDetail";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Project project) throws Exception {

		projectService.change(project);

		return "redirect:list.do";
	}

	@RequestMapping("delete")
	public String delete(int no) throws Exception {

		projectService.remove(no);

		return "redirect:list.do";
	}

}
