package Impl;

import java.util.*;
import java.sql.*;
import DAO.CartDao;
import POJO.Cart;
import POJO.Food;
import Utility.DButility;

public class CartDaoImpl implements CartDao
{
	Connection con=null;
	String sql;
	PreparedStatement pst=null; 	
	ResultSet rs=null;
	boolean flag;
	int row;
	List <Cart> cartlist=new LinkedList<>();
	
	
	@Override
	public boolean addToCart(Cart cart) 
	{
		con=DButility.getConnect();
		sql="insert into cart(foodid, fprice, fquantity, totalPrice, cEmail, fname)values(?, ?, ?, ?, ?, ?)";
		
		try
		{
		   PreparedStatement pst=con.prepareStatement(sql);
		   pst.setInt(1,cart.getFoodid());
		   
		   Food f=new FoodDaoImpl().searchFood(cart.getFoodid());
		   
		   pst.setDouble(2, f.getFoodPrice());
		   pst.setInt(3, cart.getFquantity());
		   
		   double totalPrice=f.getFoodPrice()*cart.getFquantity();
		   
		   pst.setDouble(4, totalPrice);
		   pst.setString(5, cart.getcEmail());
		   pst.setString(6, f.getFoodName());
		   
		   
		   row=pst.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public List<Cart> showCartList() 
	{
		con=DButility.getConnect();
		sql="select * from cart";
		
		try
		{
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			List<Cart> clist=new LinkedList<>();
			
			while(rs.next())
			{
				Cart ca=new Cart();
				ca.setCartid(rs.getInt("cartid"));
				ca.setcEmail(rs.getString("cEmail"));
				ca.setFname(rs.getString("fname"));
				ca.setFoodid(rs.getInt("foodid"));
				ca.setFprice(rs.getDouble("fprice"));
				ca.setFquantity(rs.getInt("fquantity"));
				ca.setTotalPrice(rs.getDouble("totalPrice"));
				
				clist.add(ca);
			}
			return clist;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Cart> searchCartByEmailId(String cEmail) 
	{
		con=DButility.getConnect();
		sql="select * from cart where cEmail=?";
		
		try
		{
			pst=con.prepareStatement(sql);
			pst.setString(1, cEmail);
			
			rs=pst.executeQuery();
			
			List<Cart> clist=new LinkedList<>();
			
			while(rs.next())
			{
				Cart ca=new Cart();
				ca.setCartid(rs.getInt("cartid"));
				ca.setcEmail(rs.getString("cEmail"));
				ca.setFname(rs.getString("fname"));
				ca.setFoodid(rs.getInt("foodid"));
				ca.setFprice(rs.getDouble("fprice"));
				ca.setFquantity(rs.getInt("fquantity"));
				ca.setTotalPrice(rs.getDouble("totalPrice"));
				
				clist.add(ca);
			}
			
			return clist;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cart searchCartById(int cartid) 
	{
		con=DButility.getConnect();
		
		sql="select * from cart where cartid=?";
		
		try
		{
			pst=con.prepareStatement(sql);
			pst.setInt(1, cartid);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				Cart ca =new Cart();
				ca.setCartid(rs.getInt("cartid"));
				ca.setcEmail(rs.getString("cEmail"));
				ca.setFname(rs.getString("fname"));
				ca.setFoodid(rs.getInt("foodid"));
				ca.setFprice(rs.getDouble("fprice"));
				ca.setFquantity(rs.getInt("fquantity"));
				ca.setTotalPrice(rs.getDouble("totalPrice"));
				
				return ca;
			}
			
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteCartById(int cartid) 
	{
		con=DButility.getConnect();
		sql="delete from cart where cartid=?";
		
		try
		{
			pst=con.prepareStatement(sql);
			pst.setInt(1, cartid);
			row=pst.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteCartByEmail(String email) 
	{
		con=DButility.getConnect();
		sql="delete from cart where cEmail=?";
		
		try
		{
			pst=con.prepareStatement(sql);
			pst.setString(1, email);
			row=pst.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		if (row>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateCart(int cartid, int fquantity) 
	{
		con=DButility.getConnect();
		sql="update cart set fquantity=? where cartid=?";
		
		try
		{
			pst=con.prepareStatement(sql);
			pst.setInt(1, fquantity);
			pst.setInt(2, cartid);
			row=pst.executeUpdate();
			
			if(row>0) {
				
				Cart c=searchCartById(cartid);
				
				double totalPrice=c.getFprice()*c.getFquantity();
				
				sql="update cart set totalPrice=? where cartid=?";
				try {
					pst=con.prepareStatement(sql);
					pst.setDouble(1, totalPrice);
					pst.setInt(2, cartid);
					
					int row2=pst.executeUpdate();
					
					if(row2>0)
						return true;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			else
				return false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
}
