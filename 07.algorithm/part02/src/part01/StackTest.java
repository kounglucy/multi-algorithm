package part01;

import java.util.Iterator;
import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
//		 Stack : LIFO
//       [Stack API]
	  // https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
	  // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Stack.html
		
		Stack<Integer> stack = new Stack<Integer>();
//		System.out.println(stack.capacity());
		
		// push : 추가
		stack.push(3);
		stack.push(5);
		
		System.out.println(stack);
		
		// pop : 제거(return)
		System.out.println(stack.pop());
		System.out.println(stack);
		
		// clear : 전체 요소 제거
		stack.clear();
		System.out.println(stack);
		
		// stack 요소가 없을 때 pop -> 예외 발생
//		stack.pop(); // java.util.EmptyStackException
		
		stack.push(7);
		stack.push(1);
		System.out.println(stack);
		
		// peek : 최신 요소 확인(return)
		System.out.println(stack.peek());
		System.out.println(stack);
		
		// stack 요소가 없을 때 peek -> 예외 발생
		stack.clear();
//		stack.peek(); // java.util.EmptyStackException
		
		// size : 크기(요소 개수)
		System.out.println(stack.size());
		
		stack.push(4);
		stack.push(8);
		stack.push(5);
		stack.push(7);
		
		// first/lastElement : 첫번째/마지막 요소 값을 출력
		System.out.println(stack.firstElement()); // 4
		System.out.println(stack.lastElement()); // 7
		
		System.out.println(stack);
		
		// 전체 요소 : for - get(i)
		for(int i = 0; i < stack.size(); i++) {
			System.out.println(stack.get(i));
		}
		
		// Iterator
		Iterator<Integer> iter = stack.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// isEmpty : stack 비어 있는지 여부 확인
		System.out.println(stack.isEmpty());
		
		// contains : stack 내부 지정에 객체 존재 여부 확인
		System.out.println(stack.contains(4));
		
		// indexOf : stack 내부에 지정 객체 위치 확인
		System.out.println(stack.indexOf(3));
		
	}
}