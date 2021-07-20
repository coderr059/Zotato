import java.util.*;

public class Cart {
	//ArrayList<Fooditem> foods=new ArrayList<Fooditem>();
	int quantity;
	Fooditem item;
	String restname;
	float deliverycharge;
	float totalvalue;
	
	Cart(int quantity,Fooditem item, String restname, float deliverycharge, float totalvalue){
		this.quantity=quantity;
		this.item=item;
		this.restname=restname;
		this.deliverycharge=deliverycharge;
		this.totalvalue=totalvalue;
	}
	
}
