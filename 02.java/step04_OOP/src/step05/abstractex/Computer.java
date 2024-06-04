package step05.abstractex;

public abstract class Computer {
	
	// 
	public void display() {
		System.out.println("컴퓨터 화면 출력 기능");
	}
	
	abstract void typing();
	
	// 전원 on/off
	abstract void turnOn();
	abstract void turnOff();
	
	
	// 테스트 기능
	public void test() {};
}






