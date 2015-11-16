/*
 * 작업 목표:
 * - help 명령 처리: 다음과 같이 출력한다.
 * [사용법]
 * 명령
 * 
 * [명령]
 * list 				 학생 목록을 리턴한다.
 * add					 학생을 추가한다.
 * delete				 학생을 삭제한다.
 * quit					 프로그램을 종료한다.
 * 
 */

package test01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProjectAppTest {

	static void help() {
		System.out.println("도움말입니다.");
		doHelp();
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String command = null;
		
		do {
			System.out.print("명령>");
			command = sc.nextLine();
		
			switch (command) {
			case "help":
				doHelp();
				break;
			case "list":
				System.out.println("목록입니다.");
				doList();
				break;
			case "add":
				System.out.println("추가합니다");
				doAdd();
				break;
			case "delete":
				System.out.println("삭제합니다.");
				break;
			case "quit":
				break;
			default:
				System.out.println("해당 명령어를 지원하지 않습니다!");
			}
		} while(!command.equals("quit"));
		
		System.out.println("안녕히가세요!");
		sc.close();
		
	}

	private static void doAdd() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("추가합니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.println("생년월일(yyyy.mm.dd)");
		String birth = sc.nextLine();       
		FileWriter ipf = new FileWriter
				("/Users/isanghoon/Documents/workspace/test/src/test01/test.txt", true);
		ipf.write(name + " " + birth + "\n");
		ipf.close();
		
	}
	
	private static void doList() throws IOException {
		File opf = new File
				("/Users/isanghoon/Documents/workspace/test/src/test01/test.txt");
		FileReader fileReader = new FileReader(opf);
		BufferedReader fop = new BufferedReader(fileReader);
		String line = null;
		while ((line = fop.readLine()) != null) {
			System.out.println(line);
		}
		fop.close();
		fileReader.close();
		
	}
	
	private static void doHelp() {
		System.out.println("[사용법]");
		System.out.println();
		System.out.println("[명령]");
		System.out.println("list         학생 목록을 리턴한다.");
		System.out.println("add          학생을 추가한다.");
		System.out.println("delete       학생을 삭제한다.");
		System.out.println("save         저장한다.");
		System.out.println("quit         프로그램을 종료한다.");
	}

}
