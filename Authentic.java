
public final class Authentic extends Restaurant{

	Authentic(String name,String address){
		super(name,address);
	    }
		
		@Override
		protected float fbdiscount(float n) {
			float v=(discount/100)*n;
			if (n-v>100) {
				v+=50;  
			}
			return v; 
		}
		@Override
		protected int rewards(float n) {
			int rew=((int)n/200)*25;
			return rew;
		}	
}
