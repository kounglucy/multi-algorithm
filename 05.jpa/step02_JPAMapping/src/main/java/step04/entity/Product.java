package step04.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
public class Product {
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; 
	
	private String name;
	
	@OneToMany(mappedBy = "product")
	private List<CustomerProduct> mappingList = new ArrayList<CustomerProduct>();
	
	
}