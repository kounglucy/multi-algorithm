package step01;

class ATM implements Runnable {
	private int deposit = 10000;
	
	// 출금
	public void withdraw(int money) {
		if(deposit > 0) {
			deposit -= money;
			System.out.println(Thread.currentThread().getName() + " 출금 완료.");
			System.out.println("현재 잔액은 : " + deposit + " 입니다.");
		}else {
			System.out.println(Thread.currentThread().getName() + " 잔액 부족.");
		}
		
	}
	
	@Override
	public void run() {
		synchronized (this) {
			for(int i = 0; i < 5; i++) {
				// 출금
				withdraw(1000);
			}
		}
	}
}

public class Ex03Synchronized {
	public static void main(String[] args) {
		ATM atm= new ATM();
		
		Thread byungIn = new Thread(atm, "병인");
		byungIn.start();

		Thread giMoon = new Thread(atm, "기문");
		giMoon.start();
	}
}
