package com.vinz.monopoly;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	public static int nbrTotalCases = 40;
	
	public enum SpecialsType {
		  Start,
		  Jail,
		  Park,
		  GoToJail,
		  Tax,
		  Prime;
		} 

	

	public static void main(String[] args) {
		
		ArrayList<Player> players = new ArrayList<Player>();

		Player player1 = new Player("Kévin", 1, 150000, 0);
		Player player2 = new Player("Hugo", 2, 150000, 0);
		
		players.add(player1);
		players.add(player2);
		
				
		System.out.println("START");
			
	
		player1.displayMoneyPlayer();
		player2.displayMoneyPlayer();
		
		Game game = new Game(players);
		

	}
	
	
	
	
}