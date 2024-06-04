package common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 공통 기능 
@Aspect
@Component
public class NoticeAspect {
//	@Before("execution(* biz.Car.buy(..))")
	public void noticeBuyStart() {
		System.out.println("자동차를 구매 예정이신가요?");
	}
	
//	@After("execution(* biz.Car.buy(..))")
	public void noticeBuyEnd() {
		System.out.println("자동차 구매를 완료했습니다.");
	}
	
//	@AfterReturning(pointcut = "execution(* biz.Car.buyReturn(..))", returning = "value")
	public void noticeReturnValue(String value) {
		if(value != null) {
			System.out.println(value);
		}
	}
	
//	@AfterThrowing(pointcut = "execution(* biz.Car.sellMoney(..))", throwing = "e")
	public void noticeException(Exception e) {
		System.out.println("문제 발생 : " + e.getMessage());
	}
	
}
