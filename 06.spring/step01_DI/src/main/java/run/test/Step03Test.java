package run.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step03.model.domain.Car;
import step03.model.domain.People;

public class Step03Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("step03.xml");

		Car c1 = context.getBean(Car.class);
		System.out.println(c1);
		
		People p1 = context.getBean(People.class);
		System.out.println(p1);
		
		
	}

}
