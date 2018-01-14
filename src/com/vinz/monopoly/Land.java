package com.vinz.monopoly;

public class Land extends Case implements ICase {

	private Group group;

	public int price;
	public int[] rents;
	public int houses;

	public Land(String name, Group group, int price, int[] rents) {

		super(name);

		this.group = group;
		this.price = price;
		this.rents = rents;

	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void endShowActions(Game game) {
		// TODO Auto-generated method stub

		if (game.getCurrentPlayer().canBuy(this) && game.isAvailable(this))
			System.out.print("1. Acheter(" + this.price + ") / 2. Passer");

	}

	public boolean endExecuteAction(Game game) {
		
		//get land owner
		Player landOwner = game.getLandOwner(this);
		
		//apply rent or not
		if(landOwner != null && landOwner != game.getCurrentPlayer()) {
			
			landOwner.takeRent(game.getCurrentPlayer(), this);
			return true;
			
		}
			
		//Si le joueur ne peut pas acheter, on passe le tour
		if (!game.getCurrentPlayer().canBuy(this))
			return true;
		
		int number = Player.getInput();

		if (number == 1) {
			game.getCurrentPlayer().buy(this);
			return true; // Acheter revient a passer car plus d'actions possibles
		}

		if (number == 2) {
			return true; // find du tour ( 2./ Passer )
		}

		return false;

	}
	
	public int getRent() {
		
		return rents[houses];
	}

}
