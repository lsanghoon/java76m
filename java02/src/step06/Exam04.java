/*
 * 주제: 자바 핵심 클래스 - StringBuffer (5)
 */

package step06;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		// StringBuffer는 mutable 객체를 만들 때 사용한다.
		// => 문자열을 변경할 수 있다.
		StringBuffer sb1 = new StringBuffer("Hello");
		
		// 1) 특정 영역의 문자열을 다른 문자열로 대체하기
		//	 시작인덱스 <= 대상 < 끝인덱스
		StringBuffer sb2 = sb1.replace(2, 4, "xx");
		// sb1의 원본을 바꾼다.
		System.out.println(sb1);	// sb1이 가리키는 인스턴스의 값이 변경되었다.
		System.out.println(sb2);	// replace()의 리턴 값은 기존 객체 주소이다.
		
		if (sb1 == sb2)
			System.out.println("sb1 == sb2");
		
		// 2) 문자열 비교하기
		StringBuffer x = new StringBuffer("Hello");
		StringBuffer y = new StringBuffer("Hello");
		
		// 결과 : false
		// 이유 : StringBuffer에 있는 equals() 메서드는 그냥 주소가 같은지 비교한다.
		//			 String은 내용이 같은지 비교하지만 StringBuffer는 그냥 == 와 같다.
		if (x.equals(y))
			System.out.println(x.equals(y));
		
		// StringBuffer에서 내용을 비교하려면 String 객체를 꺼내서 비교하라!
		// toString() : StringBuffer에 있는 값을 가지고 새로운 String 인스턴스를 만든다.
		if (x.toString().equals(y.toString()))
			System.out.println("x.toString().equals(y.toString())");
		
		String x2 = x.toString();
		String y2 = y.toString();
		if (x2.equals(y2))
			System.out.println("x2.equals(y2)");
		
		String s1 = "Hello";
		System.out.println(s1.toString());
		
		
		
		
	}
	
}