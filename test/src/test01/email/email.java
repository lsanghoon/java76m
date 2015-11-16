package test01.email;
import java.util.Scanner;
public class email {

	public static void main(String[] args) {
		final String regex = "\\p{Alnum}+@\\p{Alnum}+\\.\\p{Alnum}+";
		Scanner in = new Scanner(System.in);
		System.out.print(">>");
		String email = in.nextLine();
		in.close();
		
		if (email.matches(regex) == true) {
			System.out.println("OK");
		}
		else {
			System.out.println("NO");
		}
	}
}
