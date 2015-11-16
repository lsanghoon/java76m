package v04;

import java.sql.Date;
import java.util.Scanner;

public class ProjectControl extends StorageMenuControl<Project> {
	public ProjectControl(Scanner scanner) {
		super(scanner);
	}
	
	public void service() {
		String command = null;
		
		do {
			System.out.print("프로젝트관리> ");
			command = scanner.nextLine();
			
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
	
	private void doAdd() {
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
	
	private void doDelete() {

		System.out.println("프로젝트 번호? ");
		int no = Integer.parseInt(scanner.nextLine());
		
		System.out.println("정말 삭제하시겠습니까?(y|n)");		//정말 저장하시겠습니까?(y/n) y
		String yesno = scanner.nextLine();
		
		if (yesno.toLowerCase().equals("y")) {
			if (list.remove(no) != null) {
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
