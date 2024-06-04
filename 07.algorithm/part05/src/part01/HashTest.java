package part01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cart.dto.Car;

public class HashTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();	
		map.put("A", 101);
		map.put("B", 102);
		map.put("C", 103);
		
//		System.out.println(map);
		
		
//		System.out.println(map.get("B"));
		
		// "B" -> 112 : 조건. 만약 "B"가 map객체 존재한다면? -> 112로 값을 변경 X
		// containsKey(key) : 키 존재 여부 확인 메소드
		// containsValue(value) : 값 존재 여부 확인 메소드
//		System.out.println(map.containsKey("D"));
//		if(!map.containsKey("B")) {
//			map.put("B", 112);
//		}
		
		// getOrDefault(key) : 지정 키 이미 존재한다면 기존의 값을 return
//		System.out.println(map.getOrDefault("B", 112));
//		System.out.println(map.getOrDefault("D", 112));
		
		Car tesla1 = new Car("tesla");
		Car tesla2 = new Car("tesla");
		
		System.out.println(tesla1.equals(tesla2)); // false -> true
		
		Map<Car, Integer> carMap = new HashMap<Car, Integer>();
		carMap.put(tesla1, 1);
		carMap.put(tesla2, 2);
		
//		문제 발생 : tesla1 과 tesla2는 equals 재정의를 했기 때문에 같은 객체라고 생각했음.
// 		예상 결과 :	{Car [carName=tesla]=2} 출력이 되어야 하는데 그렇지 않음.
//		문제 해결 : hashCode() 재정의 해줘야 함.
		
		System.out.println(tesla1.hashCode());
		System.out.println(tesla2.hashCode());

		System.out.println(carMap);
		
		// HashSet
		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car("bmw"));
		carList.add(new Car("bmw"));
		
		System.out.println(carList);
		
		Set<Car> carSet = new HashSet<Car>();
		carSet.add(new Car("bmw"));
		carSet.add(new Car("bmw"));
		
		System.out.println(carSet);
	}
}

