package blood.transfusion.dto;

public class Recipient extends People{
	private String purposeTransfusion; // 수혈목적
	
	public Recipient() {}
	public Recipient(String purposeTransfusion) {
		super();
		this.purposeTransfusion = purposeTransfusion;
	}
	public Recipient(String id, String name, int age, String sex, String bloodType, String purposeTransfusion) {
		super(id, name, age, sex, bloodType);
		this.purposeTransfusion = purposeTransfusion;
	}
	public String getPurposeTransfusion() {
		return purposeTransfusion;
	}
	public void setPurposeTransfusion(String purposeTransfusion) {
		this.purposeTransfusion = purposeTransfusion;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", 수혈 목적 : ");
		builder.append(purposeTransfusion);		
		builder.append("]");
		return builder.toString();
	}
}
