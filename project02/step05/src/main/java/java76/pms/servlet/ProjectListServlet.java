package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.ProjectDao;
import java76.pms.domain.Project;

@Component("/project/list")
public class ProjectListServlet implements Servlet {
	ProjectDao projectDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public void service(HashMap<String, Object> params) {
		// <-- 페이징 처리
		int pageNo = 1;
		int pageSize = 10;

		if (params.get("pageNo") != null) {
			pageNo = Integer.parseInt((String)params.get("pageNo"));
		}
		if (params.get("pageSize") != null) {
			pageSize = Integer.parseInt((String)params.get("pageSize"));
		}
		// -->

		// <-- 정렬 처리
		String keyword = "no";
		String align = "desc";

		if (params.get("keyword") != null) {
			keyword = (String)params.get("keyword");
		}
		if (params.get("align") != null) {
			align = (String)params.get("align");
		}
		// -->

		PrintStream out = (PrintStream)params.get("out");

		out.printf("%-3s %-13s %-11s %-11s %-40s\n", 
				"No", "ProjectName", "StartDay", "EndDay", "Member");

		for (Project project : projectDao.selectList(pageNo, pageSize, keyword, align)) {
			out.printf("%3d %-13s %3$-11s %4$-11s %5$-40s\n", 
					project.getNo(), 
					project.getTitle(),
					project.getStartDate(),
					project.getEndDate(),
					project.getMember());
		}
	}
}
