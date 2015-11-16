package v07.command;

import java.util.ArrayList;
import java.util.HashMap;

import v07.Project;

// Command규칙 적용
public class ProjectListCommand implements Command{
	public void execute(HashMap<String,Object> params) {
		ArrayList<Project> list = (ArrayList<Project>)params.get("list");

		System.out.printf("%-3s %-13s %-11s %-11s %-40s\n", 
				"No", "ProjectName", "StartDay", "EndDay", "Member");

		Project project = null;
		for (int i = 0; i < list.size(); i++) {
			project = list.get(i);	// 제네릭을 적용했기 때문에 타입캐스팅 할 필요가 없다.
			if (project == null)
				continue;
			else {
				System.out.printf("%3d %-13s %3$-11s %4$-11s %5$-40s\n", 
						i, 
						project.getpName(),
						project.getsDate(),
						project.getfDate(),
						project.getMember());
			}
		}
	}
}
