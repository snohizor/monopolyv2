package com.vinz.monopoly;

import com.vinz.monopoly.Main.SpecialsType;
import com.vinz.monopoly.Case;

public class Map {

	Group group1 = new Group("Dagobah", 5000);
	Group group2 = new Group("Hoth", 5000);
	Group group3 = new Group("Tatooine", 10000);
	Group group4 = new Group("Yavin IV", 10000);
	Group group5 = new Group("Cité des nuages", 15000);
	Group group6 = new Group("Étoile noire", 15000);
	Group group7 = new Group("Endor", 20000);
	Group group8 = new Group("Coruscant", 20000);
	
	Case[] cases = new Case[80];


	int stations[] = { 2500, 5000, 10000, 20000 };

	// Light purple
	int landA1[] = { 200, 1000, 3000, 9000, 16000, 25000 };
	int landA2[] = { 300, 2000, 6000, 18000, 32000, 45000 };

	// Light blue
	int landB1[] = { 600, 3000, 9000, 27000, 40000, 55000 };
	int landB2[] = { 800, 4000, 10000, 30000, 45000, 60000 };

	// Purple
	int landC1[] = { 1000, 5000, 15000, 45000, 62500, 75000 };
	int landC2[] = { 1200, 6000, 18000, 50000, 70500, 90000 };

	// Orange
	int landD1[] = { 1400, 7000, 20000, 55000, 75000, 95000 };
	int landD2[] = { 1600, 8000, 22000, 60000, 80000, 100000 };

	// Red
	int landE1[] = { 1800, 9000, 25000, 70000, 87500, 105000 };
	int landE2[] = { 2000, 10000, 30000, 75000, 92500, 110000 };

	// Yellow
	int landF1[] = { 2200, 11000, 33000, 80000, 97500, 115000 };
	int landF2[] = { 2400, 12000, 36000, 85000, 102500, 120000 };

	// Green
	int landG1[] = { 2600, 13000, 39000, 90000, 110000, 127500 };
	int landG2[] = { 2800, 15000, 45000, 100000, 120000, 140000 };

	// Dark blue
	int landH1[] = { 3500, 17500, 50000, 110000, 130000, 150000 };
	int landH2[] = { 5000, 20000, 60000, 140000, 170000, 200000 };

	public Map() {

		cases[0] = new Special("Start", SpecialsType.Start);
		cases[1] = new Land("Marais de Dagobah", group1, 6000, landA1);
		cases[2] = new CardDraw("Rebels", Main.Faction.Rebels);
		cases[3] = new Land("Hutte de Yoda", group1, 6000, landA2);
		cases[4] = new Special("Taxe", SpecialsType.Tax);
		cases[5] = new Station("Tie-Fighter");
		cases[6] = new Land("Base Echo", group2, 10000, landB1);
		cases[7] = new CardDraw("Empire", Main.Faction.Empire);
		cases[8] = new Land("Plaines glacées", group2, 10000, landB1);
		cases[9] = new Land("Crête Nord", group2, 12000, landB2);
		cases[10] = new Special("Prison/Simple visite", SpecialsType.Jail);
		cases[11] = new Land("Ferme de Lars", group3, 14000, landC1);
		cases[12] = new Land("Mosesli", group3, 14000, landC1);
		// Reacteur Central
		cases[14] = new Land("Palais de Jabba le Forestier", group3, 16000, landC1);
		cases[15] = new Station("Faucon Millenium");
		cases[16] = new Land("Salle de combat", group4, 18000, landC1);
		cases[17] = new CardDraw("Rebels", Main.Faction.Rebels);
		cases[18] = new Land("Temple de Massassi", group4, 18000, landC1);
		cases[19] = new Land("Salle du Trône", group4, 20000, landC2);
		// PArc Gratuit
		cases[21] = new Land("Plateforme d'atterissage", group5, 20000, landD1);
		cases[22] = new CardDraw("Empire", Main.Faction.Empire);
		cases[23] = new Land("Chambre de Hughzer", group5, 20000, landD1);
		cases[24] = new Land("Salle de contrôle du réacteur", group5, 22000, landD2);
		cases[25] = new Station("X-Wing Fighter");
		cases[26] = new Land("Plateforme d'atterissage", group6, 26000, landE1);
		cases[27] = new Land("Salle du Trône", group6, 26000, landE1);
		// Ferme aquatique
		cases[29] = new Land("Noyau central", group6, 28000, landE2);
		cases[30] = new Special("Go to Jail", SpecialsType.GoToJail);
		cases[31] = new Land("Forêt d'Endor", group7, 30000, landF1);
		cases[32] = new Land("Générateur de bouclier de protection", group7, 30000, landF1);
		cases[33] = new CardDraw("Rebels", Main.Faction.Rebels);
		cases[34] = new Land("Village des Ewoks", group7, 32000, landF2);
		cases[5] = new Station("Destroyer Imperial");
		cases[2] = new CardDraw("Empire", Main.Faction.Empire);
		cases[37] = new Land("Monument carré", group8, 35000, landG1);
		// Prime
		cases[39] = new Land("Palais Impérial", group8, 40000, landG2);

	}
	
	public void display() {
		System.out.println("Voila la map :)");
	}
}
