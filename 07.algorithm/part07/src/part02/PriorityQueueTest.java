package part02;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(2);		
		pq.add(12);		
		pq.add(10);
		pq.add(23);		
		pq.add(35);		
		pq.add(16);
		
		System.out.print(pq);
	}
}
