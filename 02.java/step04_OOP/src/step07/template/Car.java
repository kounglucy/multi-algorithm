package step07.template;

public abstract class Car {
	
	// 공통 메소드
	public void turnOn() {
		System.out.println("시동을 켭니다.");
	}
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	// 특정 정의 메소드
	public abstract void drive();
	public abstract void stop();
	
	// 템플릿 패턴
	final public void run() {
		turnOn();
		drive();
		stop();
		turnOff();
	}
}











