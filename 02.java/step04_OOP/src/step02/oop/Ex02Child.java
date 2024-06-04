package step02.oop;

class Parent2 extends Object{
	String name;
	int age;
	
	Parent2() {
		super();
	}
	
	void printAll() {
		System.out.println(name);
		System.out.println(age);
	}
}

class Child2 extends Parent2 {
	String wish;
	
	public Child2() {
		super();
	}
	
	
	void printAll() {
		super.printAll();
		System.out.println(wish);
	}
	
	// 다형성 적용 메소드
	static Object toDo() {
		return "Study";
	}
	
	static Object toDo2() {
		return "Study,Exercise,Cleaning,Sleeping";
	}
}

public class Ex02Child {
	public static void main(String[] args) {
		// ? y만 출력하기 : toDo() 메소드 이용 : charAt()
//		System.out.println( ((String)Child2.toDo()).charAt(4) );
		
		// Study 문자열을 char[] 배열로 저장하여 출력하기 개발
		/* 단계
		 * step1
		 * 	- toDo2() 반환값을 , 를 기준으로 String[] toDoLists 배열에 저장
		 * 	- 반환값 -> 변환(String) -> 배열로 변환
		 * 
		 * hint : charAt()/length()/split()
		 * 
		 * step2
		 * 	- toDoLists 첫번째 index에 저장된 Study이라는 문자열을 
		 * 	  새롭게 생성한 char[] cArray 배열에 저장 후 출력
		 */
		
		// step1
		/* step1의 결과값
		 *  
		 * Study
		   Exercise
		   Cleaning
		   Sleeping
		 * 
		 */
		System.out.println("=======step1 결과값=======");
		String[] toDoLists = ((String)Child2.toDo2()).split(",");
		for(String toDo : toDoLists) {
			System.out.println(toDo);
		}
		
		// step2
		/* step2의 결과값
		 * 
		 * S	
		 * t	
		 * u	
		 * d	
		 * y	
		 */
		System.out.println("=======step2 결과값=======");
		System.out.println("===String[]의 첫번째 데이터 값으로 char[]에 저장하기===");
		System.out.println(toDoLists[0]);
		char[] cArray = new char[toDoLists[0].length()];
		for(int i = 0; i < cArray.length; i++) {
			cArray[i] = toDoLists[0].charAt(i);
		}

		System.out.println("===저장된 char[] 데이터값 출력해 보기===");
		for(char v : cArray) {
			System.out.println(v);
		}
	}
}


