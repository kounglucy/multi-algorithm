package part01;

//[퀵정렬 사용 가능 예제]
//https://school.programmers.co.kr/learn/courses/30/lessons/42746

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] strs = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            strs[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strs, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));
        
        for(int i = 0; i < strs.length; i++) {
            answer += strs[i];
        }
        
        return (strs[0].equals("0"))? "0": answer;
    }
}