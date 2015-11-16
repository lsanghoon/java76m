/*
 * JVM의 메모리 관리 : 배열과 인스턴스
 */

package step08;

public class Exam04 {
	static class Student {
		String name;
		int age;
		boolean gender;
	}
	
	public static void main(String[] args) {
		//1) Primitive type 배열
		int[] p = new int[5];
		p[0] = 100;
		p[1] = 100;
		p[2] = 100;
		p[3] = 100;
		p[4] = 100;
		
		int[] p2 = p;
		
		System.out.printf("%d, %d\n", p2[0], p2[1]);
		
		//2) 레퍼런스 배열
		//Student s1, s2, s3;
		Student[] s = new Student[3];
		s[0] = new Student();	//레퍼런스 배
		s[1] = new Student();
		s[2] = new Student();
		Student[] s2 = s;
		
		Student obj1 = s2[2];
		
		
		
	}
}
