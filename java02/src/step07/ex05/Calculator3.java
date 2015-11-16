/*
 * 상속
 * - 수퍼(부모) 클래스의 코드를 복사해오는 것이 아니다.
 * - 단지 수퍼 클래스의 연결 정보만 관리한다
 */

package step07.ex05;

import step07.ex04.Calculator2;

public class Calculator3 extends Calculator2 {
	// 기존 기능에 새 기능을 덧붙인다.
	public void multiple (int a) {
		this.result *= a;
	}
	
	public void divide (int a) {
		this.result /= a;
	}
}
