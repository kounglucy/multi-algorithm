package part01;

import java.util.Arrays;

public class QuickSort {
	
	// swap
	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
    public static void quickSort(int array[], int left, int right){
    	int start = left;
    	int end = right;
    	int pivot = array[(start + end) / 2];
    	
    	while(start <= end) {
    		while (array[start] < pivot) {
    			start++;
    		};
    		while (array[end] > pivot) {
    			end--;
    		};
    		if(start <= end) {
    			swap(array, start, end);
    			start++;
    			end--;
    		}
    	}
    	
    	if(left < end) {
    		quickSort(array, left, end);
    	}
    	if(start < right) {
    		quickSort(array, start, right);
    	}
    }
	
	public static void main(String[] args) {
		int[] arr = {7, 29, 14, 6, 23, 11};
		// {6, 7, 11, 14, 23, 29}
		
		System.out.println("-------------------------------");
		System.out.println("정렬 전 : " + Arrays.toString(arr));

		quickSort(arr, 0, arr.length-1);
		
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}

}


