package Test;

import java.util.*;
import Impl.FoodDaoImpl;
import POJO.Food;

public class FoodTest 
{
	public static void main(String args[])
	{
	FoodDaoImpl fdao=new FoodDaoImpl();
	Food f=new Food();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Choice :");
	System.out.println("1.Add Food");
	System.out.println("2.Delete Food");
	System.out.println("3.Update Food");
	System.out.println("4.List of Food");
	System.out.println("5.Search by Food Id");
	System.out.println("6.Search by Food Name");
	System.out.println("7.Search by Image");
	
	int choice=sc.nextInt();
	sc.nextLine();
	
	switch(choice)
	{
	case 1:
	{
		
		
		System.out.println("Enter the Food Name -->");
		String foodName=sc.nextLine();
		
		System.out.println("Enter the Food Type -->");
		String foodType=sc.nextLine();
		
		System.out.println("Enter the Food Category -->");
		String foodCategory=sc.nextLine();
		System.out.println("Enter the Food Description -->");
		String foodDesc=sc.nextLine();
		System.out.println("Enter the Food price -->");
		double foodPrice=sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Enter the Food Image -->");
		String image=sc.nextLine();
		
		Food f1=new Food(foodName,foodType,foodCategory,foodDesc,foodPrice,image);
		boolean b=fdao.addFood(f1);
		
		if (b)
		{
			System.out.println("Food added Successfully");
		}
		else
		{
			System.out.println("Food Not added");
		}
		break;
	}	
	case 2:
	{
		System.out.println("Enter FoodId you want to delete :");
		int foodId=sc.nextInt();
		boolean b1=fdao.deleteFood(foodId);
		if (b1)
		{
			System.out.println("Delete Successfully");
		}
		else
		{
			System.out.println("Not Deleted");
		}
		break;
	}	
	case 3:
	{
		System.out.println("Enter existing Id for update :");
		int fid=sc.nextInt();
		System.out.println("Enter the food name :");
		String fname=sc.next();
		System.out.println("Enter the food type :");
		String ftype=sc.next();
		System.out.println("Enter the food category :");
		String fcategory=sc.next();
		System.out.println("Enter the food description :");
		String fdesc=sc.next();
		System.out.println("Enter the food price :");
		double fprice=sc.nextDouble();
		System.out.println("Enter the food image :");
		String fimage=sc.next();
		
		f.setFoodId(fid);
		f.setFoodName(fname);
		f.setFoodType(ftype);
		f.setFoodCategory(fcategory);
		f.setFoodDesc(fdesc);
		f.setFoodPrice(fprice);
		f.setImage(fimage);
		
		boolean b=fdao.updateFood(f);
		if(b) 
		{
			System.out.println("Updated");
		}
		else 
		{
			System.out.println("Not updated");
		}
		break;
	}
	case 4:
	{
			List<Food> l=fdao.getAllFood();
			if(l!=null)
			{
				Iterator<Food> it= l.iterator();
				while (it.hasNext())
				{
					System.out.println(it.next());
				}
			}
			break;
	}
	case 5:
	{
		System.out.println("Enter existing id :");
		int id=sc.nextInt();
		Food f3=fdao.searchFood(id);
		if (f3!=null)
		{
			System.out.println(f3);
		}
		else
		{
			System.out.println("Food is not available");
		}
		break;
	}
	case 6:
		
	{
		System.out.println("Search food by name");
		String name =sc.next();
		List<Food> li=fdao.searchFoodByName(name);
		if(li!=null)
		{
			Iterator<Food> it=li.iterator();
			System.out.println(li);
			/*
			while(it.hasNext())
			{
				System.out.println(it.next());
			}
			*/
		}
		else
		{
			System.out.println("Unsuccessfull");
		}
		break;
	}
	case 7:
	{
		System.out.println("Search food by name");
		String category =sc.next();
		List<Food> li1=fdao.searchFoodByCategory(category);
		if(li1!=null)
		{
			Iterator<Food> it=li1.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next());
			}
		}
		else
		{
			System.out.println("Unsuccessfull");
		}
		break;
	}
	
	case 100:return;
	default :System.out.println("Invalid input....");
	}
	}
}
