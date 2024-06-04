package part01;

public class BinarySearchTest {
	
	// arr : 검색 배열, target : 검색 대상, min/max : 배열 최소/최대 인덱스
	public static int linearSearch(int arr[], int target, int min, int max) {
		while(min < max) {
			if(arr[min] == target) {
				return min;
			}
			min++;
		}
		
		return -1;
	}
	
	public static int binarySearch(int arr[], int target, int min, int max) {
	    int mid;

	    while(min <= max) {
	        mid = (min + max) / 2;

	        if (arr[mid] == target)
	            return mid;
	        else if (arr[mid] > target)
	            max = mid - 1;
	        else
	            min = mid + 1;
	    }
	    return -1;
	}
	
	public static int binarySearchRecursive(int arr[], int target, int min, int max) {
	    if (min > max)
	        return -1;

	    int mid = (min + max) / 2;
	    if (arr[mid] == target)
	        return mid;
	    else if (arr[mid] > target)
	        return binarySearchRecursive(arr, target, min, mid-1);
	    else
	        return binarySearchRecursive(arr, target, mid+1, max);
	}
	
	public static void main(String[] args) {
		
		// 주어진 배열 내부에서 target의 위치(index) 반환
		int[] arr = {17, 28, 43, 67, 88, 92, 100};
		
		//[params] arr : 검색 배열, target : 검색 대상, min/max : 배열 최소/최대 인덱스
		System.out.println(linearSearch(arr, 28, 0, arr.length - 1));
	}
}
