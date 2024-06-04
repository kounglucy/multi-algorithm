package run.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01.model.domain.Car;
import step01.model.domain.People;

public class Step01Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("step01.xml");
		
		// step01
		Car c1 = context.getBean("c1", Car.class);
		System.out.println(c1);
		
		People p1 = context.getBean("p1", People.class);
		System.out.println(p1);
		
		People p2 = context.getBean("p2", People.class);
		System.out.println(p2);
		
		// p1,p2 같은 객체인가 다른 객체인가 -> 다른 객체
		System.out.println(p1 == p2);
		
		People p3 = context.getBean("p2", People.class);
		
		// p2,p3 같은 객체인가 다른 객체인가 -> 같은 객체 (기본적으로 컨텍스트 : singletone)
		System.out.println(p2 == p3);
		
		
//		Car c2 = new Car();
//		Car c3 = new Car();
		
		// c2,c3 같은 객체 인가 다른 객체인가 -> 다른 객체 
//		System.out.println(c2 == c3);
	}

}
