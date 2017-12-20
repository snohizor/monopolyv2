package com.vinz.monopoly;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private String name;
	private int id;
	private int credit;
	private int position;
	private String positionName;
	private int ownedLands;

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

	public int getOwnedLands() {
		return ownedLands;
	}

	public void setOwnedLands(int ownedLands) {
		this.ownedLands = ownedLands;
	}
	
	
	// ******************************************
	// ******************ACTION******************
	// ******************************************

	public void onePlayerTurn(ArrayList<Land> board) {
		this.choiceTurn(board);
		this.getPlayerPosition(board);
	}

	public void choiceTurn(ArrayList<Land> board) {
		System.out.println("C'est au tour de " + this.getName() + " de jouer.\n" + this.getName() + " est sur "
				+ "position" + this.getPosition()
				+ "\nQue voulez-vous faire :\n1. Lancer les dés / 2. Gérer propriétés / 3. Échanges");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		if (choice == 1) {
			this.move();
		}

		else if (choice == 2) {
			// Do you own any land ?
			this.doesOwnAny(board);
		}

		else if (choice == 3) {
			// Trade
			System.out.println("not ready yet");
			// this.trade();
		}

		else {
			System.out.println("eksdee");
		}
	}

	// ******************************************
	// *****************POSITION*****************
	// ******************************************

	public void getPlayerPosition(ArrayList<Land> board) {
		this.getLandState(Land.findFromBoardPosition(board, this.getPosition()));
	}

	public void move() {
		Dices.rollDices();
		this.position = this.getPosition() + Dices.getTotalDices();

		// MANUAL DICE
		// this.position = this.getPosition() + 6;

		if (this.getPosition() > 40) {
			this.position = this.position - 40;
			System.out.println("Homerun ! Vous recevez 20000 $ !");
			this.setCredit(this.getCredit() + 20000);
		}
		else if(this.getPosition() == 40) {
			System.out.println("Case départ ! Vous recevez 40000 $ !!!");
			this.setCredit(this.getCredit() + 40000);
		}
	}

	public void getLandState(Land land) {

		System.out.println(this.getName() + " est tombé sur " + land.getName() + ".\n");

		// Est ce que le land est une propriété ou une carte Autre ?
		if (land.getGroup() == 0) {
			System.out.println("BONUS CARD");

			// Actions cartes spéciales
			if (land.getPosition() == 0) {
				// START

			} else if (land.getPosition() == 4) {
				// TAXE IMPOTS
			} else if (land.getPosition() == 10) {
				// PRISON/VISITE
			} else if (land.getPosition() == 20) {
				// PARC GRATUIT
			} else if (land.getPosition() == 30) {
				// GO TO JAIL
			} else if (land.getPosition() == 38) {
				// PRIME
			} else if (land.getPosition() == 2 || land.getPosition() == 17 || land.getPosition() == 33) {
				// REBELS 2 17 33
			} else if (land.getPosition() == 7 || land.getPosition() == 22 || land.getPosition() == 36) {
				// EMPIRE 7 22 36
			}
		} else if (land.getGroup() == 1 || land.getGroup() == 1 || land.getGroup() == 2 || land.getGroup() == 3
				|| land.getGroup() == 4 || land.getGroup() == 5 || land.getGroup() == 6 || land.getGroup() == 7
				|| land.getGroup() == 8 || land.getGroup() == 75 || land.getGroup() == 99) {

			// Si land.owner == 0 alors askBuy();
			if (land.getOwner() == null) {
				System.out.println("askBuy.exe\n");
				this.askBuy(land);
			}

			// Si land.owner == player.id, alors tranquille.exe;
			else if (land.getOwner().equals(this)) {
				System.out.println("tranquille.exe\n");

			}

			// Si land.owner =! 0 && =! player.id, alors payer.exe;
			else if (land.getOwner() != null && !land.getOwner().equals(this)) {
				System.out.println("Le propriétaire de ce terrain est " + land.getOwner().getName());
				this.payToPlayer(land);
			}

			// Sinon, sysout BUG ALERT;
			else {
				System.out.println("Error land.owner\n");
			}
		}

	}

	// ******************************************
	// ******************MANAGE******************
	// ******************************************

	public void doesOwnAny(ArrayList<Land> board) {
		ownedLands = 0;
		for (Land land : board) {
			if (land.getOwner() == this) {
				ownedLands++;
			}
		}
		if (ownedLands > 0) {
			this.displayPlayersOwnedLands(board);
		} else {
			System.out.println(this.getName() + " ne possède aucun terrain lol\n");
			this.choiceTurn(board);
		}
	}

	public void displayPlayersOwnedLands(ArrayList<Land> board) {
		System.out.println("Voici les propriétés possédées par " + this.getName() + " :\n");
		for (Land land : board) {
			if (land.getOwner() == this) {
				System.out.println(land.getName() + "\n");
			}
		}
		this.scanManage(board);
	}

	public void scanManage(ArrayList<Land> board) {
		System.out.println(
				"Que voulez-vous faire ?\n1. Ajouter des maisons ou hôtels / 2. Retirer des maisons ou hôtels / 3. Hypothéquer / 4. Lever hypothèque / 5. Détails carte / 0. Retour");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		if (choice == 0) {
			this.choiceTurn(board);
		}
		if (choice == 1) {
			this.addHouseOrHotel(board);
		}
		if (choice == 2) {
			this.removeHouseOrHotel(board);
		}
		if (choice == 3) {
			this.mortgage(board);
		}
		if (choice == 4) {
			this.unmortgage(board);
		}
		
	}

	public void addHouseOrHotel(ArrayList<Land> board) {
		System.out.println("addHouseOrHotel.exe");
		//est ce que t as une full collection?
		//
		//si oui, laquelle ?
				
		//sinon, get rekt.
	}
	
	public void removeHouseOrHotel(ArrayList<Land> board) {
		System.out.println("removeHouseOrHotel.exe");
	}
	
	public void mortgage(ArrayList<Land> board) {
		System.out.println("mortgage.exe");
	}
	
	public void unmortgage(ArrayList<Land> board) {
		System.out.println("unmortgage.exe");
	}

	public void detailsCard(Land land) {
		System.out.println("Voici les détails de " + land.getName());
		System.out.println("Prix : " + land.getPrice());
		System.out.println("Loyer nu : " + land.getAllRents());
		//System.out.println("Loyer 1 maison : " + land.getAllRents());
	}

	// ******************************************
	// ******************PAYING******************
	// ******************************************

	public void payToPlayer(Land land) {
		this.setCredit(this.getCredit() - land.creditsToPay(land));
		land.getOwner().setCredit(land.getOwner().getCredit() + land.creditsToPay(land));

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
		land.setOwner(this);
		this.setCredit(this.getCredit() - land.getPrice());
		System.out.println(this.getName() + " bought " + land.getName() + " for " + land.getPrice() + "$.");
		System.out.println(this.getName() + "'s credits = " + this.getCredit() + " $.");
	}

	public void displayMoneyPlayer() {
		System.out.println(this.getName() + " : " + this.getCredit() + " $");
	}
}