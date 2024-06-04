package step01.enumtype;

public class AreaCodeTest {
	public static void main(String[] args) {
		String code = "051";
		
		for(AreaCode areaCode : AreaCode.values()) {
			if(code.equals(areaCode.getAreaCode())) {
				System.out.println(areaCode.getAreaName());
			}
		}
	}
}
