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

	public Action[] getEndActions(Game game) {
		// TODO Auto-generated method stub

		//get land owner
		Player landOwner = game.getLandOwner(this);

		//Si le proprietaire est chez lui
		if(landOwner == game.getCurrentPlayer()) {

			return new Action[]{};
		}

		//Sinon, si il est chez un autre joueur
		if(landOwner != null){
			landOwner.takeRent(game.getCurrentPlayer(), this);
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
		Player landOwner = game.getLandOwner(this);
		
		//apply rent or not
		if(landOwner != null && landOwner != game.getCurrentPlayer()) {
			
			landOwner.takeRent(game.getCurrentPlayer(), this);
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
	
	public int getRent() {
		
		return rents[houses];
	}

}
