package step04.inner;

// 외부 클래스
class OuterClass {
	
	// 외부 클래스의 메소드
	Runnable getRunnable() {
		
		// 지역 클래스
		class MyRunnable implements Runnable {
			@Override
			public void run() {
				
			}
		}
		
		return new MyRunnable();
	}
	
	// 익명 클래스
	Runnable runner = new Runnable() {
		
		@Override
		public void run() {
			
		}
	};
	
}

public class LocalClassTest {
	public static void main(String[] args) {

	}
}
