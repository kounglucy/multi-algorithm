package run.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.Car;
import common.NoticeAspect;

public class CarTest {
	
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        
    	Car car = context.getBean(Car.class);
//    	car.buy();
    	
//    	car.buyReturn();
    	
    	try {
			car.sellMoney(500);
		} catch (Exception e) {
//			e.printStackTrace();
			
		}
	}

}
