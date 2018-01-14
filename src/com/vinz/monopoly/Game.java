package com.vinz.monopoly;

import java.util.ArrayList;

import static com.vinz.monopoly.Dices.isDoubleDices;

public class Game {

	Map map;

	int currentPlayerIndex = 0;
	int jackpot = 0;

	ArrayList<Player> players = new ArrayList<Player>();

	public Game(ArrayList<Player> players) {

		this.players = players;

		map = new Map();

		startGame();

	}

	public void startGame() {

		while (true) {

			for (Player player : players) {

				currentPlayerPlay(player);


			}

		}

	}

	//Tour d'un joueur
	private void currentPlayerPlay(Player player){

		boolean isTurnOver = false;


		//On montre les informations
		map.cases[player.position].showStartInformations(this);

		onePlayerRound(player, isTurnOver);

		passTurn();



	}

	private void onePlayerRound(Player player, boolean isTurnOver) {

		int throwsIndex = 0;

		//Tant que le joueur n'a pas fini son tour
		while (!isTurnOver) {

			//On lui propose des actions
            map.cases[player.position].startShowActions();

            //Prend son input puis on execute son action
            isTurnOver = map.cases[player.position].startExecuteAction(player.getInput(), this);

            if(isDoubleDices() && throwsIndex < 2)
            	isTurnOver = false;

			if(isDoubleDices() && throwsIndex > 2)
				System.out.println("VOUS ALLEZ EN PRISON POUR EXCES DE VITESSE");
				//PRISON

        }

		// Les dés ont été lancés
		map.cases[player.position].showInformations(this);

		isTurnOver = false;

		while (!isTurnOver) {

            map.cases[player.position].endShowActions(this);
            isTurnOver = map.cases[player.position].endExecuteAction(this);
            //Control double dés
        }
	}

	public void passTurn() {
		
		System.out.println("Fin du tour de " + this.getCurrentPlayer().name + ".\n");
		System.out.println("------------------------------------\n");
		
		if (players.size() - 1 == currentPlayerIndex)
			currentPlayerIndex = 0;
		else
			currentPlayerIndex++;

		System.out.println("Début du tour de " + this.getCurrentPlayer().name + ".");
		

	}

	public Player getCurrentPlayer() {
		// TODO Auto-generated method stub
		return players.get(currentPlayerIndex);
	}

	public Player getLandOwner(Land land) {

		for (Player player : this.players) {
			
			if(player.ownedLands.contains(land))
				return player;
						
		}
		
		return null;
		
	}
	
	public Player getStationOwner(Station station) {

		for (Player player : this.players) {
			
			if(player.ownedLands.contains(station))
				return player;
						
		}
		
		return null;
		
	}

	public boolean isAvailable(Land land) {
		// TODO Auto-generated method stub
		return (getLandOwner(land) == null);
	}
	
	public void payTax(Player player, int due) {
		player.credit -= due;
		jackpot += due;
		
		System.out.println("Le pot est de : " + jackpot + " $");
	}

}
