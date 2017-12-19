package com.vinz.monopoly;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private String name;
	private int id;
	private int credit;
	private int position;

	private Object tempObj;

	public Player(String name, int id, int credit, int position) {
		super();
		this.name = name;
		this.id = id;
		this.credit = credit;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	// POSITION

	public void turn() {
		this.move();
	}

	public void move() {
		Dices.rollDices();
		this.position = this.getPosition() + Dices.getTotalDices();

		if (this.position >= 40) {
			this.position = this.position - 40;
			System.out.println("homerun");

		}
	}

	public void choice(Land land) {
		
		System.out.println(this.getName() + " est tombé sur " + land.getName() + ".\n");

		// Est ce que le land est une propriété ou une carte Autre ?
		if (land.getGroup() == 0) {
			System.out.println("BONUS CARD");
			
			//Actions cartes spéciales
			if(land.getPosition() == 0) {
				//START
				
			}
			else if(land.getPosition() == 4) {
				//TAXE IMPOTS
			}
			else if(land.getPosition() == 10) {
				//PRISON/VISITE
			}
			else if(land.getPosition() == 20) {
				//PARC GRATUIT
			}
			else if(land.getPosition() == 30) {
				//GO TO JAIL
			}
			else if(land.getPosition() == 38) {
				//PRIME
			}
			else if(land.getPosition() == 2 || land.getPosition() == 17 || land.getPosition() == 33) {
				//REBELS 2 17 33
			}
			else if(land.getPosition() == 7 || land.getPosition() == 22 || land.getPosition() == 36) {
				//EMPIRE 7 22 36
			}
		} else if (land.getGroup() == 1 || land.getGroup() == 1 || land.getGroup() == 2 || land.getGroup() == 3
				|| land.getGroup() == 4 || land.getGroup() == 5 || land.getGroup() == 6 || land.getGroup() == 7
				|| land.getGroup() == 8 || land.getGroup() == 75 || land.getGroup() == 99) {

			// Si land.owner == 0 alors askBuy();
			if (land.getOwner() == 0) {
				System.out.println("askBuy.exe\n");
				this.askBuy(land);
			}

			// Si land.owner == player.id, alors tranquille.exe;
			else if (land.getOwner() == this.getId()) {
				System.out.println("tranquille.exe\n");

			}

			// Si land.owner =! 0 && =! player.id, alors payer.exe;
			else if (land.getOwner() != 1 && land.getOwner() != this.getId()) {

				this.payToPlayer(land);
			}

			// Sinon, sysout BUG ALERT;
			else {
				System.out.println("Error land.owner\n");
			}
		}
	}

	// TRAVAILLER CETTE FONCTION - need arraylist de player
	public static Land findhdjdOwner(ArrayList<Land> board, int position) {
		return board.stream().filter(land -> land.getPosition() == position).findFirst().orElse(null);
	}

	// Créer un tableau pour foreach et trouver le owner ?
	public Player findOwner() {
		int tempTable[] = { 0, 0 };
		return null;
	}

	public void payToPlayer(Land land) {
		this.setCredit(this.getCredit() - land.creditsToPay(land));

		// Texte
		// System.out.println(this.getName() + " est tombé chez " +
		// (land.getOwner()).getName() + "...");
		System.out.println("Le loyer est de " + land.getRent() + ".");
		System.out.println(this.getName() + "'s credits = " + this.getCredit() + " $.\n");
		// System.out.println(land.getOwner() + "'s credits = " +
		// (land.getOwner()).getCredit() + " $.\n");
	}

	public void askBuy(Land land) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to buy ?\n");
		System.out.println("1.YES / 2.NO\n");
		int choice = sc.nextInt();

		if (choice == 1) {
			this.buy(land);
		} else if (choice == 2) {

		} else {
			System.out.println("lol");
		}
	}

	public void buy(Land land) {
		land.setOwner(this.getId());
		this.setCredit(this.getCredit() - land.getPrice());
		System.out.println(this.getName() + " bought " + land.getName() + " for " + land.getPrice() + "$.");
		System.out.println(this.getName() + "'s credits = " + this.getCredit() + " $.");
	}
}