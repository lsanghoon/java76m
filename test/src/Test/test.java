package Test;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i = 0;
		String[] str = null;

		//do{
		str[0] = "g";
		str[1] = "g21";
		str[2] = "g3";
		str[3] = "g5";
		str[4] = "g6";
		str[5] = "g7";
		for (; i< 6; i++)
			System.out.println(str[i]);
		//}
		//while (!(str[i-1].equals("quit")));

		sc.close();
	}
}
