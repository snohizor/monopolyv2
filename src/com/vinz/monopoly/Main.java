package com.vinz.monopoly;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	public static int nbrTotalCases = 40;
	public static ArrayList<Game> games = new ArrayList<>();

	public enum SpecialsType {
		  Start,
		  Jail,
		  Park,
		  GoToJail,
		  Tax,
		  Prime;
		}


	public enum Faction {
		Empire,
		Rebels
	}

	

	public static void main(String[] args) {
		
		ArrayList<Player> players = new ArrayList<Player>();

		Player player1 = new Player("Kévin", 1, 150000, 0);
		Player player2 = new Player("Hugo", 2, 150000, 0);
		Player player3 = new Player("Vinz", 3, 150000, 0);
		
		players.add(player1);
		players.add(player2);
		players.add(player3);


		System.out.println("START");
			
	
		player1.displayMoneyPlayer();
		player2.displayMoneyPlayer();
		
		Game game = new Game(players);

		games.add(game);
		

	}


	public static Game getCurrentGame(Player player){

		for(Game testgame : games){
			if(testgame.players.contains(player))
				return testgame;
		}
		return null;

	}
	
	
	
}