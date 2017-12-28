package com.vinz.monopoly;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Player player1 = new Player("Kévin", 1, 150000, 0);
		Player player2 = new Player("Hugo", 2, 150000, 0);

		//ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(new Player("Hugo", 2, 150000, 0)));

		int stations[] = { 2500, 5000, 10000, 20000 };
		
		//Light purple
		int landA1[] = { 200, 1000, 3000, 9000, 16000, 25000 };
		int landA2[] = { 300, 2000, 6000, 18000, 32000, 45000 };
		
		//Light blue
		int landB1[] = { 600, 3000, 9000, 27000, 40000, 55000 };
		int landB2[] = { 800, 4000, 10000, 30000, 45000, 60000 };
		
		//Purple
		int landC1[] = { 1000, 5000, 15000, 45000, 62500, 75000 };
		int landC2[] = { 1200, 6000, 18000, 50000, 70500, 90000 };
		
		//Orange
		int landD1[] = { 1400, 7000, 20000, 55000, 75000, 95000 };
		int landD2[] = { 1600, 8000, 22000, 60000, 80000, 100000 };
		
		//Red
		int landE1[] = { 1800, 9000, 25000, 70000, 87500, 105000 };
		int landE2[] = { 2000, 10000, 30000, 75000, 92500, 110000 };
		
		//Yellow
		int landF1[] = { 2200, 11000, 33000, 80000, 97500, 115000 };
		int landF2[] = { 2400, 12000, 36000, 85000, 102500, 120000 };
		
		//Green
		int landG1[] = { 2600, 13000, 39000, 90000, 110000, 127500 };
		int landG2[] = { 2800, 15000, 45000, 100000, 120000, 140000 };
		
		//Dark blue
		int landH1[] = { 3500, 17500, 50000, 110000, 130000, 150000 };
		int landH2[] = { 5000, 20000, 60000, 140000, 170000, 200000 };
		
		ArrayList<Land> lands = new ArrayList<Land>(Arrays.asList(

				/*
				 * PLEASE GENERATE ME SUM AUTO ID
				 */
				
				//		ID	GROUP	OWNER		PRICE	HOUSES	
				new Land(0, 	0, 	null, 		0, 		0, 		null, 		"Start"),
				new Land(1, 	1, 	null, 		6000, 	0,	 	landA1, 	"Marais de Dagobah"),
				new Land(2, 	0, 	null, 		0, 		0, 		null, 		"Rebels"),
				new Land(3, 	1,	null, 		6000, 	0,	 	landA2, 	"Hutte de Yoda"),
				new Land(4, 	0, 	null, 		0, 		0,	 	null, 		"Taxe"),
				new Land(5, 	75, null, 		20000, 	0,	 	null, 		"Tie-Fighter"),
				new Land(6, 	2, 	player1, 		10000, 	2,	 	landB1, 	"Base Echo"),
				new Land(7, 	0, 	null, 		0, 		0, 		null, 		"Empire"),
				new Land(8, 	2, 	player1, 		10000, 	2,	 	landB1, 	"Plaines Glacées"),
				new Land(9, 	2, 	player1, 		12000, 	2,	 	landB2,		"Crête Nord"),
				new Land(10, 	0, 	null, 		0, 		0, 		null, 		"Prison/Visite"),				
				new Land(11, 	3, 	null, 		14000, 	0,	 	landC1, 	"Ferme de Lars"),
				new Land(12, 	3, 	null, 		14000, 	0,	 	landC1, 	"Mosesli"),
				new Land(13, 	99, null, 		15000, 	0, 		null, 		"Réacteur Central"),
				new Land(14, 	3, 	null, 		16000, 	0,	 	landC2,		"Palais de Jabba le Forestier"),
				new Land(15, 	75,	null, 		0, 		0,	 	stations,	"Faucon Millenium"),
				new Land(16, 	4, 	null, 		0, 		0,	 	landD1,		"Salle de combat"),
				new Land(17, 	0, 	null, 		0, 		0, 		null,		"Rebels"),
				new Land(18, 	4,	null,  		0, 		0,	 	landD1,		"Temple de Massassi"),
				new Land(19, 	4, 	null,		0, 		0,	 	landD2,		"Salle du trône"),
				new Land(20, 	0, 	null, 		0, 		0, 		null,		"Parc Gratuit"),
				new Land(21, 	5, 	null,		0, 		0,	 	landE1,		"Plateforme d'atterissage"),
				new Land(22, 	0, 	null,		0, 		0, 		null,		"Empire"),
				new Land(23, 	5, 	null,		0, 		0, 		landE1,		"Chambre de congélation carbonique"),
				new Land(24, 	5, 	null,		0,		0, 		landE2,		"Salle de contrôle du réacteur"),
				new Land(25, 	75, null,		0, 		0, 		null,		"X-Wing Fighter"),
				new Land(26, 	6, 	null,		0, 		0, 		landF1,		"Plate-forme d'atterissage"),
				new Land(27, 	6, 	null,		0, 		0, 		landF1,		"Salle du trône"),
				new Land(28, 	99, null,		0, 		0, 		null,		"Ferme aquatique"),
				new Land(29, 	6, 	null,		0, 		0, 		landF2,		"Noyau central"),
				new Land(30, 	0, 	null,		0, 		0, 		null,		"Allez en prison"),
				new Land(31, 	7, 	null,		0, 		0, 		landG1,		"Forêt d'Endor"),
				new Land(32, 	7, 	null,		0, 		0, 		landG1,		"Générateur du bouclier de protection"),
				new Land(33, 	0, 	null,		0, 		0, 		null,		"Rebels"),
				new Land(34, 	7, 	null,		0, 		0, 		landG2,		"Village des Ewoks"),
				new Land(35, 	75, null,		0, 		0, 		null,		"Destroyer impérial"),
				new Land(36, 	0, 	null,		0, 		0, 		null,		"Empire"),
				new Land(37, 	8, 	null,		0, 		0, 		landH1,		"Monument carré"),
				new Land(38, 	0, 	null,		0, 		0, 		null,		"Prime"),
				new Land(39, 	8, 	null,		0, 		0, 		landH2,		"Palais impérial")
				));
		
		//System.out.println(Land.findFromBoardPosition(lands, player1.getPosition()).getName());

		System.out.println("START");
		
		player2.onePlayerTurn(lands);
		

		
		/*
		player2.choiceTurn(lands);
		
		player1.getLandState(Land.findFromBoardPosition(lands, player1.getPosition()));
		
		*/
		player1.displayMoneyPlayer();
		player2.displayMoneyPlayer();
		/*
		
		player1.doesOwnAny(lands);
		System.out.println("player kevin :");
		System.out.println(player1.getOwnedLands());
		
		player2.doesOwnAny(lands);
		System.out.println("player hugo :");
		System.out.println(player2.getOwnedLands());
		*/
		
	}
}