package com.george.assignment.Models;

import android.graphics.Bitmap;

import com.george.assignment.ClassHelper.ImageConverter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable
{
	private int ID;
	private String Name;
	private int TypeID;
	private Date DateAdded;
	private String Image;
	private BigDecimal Price;
	private int CurrencyID;
	private String Detail;
	private int Quantity;
	private int UserID;

	public int getID()
	{
		return ID;
	}

	public void setID(int ID)
	{
		this.ID = ID;
	}

	public String getName()
	{
		return Name;
	}

	public void setName(String name)
	{
		Name = name;
	}

	public int getTypeID()
	{
		return TypeID;
	}

	public void setTypeID(int typeID)
	{
		TypeID = typeID;
	}

	public Date getDateAdded()
	{
		return DateAdded;
	}

	public void setDateAdded(Date dateAdded)
	{
		DateAdded = dateAdded;
	}

	public String getImage()
	{
		return Image;
	}

	public void setImage(String image)
	{
		Image = image;
	}

	public BigDecimal getPrice()
	{
		return Price;
	}

	public void setPrice(BigDecimal price)
	{
		Price = price;
	}

	public int getCurrencyID()
	{
		return CurrencyID;
	}

	public void setCurrencyID(int currencyID)
	{
		CurrencyID = currencyID;
	}

	public String getDetail()
	{
		return Detail;
	}

	public void setDetail(String detail)
	{
		Detail = detail;
	}

	public int getQuantity()
	{
		return Quantity;
	}

	public void setQuantity(int quantity)
	{
		Quantity = quantity;
	}

	public int getUserID()
	{
		return UserID;
	}

	public void setUserID(int userID)
	{
		UserID = userID;
	}

	public Bitmap getBitmapImage()
	{
		return ImageConverter.GetBitmapFromBase64String(getImage());
	}
}
