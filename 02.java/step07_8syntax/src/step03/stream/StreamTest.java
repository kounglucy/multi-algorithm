package step03.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		// Optional
		// empty() : 빈 Optional 객체 생성
		Optional<String> opt1 = Optional.empty();
//		System.out.println(opt1);
		
		// of(value / null) : null 이 아닌 데이터 생성 / *NPE 발생
//		Optional<String> opt2 = Optional.of(null);
//		System.out.println(opt2);
		
		// ofNullable(value / null) : null 일 수도 있는 값이 들어가는 경우
		Optional<String> opt3 = Optional.ofNullable(null);
		Optional<String> opt4 = Optional.ofNullable("java");
		// null 이 들어가게 되면 Optional 빈 객체 생성
		System.out.println(opt3);
		System.out.println(opt4);
		
		// ifPresent() : Optional 객체 내부에 데이터가 존재하는 경우만 해당 결과값을 반환
//		opt3.ifPresent(v -> System.out.println(v));
//		opt4.ifPresent(v -> System.out.println(v));
		
		// orElse : 빈 Optional 라면 orElse 내부 파라미터로 받은 값이 반환
		//          값을 내부에 갖고 있는 Optional 라면 해당 보유 값을 반환
		
//		System.out.println(opt3.orElse("orElse"));
//		System.out.println(opt4.orElse("orElse"));

		// orElseThrow : 파라미터로 Exception 객체 전달, 만약 null 아닐경우 해당 보유 객체값을 반환
		try {
			System.out.println(opt4.orElseThrow(NoSuchElementException::new));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 스트림 Stream
		// step01 : 스트림 생성
		System.out.println();
		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		System.out.println(list1);
		
		Stream<Integer> stream1 = list1.stream(); 
		stream1.forEach(num -> System.out.println(num));
		
		// 배열을 이용한 스트림
		int[] intArray = {1, 2, 3};
		IntStream intStream = Arrays.stream(intArray);
		System.out.println(intStream);
		
		System.out.println();
		
		// step02 : 중개 연산
		// filter() : 스트림 내 요소중 조건애 맞는 것을 필터 -> 반환
		List<String> fruitList = Arrays.asList("mango", "watermelon", "kiwi");
		// "m" 문자열이 포함되어 있는것만 출력
		fruitList.stream()
				.filter(fruit -> fruit.contains("m"))
				.forEach(fruit -> System.out.println(fruit));
		
		System.out.println();
		
		// map() : 스트림 내 요소들이 특정 로직 수행 한 후, 새로운 스트림을 반환
		List<Integer> integerList = Arrays.asList(2, 1, 3);
		integerList.stream()
					.map(i -> i + 10)
					.forEach(i -> System.out.println(i));
		
		System.out.println();
		
		// sorted() : 정렬
		integerList.stream()
					.sorted()
					.forEach(v -> System.out.println(v));
		
		// step03 : 최종 연산
		// count, min, max, sum
		// collect : toList, toSet, toMap
		System.out.println();
		
		List<Integer> integerList2 = Arrays.asList(1, 3, 5, 2, 1, 5, 26, 3, 2, 1);
		System.out.println(integerList2.stream()
										.count());
		
		System.out.println(integerList2.stream()
										.collect(Collectors.toSet()));
		
		// 실습
		System.out.println("---실습!!!---");
	    //reduce : 누적된 값을 계산합니다.
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(numbers.reduce((x, y) -> x + y));
		
		// forEach
		System.out.println();
		Arrays.asList(1, 2, 3).stream()
								.forEach(System.out::println);
		
		// map
		System.out.println();
		Arrays.asList(1, 2, 3).stream()
								.map(i -> i * i)
								.forEach(System.out::println);
		
		// skip
		System.out.println();
		Arrays.asList(1, 2, 3).stream()
								.skip(2)
								.forEach(System.out::println);
		
		// limit
		System.out.println();
		Arrays.asList(1, 2, 3).stream()
								.limit(2)
								.forEach(System.out::println);
		
		// filter : 1~10까지의 자연수중 홀수만 출력하기!!!
		System.out.println();
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
				.stream()
				.filter(i -> (i % 2) != 0)
				.forEach(System.out::println);
		
		// sorted : 기본 - 오름차순 정렬
		System.out.println();
		Arrays.asList(3, 1, 2)
				.stream()
				.sorted()
				.forEach(System.out::println);

		System.out.println();
		Arrays.asList(3, 1, 2)
				.stream()
				.sorted(Comparator.reverseOrder())
				.forEach(System.out::println);
	
		// distinct
		System.out.println();
		Arrays.asList(3, 1, 2, 23, 4, 1, 6, 3, 5, 2)
				.stream()
				.distinct()
				.forEach(System.out::println);
		
		// count, sum // min, max, average
		System.out.println();
		int[] numList = IntStream.range(0, 100).toArray();
		System.out.println(numList.length);
		
		System.out.println();
		long sum22;
		sum22 = IntStream.of(1, 2, 3, 4, 5).count();
		System.out.println(sum22);
		
		System.out.println();
		OptionalInt min;
		min = IntStream.of(1, 2, 3, 4, 5).min();
		System.out.println(min.getAsInt());
		
		// reduce
		System.out.println();

	}
}