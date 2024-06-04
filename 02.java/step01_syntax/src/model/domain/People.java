/* 도메인 모델(Domain Model)
 * - 객체 지향 분석 설계 기반으로 구현하고자 하는 도메인(비즈니스 영역)의 모델을 생성하는 패턴
 * - 도메인에서의 객체 판별, 목록 작성, 객체간의 관계
 * - 속성과 기능 분리
 * - 단순 : 테이블 하나 = 하나의 도메인 객체
 * - 재사용성, 유지보수 용이, 확장성
 * - 모델 구축의 어려움
 */
package model.domain;

public class People {
	// 필드
	// 캡슐화 : 객체의 필드에 직접 접근하지 못하도록 막아주는 행위(객체 보호)
	private String name;
	private int age;

	public People() {
		super();
	}
	public People(String name, int age) {
		super();
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
		this.age = age;
	}
}
