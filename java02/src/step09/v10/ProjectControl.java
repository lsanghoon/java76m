package step09.v10;

import java.sql.Date;
import java.util.Scanner;

public class ProjectControl {
	Scanner sc;
	ArrayList projects = new ArrayList();
	
	public ProjectControl(Scanner sc) {
		this.sc = sc;
	}
	
	public void service() {
		String command = null;
		
		do {
			System.out.print("프로젝트관리> ");
			command = sc.nextLine();
			
			switch (command) {
      case "list":
        doList();
        break;
      case "add":
        doAdd();
        break;
      case "delete":
        doDelete();
        break;
      case "help":
      	doHelp();
      	break;
      case "main":
      	return;
			default:
				System.out.println("해당 명령어를 지원하지 않습니다!");
			}
		} while(true);
	}
	
	private void doList() {

		System.out.println("번호\t프로젝트명\t\t시작일\t\t종료일\t\t멤버");
		//System.out.println();
		
		Project project = null;
		for (int i = 0; i < projects.size(); i++) {
			project = (Project)projects.get(i);
			if (project == null)	//배열의 항목이 null 인 경우 다음 항목으로 이동
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
	
	private void doAdd() {
		Project project = new Project();
		
		System.out.println("프로젝트명? ");
		project.setpName(sc.nextLine());
		
		System.out.println("시작일? ");	// 2015-02-02
		project.setsDate(Date.valueOf(sc.nextLine()));
		
		System.out.println("종료일? ");		// 2016-02-03
		project.setfDate(Date.valueOf(sc.nextLine()));
		
		System.out.println("멤버? ");	// 홍길동,임꺽정,김구
		project.setMember(sc.nextLine());
		
		System.out.println("정말 저장하시겠습니까?(y|n)");
		String yesno = sc.nextLine();
		
		if (yesno.toLowerCase().equals("y")) {
			if (projects.add(project) == 0) {
				System.out.println("저장되었습니다.");
			}
			else {
				System.out.println("저장소가 모두 찼습니다.\n저장할 수 없습니다.!");
			}
			//System.out.println(project.toString());
		}
		else {
			System.out.println("취소하였습니다.");
		}
		
	}
	
	private void doDelete() {

		System.out.println("프로젝트 번호? ");
		int no = Integer.parseInt(sc.nextLine());
		
		System.out.println("정말 삭제하시겠습니까?(y|n)");		//정말 저장하시겠습니까?(y/n) y
		String yesno = sc.nextLine();
		
		if (yesno.toLowerCase().equals("y")) {
			if (projects.remove(no) != null) {
					System.out.println("삭제되었습니다.");
			}
			else {
				System.out.println("유효하지 않은 번호입니다.");
			}
		}
		else {
			System.out.println("취소하였습니다.");
		}
	}
	
	private void doHelp() {
    System.out.println("[사용법]");
    System.out.println("명령");
    System.out.println();
    System.out.println("[명령]");
    System.out.println("list         프로젝트 목록을 출력한다.");
    System.out.println("add          프로젝트를 추가한다.");
    System.out.println("delete       프로젝트를 삭제한다. ");
    System.out.println("main         메인으로 이동한다.");
  }
}
