package v06.command;

import java.util.ArrayList;
import java.util.HashMap;

import v06.Project;

// Command규칙 적용
public class ProjectListCommand implements Command{
	public void execute(HashMap<String,Object> params) {
		ArrayList<Project> list = (ArrayList<Project>)params.get("list");

		System.out.println("번호\t프로젝트명\t\t시작일\t\t종료일\t\t멤버");
		//System.out.println();
		
		Project project = null;
		for (int i = 0; i < list.size(); i++) {
			project = list.get(i);	// 제네릭을 적용했기 때문에 타입캐스팅 할 필요가 없다.
			if (project == null)
				continue;
			else {
				System.out.println(i + "\t" 
														 + project.getpName() + "\t\t" 
														 + project.getsDate() + "\t"
														 + project.getfDate() + "\t"
														 + project.getMember());
			}
		}
	}
}
