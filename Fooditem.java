
public class Fooditem {
	String name;
	float price;
	int quantity;
	String category;
	float offer;
	static int cid=1;
	final int id;
	Fooditem(String name,float price,int quantity,String category,float offer){
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.category=category;
		this.offer=offer;
		id=cid++;
	}
}
