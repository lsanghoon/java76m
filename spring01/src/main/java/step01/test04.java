package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test04 {

	public static void main(String[] args) throws Exception {
		// 스프링 설정파일을 읽고 인스턴스를 준비하라
		ApplicationContext context = new  ClassPathXmlApplicationContext(
				"step01/application-context03.xml");

		System.out.println("빈의 이름 & 별명");
		for (String name : context.getBeanDefinitionNames()) {

			System.out.println(name + "의 별명");
			for (String alias : context.getAliases(name)) {
				System.out.println("  " + alias);
			}
			
			if (context.getAliases(name).length == 0)
				System.out.println("  별명없음");
		}

		System.out.println("\n특정 타입의 빈 이름");
		//		Class<?> classInfo = Class.forName("step01.Computer");
		//		Class<?> classInfo = step01.Computer.class;
		for (String name : context.getBeanNamesForType(step01.Computer.class))
			System.out.println(name);
	}

}
