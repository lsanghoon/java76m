package step11.ex01;

import java.util.Calendar;
import java.util.Date;

public class Test01 {
	public static void main(String[] args) {
		//개별적인 데이터를 저장할 필요가 있기 때문에
		//Date클래스는 new를 통해 인스턴스를 생성한다.
		Date date = new Date();	//그릇. 언제든지 새로운 날짜를 정할수있다.
		
		//시스템 달력이 한가지 종류이다.
		//개별적으로 여러개의 달력을 유지할 이유가 없다.
		//그래서 오작 한달력만 사용하도록 제한하였다.
		//=>Singleton 설계 기법
		Calendar cal = Calendar.getInstance();	//그래고리안달력. 
	
	}
}
