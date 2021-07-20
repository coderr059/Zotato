
public class Special extends Customer{
Special(String name,String address){
		
		super(name,address);
	}
	@Override
	public float order(int idnumber,int quantity,String restname) {
		float amt=Restaurant.restdisc(idnumber,quantity,restname,this); 
		if (amt>200) {
			amt-=25;
		}
		if (amt!=-1) {
		Restaurant.setrewardnbalance(this, amt+20,restname);
		}
		
		return amt+20;
	}
	
	
	
	@Override
	public int getdeliverycharge() {
		return 20;
	}

}
