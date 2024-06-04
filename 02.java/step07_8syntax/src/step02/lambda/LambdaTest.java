package step02.lambda;

public class LambdaTest {
	// 함수형 인터페이스
	// 람다1
	@FunctionalInterface
	interface Lambda1 {
		void method1();
	}
	
	// 람다2
	@FunctionalInterface
	interface Lambda2 {
		void method2(int i);
	}
	
	// 람다3
	@FunctionalInterface
	interface Lambda3 {
		int method3(int x, int y);
	}
	
	// * 적용
	@FunctionalInterface
	interface Calculation {
		int operation(int x, int y);
	}
	
	static int operate(int x, int y, Calculation calculation) {
		return calculation.operation(x, y);
	}
	
	public static void main(String[] args) {
		// * 적용
		Calculation add = (x, y) -> x + y;
		Calculation sub = (x, y) -> x - y;
		
		System.out.println(operate(5, 5, add));
		System.out.println(operate(5, 5, sub));
		
		// 람다 1 : 매개 변수가 없는 람다식
		Lambda1 lambda1;
		lambda1 = () -> System.out.println("람다 1");
		
		// System.out.println(lambda1);
		
		// 람다 2 : 매개변수가 있는 람다식, 1개(자료형, 코드블럭 생략 가능)
		Lambda2 lambda2;
		lambda2 = i -> System.out.println(i + 10);
		
//		lambda2.method2(1);
		
		
		// 람다 3 : 매개변수가 2개 이상(자료형, 코드블럭 + return 생략가능)
		Lambda3 lambda3;
		lambda3 = (x, y) -> x + y;
		
//		System.out.println(lambda3.method3(10, 20));
		
	}
}
