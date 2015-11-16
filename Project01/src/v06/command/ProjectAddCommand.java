package v06.command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import v06.Project;

public class ProjectAddCommand {
	public void execute(HashMap<String,Object> params) {
		Scanner scanner = (Scanner)params.get("scanner");
		ArrayList<Project> list = (ArrayList<Project>)params.get("list");
		
		Project project = new Project();
			
		System.out.println("프로젝트명? ");
		project.setpName(scanner.nextLine());
			
		System.out.println("시작일? ");	// 2015-02-02
		project.setsDate(Date.valueOf(scanner.nextLine()));
			
		System.out.println("종료일? ");		// 2016-02-03
		project.setfDate(Date.valueOf(scanner.nextLine()));
			
		System.out.println("멤버? ");	// 홍길동,임꺽정,김구
		project.setMember(scanner.nextLine());
			
		System.out.println("정말 저장하시겠습니까?(y|n)");
		String yesno = scanner.nextLine();
			
		if (yesno.toLowerCase().equals("y")) {
			list.add(project);
			System.out.println("저장되었습니다.");
		}
		else {
			System.out.println("취소하였습니다.");
		}		
	}
}
