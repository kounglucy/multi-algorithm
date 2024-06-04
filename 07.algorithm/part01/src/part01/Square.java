package part01;

public class Square {
	public static void main(String[] args) {
		
		System.out.println("지정 n 만큼의 정사각형 * 출력");
		int n = 5;
		
    for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}