package com.george.assignment.Models;

public class ProductReaction
{
	private  int ID;
	private String Complain;
	private boolean Love;
	private int UserID;
	private int ProductID;

	public int getID()
	{
		return ID;
	}

	public void setID(int ID)
	{
		this.ID = ID;
	}

	public String getComplain()
	{
		return Complain;
	}

	public void setComplain(String complain)
	{
		Complain = complain;
	}

	public boolean isLove()
	{
		return Love;
	}

	public void setLove(boolean love)
	{
		Love = love;
	}

	public int getUserID()
	{
		return UserID;
	}

	public void setUserID(int userID)
	{
		UserID = userID;
	}

	public int getProductID()
	{
		return ProductID;
	}

	public void setProductID(int productID)
	{
		ProductID = productID;
	}
}
