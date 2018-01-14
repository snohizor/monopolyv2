package com.vinz.monopoly;

import java.util.ArrayList;

public class Group {

	public String name;
	public int housePrice;
	
	public Group(String name, int housePrice) {
		super();
		this.name = name;
		this.housePrice = housePrice;
	}

	public boolean isFullGroupOwner(Player player){

		ArrayList<Land> groupLands = Main.getCurrentGame(player).map.getAllGroupLands(this);

		for(Land land : groupLands){

		    if(!player.ownedLands.contains(land))
		        return false;

        }

        return true;

	}

}
