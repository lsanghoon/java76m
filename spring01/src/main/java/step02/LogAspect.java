package step02;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	@Before("execution(* set*(..))")
	public void printLog() {
		System.out.println("setter가 호출되었음");
	}
}
