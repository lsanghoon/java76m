package step10.ex07;

import java.util.HashMap;
import java.util.Map.Entry;

import step10.ex07.Test03.Student;

public class Test02 {
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

	static class Project {
		String pname;
		int no;

		public Project (String pname, int no) {
			this.pname = pname;
			this.no =no;
		}

		@Override
		public String toString() {
			return "Project [pname=" + pname + ", no=" + no + "]";
		}


	}
	public static void main(String[] args) {
		HashMap<Object,Object> map = new HashMap<Object,Object>();
		map.put("s01", new Project("Lee",1234));
		map.put("s04", new Student("홍길동", "1111-1111"));
		map.put("s02", new Project("임꺽정", 1111));
		map.put("s03", new Student("유관순", "1111-1113"));

		// key 목록을 꺼내기
		for (Object key : map.keySet()) {
			System.out.printf("%s : %s\n", key, map.get(key));
		}
		
		// value 목록을 꺼내기
		for (Object value : map.values()) {
			System.out.printf("%s\n", value);
		}
	}
}
