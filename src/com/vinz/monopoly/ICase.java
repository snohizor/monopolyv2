package com.vinz.monopoly;

public interface ICase {
	
	void startShowActions();

	//RENVOIE VRAI SI LE TOUR EST FINI APRES L'ACTION
	boolean startExecuteAction(int input, Game game);
	
	void endShowActions(Game game);
	
	boolean endExecuteAction(Game game);

}
