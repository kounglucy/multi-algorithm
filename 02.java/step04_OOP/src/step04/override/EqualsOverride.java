package step04.override;

class Person {
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// equals 재정의
	@Override
	public boolean equals(Object o) {
		
		if(o instanceof Person) {
			// o 객체를 활용하여 name, age 가져 올 수 있어야 함! -> 형변환
			Person p = (Person)o;
			
			// 형변환한 p와 자기 자신의 name, age 값을 비교해야함! -> 같으면 true
			if(this.name.equals(p.name) && this.age == p.age) {
				return true;
			}
		}
		return false; 
	}
}

class Person2 {
	String name;
	int age;
	
	Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class EqualsOverride {
	public static void main(String[] args) {
		Person p = new Person("java", 28);
		Person p1 = new Person("java", 28);
		Person2 p2 = new Person2("java", 28);
		
		// ? 같은 타입 && 같은 이름 && 같은 나이 ==> 같은 객체
		System.out.println(p.equals(p1)); // f ==> t
		System.out.println(p.equals(p2)); // f
		
		
	}
}







