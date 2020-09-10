package java9.diff.app1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class ItemData {
	private static Map<String,SnackItem> itemMap=new TreeMap<String, SnackItem>();
	static
	{
	try
	{
	FileReader fileReader=new FileReader("SnackItem.txt");
	BufferedReader bufferedReader=new BufferedReader(fileReader);
	List<SnackItem> itemList=new ArrayList<SnackItem>();
	while(true)
	{
	  String str=bufferedReader.readLine();
	  if(str==null)
		  break;
	  String []arr=str.split("-");
	  SnackItem snackItem=new SnackItem(arr[0],arr[1],arr[2],arr[3],arr[4]);
	  itemList.add(snackItem);
	}// end of loop
	Stream<SnackItem> snackStream=itemList.stream().filter(item->item.getStatus().equalsIgnoreCase("A"));
	snackStream.forEach((snackItem)->{
		itemMap.put(snackItem.getItemName().toUpperCase(),snackItem);
	}); // end of forEach
	}catch(Exception ee) {System.out.println(ee);}
	}// end of static block
	
	public static  Map<String,SnackItem> getAllItems()
	{
		return itemMap;
	}
	public static SnackItem getItem(String itemName)
	{
		return itemMap.get(itemName.toUpperCase());
	}
	public static boolean isAvailable(String itemName)
	{
		return itemMap.containsKey(itemName.toUpperCase());
	}
	
 }
