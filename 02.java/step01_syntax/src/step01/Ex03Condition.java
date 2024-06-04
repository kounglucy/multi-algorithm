package step01;

public class Ex03Condition {
	public static void main(String[] args) {
		// 조건
		// if문
		// id값이 admin 또는 admin2일때 접속 성공메세지 출력?
		// 문자열 타입
		String id = "admin3";
		// equals
//		if("admin".equals(id) || "admin2".equals(id)) {
//			System.out.println("접속 성공");
//		}else {
//			System.out.println("접속 실패");
//		}
		
		// switch문 : 
		// ex 전화상담
		// 1 -> 고객상담
		// 2 -> 가게연결
		// 3 -> 다시듣기
		int number = 2;
		switch (number) {
			case 1:
				System.out.println("고객상담");
				break;
			case 2:
				System.out.println("가게연결");
				break;
			case 3:
				System.out.println("다시듣기");
				break;
			default:
				System.out.println("해당서비스는 존재x");
				break;
		}	
	}
}
