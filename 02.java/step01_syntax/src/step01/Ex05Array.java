package step01;

import java.util.Arrays;

public class Ex05Array {
	public static void main(String[] args) {
		// 배열 : *** 반드시 초기값(배열의 크기)을 가져야 함!
		int[] arr1 = new int[5];
		
		int[] arr2 = {1, 2, 3, 4, 5};
		// 자바에서 배열은 선언만 하고 사용 X
		String[] idol; 
		idol = new String[] {"레드벨벳", "뉴진스", "아이브"};
		
		// 데이터 접근
//		System.out.println(arr2[4]);
		// * 주의
//		System.out.println(arr2[5]); // 예외
		
		// ? 모든 데이터 출력 ?
//		System.out.println(arr2.toString()); // [I@15db9742
//		for(int i = 0; i < arr2.length; i++) {
//			System.out.println(arr2[i]);
//		}
		
		// 향상된 for문
		/*
		 	for(타입 변수 : 집합객체명) {
		 		수행코드;
		 	}
		 */
		for(int v : arr2) {
			System.out.println(v);
		}
		
		// 복사 
		// 얕은 복사
		int[] nums = {1, 2, 3};
		int[] copyNums = nums;
		
		copyNums[1] = 20;
		System.out.println(copyNums[1]);
		System.out.println(nums[1]); // 2 -> 20
		// call by reference
		
		
		// 완벽하게 분리하기 위해서는? -> 깊은 복사 (교안 p83)
		// Arrays.copyOf
		int[] deepNums = Arrays.copyOf(nums, nums.length);
	}
}
