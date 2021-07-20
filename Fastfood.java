
public final class Fastfood extends Restaurant {

	Fastfood(String name,String address){
	super(name,address);
    }
	
	
 
	@Override
	protected float fbdiscount(float n) {
		return (discount/100)*n;
	}
	@Override
	protected int rewards(float n) {
		reward+=((int)n/150)*10;
		return reward;
	}
	public static void main(String[] args) {
		
	}
	
	
}
