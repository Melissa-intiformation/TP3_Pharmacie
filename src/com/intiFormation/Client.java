package com.intiFormation;


import java.util.*;

public class Client {

	private static int compteur = 0;
    private int id;
    private String nom;
    private double credit;

    public Client() {
    }
 
    
    public Client(String nom, double credit)
	{
		super();
		compteur++;
		this.id = compteur;
		this.nom = nom;
		this.credit = credit;
	}


    
	public static int getCompteur()
	{
		return compteur;
	}


	public static void setCompteur(int compteur)
	{
		Client.compteur = compteur;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getNom()
	{
		return nom;
	}


	public void setNom(String nom)
	{
		this.nom = nom;
	}


	public double getCredit()
	{
		return credit;
	}


	public void setCredit(double credit)
	{
		this.credit = credit;
	}


	@Override
	public String toString()
	{
		return "Client [id=" + id + ", nom=" + nom + ", credit=" + credit + "]";
	}

	
	
}