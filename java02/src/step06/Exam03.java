/*
 * 주제: 자바 핵심 클래스 - String (3)
 */

package step06;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		
		String s1 = new String("Hello");
		
		//immutable: 값을 바꿀수 없다.
		//=> String 인스턴스는 한 번 생성되면 값을 바꿀 수 없다.
		//=> immutable 객체라 부른다.
		//예)
		String s2 = s1.replace('l', 'x');
		System.out.println(s1);
		
		// replace(): 기존의 문자열을 바꾸는것이 아니라, 새로운 문자열 인스턴스를 생성한다.
		System.out.println(s2);
		
		// 자주 사용하는 문자열 메서
		String s3 = s1.substring(2);	// 2번 문자부터 끝까지 추출하여 새로운 인스턴스를 만든다.
		System.out.println(s3);
		
		String s4 = s1.substring(1, 3);	// 1번 부터 3번까지.
		System.out.println(s4);
		
		// 특정 문자의 위치 알아내기 => 첫번째 찾은 문자의 위치
		System.out.println(s1.indexOf('l'));
		System.out.println(s1.lastIndexOf('l'));	// 끝에서부터 찾는다.
		
		//퀴즈?
		//- 스캐너로부터 한 줄 입력 받는다
		//- 해당 문자열이 이메일인지 확인한다.
		
		Scanner input = new Scanner(System.in);
		int i = 0;

		while (i == 0) {
			System.out.print(">>");
			String email = input.nextLine();
		
			if (email.indexOf('@') == -1)
				System.out.println("이메일 형식이 올바르지않습니다.");
			else if (email.indexOf('.') == -1)
				System.out.println("이메일 형식이 올바르지않습니다.");
			
			else {
				System.out.println("이메일 맞다.");
				i = 1;
			}
			
			// 정규표현식 이용하여 이메일을 검사하라.
			// ?
	
		}
	}
}