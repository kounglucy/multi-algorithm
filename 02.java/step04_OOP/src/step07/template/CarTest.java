package step07.template;

public class CarTest {
	public static void main(String[] args) {
		ManualCar mCar = new ManualCar();
		mCar.run();
		
		System.out.println();
		
		AICar aiCar = new AICar();
		aiCar.run();
	}
}
