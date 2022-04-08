package com.intiFormation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	public static ArrayList<Client> listeClient = new ArrayList<Client>();
	public static ArrayList<Medicament> listeMedicament = new ArrayList<Medicament>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{

		Medicament m1 = new Medicament("Doliprane", 2.5, 50);
		listeMedicament.add(m1);

		Client c1 = new Client("Robert", 25);
		listeClient.add(c1);

		System.out.println("Veuillez sélectionner une opération à effectuer : \n"
				+ "1. Afficher les informations des clients et des médicaments \n"
				+ "2. Approvisionner des médicaments \n" + "3. Achat par un client \n" + "4. Quitter l'application");

		int key = sc.nextInt();
		switch (key)
		{
		case 1:
			affichage();
			break;

		case 2:
			approvisionner();
			break;

		case 3:
			acheter();
			break;

		case 4:
			quitter();

		default:
			break;
		}

	}

	private static Medicament lireMedicament()
	{
		System.out.println("Liste des médicament : " + listeMedicament);
		System.out.print("Choisir l'id du médicament correspondant : ");

		int idChoisi = sc.nextInt();
		boolean isTrouver = false;

		for (int i = 0; i < listeMedicament.size(); i++)
		{
			if (listeMedicament.get(i).getId() == idChoisi)
			{
				isTrouver = true;
				System.out.println("Informations médicament : " + listeMedicament.get(i));
				return listeMedicament.get(i);

			}
			if (isTrouver == false)
			{
				System.out.println("Aucune médicament correspondant à cet id. Veuillez recommencer.");
				lireMedicament();
			}

		}
		return null;

	}

	private static Client lireClient()
	{
		System.out.println("Liste des clients : " + listeClient);
		System.out.print("Choisir l'id du client correspondant : ");

		int idChoisi = sc.nextInt();
		boolean isTrouver = false;

		for (int i = 0; i < listeClient.size(); i++)
		{
			if (listeClient.get(i).getId() == idChoisi)
			{
				isTrouver = true;
				System.out.println("Informations client : " + listeClient.get(i));
				return listeClient.get(i);

			}
			if (isTrouver == false)
			{
				System.out.println("Aucune client correspondant à cet id. Veuillez recommencer.");
				lireClient();
			}

		}
		return null;
	}

	public static void affichage()
	{
		System.out.println("Clients : " + listeClient + "\n" + "Médicament : " + listeMedicament);
	}

	public static void approvisionner()
	{

		lireMedicament().ajoutStock();
	}

	public static void acheter()
	{
		{
			//A voirdans les autres classes
			
			System.out.println("Quelle quantité de ce médicament le client veut acheter ?");
			int qtAchat = sc.nextInt();
			lireMedicament().setStock(lireMedicament().getStock() - qtAchat);
			lireClient().setCredit(lireClient().getCredit() + (lireMedicament().getPrix() * qtAchat));

		}

	}

	public static void quitter()
	{
		System.out.println("Fin de l'application!");
	}

}
