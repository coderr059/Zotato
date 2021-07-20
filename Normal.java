
public final class Normal extends Restaurant{
	Normal(String name,String address){
		super(name,address);
	    }
		
		@Override
		protected float fbdiscount(float n) {
			
			return 0;
		}
		@Override
		protected int rewards(float n) {
			reward+=((int)n/100)*5;
			return reward;
		}	
		@Override
		public void setdiscount(int n) {
			discount=0;
		}
}
