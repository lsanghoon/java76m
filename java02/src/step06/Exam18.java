/*
 * 주제: 자바 핵심 클래스 - Date 클래스 (3)
 * - 
 */

package step06;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Exam18 {
	public static void main(String[] args) throws Exception {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 10);	// 8이면 9월이다 0~11
		
		//String pattern = "yyyy";	//2015
		//String pattern = "yy";	//15
		//String pattern = "YYYY";	//2015
		//String pattern = "YY";	//15
		//String pattern = "MM";	//01,02,03,04, ~ 12
		//String pattern = "MMM";	//10월
		//String pattern = "MMMM";	//10월
		//String pattern = "M";	// 1, 2, 3, 4, ~ 12
		//String pattern = "DD";	//249일째
		//String pattern = "d";	// 6일
		//String pattern = "dd";	//01, 02, 03 ~
		String pattern = "MM/dd/yyyy";	//09/06/2015
		
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		//Date ---> text
		String str1 = formatter.format(cal.getTime());
		System.out.println(str1);
		
		//text ---> Date
		java.util.Date date1 = formatter.parse("10/06/2015");
		System.out.println(date1);	// println()은 파라미터 넘어온 객체에 대해
																// 내부적으로 toString()을 호출한다.
																// 따라서 굳이 toString()을 호출하여 문자열을
																// 줄 필요가 없다.
	}
	
	
	
	
	
	
	
	
	
}