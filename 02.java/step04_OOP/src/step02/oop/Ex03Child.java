package step02.oop;

class Parent3 extends Object {
	String name;
	
	@Override
	public String toString() {
		return name;
	}
}

class Child3 extends Parent3 {
	String nickName;
	
	@Override
	public String toString() {
		return name + " " + nickName;
	}
}
	
public class Ex03Child {
	public static void main(String[] args) {
//		Parent3 p3 = new Parent3();
//		p3.name = "java";
//		System.out.println(p3);
	
		Child3 c3 = new Child3();
		c3.name = "it";
		c3.nickName = "dev";
		// ?
		System.out.println(c3);
	
	}
}














