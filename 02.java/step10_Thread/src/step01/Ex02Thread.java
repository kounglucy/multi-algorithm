package step01;

// 스레드 생성 - runnable 인터페이스 구현
public class Ex02Thread implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + (i + 1) + "번 실행");
		}
	}
	
	public static void main(String[] args) {
		Runnable runThread1 = new Ex02Thread();
		Thread thread1 = new Thread(runThread1);
		thread1.setName("스레드1");
		
		Runnable runThread2 = new Ex02Thread();
		Thread thread2 = new Thread(runThread2);
		thread2.setName("스레드2");
		
		// 우선순위
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MIN_PRIORITY);
		
		thread1.start();
		thread2.start();
	}
}







