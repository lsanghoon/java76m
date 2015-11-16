package step17.ex02;

public class Test01 {

static class MyThread extends Thread {
		// 스레드 정의 - Thread를 상속받아
		public MyThread(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			for  (int i = 0; i < 100; i++) {
				System.out.println(this.getName() + i);
			}
		}
	}

	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1 ");
		
		//=> 스레드시작
		t1.start();	
		// CPU 사용권을 얻기 위해 대기하는 상태로 들어간다. "Runnable"상태
		// Runnable 상태로 보낸 후 즉시 리턴한다. => 다음문장으로 
		
		System.out.println("*****************");
		// main 스레드가 main()호출을 끝냈다 하더라도,
		// 자식 스레드가 실행중이면 JVM을 종료하지 않는다.
	}

}
