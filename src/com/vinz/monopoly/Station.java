package com.vinz.monopoly;

public class Station extends Case implements ICase {
	
	public int price = 20000;
	public int[] rents = {2500, 5000, 10000, 20000};
	
	public Station(String name) {

		super(name);

	}

	public Action[] getEndActions(Game game) {
		// TODO Auto-generated method stub

		//get land owner
		Player stationOwner = game.getStationOwner(this);

		//Si le proprietaire est chez lui
		if(stationOwner == game.getCurrentPlayer()) {

			return new Action[]{};
		}

		//Sinon, si il est chez un autre joueur
		if(stationOwner != null){
			stationOwner.takeRent(game.getCurrentPlayer(), this);
		}

		if (game.getCurrentPlayer().canBuy(this) && game.isAvailable(this)) {

			System.out.println("Prix du terrain :"+this.price);

			System.out.println("Argent de "+ game.getCurrentPlayer().name + " : " + game.getCurrentPlayer().credit);

			return new Action[]{
					new Action("Acheter", false),
					new Action("Passer", true)
			};

		} else {

			System.out.println("Vous ne pouvez pas acheter car :");

			if(!game.getCurrentPlayer().canBuy(this))
				System.out.println("Vous n'avez pas assez d'argent.");

		}


		return new Action[]{};
	}

	public boolean endExecuteAction(int input, Game game) {

		//get land owner
		Player stationOwner = game.getStationOwner(this);

		//apply rent or not
		if(stationOwner != null && stationOwner != game.getCurrentPlayer()) {

			stationOwner.takeRent(game.getCurrentPlayer(), this);
			return true;

		}

		//Si le joueur ne peut pas acheter, on passe le tour
		if (!game.getCurrentPlayer().canBuy(this))
			return true;

		if (input == 1) {
			game.getCurrentPlayer().buy(this);
			return true; // Acheter revient a passer car plus d'actions possibles
		}

		if (input == 0) {
			return true; // fin du tour ( 0./ Passer )
		}

		return false;

	}

	public int getRent(Player player) {

		return rents[player.getStations().size()-1];
	}
	
}
