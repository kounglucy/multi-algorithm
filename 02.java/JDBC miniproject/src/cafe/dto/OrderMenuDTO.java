package cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenuDTO {
	private String orderId;		// 주문 번호
	private String orderDate;	// 주문 날짜
	private String orderList;	// 주문 목록
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[주문번호 : ");
		builder.append(orderId);
		builder.append(", 주문 날짜 : ");
		builder.append(orderDate);
		builder.append(", 주문 목록 : ");
		builder.append(orderList);
		builder.append("]");
		return builder.toString();
	}
}