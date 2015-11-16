/*
 * 주제 : 기능 정의
 * - function = method
 * - 문법
 * 	 작업결과값의 종류 기능명(작업할때 사용할 값1, 값2, 값3...){
 * 		 명령어...
 * 	 }
 */

package step04;

public class Exam01 {
	//1) non method 
	//return : void
	//parameter : none
	//parameter? 값을 받는 변수(메모리)를 가리킨다.
	static void hello() {
		System.out.println("Hello!");
	}
	
	public static void main(String[] args) {
		hello();	// 메서드 호출
		// 메소드 호출?
		// 메서드 블록 안에 선언된 명령어를 실행하라!
	}

}
