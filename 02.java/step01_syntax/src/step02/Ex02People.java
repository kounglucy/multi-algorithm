package step02;

//사람 People
class People2 {
	// 멤버변수, 필드
	String name;
	int age;
	
	// *생성자 : 반환값이 X, 클래스의 이름과 똑같아야 함!, 클래스의 필수 요소!
	// 기본 생성자
	People2(){}
	
	// 사용자 정의 생성자
	// overloading 생성자 오버로딩 
	People2(String name){
		this.name = name;
	}
	People2(int age){
		this.age = age;
	}
	People2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 메소드
	// getXXX : getter
	// 이름(String) 반환하는 메소드 getName()
	String getName() {
		return this.name;
	}
	
	// 나이(age) 반환하는 메소드 getAge()만들기
	int getAge() {
		return this.age;
	}
	
	// setXXX : setter
	// setAge(int age)
	void setAge(int age) {
		if(age > 0) {
			this.age = age;
		}
	}
	
	// 단순 출력 (name, age) printInfo() 만들기(단, 반환값 없음 void)
	void printInfo() {
		System.out.println(name + " " + age);
	}
}

public class Ex02People {

	public static void main(String[] args) {
		People2 java = new People2("java", 29);
		System.out.println(java.name);
		System.out.println(java.age);
		
		// 필드를 통해 값을 직접 할당하는 경우에는
		// 특정 조건을 줄 수 없음!
		// 따라서, 이부분을 해결하기 위해서는 set메소드를 활용!
//		java.age = -30;
//		System.out.println(java.age);
		
		java.setAge(-30);
		System.out.println(java.age);
		
		
		People2 ppl1 = new People2("ppl1", 29);
		People2 ppl2 = new People2("ppl2", 29);
		// 1. ppl1과 ppl2는 같은 타입인가요? 같은 타입입니다.
		// 2. ppl1과 ppl2는 같은 객체인가요? 다른객체 입니다.
		System.out.println(ppl1);
		System.out.println(ppl2);
		
		
		// 기본 생성자는 다른 생성자가 존재하지 않는 경우에
		// 자동으로 생성해준다!
	}
}








