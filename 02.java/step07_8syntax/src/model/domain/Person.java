package model.domain;

public class Person {
	private String name;
	private String mbti;
	
	public Person() {}
	public Person(String name, String mbti) {
		super();
		this.name = name;
		this.mbti = mbti;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMbti() {
		return mbti;
	}
	public void setMbti(String mbti) {
		this.mbti = mbti;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", mbti=" + mbti + "]";
	}
}