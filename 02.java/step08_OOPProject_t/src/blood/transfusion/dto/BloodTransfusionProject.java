package blood.transfusion.dto;

public class BloodTransfusionProject {
	private String btProjectName; 	 // 수혈프로젝트 이름
	private String btProjectId; 	 // 수혈프로젝트 id
	private Donor donor; 			 // 헌혈자
	private Recipient recipient;	 // 수혈자
	private String projectContenent; // 수혈프로젝트 내용
	
	public BloodTransfusionProject() {}
	public BloodTransfusionProject(String btProjectName, String btProjectId, Donor donor, Recipient recipient, String projectContenent) {
		this.btProjectName = btProjectName;
		this.btProjectId = btProjectId;
		this.donor = donor;
		this.recipient = recipient;
		this.projectContenent = projectContenent;
	}
	public String getBtProjectName() {
		return btProjectName;
	}
	public void setBtProjectName(String btProjectName) {
		this.btProjectName = btProjectName;
	}
	public String getBtProjectId() {
		return btProjectId;
	}
	public void setBtProjectId(String btProjectId) {
		this.btProjectId = btProjectId;
	}
	public Donor getDonor() {
		return donor;
	}
	public void setDonor(Donor donor) {
		this.donor = donor;
	}
	public Recipient getRecipient() {
		return recipient;
	}
	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}
	public String getProjectContenent() {
		return projectContenent;
	}
	public void setProjectContenent(String projectContenent) {
		this.projectContenent = projectContenent;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[수혈 프로젝트 : ");
		builder.append(btProjectName);
		builder.append(", 프로젝트ID : ");
		builder.append(btProjectId);
		builder.append(", 헌혈자 : ");
		builder.append(donor);
		builder.append(", 수혈자 : ");
		builder.append(recipient);
		builder.append(", 프로젝트 내용 : ");
		builder.append(projectContenent);
		builder.append("]");
		return builder.toString();
	}
}
