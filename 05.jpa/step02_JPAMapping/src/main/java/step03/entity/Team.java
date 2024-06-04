package step03.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString (exclude = "members")
@Entity

public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
    
	private String name;
	
	// 양방향 참조 
	@OneToMany(mappedBy = "team")
	private List<Member>members = new ArrayList<Member>();
}
