package step10.ex05;

import java.util.ArrayList;

public class Test01 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1);	// 오토박싱
		list.add("홍길동");
		list.add(true);
		list.add(null);
		list.add(null);
		list.add("홍길동");	//중복값 저장가능
		//Type casting
		//- 인스턴스가 어떤 클래스의 것인지 그 사실을 알려주는 명령어.
		Integer v1 = (Integer)list.get(0);
		String v2 = (String)list.get(1);
		Boolean v3 = (Boolean)list.get(2);
		int v4 = (Integer)list.get(0);	// 오토 언박싱
		boolean v5 = (Boolean)list.get(2);	// 오토 언박싱
		String v6 = (String)list.get(5);
		
		System.out.printf("크기 :  %d\n", list.size());
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v6);
	}

}
