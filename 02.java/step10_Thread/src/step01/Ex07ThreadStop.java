package step01;

class InterruptedThread extends Thread {
	
	@Override
	public void run() {
		while(true) {
			System.out.println("무한 실행.");
			
			if(Thread.interrupted()) {
				System.out.println("즐, 종료함");
				break;
			}
		}
	}
}

public class Ex07ThreadStop {
	public static void main(String[] args) {
		InterruptedThread iThread = new InterruptedThread();
		
		iThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		iThread.interrupt();
	}
}
