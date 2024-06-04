package model.domain;

public class Student {
	private String name;
	private int age;
	
	public Student() {}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
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
		if(age > 0) {
			this.age = age;
		}else {
			System.out.println("입력한 나이는 유효하지 않습니다");
		}
	}
	
	public String toString() {
		return name + " " + age;
	}
}
