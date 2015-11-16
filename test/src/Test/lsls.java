package Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class lsls {
	File file = new File(".");
	Scanner sc = new Scanner(System.in);
	HashMap map = new HashMap();

	public lsls() throws Exception {
	  	// 메뉴를 처리할 컨트롤의 이름이 있는 menu.properties 파일을 로딩한다.
	  	Properties props = new Properties();
	  	props.load(new FileInputStream("src/Test/menu.properties"));
	  	
	  	String className = null;
	  	
	  	for (Object menuNo : props.keySet()) {
	  		// 프로퍼티에서 클래스 이름을 가져온다.
	  		className = props.getProperty((String)menuNo);
	  		
	  		System.out.println(map.put((String)menuNo, props.getProperty((String)menuNo)));
	  	}
  }
	
	static FileFilter fileFilter = new FileFilter() {

	@Override
	public boolean accept(File file) {
		if (!file.getName().substring(0, 1).equals("."))
			return true;
		return false;
	}
		
	};
	
	public static void main(String[] args) throws Exception {
    lsls app = new lsls();
		app.cmd();
	}

	private void cmd() {
		
		System.out.print("$> ");
		String[] command = sc.nextLine().split(" ");
		if (command[0].equals("ls")) {
			if (command.length == 1)
				notHiddenList(file);
			else {
				if (command[1].equals("-a"))
					hiddenList(file);
			}
		}
		sc.close();
		
	}

	private static void hiddenList(File file) {
		File[] flist = file.listFiles();
		for (int i = 1; i < flist.length+1; i++) {
			System.out.printf("%-13s",flist[i-1].getName());
			if (i % 4 == 0)
				System.out.println();
		}
	}
	
	private static void notHiddenList(File file) {
		File[] flist = file.listFiles(fileFilter);
		for (int i = 1; i < flist.length+1; i++) {
			System.out.printf("%-13s",flist[i-1].getName());
			if (i % 4 == 0)
				System.out.println();
		}
	}
}
