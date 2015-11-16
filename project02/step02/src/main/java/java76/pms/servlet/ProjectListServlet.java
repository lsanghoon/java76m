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
		PrintStream out = (PrintStream)params.get("out");

		out.printf("%-3s %-13s %-11s %-11s %-40s\n", 
				"No", "ProjectName", "StartDay", "EndDay", "Member");

		for (Project project : projectDao.selectList()) {
			out.printf("%3d %-13s %3$-11s %4$-11s %5$-40s\n", 
					project.getNo(), 
					project.getTitle(),
					project.getStartDate(),
					project.getEndDate(),
					project.getMember());
		}
	}
}
