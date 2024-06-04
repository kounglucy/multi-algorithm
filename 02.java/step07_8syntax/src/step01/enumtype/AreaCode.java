package step01.enumtype;

public enum AreaCode {
	// 서울 : 02
	// 부산 : 051
	// 대구 : 053
	SEOUL("서울특별시", "02"),
	BUSAN("부산", "051");
	
	private String areaName;
	private String areaCode;
	
	AreaCode(String areaName, String areaCode) {
		this.areaName = areaName;
		this.areaCode = areaCode;
	}
	
	public String getAreaName() {
		return this.areaName;
	}
	public String getAreaCode() {
		return this.areaCode;
	}
}
