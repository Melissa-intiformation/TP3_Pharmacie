package com.intiFormation.Exception;

public class notEnoughStockException extends Exception
{

	public notEnoughStockException()
	{
		System.err.println("Quantit� � acheter sup�rieure au stock disponible instanci�e");

	}

}
