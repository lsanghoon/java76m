/*
 * 주제 : 기능 정의 4
 * - function = method
 * - 문법
 * 	 작업결과값의 종류 기능명(작업할때 사용할 값1, 값2, 값3...){
 * 		 명령어...
 * 	 }
 */

package step04;

public class Exam04 {
	//1) 메서드 정의
	//return : 있음
	//parameter : 있음
		static String hello(String name) {
			return "Hello! " + name;
		}
	
	public static void main(String[] args) {		
		String str = hello("홍길동");	
		System.out.println(str);
	}

}
