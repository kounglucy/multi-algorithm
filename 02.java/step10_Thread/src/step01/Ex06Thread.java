package step01;

class WorkObject {
	public synchronized void methodA() {
		System.out.println("WokerA의 메소드 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB() {
		System.out.println("WokerB의 메소드 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class WokerA extends Thread{
	private WorkObject workObject;
	
	public WokerA(WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			workObject.methodA();
		}
	}
}

class WokerB extends Thread{
	private WorkObject workObject;
	
	public WokerB(WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			workObject.methodB();
		}
	}
}

public class Ex06Thread {
	public static void main(String[] args) {
		WorkObject sharedObject = new WorkObject();
		
		WokerA wokerA = new WokerA(sharedObject);
		WokerB wokerB = new WokerB(sharedObject);
		
		wokerA.start();
		wokerB.start();
	}
}
