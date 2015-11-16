package step12.ex01;

import java.util.Map.Entry;
import java.io.FileInputStream;
import java.util.Properties;

public class Test02 {
	public static void main(String[] args) throws Exception {
		//Properties props = System.getProperties();
		Properties props = new Properties();
		props.load(new FileInputStream("src/step12/ex01/test.properties"));
		for (Entry<Object, Object> entry : props.entrySet()) {
			System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
		}
	}
}
