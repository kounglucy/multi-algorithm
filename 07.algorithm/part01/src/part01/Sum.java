package part01;

public class Sum {

	// a ~ b 사이 자연수의 총합
	static int sumof(int a, int b) {
		// a, b의 크기 비교 (반복문의 조건에서 큰 값이 앞에 들어가면 실행X)
		int start;
		int end;
		
		if(a < b) {
			start = a;
			end = b;
		} else {
			start = b;
			end = a;
		}
		
		int sum = 0;
		
		for(int i = start; i <= end; i++) {
			sum += i;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		int sum = sumof(5, 1);
		
		System.out.println("최종 합 : " + sum);

	}

}
