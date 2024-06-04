package part02;

import java.util.Arrays;

public class ReverseArray {
	
	// 역순 정렬 메소드
    static void reverseArray(int[] a) {
    	
    	for(int i = 0; i < a.length / 2; i++) {
    		int temp = a[i];
    		a[i] = a[a.length -i - 1];
    		a[a.length -i - 1] = temp;
    	}
    	
    }

    public static void main(String[] args) {
        int[] numArray = {2, 4, 5, 3, 1, 6};

        reverseArray(numArray);        

        System.out.println("역순 정렬 결과 : " + Arrays.toString(numArray));
    }
}