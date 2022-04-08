package com.intiFormation.Exception;

public class notEnoughStockException extends Exception
{

	public notEnoughStockException()
	{
		System.err.println("Quantité à acheter supérieure au stock disponible instanciée");

	}

}
