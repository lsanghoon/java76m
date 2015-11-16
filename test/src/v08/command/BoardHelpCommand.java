package v08.command;

import java.util.HashMap;

public class BoardHelpCommand implements Command {
	public void execute(HashMap<String,Object> params) {
		
	    System.out.println("[사용법]");
	    System.out.println("명령");
	    System.out.println();
	    System.out.println("[명령]");
	    System.out.println("list         게시글 목록을 출력한다.");
	    System.out.println("add          게시글을 추가한다.");
	    System.out.println("read         게시글을 읽는다.");
	    System.out.println("delete       게시글을 삭제한다. ");
	    System.out.println("main         메인으로 이동한다.");
	}
}
