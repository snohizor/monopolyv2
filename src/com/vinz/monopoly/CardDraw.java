package com.vinz.monopoly;

import com.vinz.monopoly.Main.Faction;


public class CardDraw extends Case implements ICase{

    public CardDraw(String name, Faction faction ){

        super(name);

    }

    public void startShowActions()
    {
        System.out.println("PIOCHE UNE CARTE.... LOOOOOL ON A PAS FAIT LA CASE EM D AIR");
    }

    public boolean startExecuteAction(int input, Game game){

        return true;

    }

    public void endShowActions(Game game){

    }

    public boolean endExecuteAction(Game game){

        return true;

    }


}
