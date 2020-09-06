package java9.diff.app1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SnackItem {
	private String itemName;
	private String rate;
	private String status;
	private String discountRate; 
	private String discountQty;
	
}
