package part02;

public class ArrayTest {
	
	static int maxHeight(int[] heightArray) {
		int max = heightArray[0];
		
		// max와 index:1요소부터 크기를 비교
		for(int i = 1; i < heightArray.length; i++) {
			if(heightArray[i] > max) {
				max = heightArray[i];
			}
		}
		
		return max;
	}
	
	static int sumHeight(int[] heightArray) {
		int sum = 0;
		
		for(int i = 0; i < heightArray.length; i++) {
			sum += heightArray[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		int[] heightArray = {172, 192, 180, 157, 162};
		
		int result1 = maxHeight(heightArray);
		System.out.println("최대 키 값 : " + result1);
		
		int result2 = sumHeight(heightArray);
		System.out.println("키 총합 : " + result2);
	}

}

