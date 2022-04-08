package com.intiFormation;

import java.util.*;

import com.intiFormation.Exception.nbMedicamentNegException;
import com.intiFormation.Exception.notEnoughStockException;

public class Client
{

	Scanner sc = new Scanner(System.in);

	private static int compteur = 0;
	private int id;
	private String nom;
	private double credit;

	public Client()
	{
	}

	public Client(String nom, double credit)
	{
		super();
		compteur++;
		this.id = compteur;
		this.nom = nom;
		this.credit = credit;
	}

	public void achat(Medicament medicament) throws notEnoughStockException
	{
		System.out.println("Quelle quantité d'un médicament le client veut acheter ?");
		int qtAchat = sc.nextInt();

		if (qtAchat > medicament.getStock())
		{
			throw new notEnoughStockException();

//			System.out.println(
//					"Stock restant : " + medicament.getStock() + "\nVoulez-vous acheter tout le stock restant ? \n"
//							+ "1. Oui.\n" + "2. Non, je souhaite recommencer l'achat.");
//			int choixTtAcheter = sc.nextInt();
//			if (choixTtAcheter == 1)
//			{
//				qtAchat = medicament.getStock();
//				medicament.setStock(0);
//				credit += qtAchat * medicament.getPrix();
//				System.out.println("Nouveau stock du médicament : " + medicament.getNom() + "reste "
//						+ medicament.getStock() + "\nNouveau crédit client avant paiement : " + credit);
//			} else
//			{
//				achat(medicament);
//			}

		} else
		{

			medicament.setStock(medicament.getStock() - qtAchat);
			credit += qtAchat * medicament.getPrix();
			System.out.println("Nouveau stock du médicament : " + medicament.getNom() + "reste " + medicament.getStock()
					+ "\nNouveau crédit client avant paiement : " + credit);
		}

		System.out.println("Le client veut-il payer maintenant ? Son crédit actuel après achat est de " + credit
				+ "\n1. oui \n" + "2. non");
		int choixPayer = sc.nextInt();
		if (choixPayer == 1)
		{
			payer();
		} else
		{
			System.out.println("Le client n'a pas voulu payer toute de suite. Le crédit du client n'a pas diminué.");
		}
	}

	public void payer()
	{
		System.out.println("Combien le client a-il payé (Saisir une valeur supérieure ou égale à 0 ?)");
		double paie = sc.nextDouble();
		if (paie > 0)
		{
			credit -= paie;
			System.out.println("Nouveau crédit : " + credit);
		} else
		{
			System.out.println("Erreur, le montant saisi est incorrecte. Le crédit du client n'a pas diminué.");
		}
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