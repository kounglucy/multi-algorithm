package blood.transfusion.dto;

public class Donor extends People{
	private String purposeDonation; // 헌혈목적
	
	public Donor() {}
	public Donor(String purposeDonation) {
		super();
		this.purposeDonation = purposeDonation;
	}
	public Donor(String id, String name, int age, String sex, String bloodType, String purposeDonation) {
		super(id, name, age, sex, bloodType);
		this.purposeDonation = purposeDonation;
	}
	public String getPurposeDonation() {
		return purposeDonation;
	}
	public void setPurposeDonation(String purposeDonation) {
		this.purposeDonation = purposeDonation;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", 헌혈 목적 : ");
		builder.append(purposeDonation);		
		builder.append("]");
		return builder.toString();
	}
}
