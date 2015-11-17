package step04;

public class Test02X {
	
	interface GeneratedClosure {
		Object call(Object... args);
	}
	
	public static void main(String[] args) {
		Test02X p = new Test02X();
		p.run();
	}
	
	public Object run() {
		GeneratedClosure plus = new GeneratedClosure() {
			public Object call(Object... args) {
				System.out.println("1111");
				System.out.println("2222");
				System.out.println("3333");
				return ((Integer)args[0]) + ((Integer)args[1]);
				
			}
		};
		
		System.out.println(plus.call(10,20));
		System.out.println(plus.getClass().getName());
		return null;
	}
	
}
