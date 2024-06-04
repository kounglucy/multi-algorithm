package step03.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.domain.Person;

public class StreamReview {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		// 문제! I이고 J인 사람들만 출력하시오!
		Person nike = new Person("nike", "entp");
		Person adidas = new Person("adidas", "infp");
		Person yale = new Person("yale", "intj");
		Person reabok = new Person("reabok", "istp");
		Person puma = new Person("puma", "estp");
		Person mizuno = new Person("mizuno", "infp");
		Person asics = new Person("asics", "entj");
		Person spris = new Person("spris", "intp");
		Person vans = new Person("vans", "esfj");
		Person converse = new Person("converse", "isfp");
		Person rapido = new Person("rapido", "istp");
		Person kappa = new Person("kappa", "istj");

		personList.add(nike);
		personList.add(adidas);
		personList.add(yale);
		personList.add(reabok);
		personList.add(puma);
		personList.add(mizuno);
		personList.add(asics);
		personList.add(spris);
		personList.add(vans);
		personList.add(converse);
		personList.add(rapido);
		personList.add(kappa);
		
		// 이름 순서대로 출력?
//		System.out.println(personList.stream()
//										.sorted(Comparator.comparing(Person::getName))
//										.collect(Collectors.toList()));
//		
//		personList
//			.stream()
//			.sorted(Comparator.comparing(Person::getName))
//			.forEach(System.out::println);
		
		System.out.println("***MBTI***");
		// i && j 사람을 출력?
		personList.stream()
					.filter(p -> p.getMbti().contains("i") && p.getMbti().contains("j"))
					.forEach(System.out::println);
		
	}
}
