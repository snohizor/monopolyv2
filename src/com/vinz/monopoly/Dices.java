package com.vinz.monopoly;

import java.util.Random;

public class Dices {
	public static int dice1 = 0;
	public static int dice2 = 0;
	private static int totalDices;

	public static int getTotalDices() {
		return totalDices;
	}

	public static void setTotalDices(int totalDices) {
		Dices.totalDices = totalDices;
	}

	public static int getDice1() {
		return dice1;
	}

	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	public static int getDice2() {
		return dice2;
	}

	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	public static void rollDices() {
		int rng = new Random().nextInt(6);
		dice1 = (int) (Math.random() * 6) + 1;
		dice2 = (int) (Math.random() * 6) + 1;
		totalDices = dice1 + dice2;
		System.out.println("\n" + getDice1() + " + " + getDice2());
	}

	public static String displayTotalDices() {
		return "Total dices = " + totalDices;
	}

	public void playDices() {
		rollDices();
		System.out.println(getTotalDices());
		displayTotalDices();
	}
}
