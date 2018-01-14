package com.vinz.monopoly;

public interface ICase {
	
	Action[] getStartActions();

	//RENVOIE VRAI SI LE TOUR EST FINI APRES L'ACTION
	boolean startExecuteAction(int input, Game game);
	
	Action[] getEndActions(Game game);
	
	boolean endExecuteAction(int input, Game game);

}
