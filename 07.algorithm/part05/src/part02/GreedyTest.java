package part02;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 500원, 100원, 50원 , 10원의 동전이 있다.
 * 5870을 지불할 때, 최소 개수의 동전을 사용하는 방법은 무엇인가?
 */

public class GreedyTest {

    public static void main(String[] args) {

        ArrayList<Integer> coinList = new ArrayList<Integer>(Arrays.asList(500,100,50,10));

        int price = 5870;
        int totalCoinCount = 0;
        int coinCount = 0;
        
        for(int i = 0; i < coinList.size(); i++) {
        	coinCount = price / coinList.get(i); // 현재 동전 개수
        	totalCoinCount += coinCount;		 // 전체 동전 개수
        	price = price - (coinCount * coinList.get(i)); // 사용된 동전수*금액을 뺀 값을 대입
        	
        	System.out.println(coinList.get(i) + "원 동전 : " + coinCount + "개 사용");
        }

        System.out.println("총 사용 동전 수 : " + totalCoinCount + "개");
    }
}
