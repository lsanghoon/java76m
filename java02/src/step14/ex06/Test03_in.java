package step14.ex06;

public class Test03_in {

	public static void main(String[] args) throws Exception {
		// 캐싱 적용한 BufferedInputStream 사용하기
		// => 8096바이트씩 가져와서 1바이트씩 리턴한다.
		BufferedInputStream in = new BufferedInputStream("./test/test.mp4");

		long start = System.currentTimeMillis();

		int b;
		
		while ((b = in.read()) != -1);

		long end = System.currentTimeMillis();

		//System.out.println(end + " - " + start);
		System.out.print("시간 : ");
		System.out.println(end - start);

		in.close();

	}

}
