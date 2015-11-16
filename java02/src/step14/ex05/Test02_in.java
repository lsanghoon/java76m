package step14.ex05;

import java.io.File;
import java.io.FileInputStream;

public class Test02_in {

	public static void main(String[] args) throws Exception {
		// FileInputStream을 사용하여 primitive type 데이터 읽기
		FileInputStream in = new FileInputStream("./test/ex05.test02.dat");

		String name = null;
		int kor=0, eng=0, math=0;

		File file = new File("./test/ex05.test02.dat");

		//성적 데이터를 읽어서 각 변수에 저장하라.
		//파일 포켓에 따라 읽는다.
		//1) 문자열 크기 읽는다.
		int len = 0;
		len |= in.read() << 8;
		System.out.println(len);
		byte[] b = new byte[len];
		in.read(b);
		name = new String(b);

		kor |= (in.read() << 24);
		kor |= (in.read() << 16);
		kor |= (in.read() << 8);
		kor |= (in.read());

		eng |= (in.read() << 24);
		eng |= (in.read() << 16);
		eng |= (in.read() << 8);
		eng |= (in.read());

		math |= (in.read() << 24);
		math |= (in.read() << 16);
		math |= (in.read() << 8);
		math |= (in.read());

		// 성적 데이터를 읽어서 각 변수에 저장하라.
		System.out.printf("%s, %d, %d, %d\n", name, kor, eng, math);
	}

}

/*long size = file.length();
		byte[] b = new byte[100];
		int len = in.read(b);

		name =new String(b, 0, len-9);
		kor = b[len-9];
		eng = b[len-5];
		math = b[len-1];*/