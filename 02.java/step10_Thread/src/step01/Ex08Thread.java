package step01;

// 데몬 스레드
class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("자동 저장");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			save();
		}
	}
}

// 스레드 그룹
class Worker extends Thread {
	
	public Worker(ThreadGroup groupName, String threadName) {
		super(groupName, threadName);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("무한 업무.");
			
			if(Thread.interrupted()) {
				System.out.println("업무 종료.");
				break;
			}
		}
		System.out.println(getName() + "종료.");
	}
}


public class Ex08Thread {
	public static void main(String[] args) {
		// 데몬 스레드
//		AutoSaveThread auto = new AutoSaveThread();
//		auto.setDaemon(true);
//		auto.start();
//		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		// 스레드 그룹
		ThreadGroup dev = new ThreadGroup("dev");
		
		Worker java = new Worker(dev, "java");
		Worker python = new Worker(dev, "pyton");
		Worker js = new Worker(dev, "js");
		Worker oracle = new Worker(dev, "oracle");
		
		dev.interrupt();
		
	}
}
