package com.vinz.monopoly;

public class Case implements ICase {
	
	public String name = new String();

	public Case(String name) {
		
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void showStartInformations(Game game) {
		
		System.out.println(game.getCurrentPlayer().name + " est sur la case " + name + "(" +  game.getCurrentPlayer().position + ")");
	
	}

	public void showInformations(Game game) {

		System.out.println(game.getCurrentPlayer().name + " atterit sur la case " + name + "(" +  game.getCurrentPlayer().position + ")");

	}

	public Action[] getStartActions() {
		// TODO Auto-generated method stub
		return new Action[]{
				new Action("Lancer les dès", true),
				new Action("Voir la map" , false),
				new Action("Gérer les propriétés",false)
		};
		
		
	}


	public boolean startExecuteAction(int input, Game game) {
		// TODO Auto-generated method stub
		
		if(input == 1) {
			game.getCurrentPlayer().throwDices();
			return true;
		}
		if(input == 2) {
			game.map.display();
			return false;
		}
		if(input == 3) {
			game.getCurrentPlayer().manage();
			return false;
		}
		
		return false;
	}

	//Renvoie true si le
	public Action[] getEndActions(Game game) {
		// TODO Auto-generated method stub
		return new Action[]{};
		
	}

	public boolean endExecuteAction(int input, Game game) {
		
		//Fin du tour
		return true;
	}



}
 