package test01.email;
import java.util.Scanner;
//import java.util.regex.*;
public class email2 {

	public static void main(String[] args) {
		final String reg = "(\\w.)*"		// 아이디부분에 .1번 허용 없어도된다.
										 + "\\w+"				// 아이디 한글자 이상 받는다
										 + "@\\w+"			// @뒤에 한글자 이상 받는다
										 + "\\.\\w+"		// .뒤에 한글자 받는다
										 + "(.\\w+)*";	// a@a.a 뒤에 서버메일용 으로 .추가
		Scanner in = new Scanner(System.in);
		System.out.print(">>");
		String email = in.nextLine();
		in.close();
		
		if (email.matches(reg) == true) {
			System.out.println("OK");
		}
		else {
			System.out.println("NO");
		}
	}
}
