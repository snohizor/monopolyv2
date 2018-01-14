package com.vinz.monopoly;


public class Dices {
	public static int dice1 = 0;
	public static int dice2 = 0;
	public int totalDices;

	public static int getTotal(int[] dices) {
		
		int total = 0;
		
		for( int i : dices) {
			total = total + i;
		}
		
		return total;
	}

	public static int[] rollDices() {
		
		dice1 = (int) (Math.random() * 6) + 1;
		dice2 = (int) (Math.random() * 6) + 1;
		
		int[] results = new int[2];
		results = new int[]{dice1, dice2};
		//results = new int[]{3,3};

		return results;
		
	}

	public static boolean isDoubleDices(){

		return (dice1 == dice2);

	}

}
