package step01;

class ThreadA extends Thread{
	private boolean stop = false;
	private boolean flag = true;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println(Thread.currentThread().getState());
			if(flag) {
				System.out.println("ThreadA는 작업중");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				Thread.yield();
			}
		}
	}
}

class ThreadB extends Thread{
	private boolean stop = false;
	private boolean flag = true;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			if(flag) {
				System.out.println("ThreadB는 작업중");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				Thread.yield();
			}
		}
	}
}

class SumThread extends Thread {
	private long sum;
	
	public long getSum() {
		return sum;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
	}
}

public class Ex05ThreadControl {
	public static void main(String[] args) {
		// sleep()
		/*
		for(int i = 1; i < 11; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
		*/
		
		/*
		// yield(), stop()
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		// A, B 시작
		threadA.start();
		threadB.start();
		
		// B만 실행하게 하고싶다면?
		threadA.setFlag(false);
		
		// A를 확실하게 종료하고 싶다면?
		threadA.setStop(true);
		*/
		
		// join()
		SumThread sumThread = new SumThread();
		sumThread.start();

		
		try {
			// 메인 스레드를 일시정지 -> sumThread가 최종 실행된 후 다시 재실행
			sumThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("총 합은 : " + sumThread.getSum());
	}
}
