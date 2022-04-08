package com.intiFormation;

import java.util.ArrayList;
import java.util.Scanner;

import com.intiFormation.Exception.nbMedicamentNegException;
import com.intiFormation.Exception.notEnoughStockException;

public class Main
{
	public static ArrayList<Client> listeClient = new ArrayList<Client>();
	public static ArrayList<Medicament> listeMedicament = new ArrayList<Medicament>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws nbMedicamentNegException, notEnoughStockException
	{

		Medicament m1 = new Medicament("Doliprane", 2.5, 50);
		listeMedicament.add(m1);
		Medicament m2 = new Medicament("Spasfon", 3, 25);
		listeMedicament.add(m2);

		Client c1 = new Client("Robert", 25);
		listeClient.add(c1);
		
		Client c2 = new Client("Marie", -10);
		listeClient.add(c2);
		
		switchCase();

	}
	
	public static void switchCase() throws nbMedicamentNegException, notEnoughStockException
	{
		System.out.println("Veuillez choisir une fonction : \n" 
				+ "1. Fonction de l'application (afficher, appprovisionner, acheter) \n"
				+ "2. Ajouter nouveau client et/ou médicament \n"
				+ "3. Quitter l'application");
		
		int key = sc.nextInt();
		switch (key)
		{
		case 1:
			switchCase1();
			quitter();
			break;
		
		case 2:
			switchCase2();
			quitter();
			break;
		
		case 3:
			quitter();
			break;
		
		default:
			break;
		}
	}
	
	
	
	public static void switchCase2() throws nbMedicamentNegException, notEnoughStockException
	{
		System.out.println("Veuillez choisir une fonction : \n" 
				+ "1. Ajouter nouveau médicament \n"
				+ "2. Ajouter nouveau client \n"
				+ "3. Revenir à l'accueil de l'application");
		int key = sc.nextInt();
		switch (key)
		{
		case 1:
			Medicament m = new Medicament();
			System.out.print("Nom du médicament: ");
			m.setNom(sc.next());
			System.out.print("Prix : ");
			m.setPrix(sc.nextInt());
			System.out.print("Stock actuel : ");
			m.setStock(sc.nextInt());
			break;
		
		case 2:
			Client c = new Client();
			System.out.print("Nom du client : ");
			c.setNom(sc.next());
			System.out.print("Prix : ");
			c.setCredit(sc.nextDouble());
			break;
		
		case 3:
			switchCase();
			break;

		}
	}
	
	public static void switchCase1() throws nbMedicamentNegException, notEnoughStockException
	{

		System.out.println("Veuillez sélectionner une opération à effectuer : \n"
				+ "1. Afficher les informations des clients et des médicaments \n"
				+ "2. Approvisionner des médicaments \n" + "3. Achat par un client \n"
				+ "4. Revenir à l'accueil de l'application");

		int key = sc.nextInt();
		switch (key)
		{
		case 1:
			affichage();
			quitter();
			break;

		case 2:
			lireMedicament().ajoutStock();
			quitter();
			break;

		case 3:
			lireClient().achat(lireMedicament());
			System.out.println("Opération réalisée avec succès.");
			quitter();
			break;
		
		case 4:
			switchCase();
			break;

		
		default:
			break;
		}

	}

	private static Medicament lireMedicament()
	{
		System.out.println("Liste des médicaments : " + listeMedicament);
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

		}
		if (isTrouver == false)
		{
			System.out.println("Aucune médicament correspondant à cet id. Veuillez recommencer.");
			lireMedicament();
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
			
		}
		if (isTrouver == false)
		{
			System.out.println("Aucune client correspondant à cet id. Veuillez recommencer.");
			lireClient();
		}

		return null;
	}

	public static void affichage()
	{
		System.out.println("Clients : " + listeClient + "\n" + "Médicament : " + listeMedicament);
	}


	public static void quitter() throws nbMedicamentNegException, notEnoughStockException
	{
		System.out.println("Voulez-vous faire d'autres opérations ou quitter l'application ? \n"
				+ "1. Quitter l'application \n"
				+ "2. Revenir au menu");
		int choixMenu = sc.nextInt();
		if (choixMenu == 1)
		{
			System.out.println("Fin de l'application!");
		}
		else 
		{
			switchCase();
		}

	}

}
