package part01;

public class Pyramid {

	// * 피라미드
	// (n-1) * 2 + 1 => *
	static void starPyramid(int n) {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= (n-i); j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= (i-1) * 2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// number 피라미드
	static void numberPyramid(int n) {

	}
	
	public static void main(String[] args) {
		int n = 5;
		starPyramid(n);		
		numberPyramid(n);
	}

}