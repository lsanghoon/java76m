package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test02 {

	public static void main(String[] args) {
		// 스프링 설정파일을 읽고 인스턴스를 준비하라
		ApplicationContext context = new  ClassPathXmlApplicationContext(
				"step01/application-context02.xml");
		
		Computer c1 = (Computer)context.getBean("c1");
		System.out.println(c1);
		
		Computer c2 = (Computer)context.getBean("c2");
		System.out.println(c2);
	}

}
