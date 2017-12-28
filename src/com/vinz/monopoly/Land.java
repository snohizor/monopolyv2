package com.vinz.monopoly;

import java.util.ArrayList;

public class Land {
	private String name;
	private int position;
	private int group;
	private int price;
	private Player owner;
	private int nbrHouses;
	private int allRents[];

	public Land(int position, int group, Player owner, int price, int nbrHouses, int[] allRents, String name) {
		this.name = name;
		this.group = group;
		this.price = price;
		this.position = position;
		this.owner = owner;
		this.nbrHouses = nbrHouses;
		this.allRents = allRents;
	}

	// RENT TABLES

	public int[] getAllRents() {
		return allRents;
	}

	public void setAllRents(int[] allRents) {
		this.allRents = allRents;
	}

	public int getNbrHouses() {
		return nbrHouses;
	}

	public void setNbrHouses(int nbrHouses) {
		this.nbrHouses = nbrHouses;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	// Prix réel du loyer
	// A modifier ?
	public int creditsToPay(Land land) {
		int realRent = 1337;

		switch (land.getNbrHouses()) {
		case 0:
			realRent = land.allRents[0];
			break;
		case 1:
			realRent = land.allRents[1];
			break;
		case 2:
			realRent = land.allRents[2];
			break;
		case 3:
			realRent = land.allRents[3];
			break;
		case 4:
			realRent = land.allRents[4];
			break;
		case 5:
			realRent = land.allRents[5];
			break;
			default:
			realRent = 420;
		}
		return realRent;
	}

	public static Land findFromBoardPosition(ArrayList<Land> board, int position) {
		return board.stream().filter(land -> land.getPosition() == position).findFirst().orElse(null);
	}

}
