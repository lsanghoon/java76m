package step14.ex11;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Test04_in {

	public static void main(String[] args) throws Exception {
	//직렬화 사용 후
	FileInputStream in = new FileInputStream("./test/exam11.test04.dat");
	ObjectInputStream in2 = new ObjectInputStream(in);
	
	//바로 인스턴스를 리턴한다.
	Score s1 = (Score)in2.readObject();
	System.out.println();
	s1.compute();
	
	in2.close();
	in.close();
	
	System.out.println(s1);

	}

}
