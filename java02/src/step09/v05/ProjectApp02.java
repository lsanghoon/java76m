/*
 * 작업 목표: add 명령 처리 (2): main을 제외한 나머지 메서드를 인스턴스 메서드로 변환
 * add : 회원 정보를 추가하는 명령어.
예)
명령> add
이름? 홍길동4
이메일? hong4@test.com
전화? 111-2222
기수? 자바76기
정말 저장하시겠습니까?(y/n) y
저장되었습니다.
정말 저장하시겠습니까?(y/n) n
취소하였습니다.
 */

package step09.v05;

import java.util.Scanner;

public class ProjectApp02 {

	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ProjectApp02 app = new ProjectApp02();
		app.service();
	}

	private void service() {
		String command = null;
		
		do {
			System.out.print("명령>");
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
		System.out.println("목록입니다.");		
	}
	
	private void doAdd() {
		
		System.out.println("이름? ");	//이름? 홍길동4
		String name = sc.nextLine();
		
		System.out.println("이메일? ");//이메일? hong4@test.com
		String email = sc.nextLine();
		
		System.out.println("전화? ");		//전화? 111-2222
		String tel = sc.nextLine();
		
		System.out.println("기수? ");//기수? 자바76기
		String times = sc.nextLine();
		
		System.out.println("정말 저장하시겠습니까?(y|n)");		//정말 저장하시겠습니까?(y/n) y
		String yesno = sc.nextLine();
		
		if (yesno.toLowerCase().equals("y")) {
			System.out.println("저장되었습니다.");
		}
		else {
			System.out.println("취소하였습니다.");
		}
		
	}
	
	private void doDelete() {
		System.out.println("삭제합니다.");		
	}
	
	private void doQuit() {
		
	}
	
	private void doHelp() {
	System.out.println("[사용법]");
	System.out.println();
	System.out.println("[명령]");
	System.out.println("list         학생 목록을 리턴한다.");
	System.out.println("add          학생을 추가한다.");
	System.out.println("delete       학생을 삭제한다.");
	System.out.println("quit         프로그램을 종료한다.");
	}

}
