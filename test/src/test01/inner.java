package test01;

public class inner {
	private static class Student {
		protected String name;
		protected String tel;

		public Student() {

		}

		public Student(String name) {
			this.name = name;
		}

		public Student(String name, String tel) {
			this(name);
			this.tel = tel;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", tel=" + tel + "]";
		}
	}

	public class print {
		public print() {
			Student s = new Student("s01", "1111");
			System.out.println(s);
		}
	}
}
