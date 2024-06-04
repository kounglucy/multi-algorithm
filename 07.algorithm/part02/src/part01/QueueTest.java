package part01;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		// Queue : FIFO
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// add : 추가
		queue.add(3);
		queue.add(9);
		
		System.out.println(queue);
		
		// poll : 제거(front -> dequeue)
		queue.poll();
		System.out.println(queue);
		
		// remove : 제거
		queue.remove();
		System.out.println(queue);
		
		// poll은 queue가 비어있어도 실행 -> null
		System.out.println(queue.poll());
//		System.out.println(queue.remove()); // java.util.NoSuchElementException
		
		queue.add(4);
		queue.add(8);
		queue.add(5);
		queue.add(7);
		System.out.println(queue);
		
		// size, iterator, isEmpty, contains 사용 가능
		// queue에서의 peek dequeue대상(front)을 출력
		System.out.println(queue.peek());
	}
}
