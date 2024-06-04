package common;

// 공통 기능 
public class NoticeAspect {
	public void noticeBuyStart() {
		System.out.println("자동차를 구매 예정이신가요?");
	}
	
	public void noticeBuyEnd() {
		System.out.println("자동차 구매를 완료했습니다.");
	}
	
	
	public void noticeReturnValue(String value) {
		if(value != null) {
			System.out.println(value);
		}
	}
	
	public void noticeException(Exception e) {
		System.out.println("문제 발생 : " + e.getMessage());
	}
	
}
