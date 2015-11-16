package step04.exam08;

public class Calculator {
	static int result;	//정수 메모리는 0으로 초기화 된다.
	
	static void plus(int a) {
		result += a;
	}
	
	static void minus(int a) {
		result -= a;
	}
	
	static void multiple(int a) {
		result *= a;
	}
	
	static void divide(int a) {
		result /= a;
	}
}
