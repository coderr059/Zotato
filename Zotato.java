import java.util.*;
public  class Zotato {
	static Restaurant[] a=new Restaurant[5];
	static Customer[] c=new Customer[5];
	
	static Restaurant[] initializerest() {
		//Restaurant[] a=new Restaurant[5];
		a[0]=new Authentic("Shah","Pune"); 
		a[1]=new Normal("Ravi's","Mumbai");
		a[2]=new Authentic("The Chinese","Pochinki");
		a[3]=new Fastfood("Wang's","Military Base");
		a[4]=new Normal("Paradise","Rozhok");
		Restaurant.setrestlist(a);
		return a;
	}
	
	
	
	static Customer[] initializecust() {
		//Customer[] c=new Customer[5];
		c[0]=new Elite("Ram","Delhi");
		c[1]=new Elite("Sam","Pune");
		c[2]=new Special("Tim","Mumbai");
		c[3]=new Normalc("Kim","Mumbai");
		c[4]=new Normalc("Jim","Mumbai");
		return c;
	}
	
	
	static void display1() {
	System.out.println("Welcome to Zotato");
	System.out.println("1) Enter as Restaurant Owner");
	System.out.println("2) Enter as Customer");
	System.out.println("3) Check User Details");
	System.out.println("4) Company Account details");
	System.out.println("5) Exit");
	
	}

	
	static void displayrest() {
	System.out.println("Choose restaurant:");
	System.out.println("1) Shah (Authentic)");
	System.out.println("2) Ravi's");
	System.out.println("3) The Chinese(Authentic)");
	System.out.println("4) Wang's (Fast Food)");
	System.out.println("5) Paradise");
}
	static void dislpayrestoptions(int qi) {
		System.out.println("Welocome"+" "+ a[qi].name);
		System.out.println("1)Add item");
		System.out.println("2)Edit item");
		System.out.println("3)Print Rewards");
		System.out.println("4)Discount on bill value");
		System.out.println("5)Exit");
		
	}
	static void displaycust() {
		System.out.println("Choose Customer:");
		System.out.println("1) Ram (Elite)");
		System.out.println("2) Sam (Elite)");
		System.out.println("3) Tim (Special)");
		System.out.println("4) Kim");
		System.out.println("5) Jim");
	}
	static void dislpaycustoptions(int qi) {
		System.out.println("Welocome"+" "+ c[qi].getname());
		System.out.println("Customer menu");
		System.out.println("1)Select Restaurant");
		System.out.println("2)checkout cart");
		System.out.println("3)Reward won");
		System.out.println("4)print the recent orders");
		System.out.println("5)Exit");
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initializerest();
		initializecust();
		
		Scanner abc=new Scanner(System.in);
		int page=1;
		int pg1inp=0;
		while (!(page==1 && pg1inp==5)) {
			page=1;
			display1();
			int q=abc.nextInt();
			if (q==1) {
				displayrest();
				int q1=abc.nextInt()-1;
				dislpayrestoptions(q1);
				int q2=abc.nextInt();
				int first=1;
				while (q2!=5) {
					if (first!=1) {
						dislpayrestoptions(q1);
						q2=abc.nextInt();
					}
					if (q2==1) {
						System.out.println("Enter food item details:");
						System.out.println("Food name:");
						String name=abc.next();
						System.out.println("item price:");
						float p=abc.nextFloat();
						System.out.println("item quantity:");
						int qty=abc.nextInt();
						System.out.println("item category:");
						String cat=abc.next();
						System.out.println("Offer");
						float off=abc.nextFloat();
						int id=a[q1].addfooditem(name, p, qty, cat, off);
						System.out.println(id+ " "+name+ " "+ p+ " "+ qty + " " + off +" "+ "%off" + " " + cat);
					}if (q2==2) {
						//implement edit food item
					//	System.out.println("Choose item by code");
						ArrayList<Fooditem> item=a[q1].getfoodlist();
						System.out.println("Choose item by code:");
						for (int i=0;i<item.size();i++) {
							System.out.println(item.get(i).id+ " "+item.get(i).name+ " "+ item.get(i).price+ " "+ 
						item.get(i).quantity + " " + item.get(i).offer+" "+ "%off" + " " + item.get(i).category);
						}
						int code =abc.nextInt();
						System.out.println("Choose an attribute to edit:");
						System.out.println("1) Name");
						System.out.println("2) Price");
						System.out.println("3) Quantity");
						System.out.println("4) Category");
						System.out.println("5) Offer");
						int atr=abc.nextInt();
						String s=null;
						if (atr==1) {
							s="Name";
						}if (atr==2) {
							s="Price";
						}if (atr==3) {
							s="Quantity";
						}if (atr==4) {
							s="Category";
						}if (atr==5) {
							s="Offer";
						}
						System.out.println("Enter the new "+ s);
						if (atr==2 || atr==3 || atr==5) {
							int upd=abc.nextInt();
							if (atr==2) {
								for (int i=0;i<item.size();i++) {
									if (item.get(i).id==code) {
										item.get(i).price=upd;
										break;
									}
								}
							}if (atr==3) {
								for (int i=0;i<item.size();i++) {
									if (item.get(i).id==code) {
										item.get(i).quantity=upd;
										break;
									}
								}
							}if (atr==5) {
								for (int i=0;i<item.size();i++) {
									if (item.get(i).id==code) {
										item.get(i).offer=upd;
										break;
									}
								}
							}
						}else {
							String upd=abc.next();
							if (atr==1) {
								for (int i=0;i<item.size();i++) {
									if (item.get(i).id==code) {
										item.get(i).name=upd;
										break;
									}
								}
							}if (atr==4) {
								for (int i=0;i<item.size();i++) {
									if (item.get(i).id==code) {
										item.get(i).category=upd;
										break;
									}
								}
							}
						}
						for (int i=0;i<item.size();i++) {
							if (item.get(i).id==code) {
							System.out.println(item.get(i).id+ " "+item.get(i).name+ " "+ item.get(i).price+ " "+ 
						item.get(i).quantity + " " + item.get(i).offer+" "+ "%off" + " " + item.get(i).category);
						}
						}	
					}if (q2==3) {
						System.out.println("Reward points- "+ a[q1].getreward());
					}if (q2==4) {
						System.out.println("Enter offer on total bill value ");
						int r=abc.nextInt();
						a[q1].setdiscount(r);
						
					}
					first++;
					
					}page=2;
					pg1inp=5;
				
			}
			
			if (q==2) {
				displaycust();
				int q1=abc.nextInt()-1;
				dislpaycustoptions(q1);
				int q2=abc.nextInt();
				int first=1;
				while (q2!=5){
					if (first!=1) {
						dislpaycustoptions(q1);
						q2=abc.nextInt();
					}
					if (q2==1) {
						displayrest();
						int rid=abc.nextInt();
						ArrayList<Fooditem> item=a[rid-1].getfoodlist();
						System.out.println("Choose item by code:");
						for (int i=0;i<item.size();i++) {
							System.out.println(item.get(i).id+ " "+item.get(i).name+ " "+ item.get(i).price+ " "+ 
						item.get(i).quantity +" "+ item.get(i).offer+" "+ "%off" + " " + item.get(i).category);
						}
						
						int fid=abc.nextInt();
						Fooditem cf=null;
						for (int i=0;i<item.size();i++) {
							if (fid==item.get(i).id) {
							cf=item.get(i);
								break;
							}
						}
						System.out.println("Enter item quantity-:");
						int qty=abc.nextInt();
						float totalvalue=c[q1].order(fid, qty, a[rid-1].name);
						if (totalvalue!=-1) {
						int deliverycharge=c[q1].getdeliverycharge();
						c[q1].addtocart(qty, cf, a[rid-1].name, deliverycharge, totalvalue);
						System.out.println("Items added to cart!");
						}else {
							System.out.println("Please select again , invalid selection ");
						}
					}if (q2==2) {
						ArrayList<Cart> mycart=c[q1].getcart();
						if (mycart.size()==0) {
							System.out.println("No items selected !");
						}else {
							float totalcharge=0;
							int deliverycharge=0;
							int totalqty=0;
							System.out.println("Items in cart:");
							for (int i=0;i<mycart.size();i++) {
								Cart fc=mycart.get(i);
								totalcharge+=fc.totalvalue;
								deliverycharge+=fc.deliverycharge;
								totalqty+=fc.quantity;
								System.out.println(mycart.get(i).item.id + " - " + fc.restname + " - " + fc.item.name 
										+ " - " + fc.item.price +" - "+ fc.quantity+ " - "+ fc.item.offer + "% "+ "off");
							}System.out.println("Delivery charge-"+ " "+ deliverycharge +"/-");
							System.out.println("Total order value- "+ totalcharge +"/-");
							System.out.println("1) Proceed to checkout ");
							int y=abc.nextInt();
							System.out.println(totalqty + " items bought successfully for "+ totalcharge);
							c[q1].setmycart();
						}
					}if (q2==3) {
						System.out.println("Rewards won-"+ c[q1].getreward());
					}if (q2==4) {
						//print recent orders
						ArrayList<Cart> mylcart=c[q1].getmylcart();
						int ran=Math.min(10,mylcart.size());
						for (int i=0;i<ran;i++) {
							Cart cur=mylcart.get(i);
							System.out.println("Bought item: "+ cur.item.name + " , "+ "quantity: "+cur.quantity + " for Rs "+
							cur.item.price + " from Restaurant "+ cur.restname+ " and Delivery Charge: " + cur.deliverycharge);
						}
					}first++;
				}page=2;
				pg1inp=5;
			}
			if (q==3) {
				System.out.println(3);
				System.out.println("1) Customer list");
				System.out.println("2) Restaurant list");
				int cho=abc.nextInt();
				if (cho==1) {
					displaycust();
					int y=abc.nextInt()-1;
					System.out.println(c[y].getname()+ " "+ c[y].getClass()+" " + c[y].address +" " + c[y].getbalance());
				}else {
					displayrest();
					int y=abc.nextInt()-1;
					System.out.println(a[y].name+ " "+ a[y].address+" " +  a[y].getnoorders());
				}page=2;
				pg1inp=5;
			}if (q==4) {
				System.out.println("Total Company balance- "+ CompanyAccount.getbalance() + "/-");
				System.out.println("Toatal delivery charges collected- "+ CompanyAccount.getdcharge()+"/-");
				page=2;
				pg1inp=5;
			}if (q==5) {
				page=1;
				pg1inp=5;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
