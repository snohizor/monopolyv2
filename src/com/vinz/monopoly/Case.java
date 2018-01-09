package com.vinz.monopoly;

public class Case implements ICase {
	
	public String name = new String();

	public Case(String name) {
		
		this.name = name;
		
	}
	
	public void showInformations(Game game) {
		
		System.out.println(game.getCurrentPlayer().name + " atterit sur la case " + name + "(" +  game.getCurrentPlayer().position + ")");	
	
	}

	public void startShowActions() {
		// TODO Auto-generated method stub
		System.out.print("1. Lancer les dés / 2. Voir la map / 3. Gérer les propriétés");
		
		
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

	public void endShowActions(Game game) {
		// TODO Auto-generated method stub
		
	}

	public boolean endExecuteAction(Game game) {
		
		//Fin du tour
		return true;
	}



}
 