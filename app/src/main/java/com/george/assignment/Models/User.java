package com.george.assignment.Models;

import android.graphics.Bitmap;

import com.george.assignment.ClassHelper.ImageConverter;

import java.util.Date;

public class User
{
	private int ID;
	private String FirstName;
	private String LastName;
	private String Sex;
	private Date DateOfBirth;
	private String Address;
	private String Email;
	private String Password;
	private Date DateSignUp;
	private String Image;


	public int getID()
	{
		return ID;
	}

	public void setID(int ID)
	{
		this.ID = ID;
	}

	public String getFirstName()
	{
		return FirstName;
	}

	public void setFirstName(String firstName)
	{
		FirstName = firstName;
	}

	public String getLastName()
	{
		return LastName;
	}

	public void setLastName(String lastName)
	{
		LastName = lastName;
	}

	public String getSex()
	{
		return Sex;
	}

	public void setSex(String sex)
	{
		Sex = sex;
	}

	public Date getDateOfBirth()
	{
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth)
	{
		DateOfBirth = dateOfBirth;
	}

	public String getAddress()
	{
		return Address;
	}

	public void setAddress(String address)
	{
		Address = address;
	}

	public String getEmail()
	{
		return Email;
	}

	public void setEmail(String email)
	{
		Email = email;
	}

	public String getPassword()
	{
		return Password;
	}

	public void setPassword(String password)
	{
		Password = password;
	}

	public Date getDateSignUp()
	{
		return DateSignUp;
	}

	public void setDateSignUp(Date dateSignUp)
	{
		DateSignUp = dateSignUp;
	}

	public String getImage()
	{
		return Image;
	}

	public void setImage(String image)
	{
		Image = image;
	}

	public String getFullName()
	{
		return getFirstName().concat(" ".concat(getLastName()));
	}

	public Bitmap getBitmapImage()
	{
		return ImageConverter.GetBitmapFromBase64String(getImage());
	}
}
