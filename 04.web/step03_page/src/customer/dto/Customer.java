package customer.dto;

public class Customer {
	private String id;
	private String pw;
	private String grade;
	
	public Customer() {}
	public Customer(String id, String pw, String grade) {
		this.id = id;
		this.pw = pw;
		this.grade = grade;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", pw=" + pw + ", grade=" + grade + "]";
	}
}