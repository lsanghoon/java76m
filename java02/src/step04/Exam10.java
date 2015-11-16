/*
 * 주제 : 레퍼런스와 인스턴스 관계
 */

package step04;

public class Exam10 {
	
	// 클래스는 메모리를 준비하는것이 아니다.
	// 어떤 메모리를 준비해야 하는지 늘 가리키는 설계도이다.
	// => 사용자 정의 데이터 타입
	static class Score {
		String name;
		int[] subjects = new int[5];
		int sum;
		float aver;
	}
	
	public static void main(String[] args) {
		// Score 인스턴스를 저장할 변수 선언.
		// => Score인스턴스란 Score설계도에 따라 준비한 메모리
		// => 레퍼런스 변수란 메모리의 주소를 보관하는 변수
		Score v1;
		
		// 주소를 저장할 변수를 초기화시키기 => 모든 비트를 0으로 설정하기
		// v1 = 0;	// 0으로 초기화시킬 것이지만 직접 0으로 설정해서는 안된다. 오류!
		v1 = null;	// 주소 변수를 초기화시키는 특별한 값 null을 사용한다.
		
		// 인스턴스 생성
		// => Score 클래스에 선언된 메모리가 준비된다.
		// => 인스턴스의 모든 변수는 0으로 자동 초기화 된다.
		// => 인스턴스 생성 후 맅ㄴ 값은 그 메모리의 시작주소이다.
		// => 이렇게 생성된 인스턴스 메모리를 나중에 사용하려면
		//		인스턴스 주소 값을 변수에 보관해야 한다.
		new Score();	// 이 인스턴스는 주소를 보과하지 않기 때문에 나중에 사용할 수 없다.
		v1 = new Score();	// 이 인스턴스의 주소는 v1변수에 보관되어 있다.
		
		// 주소를 이용하여 인스턴스 변수에 값을 보관할수 있다.
		v1.name = "홍길동";	//v1에 보관된 주소로 찾아가서 그 메모리의 name변수에 값을 할당.
		
		Score v2 = null;
		//v2.name = "오호라";	// 컴파일 할때는 오류가 발생하지 않는다. 실행할 때 오류 발생!
		
		//레퍼런스 변수 활용
		Score v3;
		v3 = v1;
		v3.name = "임꺽정";
		System.out.println(v1);
		System.out.println(v1.name);
		
	}

}
