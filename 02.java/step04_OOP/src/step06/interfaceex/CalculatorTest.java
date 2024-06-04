package step06.interfaceex;

public class CalculatorTest {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println(calculator.add(1, 2));

//	다른 두 인터페이스에 메소드 이름이 같으면 구별 하는 방법이 있나요?
//	인터페이스는 객체를 생성할 수 없지 않나요?
		Calculation tester = new Calculator();
		tester.test();
	}
}
