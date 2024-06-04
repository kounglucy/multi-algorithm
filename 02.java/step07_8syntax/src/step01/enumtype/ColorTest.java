package step01.enumtype;

public class ColorTest {
	public static void main(String[] args) {
		System.out.println(Color.values());
		for(Color color : Color.values()) {
			System.out.println(color.getColorCode());
		}
	
	}
}
