package com.vinz.monopoly;

public interface ICase {
	
	void startShowActions();
	
	boolean startExecuteAction(int input, Game game);
	
	void endShowActions(Game game);
	
	boolean endExecuteAction(Game game);

}
