package com.vinz.monopoly;

public class Station extends Case implements ICase {
	
	public int price = 20000;
	public int[] rents = {2500, 5000, 10000, 20000};
	
	public Station(String name) {

		super(name);

	}
	
	
}
