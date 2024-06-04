package step02.oop;

// 객체 지향 프로그래밍 Object Oriented Programming
// 부모 클래스
class Parent extends Object {
	String name;
	int age;
	
	public Parent() {
//		System.out.println("부모 생성자");
	}
	public Parent(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
//		System.out.println("부모 메소드");
	}
}

// 자식 클래스
class Child extends Parent {
	String wish;
	
	public Child() {
		super();
		System.out.println("자식 생성자");
	}
	
	// 사용자 정의 생성자
	public Child(String name, int age, String wish) {
		
		// version 3
		super(name, age);
		this.wish = wish;
		
		// version 2
//		super.name = name;
//		super.age = age;
//		this.wish = wish;

		// version 1
//		this.name = name;
//		this.age = age;
//		this.wish = wish;
	}
	
	// 메소드 오버라이딩 
	public void printInfo() {
		System.out.println(wish);
//		System.out.println("자식 메소드");
	}
	public void printInfo(String name) {
		System.out.println(wish);
		System.out.println(name);
//		System.out.println("자식 메소드");
	}
}

public class Ex01Child {
	public static void main(String[] args) {
		Child child = new Child("java", 29, "travel");
		// 상속을 통해 부모는 자식에게 필드, 메소드를 전달할 수 있다.
//		child.name = "java";
//		child.age = 29;
//		child.wish = "travel";
		
//		child.printInfo();
//		child.printInfoChild();

		// 자식이 사용하는 메소드명이 부모와 똑같다면?
		// 자식 객체를 통해 사용하게 되는 메소드는 자식의 메소드이다!
		// 그런데 여기서 주의할점!
		// 단, 조건이 있음
		// 부모의 메소드 형태와 자식의 메소드 형태가 반드시 똑같을때에만!
		// 이런한 현상을 메소드 오버라이딩(Overriding)이라고 한다.
//		child.printInfo();
//		child.printInfo("자식");
		
		// 다형성 : 타입을 다양한 형태로 변경시킬 수 있음
		Parent p1 = new Parent();
		Child c1 = new Child();
		
		// 자동 타입 변환 : 자식 객체가 부모의 타입으로 생성
		Parent c2 = new Child();
		/*
		 * Child c = new Child();
		 * Parent c2 = c;
		 * 
		 */
		
		// 부모의 객체는 자식의 타입으로 생성이 가능할까? 불가능
//		Child p2 = new Parent(); // 에러
		
		// 강제 타입 변환 : 자식 객체가 부모의 타입으로 생성 되었다가 다시 자식 타입으로 변환
		Child c3 = (Child)c2;
	}
}












