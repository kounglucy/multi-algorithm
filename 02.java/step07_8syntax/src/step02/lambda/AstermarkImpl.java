package step02.lambda;

public class AstermarkImpl implements Astermark {

	@Override
	public void addAstermark(String str1, String str2) {
		System.out.println(str1 + "*" + str2);
	}
}
