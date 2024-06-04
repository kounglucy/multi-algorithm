package part01;

import java.util.Arrays;

public class SelectionSort {
	
	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			
			for(int j = i + 1; j < arr.length; j++) {
				// 최소값을 찾는 과정
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
      swap(arr, i, min);
      
      			// 중간 결과 출력용
			System.out.print((i + 1) + "번째 과정 : ");
			System.out.print(Arrays.toString(arr));
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {7, 29, 14, 6, 23, 11};
		// {6, 7, 11, 14, 23, 29}
		
		System.out.println("-------------------------------");
		System.out.println("정렬 전 : " + Arrays.toString(arr));

		selectionSort(arr);
		
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}

}