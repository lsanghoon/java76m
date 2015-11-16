/*
 * 주제 : 조건문 - if ~ else가 한문장이다.
 */
package step03;

public class Exam03 {
	public static void main(String[] args) {
		int a = 70;
		
		
		//예1:
		if (a < 19)
			System.out.println("미성년");
		else	// 블록을 해도되고 안해도 된다. 일부로 할 필요는 없다.
			if (a >= 19 && a < 65)	// if ~ else는 한문장이다.
				System.out.println("성인");
			else
				System.out.println("노인");
		
		System.out.println("----------------");
		
		//예2:
		a = 8;
		if (a >= 19)
			if(a >= 19 && a <65)	// if ~ else는 한문장이다.
				System.out.println("성인");
		else	// 항상 else문은 가장 가까운 if문과 짝을 이룬다.
			System.out.println("미성년");
		
		System.out.println("-----------------");
		
		//예3:
		a = 57;
		if (a < 8)
			System.out.println("유아");
		else	{
			if (a >= 8 && a < 14)
				System.out.println("어린이");
			else {
				if (a >= 14 && a <19)
					System.out.println("청소년");
				else {
					if (a >= 19 && a < 35)
						System.out.println("청년");
					else {
						if (a >= 35 && a < 50)
							System.out.println("장년");
						else {
							System.out.println("중년 및 노인");
						}
					}
				}
			}
		}
		
		
		
		//예4: if ~ else 는 한문장이란것을 이용하
		a = 57;
		if (a < 8)
			System.out.println("유아");
		else
			if (a >= 8 && a < 14)
				System.out.println("어린이");
			else
				if (a >= 14 && a <19)
					System.out.println("청소년");
				else
					if (a >= 19 && a < 35)
						System.out.println("청년");
					else
						if (a >= 35 && a < 50)
							System.out.println("장년");
						else
							System.out.println("중년 및 노인");			
			
		
		//예5: 
		a = 57;
		if (a < 8)
			System.out.println("유아");
		else if (a >= 8 && a < 14)
			System.out.println("어린이");
		else if (a >= 14 && a < 19)
			System.out.println("청소년");
		else if (a >= 19 && a < 35)
			System.out.println("청년");
		else if (a >= 35 && a < 50)
			System.out.println("장년");
		else
			System.out.println("중년 및 노인");
	}
}
