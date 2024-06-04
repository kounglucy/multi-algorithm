package part01;

import java.util.Arrays;

public class BubbleSort {

	// swap
	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static void bubbleSort(int[] arr) {
		// 전체 반복 횟수 지정
		for(int i = 0; i < arr.length; i++) {
			for(int j = arr.length - 1; j > i; j--) {
				// 자리를 바꿔야 하는 조건(맨 뒤에서 부터 앞에 있는 값을 비교)
				if(arr[j] < arr[j-1]) {
//					int temp = arr[j-1];
//					arr[j-1] = arr[j];
//					arr[j] = temp;
					swap(arr, j-1, j);
				}
			}
		}
	}
	
	public static void bubbleSort2(int[] arr) {
		// 전체 반복 횟수 지정
		for(int i = arr.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				// 자리를 바꿔야 하는 조건(맨 뒤에서 부터 앞에 있는 값을 비교)
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}
  
	public static void main(String[] args) {
		int[] arr = {7, 29, 14, 6, 23, 11};
		
		System.out.println("-------------------------------");
		System.out.println("정렬 전 : " + Arrays.toString(arr));

//		bubbleSort(arr);
    bubbleSort2(arr);
		
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}

}