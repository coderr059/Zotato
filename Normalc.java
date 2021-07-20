
public class Normalc extends Customer{
Normalc(String name,String address){
		
		super(name,address);
	}
	@Override
	public float order(int idnumber,int quantity,String restname) {
		float amt=Restaurant.restdisc(idnumber,quantity,restname,this); 
		if (amt>200) {
			amt-=0;
		}
		if (amt!=-1) {
		Restaurant.setrewardnbalance(this, amt+40,restname);
		}
		
		return amt+40;
	}
	
	
	
	@Override
	public int getdeliverycharge() {  
		return 40; 
	}

}
