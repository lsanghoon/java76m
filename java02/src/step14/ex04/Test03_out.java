package step14.ex04;

import java.io.FileWriter;

public class Test03_out {
	public static void main(String[] args) throws Exception {

		//FileWriter와 FileOutputStream의 출력비교!
		FileWriter out = new FileWriter("./test/ex04.test03.txt");
		
		//write(int)
		//=> 유니코드 문자열을 출력한다.
		String str = "ABC\nabc\n가각간\n똘똠똥\n";
		for (byte b : str.getBytes("UTF-16")) {	//UTF-16 = unicode 2바이트
			System.out.printf("%02x", b);
		}
		// 출력결과
		//feff004100420043000a006100620063000aac00ac01ac04000ab618b620b625000a
		//첫번째 2바이트는 유니코드입을 알려주기 위해부차적으로 붙은 데이터이다. 일단 무시한다.
		//feff 0041 0042 0043 000a 0061 0062 0063 000a ac00 ac01 ac04 000a b618 b620 b625 000a
		//			A		 B		C		 \n		a		 b		c		\n		가	 	 각		간		 \n		똘		 똠		똥		 \n	
		
		out.write(str);	// Unicode ---> UTF-8로 변환 되어 출력한다.

		out.close();
		System.out.println("실행완료");
	}
}
