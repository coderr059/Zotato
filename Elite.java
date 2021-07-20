import java.util.*;
public class Elite extends Customer{
	
	Elite(String name,String address){
		
		super(name,address);
	}
	@Override
	public float order(int idnumber,int quantity,String restname) {
		float amt=Restaurant.restdisc(idnumber,quantity,restname,this); 
		if (amt>200) {
			amt-=50;
		}
		if (amt!=-1) {
		Restaurant.setrewardnbalance(this, amt,restname);
		}
		
		return amt;
	}
	
	
	
	@Override
	public int getdeliverycharge() {
		return 0;
	}

	
	
}
