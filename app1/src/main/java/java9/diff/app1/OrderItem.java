package java9.diff.app1;


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
	
	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderItem(String itemName, String rate, String orderQty, String actualAmount, String discount,
			String payAmount) {
		super();
		this.itemName = itemName;
		this.rate = rate;
		this.orderQty = orderQty;
		this.actualAmount = actualAmount;
		this.discount = discount;
		this.payAmount = payAmount;
	}
   

	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getRate() {
		return rate;
	}


	public void setRate(String rate) {
		this.rate = rate;
	}


	public String getOrderQty() {
		return orderQty;
	}


	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}


	public String getActualAmount() {
		return actualAmount;
	}


	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}


	public String getDiscount() {
		return discount;
	}


	public void setDiscount(String discount) {
		this.discount = discount;
	}


	public String getPayAmount() {
		return payAmount;
	}


	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}


	@Override
	public String toString() {
			String output=String.format("%-15s %-10s %-10s %-10s %-10s %-10s ",itemName,rate,orderQty,actualAmount,discount,payAmount);
		return output;
	}
	
}
