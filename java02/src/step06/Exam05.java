/*
 * 주제: 자바 핵심 클래스 - String (4)
 */

package step06;

import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		// Escape 문자 : 특별한 기능을 수행하는 문자
		// 1) 줄 바꿈 문자 삽입: 
		//		\n (new line) => Unicode(2byte) (0x000a)
		//		\r (line feed) => Unicode (0x000d) => \u000d
		System.out.println("Hello,\n World");
		
		// => 각 문자의 유니코드 값을 출력하여 줄바꿈 문자의 유니코드 값을 확인한다.
		toHexFromString("Hello, \r\n World");
		
		// => 문자열에 줄 바꿈 코드를 넣을 때 보통 \n만 사용한다.
		toHexFromString("Hello, \n World");
		
		// => Windows와 UNIX의 줄 바꿈 코드 값
		//		Windows : Carrage Return(CR) - 0x0d
		//							Line Feed(LF) - 0x0a
		//		=> 윈도우는 타자기에서 줄 바꿈을 참조하여 만들었다.
		//
		//		UNIX : Line Feed(LF) - 0x0a
		
		// 2) 임의의 유니코드 삽입하기:
		//		예) \u0020 유니코드값
		toHexFromString("ABC\u0020abc");
		toHexFromString("\uac00\uac01abc");
		
		// 3) 탭 코드 넣기: 예) \t
		toHexFromString("ABC\tabc");
		
		// 4) 백스페이스: 예) \b
		toHexFromString("ABC\babc");
		
		// 5) 역슬래시 출력 : 예) \\
		toHexFromString("ABC\\abc");
		//toHexFromString("ABC\u5cabc");
		
		System.out.print("c:\\javaide\\workspace");
		System.out.print("c:/javaide/workspace");
		// => 파일 경로
		//		유닉스 : /(슬래시) 사용
		//		윈도 : \(역슬래시) 사용
		//		자바는 윈도우와 유닉스 상관없이 그냥 /를 사용해도 된다.
		
		// 6) 큰 따옴표 출력 : 예) \"
		toHexFromString("ABC\"ab\"c");
		toHexFromString("ABC'ab'c");	// 문자열 에서는 \' 이렇게 사용할수 있다.
		System.out.println('\''); // 문자에서 작은 따음표를 표현하고 싶을 때 사용한다.
	}
	
	static void toHexFromString(String s) {
		System.out.println("----------------------");
		System.out.println(s);
		for (int i = 0; i < s.length(); i++) {
			System.out.printf("%x\n", (int)s.charAt(i));
		}
	}
	
}