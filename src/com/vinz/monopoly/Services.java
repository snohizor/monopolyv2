package com.vinz.monopoly;

import com.vinz.monopoly.Main.Faction;


public class Services extends Case implements ICase{

    public Services(String name ){

        super(name);

    }

    public void startShowActions()
    {
        System.out.println("ON A PAS FAIT LA CASE SERVICE LOL");
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
