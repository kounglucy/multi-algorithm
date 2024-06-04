package step02;

import model.domain.People;

public class Ex06Practice {
	
	// Q1.
	/* 매개변수로 들어오는 값을 비교하여 같을 경우 true를 반환하는 메소드 개발 - 메소드명 : checkAdmin / 반환값 :
	 * boolean / static
	 * 개발 후 실행결과 확인
	 * step01 -> Condition의 if문 활용하여 메소드 개발 
	 * 		-> 메소드명은 checkAdmin, 입력 id값이 admin1 or admin2일 때 "관리자 접속 성공" 문자열 출력
	 * 		-> 실패 시 "관리자 접속 실패" 문자열 출력
	 */ 
	
	static boolean checkAdmin(String id) {
		return false;
	}
	
	
	// Q2.
	/* 매개변수로 들어오는 값 비교하여 월(~4월까지만) 확인 메소드 개발 - 함수명 : checkMonth / 반환값 없음 / static
	 * step01 -> Condition의 switch / case문 활용하여 메소드 개발
	 */
	 
	private static void checkMonth(int month) {
		switch (month) {
			case 1:
				System.out.println("1월");
				break;
			case 2:
				System.out.println("2월");
				break;
			case 3:
				System.out.println("3월");
				break;
			case 4:
				System.out.println("4월");
				break;
			default:
				System.out.println("1~4까지의 값만 입력해주세요.");
				break;
		}
	}
	
	static People[] peopleArray() {
		People p1 = new People("Java", 28);
		People p2 = new People("IT", 29);
		People[] v = {p1, p2};
		return v;
	}
	
	//Q3. printPeopleName 메소드 개발
	/* printPeopleName(People[] v){} - 배열 내부의 모든 사람 이름 출력 - name 변수는 직접적인 접근 불가 :
	 * private - getName() 호출 가능 : public - for문 활용하여 출력 - 호출만으로 이름 출력할 것
	 */
	
	static void printPeopleName(People[] v) {
		for(int i = 0; i < v.length; i++) {
			System.out.println(v[i].getName());
		}
			
//		for(People p : v) {
//			System.out.println(p.getName());
//		}
		
	}
	
	public static void main(String[] args) {
//		String id = null;
//		boolean result = checkAdmin(id);
//		
//		if(result) {
//			System.out.println("관리자 접속 성공");
//		}else {
//			System.out.println("관리자 접속 실패");
//		}
		
		
//		int month = 2;
//		checkMonth(month);
		
		People[] v = peopleArray();
		printPeopleName(v);
	}
}







