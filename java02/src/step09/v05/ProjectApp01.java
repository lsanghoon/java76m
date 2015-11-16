/*
 * 작업 목표: add 활용
 * - help 명령 처리: 다음과 같이 출력한다.
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

public class ProjectApp01 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
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

	private static void doList() {
		System.out.println("목록입니다.");		
	}
	
	private static void doAdd() {
		System.out.println("추가합니다");
		
	}
	
	private static void doDelete() {
		System.out.println("삭제합니다.");		
	}
	
	private static void doQuit() {
		
	}
	
	private static void doHelp() {
	System.out.println("[사용법]");
	System.out.println();
	System.out.println("[명령]");
	System.out.println("list         학생 목록을 리턴한다.");
	System.out.println("add          학생을 추가한다.");
	System.out.println("delete       학생을 삭제한다.");
	System.out.println("quit         프로그램을 종료한다.");
	}

}
