package com.vinz.monopoly;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Player player1 = new Player("Kévin", 1, 150000, 0);
		Player player2 = new Player("Hugo", 2, 150000, 0);

		//ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(new Player("Hugo", 2, 150000, 0)));

		int land1[] = { 200, 2000, 4000, 8000, 15000, 25000 };
		int land3[] = { 300, 3000, 6000, 10000, 17000, 45000 };
		int land6[] = { 600, 5000, 10000, 15000, 20000, 50000 };
		int land8[] = { 600, 5000, 10000, 15000, 20000, 50000 };
		int land9[] = { 800, 6000, 12000, 17000, 22000, 55000 };
		
		ArrayList<Land> lands = new ArrayList<Land>(Arrays.asList(

				/*
				 * PLEASE GENERATE ME SUM AUTO ID
				 */
				
				
				new Land(0, 	0, 	null, 		0, 		0, 		null, 	"Start"),
				new Land(1, 	1, 	null, 		6000, 	200, 	land1, 	"Marais de Dagobah"),
				new Land(2, 	0, 	null, 		0, 		0, 		null, 	"Rebels"),
				new Land(3, 	1,	null, 		6000, 	400, 	land3, 	"Hutte de Yoda"),
				new Land(4, 	0, 	null, 		0, 		20000, 	null, 	"Taxe"),
				new Land(5, 	75, null, 		20000, 	2500, 	null, 	"Tie-Fighter"),
				new Land(6, 	2, 	player2, 	10000, 	600, 	land6, 	"Base Echo"),
				new Land(7, 	0, 	null, 		0, 		0, 		null, 	"Empire"),
				new Land(8, 	2, 	player2, 	10000, 	600, 	land8, 	"Plaines Glacées"),
				new Land(9, 	2, 	player2, 	12000, 	800, 	land9,	"Crête Nord"),
				new Land(10, 	0, 	null, 		0, 		0, 		null, 	"Prison/Visite")
				
				/*
				
				new Land(11, 3, null, 14000, 1000, "Ferme de Lars"),
				new Land(12, 3, null, 14000, 1000, "Mosesli"),
				new Land(13, 99, null, 15000, 0, "Réacteur Central"),
				new Land(14, 3, null, 16000, 1200, "Palais de Jabba le Forestier")
				
				*/
				/*
				new Land(15, 75, 0, 20000, "Faucon Millenium"),
				new Land(16, 4, 0, 18000, "Salle de combat"),
				new Land(17, 0, 0, 0, "Rebels"),
				new Land(18, 4, 0, 18000, "Temple de Massassi"),
				new Land(19, 4, 0, 20000, "Salle du trône"),
				new Land(20, 0, 0, 0, "Parc Gratuit"),
				new Land(21, 5, 0, 22000, "Plateforme d'atterissage"),
				new Land(22, 0, 0, 0, "Empire"),
				new Land(23, 5, 0, 0, "Chambre de congélation carbonique"),
				new Land(24, 5, 0, 0, "Salle de contrôle du réacteur"),
				new Land(25, 75, 0, 0, "X-Wing Fighter"),
				new Land(26, 6, 0, 0, "Plate-forme d'atterissage"),
				new Land(27, 6, 0, 0, "Salle du trône"),
				new Land(28, 99, 0, 0, "Ferme aquatique"),
				new Land(29, 6, 0, 0, "Noyau central"),
				new Land(30, 0, 0, 0, "Allez en prison"),
				new Land(31, 7, 0, 0, "Forêt d'Endor"),
				new Land(32, 7, 0, 0, "Générateur du bouclier de protection"),
				new Land(33, 0, 0, 0, "Rebels"),
				new Land(34, 7, 0, 0, "Village des Ewoks"),
				new Land(35, 75, 0, 0, "Destroyer impérial"),
				new Land(36, 0, 0, 0, "Empire"),
				new Land(37, 8, 0, 0, "Monument carré"),
				new Land(38, 0, 0, 0, "Prime"),
				new Land(39, 8, 0, 0, "Palais impérial")
				*/
				));
		
		//System.out.println(Land.findFromBoardPosition(lands, player1.getPosition()).getName());

		System.out.println("START");
		
		player2.onePlayerTurn(lands);
		
		player2.displayPlayersOwnedLands(lands);

		
		/*
		player2.choiceTurn(lands);
		
		player1.getLandState(Land.findFromBoardPosition(lands, player1.getPosition()));
		

		player1.displayMoneyPlayer();
		player2.displayMoneyPlayer();
		
		player1.doesOwnAny(lands);
		System.out.println("player kevin :");
		System.out.println(player1.getOwnedLands());
		
		player2.doesOwnAny(lands);
		System.out.println("player hugo :");
		System.out.println(player2.getOwnedLands());
		*/
		
	}

}