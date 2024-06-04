package step02.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import customer.enumtype.GradeType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@AllArgsConstructor // 주의! 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
//@Setter // 주의!
@ToString
@Entity

public class Customer {
	@Id
	private String id; 
	
	@Column(length = 100)
	private String name; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@Enumerated(EnumType.STRING) // 자바 enum 타입으로 문자열로 db 저장
    private GradeType grade;
	
    @Builder
	public Customer(String id, String name, Date registrationDate, GradeType grade) {
		super();
		this.id = id;
		this.name = name;
		this.registrationDate = registrationDate;
		this.grade = grade;
	}
    
	
}
