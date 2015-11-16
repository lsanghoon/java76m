/*
 * 주제: 다형성(polmorphism) - 오버로딩 (over loading)
 * - 파라미터의 타입과 개수는 다르지만 기능은 같은 메서드 추가
 */

package step07.ex09;

public class Test {

	public static void main(String[] args) {
		Calculator4 cal = new Calculator4();
		cal.plus(10);		// Calculator2.plus(int) 호출됨.
		cal.plus(7.2f);	// Calculator4.plus(float) 호출됨.	result 17
		cal.plus(3.5f);	// 반올림 했다.		result 21
		cal.print();
	}

}
