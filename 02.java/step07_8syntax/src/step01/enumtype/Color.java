package step01.enumtype;

public enum Color {
	RED("c01"),
	BLUE("c02"),
	GREEN("c03");
	
	private String colorCode;
	
	Color(){};
	Color(String colorCode) {
		this.colorCode = colorCode;
	}
	
	public String getColorCode() {
		return this.colorCode;
	}
	
	/*
	 * Color.values()메소드를 사용한 결과가 메모리의 어떠한 주소값이므로 
	 * Color에 저장되어있는 타입이 배열타입임을 추측할 수 있다. 
	 * 따라서 Color.values()로 for문을 돌려도 문제가 없다 인데 맞는 생각인가요?
	 * 
	 */
	
}







