package blood.transfusion.dto;

public class PeopleDTO {
	private String id; 			// 프로젝트내 ID
	private String name; 		// 이름
	private int age; 			// 나이
	private String sex; 		// 성별
	private String bloodType; 	// 혈액형타입
	
	public PeopleDTO() {}
	public PeopleDTO(String id, String name, int age, String sex, String bloodType) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.bloodType = bloodType;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getSex() {
		return sex;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[아이디 : ");
		builder.append(id);
		builder.append(", 이름 : ");
		builder.append(name);
		builder.append(", 나이 : ");
		builder.append(age);
		builder.append(", 성별 : ");
		builder.append(sex);
		builder.append(", 혈핵형 : ");
		builder.append(bloodType);
		return builder.toString();
	}
	
}
