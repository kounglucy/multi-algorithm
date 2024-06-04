package Test;
import java.util.*;

public class Solution {
    public static int[] solution(int []arr) {
        
        // stack 또는 queue를 
        // 어떻게 적용할 수 있을까?
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]){
                queue.add(arr[i-1]);
            }
        }
        queue.add(arr[arr.length - 1]);
        
        int[] answer = new int[queue.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }
        
        return answer;
    }
}
