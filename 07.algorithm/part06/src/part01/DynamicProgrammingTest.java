package part01;

public class DynamicProgrammingTest {
	
	// 재귀함수
    private static int fibonacciRecursive(int n){
    	if(n <= 1) {
    		return n;
    	}else {
    		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    	}
    }
	
    // DP : 가장 최하위의 답을 구해 놓고 -> 저장한 뒤에 해당 결과값을 이용하여 상위 문제를 해결하는 방식
    private static int fibonacciDP(int n){
    	int[] memo = new int[n + 1];
    	memo[0] = 0;
    	memo[1] = 1;
    
    	for(int i = 2; i < n + 1; i++) {
    		memo[i] = memo[i - 1] + memo[i - 2];
    	}
    	
    	return memo[n];
    }
    
	public static void main(String[] args) {
		System.out.println(fibonacciDP(1));
	}
}