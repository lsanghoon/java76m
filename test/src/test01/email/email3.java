package test01.email;

import java.util.Scanner;
import java.util.regex.*;

public class email3 {

	public static void main(String[] args) {
		final String regex = "\\w+"				// 아이디 한글자 이상 받는다
											 + "@\\w+"			// @뒤에 한글자 이상 받는다
											 + "\\.\\w+";		// .뒤에 한글자 받는다
		Scanner in = new Scanner(System.in);
		System.out.print(">>");
		String email = in.nextLine();
		in.close();
		
		Pattern pattern = Pattern.compile(regex);	// regex로 패턴을 만들어낸다.
		Matcher match = pattern.matcher(email);	// email이 패턴에 부합되는지 판단한다
		
		if (match.find() == true) {
			System.out.println("OK");
		}
		else {
			System.out.println("NO");
		}
	}
}
