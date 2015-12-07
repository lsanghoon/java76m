package step11;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {
	
	static Logger logger = Logger.getLogger(test01.class);

	public static void main(String[] args) {
		ApplicationContext context = new  ClassPathXmlApplicationContext(
				"step11/application-context01.xml");
		
		logger.info(context.getBean("computer"));
		
		
	}

}
