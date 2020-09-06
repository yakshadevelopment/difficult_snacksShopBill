package java9.diff.app1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	private String itemName;
	private String rate;
	private String orderQty;
	private String actualAmount;
	private String discount;
	private String payAmount;
	public OrderItem(String itemName, String rate, String orderQty) {
		super();
		this.itemName = itemName;
		this.rate = rate;
		this.orderQty = orderQty;
	}
	@Override
	public String toString() {
			String output=String.format("%-15s %-10s %-10s %-10s %-10s %-10s ",itemName,rate,orderQty,actualAmount,discount,payAmount);
		return output;
	}
	
}
