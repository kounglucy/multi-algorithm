package part01;

public class Min {
	static int min(int a, int b, int c) {
		int minValue = a;
		
		if(b < minValue) {
			minValue = b;
		}
		
		if(c < minValue) {
			minValue = c;
		}
		
		return minValue;
	}
	
	public static void main(String[] args) {
		
		int result = min(3, 2, 5);
		System.out.println("최소값은:" + result);
	}
}