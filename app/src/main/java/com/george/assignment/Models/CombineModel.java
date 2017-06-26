package com.george.assignment.Models;

import java.util.Date;

public class CombineModel
{
	private User user;
	private ProductReaction productReaction;
	private Product product;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public ProductReaction getProductReaction()
	{
		return productReaction;
	}

	public void setProductReaction(ProductReaction productReaction)
	{
		this.productReaction = productReaction;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}
}
