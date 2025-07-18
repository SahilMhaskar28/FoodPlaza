package Test;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Impl.CartDaoImpl;
import Impl.OrderDaoImpl;
import POJO.OrderFood;

public class AdminOrderTest {

	public static void main(String[] args) {
		
		boolean exit=false;
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
		
		do {
			
			System.out.println("1-------> Show all orders");
			System.out.println("2-------> Show order by id");
			System.out.println("3-------> Change order status");
			int option=sc.nextInt();
			sc.nextLine();
			
			switch (option) {
			case 1:
				olist=oimpl.showAllOrder();
				
				if(olist!=null && olist.isEmpty()!=true) {
					
					for(OrderFood o1: olist) {
						System.out.println("Ordered By: "+o1.getEmailId());
						System.out.println("Order no: "+o1.getOrderId());
						System.out.println("Order date: "+o1.getOrderDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
						System.out.println("Bill: "+o1.getTotalBill());
						System.out.println("Status: "+o1.getOrderStatus());
						System.out.println("_____________________________________________________");
					}
				}
				else
					System.out.println("No one has ordered anything yet!!!");
				break;
				
			case 2:
				System.out.println("Enter id of order that you want to see....");
				orderId=sc.nextInt();
				sc.nextLine();
				
				o=oimpl.showOrderById(orderId);
				
				if(o!=null) {
					
					System.out.println("Ordered By: "+o.getEmailId());
					System.out.println("Order no: "+o.getOrderId());
					System.out.println("Order date: "+o.getOrderDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
					System.out.println("Bill: "+o.getTotalBill());
					System.out.println("Status: "+o.getOrderStatus());
					System.out.println("_____________________________________________________");
				}
				
				else
					System.out.println("No order of this id found...");
				break;
				
			case 3:
				System.out.println("Enter the new status for the order");
				orderStatus=sc.nextLine();
				
				System.out.println("Enter the id of order whose status has to be changed");
				orderId=sc.nextInt();
				sc.nextLine();
				
				boolean flag=oimpl.changeOrderStatus(orderStatus, orderId);
				
				if(flag)
					System.out.println("Status has been changed successfully!!!");
				else
					System.out.println("Error while changing status");
				break;
				
			default:
				break;
			}
		}
		while(exit==false);

	}

}
