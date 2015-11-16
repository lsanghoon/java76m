package step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01.Computer;

public class test05 {

	public static void main(String[] args) {
		ApplicationContext context = new  ClassPathXmlApplicationContext(
				"step02/application-context05.xml");
		
		Computer5 c1 = (Computer5)context.getBean("c1");
		Computer5 c2 = (Computer5)context.getBean("c2");
		Computer5 c3 = (Computer5)context.getBean("c3");
		Computer5 c4 = (Computer5)context.getBean("c4");
		Computer5 c5 = (Computer5)context.getBean("c5");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
	}

}
