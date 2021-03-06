package step14.ex11;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Test02_in {

	public static void main(String[] args) throws Exception {
	//직렬화 사용 후
	FileInputStream in = new FileInputStream("./test/exam11.test02.dat");
	ObjectInputStream in2 = new ObjectInputStream(in);
	
	//바로 인스턴스를 리턴한다.
	Student s1 = (Student)in2.readObject();
	Student s2 = (Student)in2.readObject();
	
	in2.close();
	in.close();
	
	System.out.println(s1);
	System.out.println(s2);

	}

}
