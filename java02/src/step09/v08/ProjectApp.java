/*
 * 작업 목표: delete 명령 처리(3) - 삭제한 항목을 비우지 말고, 뒤의 항목을 앞으로 당길 것.
 */

package step09.v08;

import java.sql.Date;
import java.util.Scanner;

public class ProjectApp {

	Scanner sc = new Scanner(System.in);
	Project[] projects = new Project[1000];
	int pos;	// 저장위치
	
	public static void main(String[] args) {
		ProjectApp app = new ProjectApp();
		app.service();
	}

	private void service() {
		String command = null;
		
		do {
			System.out.print("명령> ");
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
			case "quit":
				doQuit();
				break;
			default:
				System.out.println("해당 명령어를 지원하지 않습니다!");
			}
		} while(!command.equals("quit"));
		
		System.out.println("안녕히가세요!");
		sc.close();
		
	}
	
	private void doList() {

		System.out.println("번호\t프로젝트명\t\t시작일\t\t종료일\t\t멤버");
		//System.out.println();
		for (int i = 0; i < pos; i++) {
			if (projects[i] == null)	//배열의 항목이 null 인 경우 다음 항목으로 이동
				continue;
			else {
				System.out.println(i + "\t" 
														 + projects[i].pName + "\t\t" 
														 + projects[i].sDate.toString() + "\t"
														 + projects[i].fDate.toString() + "\t"
														 + projects[i].member);
			
				/*System.out.printf("% 3d %-20s %3$tY-%3$tm-%3$td %4$s %5-$40s\n",
						i, 
						projects[i].pName, 
						projects[i].sDate, 
						projects[i].fDate, 
						projects[i].member);*/
			}
			
			//if(!(students[i] == null))
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
			if (pos < projects.length) {
				projects[pos++] = project;
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
			if (no > -1 && no < pos) {
				if (projects[no] == null) {
					System.out.println("이미 삭제된 항목입니다.");
				}
				else {
					for (int i = no; i < pos-1; i++) {
						projects[i] = projects[i+1];
					}
					pos--;
					
					System.out.println("삭제되었습니다.");
				}
			}
			else {
				System.out.println("유효하지 않은 번호입니다.");
			}
		}
		else {
			System.out.println("취소하였습니다.");
		}
	
	}
	
	private void doQuit() {
		
	}

}
