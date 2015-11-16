package step15.ex01;

public class Calculator2 {
	public static int plus(int a, int b) {
		return a + b;
	}

	public static int minus(int a, int b) {
		return a - b;
	}

	public static int multiple(int a, int b) {
		return a * b;
	}
	
	public static int divide(int a, int b) throws Throwable {
		if (b == 0) {
			// 오류 정보를 Throwable 객체에 담아서 던지기
			throw new Throwable("0으로 나눌 수 없습 니다.");
		}
		return a / b;
	}

}
