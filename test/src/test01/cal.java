package test01;

public class cal {
	public static void main(String[] args) throws Exception {
		
		//8 + 7 * 6 
		//9 / 3 - 2
		Calcul cal1 = new Calcul();
		Calcul cal2 = new Calcul();
		
		cal1.plus(8);
		cal2.plus(9);
		
		cal1.plus(7);
		cal2.div(3);
		
		cal1.multi(6);
		cal2.minus(2);
		
		System.out.println(cal1.result);
		System.out.println(cal2.result);
	}
}
