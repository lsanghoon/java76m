package step10.ex07;

import java.util.HashMap;
import java.util.Map.Entry;

public class Test01 {
	static class Student {
		String name;
		String tel;
		
		public Student (String name, String tel) {
			this.name = name;
			this.tel = tel;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", tel=" + tel + "]";
		}
		
		
	}
	public static void main(String[] args) {
		HashMap<String,Student> map = new HashMap<String,Student>();
		map.put("s01", new Student("홍길동", "1111-1111"));
		map.put("s02", new Student("임꺽정", "1111-1112"));
		map.put("s03", new Student("유관순", "1111-1113"));
		
		// Entry: key / value 값을 보관한 객체
		// => Entry 목록을 얻기
		for (Entry<String,Student> entry : map.entrySet()) {
			System.out.printf("%s : %s\n"
					,entry.getKey() ,entry.getValue().toString());
		}
		
	}
}
