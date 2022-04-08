package com.intiFormation;

import java.util.*;

public class Medicament
{

	Scanner sc = new Scanner(System.in);

	private static int compteur = 0;
	private int id;
	private String nom;
	private double prix;
	private int stock;

	public Medicament()
	{
	}

	public Medicament(String nom, double prix, int stock)
	{
		super();
		compteur++;
		this.id = compteur;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
	}

	public void ajoutStock()
	{
		System.out.println("Combien voulez-vous ajouter au stock ? ");
		int ajoutStock = sc.nextInt();

		stock += ajoutStock;
		System.out.println("Nouveau stock : " + stock);

	}


	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public double getPrix()
	{
		return prix;
	}

	public void setPrix(double prix)
	{
		this.prix = prix;
	}

	public int getStock()
	{
		return stock;
	}

	public void setStock(int stock)
	{
		this.stock = stock;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "Medicament [id=" + id + ", nom=" + nom + ", prix=" + prix + ", stock=" + stock + "]";
	}

}