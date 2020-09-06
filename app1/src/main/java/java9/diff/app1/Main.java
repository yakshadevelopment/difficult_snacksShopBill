package java9.diff.app1;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static String floatToString(double value)
	{
		DecimalFormat decimalFormat=new DecimalFormat("0.00");
		return decimalFormat.format(value);
	}
	
	public static String salesTaxCalculation(double billAmount)
	{
		double taxAmount=0.00;
		if(billAmount<1001)
			taxAmount=billAmount*0.125;
		else if(billAmount<2501)
		{
			taxAmount=1000.00*0.125+(billAmount-1000)*0.1;
		}
		else
		{
			taxAmount=1000.00*0.125+2500.00*0.1+(billAmount-2500)*0.075;
		}
		return floatToString(taxAmount);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		List<OrderItem> orderList=new ArrayList<OrderItem>();
		System.out.println("Enter Customer Name:");
		String customerName=scanner.nextLine();
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		String today=dateFormat.format(date);
		System.out.println("Enter number of items the customer purchases:");
		int no=Integer.parseInt(scanner.nextLine());
		for(int i=0;i<no;i++)
		{
			int j=i+1;
			System.out.println("Enter name and quantity (comma seperate format) of purchased item no "+j);
			String detail=scanner.nextLine();
			String arr[]=detail.split(",");
			SnackItem snackItem=ItemData.getItem(arr[0]);
			String rate=snackItem.getRate();
			OrderItem orderItem=new OrderItem(arr[0], rate, arr[1]);
			double actualAmount=Double.parseDouble(rate)*Double.parseDouble(arr[1]);
	        orderItem.setActualAmount(floatToString(actualAmount));		
			double purchaseQty=Double.parseDouble(arr[1]);
			double discountQty=Double.parseDouble(snackItem.getDiscountQty());
			if(purchaseQty>=discountQty)
			{
				double discountRate=Double.parseDouble(snackItem.getDiscountRate());
				double discountAmount=0.00;
				if(discountRate!=0)
				{
					discountAmount=actualAmount/discountRate;
				}
				double payAmount=actualAmount-discountAmount;
			  orderItem.setDiscount(floatToString(discountAmount));
			  orderItem.setPayAmount(floatToString(payAmount));
			}
			else
			{
				orderItem.setDiscount("0.00");
				  orderItem.setPayAmount(floatToString(actualAmount));
			}
		    orderList.add(orderItem);	
		}// end of loop
		double billAmount=0.00;
		for(OrderItem orderItem:orderList){
			billAmount=billAmount+Double.parseDouble(orderItem.getPayAmount());
			}
	    String salesTax=salesTaxCalculation(billAmount);
	    String finalAmount=floatToString(billAmount+Double.parseDouble(salesTax));
	    System.out.println("\n\nCustomer Name:"+customerName+"\t\t\t\tDate:"+today);
	    System.out.println("\n"+String.format("%-15s %-10s %-10s %-10s %-10s %-10s ","ITEM","RATE","QUANTITY","PRICE","DISCOUNT","AMOUNT"));
		orderList.forEach(System.out::println);
		System.out.println("\n\t\t\t\t\t     Bill Amount:"+floatToString(billAmount));
		System.out.println("\t\t\t\t\t     Add: Sales Tax:"+salesTax);
		System.out.println("\t\t\t\t\t     Final Amount:"+finalAmount);
		}
}