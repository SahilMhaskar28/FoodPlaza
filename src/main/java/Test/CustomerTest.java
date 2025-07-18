package Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Impl.CustomerDaoImpl;
import POJO.Customer;

public class CustomerTest 
{
	public static void main(String args[])

	{
		CustomerDaoImpl cdao=new CustomerDaoImpl();
		Customer c =new Customer();
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter Your Choice :");
		System.out.println("1.Add Customer Name");
		System.out.println("2.Delete Customer");
		System.out.println("3.Update Details of Customer");
		System.out.println("4.Show List of Customer");
		System.out.println("5.Search by Email Id");
		System.out.println("6.Return or Exit");

		int choice=sc.nextInt();

		switch(choice)
		{
			case 1:
			{
				System.out.println("Enter the customer name :");
				String custName=sc.next();
				System.out.println("Enter the customer emailid :");
				String emailId=sc.next();
				System.out.println("Enter the customer password :");
				String custPassword=sc.next();
				System.out.println("Enter the customer address :");
				String custAddress=sc.next();
				System.out.println("Enter the customer contact number :");
				String contactNo=sc.next();
				System.out.println("Enter the customer location :");
				String custLocation=sc.next();
	
				Customer c1=new Customer(custName,emailId,custPassword,custAddress,contactNo,custLocation);
				boolean b=cdao.addCustomer(c1);
				if(b)
					{System.out.println("Customer added Successfully..");}
				else
					{System.out.println("Customer not inserted");}
				break;
			}
		

		case 2:
			{
				System.out.println("Enter Customer email Id,you want to delete :");
				String emailId=sc.next();
				boolean b1=cdao.deleteCustomer(emailId);
				if(b1)
					{System.out.println("Customer Delete successfully....");}
				else
					{System.out.println("SORRY,Customer Not Deleted...");}
				break;
			}	
				

		case 3:
			{
				System.out.println("Enter eexisting email Id for update details :");
				String emailId=sc.next();
				System.out.println("Enter Customer name :");
				String custName=sc.next();
				System.out.println("Enter Customer password :");
				String custPassword=sc.next();
				System.out.println("Enter Customer Address :");
				String custAddress=sc.next();
				System.out.println("Enter Customer Contact Number :");
				String contactNo=sc.next();
				System.out.println("Enter Customer Location :");
				String custLocation=sc.next();
	
				c.setEmailId(emailId);
				c.setCustName(custName);
				c.setCustPassword(custPassword);
				c.setCustAddress(custAddress);
				c.setContactNo(contactNo);
				c.setCustLocation(custLocation);
	
				boolean b=cdao.updateCustomer(c);
				if(b)
					{System.out.println("Customer Update Successfully...");}
				else 
					{System.out.println("SORRY,Customer is not updated...");}
				break;
			}
		

		case 4:
			{
				List<Customer> l= cdao.getAllCustomer();
				if(l !=null)
				{
					Iterator<Customer> it=l.iterator();
					while(it.hasNext())
					{
						System.out.println(it.next());
					}
				}
				break;
			}
			

		case 5:
					{ 
						System.out.println("Enter existing email Id :");
						String emailId=sc.next();
						Customer c3=cdao.searchByEmailId(emailId);
						if(c3!=null)
							{System.out.println(c3);}
						else
							{System.out.println("Email Id is not available");}
						break;
					}
		

		case 6: return;

		default:System.out.println("Invalid Input");

		}
	}
}
