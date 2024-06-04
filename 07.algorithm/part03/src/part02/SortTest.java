package part02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortTest {
	public static void main(String[] args) {
		// 오름차순 정렬
		int[] numArray1 = {7, 29, 14, 6, 23, 11};
		
//		System.out.println("정렬 전 : " + Arrays.toString(numArray1));
//		Arrays.sort(numArray1);
//		System.out.println("정렬 후 : " + Arrays.toString(numArray1));
//		System.out.println();
		
		// 내림차순 정렬?
		/*
			[Comparable]
			https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
			https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html
			
			[Comparator]
			https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
			https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Comparable.html
		 */
		Integer[] numArray2 = {7, 29, 14, 6, 23, 11};
		
//		System.out.println("정렬 전 : " + Arrays.toString(numArray2));
		
//		Arrays.sort(numArray2);
//		Arrays.sort(numArray2, Collections.reverseOrder());
//		Arrays.sort(numArray2, new Comparator<Integer>() {
//			@Override
//			public int compare(Integer integer1, Integer integer2) {
//				// return int 값이 양수 -> 자리를 변경
//				return integer2 - integer1;
//			}
//		});
//		Arrays.sort(numArray2, (i1, i2) -> i2 - i1);
//		
//		System.out.println("정렬 후 : " + Arrays.toString(numArray2));
//		System.out.println();
		
		String[] nameArray = {"dev", "it", "devops", "tech"};
		
//		System.out.println("정렬 전 : " + Arrays.toString(nameArray));
//		Arrays.sort(nameArray, Collections.reverseOrder());
		
		// nameArray 정렬 : 문자열의 길이(오름차순)
		// 예상 결과 : [it, dev, tech, devops]
//		Arrays.sort(nameArray, new Comparator<String>() {
//			@Override
//			public int compare(String str1, String str2) {
//				// return int 값이 양수 -> 자리를 변경
//				return str1.length() - str2.length();
//			}
//		});
		
//		System.out.println("정렬 후 : " + Arrays.toString(nameArray));
//		System.out.println();
		
		
	}
}

