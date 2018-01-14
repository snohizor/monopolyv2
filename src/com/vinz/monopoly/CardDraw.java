package com.vinz.monopoly;

import com.vinz.monopoly.Main.Faction;


public class CardDraw extends Case implements ICase {

    public CardDraw(String name, Faction faction) {

        super(name);

    }

    public Action[] getStartActions() {
        return super.getStartActions();
    }


    public Action[] getEndActions(Game game) {

        return new Action[]{};
    }

    public boolean endExecuteAction(Game game) {

        System.out.println("PIOCHE UNE CARTE.... LOOOOOL ON A PAS FAIT LA CASE EM D AIR");

        return true;

    }


}
