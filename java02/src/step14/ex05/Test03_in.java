package step14.ex05;

import java.io.File;

public class Test03_in {

	public static void main(String[] args) throws Exception {
		// FileInputStream을 사용하여 primitive type 데이터 읽기
		DataInputStream in = new DataInputStream("./test/ex05.test02.dat");

		String name = null;
		int kor=0, eng=0, math=0;

		File file = new File("./test/ex05.test02.dat");

		name = in.readUTF();
		kor = in.readInt();
		eng = in.readInt();
		math = in.readInt();
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