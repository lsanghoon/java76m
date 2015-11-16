package step14.ex02;

import java.io.File;
import java.io.IOException;

public class Test01 {

	public static void main(String[] args) throws IOException {
		// File 도구 사용법
		// . 은 현재위치
		// .. 은 상위 디렉토리
		File file = new File("./src/..");
		
		//1) 하위 파일(디렉토리 포함)의 목록을 문자열로 얻기
		String[] files = file.list();
		for (String f : files) {
			System.out.println(f);
		}
		
		//2) 하위 파일(디렉토리 포함)의 정보를 File 객체로 얻기
		System.out.println("-------------------------");
		File[] files2 = file.listFiles();
		for (File f : files2) {
			System.out.printf("%s(%d)\n", f.getName(), f.length());
		}
	}
	
}
