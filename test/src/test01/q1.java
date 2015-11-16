package test01;

import java.io.File;

public class q1 {

	public static void main(String[] args) {
		File fop = new File("/Users/isanghoon/Documents/workspace/test/src/test01");
		
		String[] files = fop.list();
		for (int k = 0; k < files.length; k++) {
			System.out.println(files[k]);
		}

	}

}
