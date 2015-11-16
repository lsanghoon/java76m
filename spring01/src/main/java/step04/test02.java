package step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test02 {

	public static void main(String[] args) {
		ApplicationContext context = new  ClassPathXmlApplicationContext(
				"step04/application-context02.xml");
		
		Computer c1 = (Computer)context.getBean("c1");
		Computer c2 = (Computer)context.getBean("c2");
		Computer c3 = (Computer)context.getBean("c3");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		//c2에 저장된 Monitor객체와 c3에 저장된 Monitor객체는 다른것이다.
		System.out.println(c2.getMonitor().hashCode());
		System.out.println(c3.getMonitor().hashCode());
		
		if (c2.getMonitor() == c3.getMonitor())
			System.out.println("c2모니터 == c3모니터");
	}

}
