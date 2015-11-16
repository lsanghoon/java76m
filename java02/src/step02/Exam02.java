/*
 * 주제 : 다른 타입끼리의 계산 결과
 * - 자바에서 내부적으로 정의한 규칙(암시적 형변)에 따라 타입을 변환한후 계산한다.
 * 	 (byte, short, char) > int > long > float > double
 */

package step02;

public class Exam02 {
	public static void main(String[] args) {
		byte b = 10;
		short s = 20;
		char c = 20;
		int i = 30;
		long l = 40;
		float f = 50;
		double d = 60.1;
		
		// 1) byte, short, char : int
		int r1 = b + s + c;
		
		
		// 2) int long --> long : 작은 메모리와 큰 메모리 를 계사하면 큰 메모리가 된다.
		long r2 = i + l;
		
		// 3) int, float . float : 정수와 실수를 계산하면 실수가 된다.
		float r3 = i + f;	// 주의! 값이 짤릴수 있다.
		
		// 4) long, float> float : 아무리 크 정수라도 실수와 계산을 하면 실수가 된다.
		float r4 = l + f;
		
		// 5) float, double> double :
		double r5 = f + d;
		
		// 6) 다음의 계산 결과는 어떤 타입일까요?
		double r6 = b + s - c * i / f - d * i;
		
		// 결론
		// - 두 개의 다른 타입의 값을 계산하면,
		//   두 값을 같은 타입으로 만든 후에 계산을 한다.
		
		// 주의!
		byte x = 10;
		short y =20;
		int z = x + y;
		//x변수와 y변수를 int로 바꾸는 것이 아니다.
		
		
	}
}
