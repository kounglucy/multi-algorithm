package part01;

import java.util.Arrays;

public class InsertionSort {
	
	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j;
			for(j = i; j > 0 && arr[j-1] > temp; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = temp;
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {7, 29, 14, 6, 23, 11};
		// {6, 7, 11, 14, 23, 29}
		
		System.out.println("-------------------------------");
		System.out.println("정렬 전 : " + Arrays.toString(arr));

		insertionSort(arr);
		
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}

}