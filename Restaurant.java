import java.util.*;

public abstract class Restaurant {
	protected String name;
	protected String address;
	protected int nooforders=0;
	//protected ArrayList<Integer> items=new ArrayList<Integer>();       //change int to fooditems object
	protected ArrayList<Fooditem> items=new ArrayList<Fooditem>(); 
	protected static Restaurant[] a;
	//a[0]=new Fastfood(abc,asd,5);
	protected int reward=0;
	protected float discount=0;
	
	Restaurant(String name ,String address ){
		this.name=name;
		this.address=address;
		//this.discount=discount;
	}
	
	//a[0]=new Fastfood("abc","asd",5);
	
	
	protected float payfoodtech(float n) {
		CompanyAccount.balance(n);
		return (float)((1.0/100)*n);   
	}
	protected int addfooditem(String name,float price,int quantity,String category,float offer) {
		Fooditem item=new Fooditem(name,price,quantity,category,offer);
		items.add(item);
		return item.id;
	}
	protected abstract float fbdiscount(float n);
	
	protected abstract int rewards(float n);
	
	public float getdiscount() {
		return discount;
	}
	public int getreward() {
		return reward;
	}
	public void setdiscount(int n) {
		discount=n;
	}
	public void updateorders() {
		nooforders++;
	}
	public int getnoorders() {
		return nooforders;
	}
	static void setrestlist(Restaurant[] a1) {
		a=a1;
	}
	 ArrayList<Fooditem> getfoodlist() {
			return items;
		}
	/*public 
	 * a[i].dicount*/
	public float[] itemdisc(int id,int quantity,Customer c) {
		for (int i=0;i<items.size();i++) {
			if (items.get(i).id==id) {
				if (quantity<=items.get(i).quantity) {
					float y=items.get(i).offer;
					//items.get(i).quantity-=quantity;
					float u=quantity*items.get(i).price;
					if (u>c.getbalance()+c.getreward()) {
						return null;
					}
					items.get(i).quantity-=quantity;
					float[] fa= {(y/100)*u,u};
					return fa;
				}else {
					return null;
				}
			}
		}
		return null;
	}
	public static float restdisc(int idnumber,int quantity,String restname,Customer c) {
		Restaurant r=null;
		for (int i=0;i<5;i++) {
			if (a[i].name.equals(restname)) {
				r=a[i];
			}
		}
		float[] itd=r.itemdisc(idnumber,quantity,c);
		if (itd!=null) {
			for (int i=0;i<5;i++) {
				if (a[i].name.equals(restname)) {
					float amt=itd[1]-itd[0];
					float amt2=a[i].fbdiscount(amt);
					amt-=amt2;
					a[i].updateorders();
					
					//also update rewards , i.e., u+deliverycharge in argument of rewards
					return amt;
				}
			}
		}else {
			return -1;
		}return -1;
	}
	public static void setrewardnbalance(Customer c ,float n, String restname) {
		
		Restaurant r=null;
		for (int i=0;i<5;i++) {
			if (a[i].name.equals(restname)) {
				r=a[i];
			}
		}r.payfoodtech(n);
		r.reward+=r.rewards(n);
		c.setreward(r.rewards(n));
		if (c.getreward()<=n) {
			n-=c.getreward();
			c.setreward(0);
			c.setbalance(n);
		}else {
			c.setreward(-n);
		}
		
		
	}
}
