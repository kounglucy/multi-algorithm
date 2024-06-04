package blood.transfusion.dto;

public class BTProjectDTO {
	private String btProjectName; 	// 수혈프로젝트 이름
	private String btProjectId; 	// 수혈프로젝트 id
	private String donorId; 		// 헌혈자
	private String recipientId; 	// 수혈자
	private String btContent; 		// 수혈프로젝트 내용
	
	public BTProjectDTO() {}
	public BTProjectDTO(String btProjectName, String btProjectId, String donorId, String recipientId, String btContent) {
		this.btProjectName = btProjectName;
		this.btProjectId = btProjectId;
		this.donorId = donorId;
		this.recipientId = recipientId;
		this.btContent = btContent;
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
	public String getDonorId() {
		return donorId;
	}
	public void setDonorId(String donorId) {
		this.donorId = donorId;
	}
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public String getbtContent() {
		return btContent;
	}
	public void setbtContent(String btContent) {
		this.btContent = btContent;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[수혈 프로젝트 : ");
		builder.append(btProjectName);
		builder.append(", 프로젝트ID : ");
		builder.append(btProjectId);
		builder.append(", 헌혈자 : ");
		builder.append(donorId);
		builder.append(", 수혈자 : ");
		builder.append(recipientId);
		builder.append(", 프로젝트 내용 : ");
		builder.append(btContent);
		builder.append("]");
		return builder.toString();
	}
}
