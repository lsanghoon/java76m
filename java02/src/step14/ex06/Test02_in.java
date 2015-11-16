package step14.ex06;

import java.io.FileInputStream;

public class Test02_in {

	public static void main(String[] args) throws Exception {
		// 캐싱 적용 전
		// => 8096바이트씩 받아와서 8096씩 리턴한다.
		FileInputStream in = new FileInputStream("./test/test.mp4");

		long start = System.currentTimeMillis();

		byte[] bytes = new byte[8096];
		int len = -1;

		while ((len = in.read(bytes)) != -1);

		long end = System.currentTimeMillis();

		System.out.println(end - start);

		in.close();

	}

}
