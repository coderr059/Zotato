import java.util.ArrayList;

public abstract class Customer {
	String name;
	String address;
	float balance=1000;
	float rewards=0;
	int deliverycharge;
	ArrayList<Cart> mycart=new ArrayList<Cart>();
	ArrayList<Cart> mylcart=new ArrayList<Cart>();
	
	Customer(String name,String address){
		this.name=name;
		this.address=address;
	}
	
	protected abstract float order(int id,int qty,String restname);
	protected abstract int getdeliverycharge();
	
	public void setreward(float n) {
		if (n==0) {
			rewards=0;
		}else {
		rewards+=n;
		}
	}
	public void addtocart(int quantity,Fooditem item, String restname, float deliverycharge, float totalvalue) {
		Cart sub=new Cart(quantity,item,restname,deliverycharge,totalvalue);
		mycart.add(sub);
		mylcart.add(sub);
	}
	
	public void setbalance(float n) {
		balance-=n;
	}
	public float getreward() {
		return rewards;
	}
	public float getbalance() {
		return balance;
	}
	public String getname() {
		return name;
	}
	public ArrayList<Cart> getcart(){
		return mycart;
	}
	public void setmycart() {
		mycart=null;
		mycart=new ArrayList<Cart>();
	}
	public ArrayList<Cart> getmylcart(){
		return mylcart;
	}
}
