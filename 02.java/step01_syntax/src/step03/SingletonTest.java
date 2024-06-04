package step03;

import java.util.Calendar;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		
		// singleton1 singleton2 같은객체? 같은 객체
		System.out.println(singleton1);
		System.out.println(singleton2);
		
		// Calendar 
		Calendar caledar = Calendar.getInstance();
		System.out.println(caledar.getWeekYear());
		
	}
}
