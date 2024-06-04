package cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {
	private String ingredientId;	// 재료 ID
	private String ingredientName;	// 재료 이름
	private int ingredientPrice;	// 가격
	private int ingredientStock;	// 재고
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[재료 ID : ");
		builder.append(ingredientId);
		builder.append(", 재료 이름 : ");
		builder.append(ingredientName);
		builder.append(", 가격 : ");
		builder.append(ingredientPrice);
		builder.append(", 재고 : ");
		builder.append(ingredientStock);
		builder.append("]");
		return builder.toString();
	}
}
