package part02;

public class FactorialTest {
	
	// 2! = 1 * 2
	// 3! = 2! * 3
	// 4! = 3! * 4
	static int factorial(int n) {
		if(n > 0) {
			return n * factorial(n - 1);
		} else {
			return 1;
		}
	}
	
	// ver2 : 재귀함수 사용X
	static int factorial2(int n) {
		int result = 1;
		
		// 
		while(n > 1) {
			result *= n--;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int result = factorial(2);
		System.out.println("factorial 결과 : " + result);
	}

}
