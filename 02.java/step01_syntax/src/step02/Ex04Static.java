/* 정적(Static)
 * - '고정'이라는 의미를 가지며 객체 소속이 아닌 클래스 소속
 * - 객체 생성 없이도 사용 가능(클래스 로딩 -> 메모리상 적재)
 * - 구조 및 종류
 * 		- static 타입 변수
 * 		- static 리턴타입 메소드
 * - 사용 : 공용 데이터 값 지정 -> 상수 Constant, DB 연결, ...
 */
package step02;

class Customer {
	// 필드(인스턴스 변수)
	String name;
	
	// 클래스 변수(static 변수)
	static String company;
	
	// static 변수를 초기화 하기 위해 사용되는 블럭
	static {
		Customer customer = new Customer();
		customer.name = "java";
		
//		name = "java"; // 에러
		company = "google";
	}
	
	// static 메소드
	static void getCompany() {
		System.out.println(company);
	}
	
	// 상수 static final
	static final double PI_VALUE = 3.14;
	
}

public class Ex04Static {
	public static void main(String[] args) {
//		Customer customer1 = new Customer();
//		System.out.println(customer1.name);
//		System.out.println(customer1.company);
		System.out.println(Customer.company);
//		
//		Customer.getCompany();
		
//		Customer.PI = 3.141592;
//		System.out.println(Customer.PI);
	}
}
