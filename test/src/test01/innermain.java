package test01;

public class innermain {

	public static void main(String[] args) {
		
		inner in = new inner();
		inner.print pr = null;
		pr = in.new print();
		
	}

}
