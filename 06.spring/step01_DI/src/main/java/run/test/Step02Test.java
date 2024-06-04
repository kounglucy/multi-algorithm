package run.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step02.model.domain.Car;
import step02.model.domain.People;

public class Step02Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("step02.xml");

		Car c1 = context.getBean("c1", Car.class);
		System.out.println(c1);
		
		People p1 = context.getBean("p1", People.class);
		System.out.println(p1);
		
		/*
		 [시나리오 1]
		 1) 현재 설정
		 	[xml]
		 	<bean id="c1" class="step02.model.domain.Car" />
			<bean id="p1" class="step02.model.domain.People" />
		 	
		 	[People]
		 	어노테이션이 없음
		 	
			[결과]
			자동차 기본 생성자
			사람 기본 생성자
			Car [carNo=0, carName=null]
			People [name=null, age=0, car=null]
		 
		 2)추가 설정
		 	[xml]
		 	xml의 Namespaces에서 context 체크 및 저장
		 	<context:annotation-config /> 추가
		 	
		 	[People]
		 	@Autowired 추가
			
			[결과]
			자동차 기본 생성자
			사람 기본 생성자
			Car [carNo=0, carName=null]
			People [name=null, age=0, car=Car [carNo=0, carName=null]]
			
			
		[시나리오 2]
		 	[xml]
		 	<bean id="c1" class="step02.model.domain.Car" />
		 	<bean id="c2" class="step02.model.domain.Car" />
			<bean id="p1" class="step02.model.domain.People" />
		 	
		 	[People]
		 	@Autowired
		
			[결과]
			문제 발생 : 이유는 p1 객체가 참조하는 의존 객체가 같은 타입으로 2개(c1, c2)가 존재하는데
			스프링 DI 컨테이너는 어떤 객체를 넣어줘야 할지 선택 할 수 없음.
			따라서 에러가 발생하므로 이를 해결해줘야 함.
			
			해결 방법은 @Autowired라는 어노테이션하단에 기본적인 주입 객체를 지정해 줌으로써 충돌을 방지할 수 있음.
			[People]
		 	@Autowired
			@Qualifier("c2")
			
		[시나리오 3]
			그런데! Qualifier에서 지정 bean이 반드시 존재하라는 법은 없음!
		 	[xml]
		 	<bean id="c1" class="step02.model.domain.Car" />
		 	<!-- <bean id="c2" class="step02.model.domain.Car" /> -->
			<bean id="p1" class="step02.model.domain.People" />
		 	
			[People]
		 	@Autowired
			@Qualifier("c2")
		
			[결과]
			문제 발생 : 이유는 Qualifier 지정 빈이 존재하지 않기 때문.
			따라서 지정 빈bean 객체가 없어도 p1 객체가 생성되기 위해서는 @Autowired에 (required=false)로 지정
			[People]
		 	@Autowired(required = false)
			@Qualifier("c2")
		 
		 */
		
		
	}

}
