
public class CompanyAccount {
	//Total Company balance - INR 17.75/-
	//Total Delivery Charges Collected - INR 0/-
	private static float companybalance=0;
	private static int deliverycharges=0;
	//private static Restaurant[] a;
	//private static Customer[] c;
	
	
	static void balance(float n) {
		companybalance+=(1.0/100)*n;
	}
	
	static void delivery(Customer c) {
		
		deliverycharges+=c.getdeliverycharge();
		companybalance+=c.getdeliverycharge();
	}
	static float getbalance() {
		return companybalance;
	}
	static int getdcharge() {
		return deliverycharges;
	}
}
