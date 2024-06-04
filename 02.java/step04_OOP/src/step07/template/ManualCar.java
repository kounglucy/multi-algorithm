package step07.template;

public class ManualCar extends Car{

	@Override
	public void drive() {
		System.out.println("사람이 운전합니다.");
	}

	@Override
	public void stop() {
		System.out.println("사람이 브레이크를 밟아 정지합니다.");
	}
}
