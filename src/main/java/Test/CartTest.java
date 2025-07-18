package Test;

import java.util.*;
import java.util.Scanner;

import Impl.CartDaoImpl;
import Impl.FoodDaoImpl;
import Impl.LoginDaoImpl;
import POJO.Cart;
import POJO.Food;

public class CartTest 
{
public static void main(String[] args) 
{
	Scanner sc=new Scanner(System.in);
	
	boolean exit=false, flag;
	FoodDaoImpl fimpl=new FoodDaoImpl();
	List<Food> flist=null;
	CartDaoImpl cimpl=new CartDaoImpl();
	Cart cart=null;
	List<Cart> clist=null;
	
	int cartid;
	int foodid;
	String cEmail;
	int fquantity;
	String fname;
	double fprice;
	
	System.out.println("Enter email id:-");
	String email=sc.nextLine();
	
	System.out.println("Enter password:-");
	String password=sc.nextLine();
	
	boolean login=new LoginDaoImpl().userLogin(email, password);
	
	if(login==true) {
	do {
		
		System.out.println("1-----> Add to cart");
		System.out.println("2-----> Show my cart");
		System.out.println("3-----> Update quantity of item");
		System.out.println("4-----> Delete item from cart");
		System.out.println("5-----> Clear my cart");
		
		
		int option=sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		
		case 1:
			
			flist=fimpl.getAllFood();
			
			for(Food f: flist) {
				
				System.out.println(f);
				System.out.println("__________________________________________________________________________");
			}
			
			
			System.out.println("Enter id of food you want to add to cart");
			foodid=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter quantity of this food ");
			fquantity=sc.nextInt();
			sc.nextLine();
			
			
			cart=new Cart();
			cart.setFoodid(foodid);
			cart.setFquantity(fquantity);
			cart.setcEmail(email);//we get email when the person is logging in
			
			flag=cimpl.addToCart(cart);
			
			if(flag)
				System.out.println("Food item added to cart successfully");
			else
				System.out.println("Error while adding this item in cart. Please try again");
			
			break;
			
		case 2:
			
			clist=cimpl.searchCartByEmailId(email);
			
			if(clist==null || clist.isEmpty())
				System.out.println("Your cart is empty. Please add items to your cart first!!!");
			else {
				double bill=0;
				
				for(Cart c1: clist) {
					
					bill=bill+c1.getTotalPrice();
					System.out.println(c1);
					System.out.println("_______________________________________________");
				}
				
				System.out.println("Amount payable= "+bill);
			}
		break;
		
		case 3:
			System.out.println("Enter the cart id for the item whose quantity is to be changed...");
			cartid=sc.nextInt();
			sc.nextLine();
			
			
			System.out.println("Enter the new quantity for said item");
			fquantity=sc.nextInt();
			sc.nextLine();
			
			flag=cimpl.updateCart(cartid, fquantity);
			
			if(flag)
				System.out.println("Quantity of your food item has been changed successfully");
			else
				System.out.println("Error while changing quantity!!!");
			break;
			
		case 4: 
			System.out.println("Enter the cart id of item to be deleted...");
			cartid=sc.nextInt();
			sc.nextLine();
			
			flag=cimpl.deleteCartById(cartid);
			
			if(flag)
				System.out.println("Item successfully deleted from cart");
			else
				System.out.println("Error while deleting item from cart!!!");
			break;
			
		case 5: 
			
			System.out.println("Are you sure you want to clear your cart?Enter yes or no");
			String answer=sc.next().toLowerCase();
			sc.nextLine();
			
			if(answer.equals("yes")) {
				
				flag=cimpl.deleteCartByEmail(email);
				
				if(flag)
					System.out.println("Your cart is cleared. Please continue browsing for other items of your choice");
				else
					System.out.println("Error while clearing cart!!!");
			}
			
			else if(answer.equals("no"))
				System.out.println("Thank you!! Please continue browsing for more of your favourite dishes");
			else
				System.out.println("Please enter your answer in yes or no only!!!");
			
			break;
		}//switch end bracket
		
		
	}//do end bracket
	while(exit==false);
	
	}
	
	else
	{
		login=new LoginDaoImpl().adminLogin(email, password);
		
		if(login) {
			
			clist=cimpl.showCartList();
			
			if(clist!=null && clist.isEmpty()!=true) {
				
				for(Cart c1: clist) {
					
					System.out.println(c1);
					System.out.println("___________________________________________________________________");
				}
			}
			
			else
				System.out.println("No one has added any item to cart!!!");
		}
		
		else
			System.out.println("Please check the email id and password given. Login could not be processed");
		
	}
	
}
}
