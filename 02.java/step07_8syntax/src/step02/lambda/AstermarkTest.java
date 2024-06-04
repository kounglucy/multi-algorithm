package step02.lambda;

public class AstermarkTest {
	public static void main(String[] args) {
		// ? 두 문장을 * 를 기점으로 합쳐서 출력하는 기능
		String str1 = "Hello";
		String str2 = "Java";
//		Hello*Java
		
		System.out.println();
		
		// interface + class
		AstermarkImpl astermarkImpl = new AstermarkImpl();
		astermarkImpl.addAstermark(str1, str2);
		
		
		// lambda
		Astermark astermark = (String s1, String s2) -> System.out.println(s1 + "*" + s2);
		astermark.addAstermark(str1, str2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
