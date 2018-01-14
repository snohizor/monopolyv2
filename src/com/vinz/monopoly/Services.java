package com.vinz.monopoly;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.vinz.monopoly.Main.Faction;


public class Services extends Case implements ICase{

    public Services(String name ){

        super(name);

    }

    public void startShowActions()
    {
        System.out.println("ON A PAS FAIT LA CASE SERVICE LOL");
    }

    public Action[] getEndActions(Game game){

        System.out.println("Pas encore implémenté");

        return new Action[]{};

    }

    public boolean endExecuteAction(Game game){

        return true;

    }


}
