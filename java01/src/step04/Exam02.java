/*
 * 주제 : 기능 정의 2
 * - function = method
 * - 문법
 * 	 작업결과값의 종류 기능명(작업할때 사용할 값1, 값2, 값3...){
 * 		 명령어...
 * 	 }
 */

package step04;

public class Exam02 {
	//1) non method 
	//return : 없음
	//parameter : 있음
		static void hello(String name) {
			System.out.println("Hello! " + name);
	}
	
	public static void main(String[] args) {
		hello("홍길동");	// 메서드 호출
		// "홍길동" - 메서드 호출할 때 넘기는 값 => argument
		// 메서드 블록 안에 선언된 명령어를 실행하라!
	}

}
