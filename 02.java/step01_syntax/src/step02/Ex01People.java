package step02;

// 사람 People
class People {
	// 멤버변수, 필드
	String name = "java";
	int age = 29;
	
	// *생성자 : 반환값이 X, 클래스의 이름과 똑같아야 함!, 클래스의 필수 요소!
	// 기본 생성자 : 다른 생성자가 없는 경우에는 자동으로 만들어 줌!
	People(){}
	People(String name){
		this.name = name;
	}
	
	// 메소드
	// 이름(String) 반환하는 메소드 getName()
	String getName() {
		return name;
	}
	
	// 나이(age) 반환하는 메소드 getAge()만들기
	int getAge() {
		return age;
	}
	
	// 단순 출력 (name, age) printInfo() 만들기(단, 반환값 없음 void)
	void printInfo() {
		System.out.println(name + " " + age);
	}
}

public class Ex01People {
	public static void main(String[] args) {
		
		// 객체 생성 : 타입(클래스명) 변수명  = new 생성자명();
		// 인스턴스 : 객체가 힙 메모리 영역에 올라가 있을때
		People java = new People();
		System.out.println(java.getName());
		System.out.println(java.getAge());
		java.printInfo();
	}
}














