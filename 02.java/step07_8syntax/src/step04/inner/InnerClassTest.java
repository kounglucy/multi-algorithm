package step04.inner;

// 외부 클래스
class Outer {
	int outerNum = 10;
	
	// 내부 클래스
	class Inner {
		int innerNum = 100;
		
		void innerMethod() {
			System.out.println("내부 클래스 메소드");
		}
	}

	void outerMethod() {
		System.out.println("외부 클래스 메소드");
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		Outer outerClass = new Outer();
		outerClass.outerMethod();
		
		// 내부 클래스
//		Inner innerClass = new Inner(); // 불가능!
		Outer.Inner innerClass = outerClass.new Inner();
		innerClass.innerMethod();
	}
}











