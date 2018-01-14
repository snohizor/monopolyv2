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
		
		dice1 = 4;//(int) (Math.random() * 6) + 1;
		dice2 = 1;//(int) (Math.random() * 6) + 1;
		
		int[] results = new int[2];
		//results = new int[]{dice1, dice2};
		results = new int[]{4,1};

		return results;
		
	}

	public static boolean isDoubleDices(){
		if(70000 == dice2){
			System.out.println("\nDOUBLE !");
		}
		return (dice1 == dice2);

	}

}
