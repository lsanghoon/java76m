package v02;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentControl {
	Scanner scanner;
	ArrayList<Student> students = new ArrayList<Student>();
	
	public StudentControl(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void service() {
		String command = null;
    do {
      System.out.print("학생관리> ");
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
        System.out.println("해당 명령을 지원하지 않습니다.");
      }
    } while (true);
	}
	
	private void doList() {
		Student student = null;
    for (int i = 0; i < students.size(); i++) {
    	student = students.get(i);	// 제네릭을 적용했기 때문에 타입캐스팅 할 필요가 없다.
      if (students == null)
        continue;
      System.out.printf("%d %s %s %s %s\n", 
          i, 
          student.getName(),
          student.getEmail(),
          student.getTel(),
          student.getCid());
    }
  }
  
  private void doAdd() {
    Student student = new Student();
    
    System.out.print("이름? ");
    student.setName(scanner.nextLine());
    
    System.out.print("이메일? ");
    student.setEmail(scanner.nextLine());
    
    System.out.print("전화? ");
    student.setTel(scanner.nextLine());

    System.out.print("기수? ");
    student.setCid(scanner.nextLine());

    System.out.print("정말 저장하시겠습니까?(y/n)");
    String yesno = scanner.nextLine();
    if (yesno.toLowerCase().equals("y")) {
      students.add(student);
      System.out.println("저장되었습니다.");
    }
    else {
      System.out.println("취소하였습니다.");
    }
  }
  
  private void doDelete() {
    System.out.print("회원 번호? ");
    int no = Integer.parseInt(scanner.nextLine());
    
    System.out.print("정말 삭제하시겠습니까?(y/n)");
    String yesno = scanner.nextLine();
    if (yesno.toLowerCase().equals("y")) {
      if (students.remove(no) != null) {
        System.out.println("이미 삭제된 항목입니다.");
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
    System.out.println("list         학생 목록을 리턴한다.");
    System.out.println("add          학생을 추가한다.");
    System.out.println("delete       학생을 삭제한다. ");
    System.out.println("main         메인으로 이동한다.");
  }
	
}
