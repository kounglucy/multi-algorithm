package step07.template;

public class AICar extends Car{

	@Override
	public void drive() {
		System.out.println("AI가 자율주행 합니다.");
	}

	@Override
	public void stop() {
		System.out.println("AI가 스스로 정지합니다.");
	}
}
