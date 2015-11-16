package step14.ex01;

import java.io.File;
import java.io.IOException;

public class Test03 {

	public static void main(String[] args) throws IOException {
		// File 도구 사용법
		// . 은 현재위치
		// .. 은 상위 디렉토리
		File file = new File("./test/a.txt");
		
		// 1) 파일 또는 디렉토리 정보 가져오기
		System.out.printf("존재 여부 : %b\n", file.exists());
		
		// 3) 파일 이름 바꾸기
		file.renameTo(new File("./test/b.txt"));
		
	}
	
}
