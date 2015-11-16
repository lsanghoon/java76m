package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test05 {

	public static void main(String[] args) throws Exception {
		// 스프링 설정파일을 읽고 인스턴스를 준비하라
		ApplicationContext context = new  ClassPathXmlApplicationContext(
				"step01/application-context05.xml");

		System.out.println("익명 빈의 이름 알아내기");
		for (String name : context.getBeanDefinitionNames()) {
			System.out.println(name);

			System.out.println("익명 빈의 별명");
			for (String alias : context.getAliases(name)) {
				System.out.println("  " + alias);
				System.out.println();
			}
			if (context.getAliases(name).length == 0)
				System.out.println("  별명 없음");
			System.out.println();
		}

	}

}
