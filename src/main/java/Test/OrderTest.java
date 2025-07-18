package Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Impl.CartDaoImpl;
import Impl.LoginDaoImpl;
import Impl.OrderDaoImpl;
import POJO.Cart;
import POJO.OrderFood;

public class OrderTest {

	public static void main(String[] args) {
		
		boolean exit=false, flag;
		int option;
		
		Scanner sc=new Scanner(System.in);
		CartDaoImpl cimpl=new CartDaoImpl();
		OrderDaoImpl oimpl=new OrderDaoImpl();
		OrderFood o=null;
		List<OrderFood> olist=null;
		int orderId;
		String orderDate;
		double totalBill;
		String emailId;
		String orderStatus;
		
		System.out.println("Enter email id:-");
		String email=sc.nextLine();
		
		System.out.println("Enter password:-");
		String password=sc.nextLine();
		
		boolean login=new LoginDaoImpl().userLogin(email, password);
		
		if(login) {
			
			do {
				
				System.out.println("1------> Place order");
				System.out.println("2------> Show my order history");
				
				option=sc.nextInt();
				sc.nextLine();
				
				switch(option) {
				
					case 1:
							List<Cart> clist=cimpl.searchCartByEmailId(email);
							
							if(clist!=null && clist.isEmpty()!=true) {
								
								for(Cart c: clist) {
									
									System.out.println(c);
									System.out.println("_______________________________________");
								}
								
								System.out.println("Proceed to buy?? Enter yes or no...");
								String answer=sc.next().toLowerCase();
								sc.nextLine();
								
								if(answer.equals("yes")) {
									
									orderStatus="processing..............";
									
									o=new OrderFood();
									o.setOrderStatus(orderStatus);
									o.setEmailId(email);
									
									flag=oimpl.placeOrder(o);
									
									if(flag) {
										
										System.out.println("Your order has been placed");
										LocalTime time=LocalTime.now().plusHours(1);
										
										System.out.println("Delivery will be done before : "+time);
									}
									
									else
										System.out.println("Error while placing order....");
								}
								else if(answer.equals("no"))
									System.out.println("Thank you for being with us");
								else
									System.out.println("Please give answer in yes or no only!!");
							}
							else
								System.out.println("You do not have items in your cart.Hence you cannot place order");
							
						break;
						
					case 2:
						olist=oimpl.showMyOrderHistory(email);
						
						if(olist!=null && olist.isEmpty()!=true) {
							
							for(OrderFood o1: olist) {
								
								System.out.println("Order no: "+o1.getOrderId());
								System.out.println("Order date: "+o1.getOrderDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
								System.out.println("Bill: "+o1.getTotalBill());
								System.out.println("Status: "+o1.getOrderStatus());
								System.out.println("_____________________________________________________");
							}
						}
						else
							System.out.println("You have not ordered any thing from us till now!!!");
						break;
						
				}
			}
			while(exit==false);
		}
		else {}

	}

}
