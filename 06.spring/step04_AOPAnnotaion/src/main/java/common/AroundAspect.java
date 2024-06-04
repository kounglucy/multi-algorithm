package common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {
	
	@Around("execution(* biz.Car.*(..))")
	public void aroundAspect(JoinPoint joinPoint) {
		// @Around 편리함, 그러나 : 해당 메소드(target)의 before/after 시점 지정 X
		// 이를 해결하기 위해 나온 JoinPoint interface
		
		Signature signature = joinPoint.getSignature();
//		System.out.println(signature.toLongString());
		
		ProceedingJoinPoint proJoinPoint = (ProceedingJoinPoint)joinPoint;
		try {
//			System.out.println("자동차를 구매 예정인가요?");
			Object returnValue = proJoinPoint.proceed();
//			System.out.println("자동차 구매를 완료했습니다.");
			System.out.println(returnValue);
		} catch (Throwable e) {
//			e.printStackTrace();
			System.out.println("문제 발생 : " + e.getMessage());
		}
	}
}
