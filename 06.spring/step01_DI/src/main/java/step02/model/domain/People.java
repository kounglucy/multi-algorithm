package step02.model.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class People {
	private String name;
	private int age;
	
    @Autowired (required = false) // 지정 객체가 존재하지 않더라고 기본 null 값으로 people 객체를 생성
    @Qualifier("c2") // 여러개의 주입 대상 객체가 존재 할때 하나의 객체를 지정 
	private Car car;
	
	public People() {
		System.out.println("사람 기본 생성자");
	}
	public People(String name, int age, Car car) {
		super();
		this.name = name;
		this.age = age;
		this.car = car;
		System.out.println("사람 일반 생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
	

}
