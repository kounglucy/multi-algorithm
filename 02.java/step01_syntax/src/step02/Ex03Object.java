package step02;

class A {
	A() {
		System.out.println("Class A");
	}
}

class B {
	// 멤버변수, 필드
	A a = new A();
	// 생성자
	B() {
		System.out.println("Class B");
	}
}


public class Ex03Object {
	public static void main(String[] args) {
		
//		A a = new A();
		B b = new B();
		
		// B 타입의 b 객체 생성에 주목 : B객체의 생성완료 시점은 언제인가?
		// 객체의 생성은 객체가 보유하고 있는 모든 필드(멤버변수)들이
		// 메모리에 올라가서 생성된 이후에 객체의 생성이 완료된다!
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
