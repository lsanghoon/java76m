package step17.ex01;

public class Test03 {
	
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println("현재 스드명: " + main.getName());
		
		ThreadGroup tg = main.getThreadGroup();
		System.out.println("main 스레드의 그룹명: " + tg.getName());
		
		// main 스레드 그룹의 부모 그룹은?
		ThreadGroup parent = tg.getParent();
		System.out.println("main 스레드의 부모 그룹명: " + parent.getName());
		
		// system 스레드 그룹의 부모그뤂은?
		ThreadGroup parent2 = parent.getParent();
		System.out.println("system 스레드의 부모 그룹명: " + parent2);
		
		
		
	}
}
