/* 싱글톤 패턴(Singleton Pattern)
	- 하나의 객체만 만들어서 내부적인 메소드 혹은 정보를 사용하는 경우
    - 동일한 자원이나 데이터를 처리하는 객체가 불필요하게 여러 개 만들어질 필요가 없는 경우에 주로 사용
 */
package step03;

public class Singleton {
	// private 필드 : 외부의 접근 제한
	private static Singleton instance = new Singleton();
	
	// private 생성자
	private Singleton(){}

	// 메소드 : getInstance() : 외부에서 내부에 생성된 객체에 접근
	public static Singleton getInstance() {
		return instance;
	}
}