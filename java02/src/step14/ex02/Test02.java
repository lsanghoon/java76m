package step14.ex02;

import java.io.File;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) throws IOException {
		//문제: 모든 하위 파일(디렉토리 포함)의 이름을 출력하라.
		//		 단, 하위 파일에 대해 두칸 들여쓰기를 적용하여 계층 구조로 출력하라!
		//		 힌트) 재귀호출 사용

		File file = new File(".");

		int tab = 1;
		
		File[] filelist = file.listFiles();
		for (File f : filelist) {
			System.out.println(f.getName());
			if (f.isDirectory()) {
				sub(f.getName(), tab);
			}
		}
		
	}
	
	private static void sub(String sub, int tab) throws IOException {
		File file = new File(sub);
		
		String stab =" ";
		for (int i = 0; i < tab; i++) {
			stab += stab;
		}
		
		File[] sublist = file.listFiles();
		for (File f : sublist) {
			System.out.println(stab + f.getName());
			if (f.isDirectory()) {
				sub(f.getCanonicalPath().toString(), tab+1);
			}
		}
		
	}
	
}
