package step01;

// 스레드 생성 - Thread 클래스
public class Ex01Thread extends Thread {

	public static void main(String[] args) {
		// 실행
		Ex01Thread thread1 = new Ex01Thread();
		thread1.setName("스레드1");
		thread1.start();
		System.out.println(thread1);
		
		Ex01Thread thread2 = new Ex01Thread();
		thread2.setName("스레드2");
		thread2.start();
		System.out.println(thread2);
		
		
	}
}
