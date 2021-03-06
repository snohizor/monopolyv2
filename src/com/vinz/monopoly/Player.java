package com.vinz.monopoly;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public String name;
    private int id;
    public int credit;
    public int position;
    public ArrayList<Land> ownedLands;
    public ArrayList<Station> ownedStations;

    public Player(String name, int id, int credit, int position) {

        super();

        this.name = name;
        this.id = id;
        this.credit = credit;
        this.position = position;

        this.ownedLands = new ArrayList<Land>();
        this.ownedStations = new ArrayList<Station>();

    }

    ////////////////////////////////////
    //////////////MOVEMENT//////////////
    ////////////////////////////////////

    public void move(int distance) {

        this.position = this.position + distance;

        if (this.position == 40) {
            this.position = 0;
        }
        if (this.position > Main.nbrTotalCases) {
            this.position = this.position - Main.nbrTotalCases;
            System.out.println("Vous passez par la case départ et gagnez 20 000!");
            this.addCredit(20000);
        }

    }

    public void throwDices() {

        int[] dicesThrow = Dices.rollDices();

        System.out.println(dicesThrow[0] + " - " + dicesThrow[1]);

        this.move(Dices.getTotal(dicesThrow));

    }

    ////////////////////////////////////
    //////////////OPTIONS///////////////
    ////////////////////////////////////

    public static int getInput() {

        System.out.print("\nChoix:");

        Scanner sc = new Scanner(System.in);


        if (sc.hasNextInt()) {
            System.out.println("");
            return sc.nextInt();
        } else
            return getInput();

    }

    public void manage() {

        System.out.println("1. Voir ses propriétés / 2. Ajouter des maisons / 3. Retirer des maisons / 4. Échanges / 0. Retour");

        int x = Player.getInput();

        if (x == 0)
            return;
        else if (x == 1) {
            this.seeProperties();
            manage();
        } else if (x == 2) {
            this.addHouses();
        }
    }

    public void seeProperties() {

        if (ownedLands.size() != 0) {

            System.out.println("Terrains de " + this.name + " :");
            for (Land testland : ownedLands) {
                System.out.println("- " + testland.getName());
            }
            System.out.println("");
        } else if (ownedStations.size() != 0) {
            System.out.println("Gares de " + this.name + " :");
            for (Station teststation : ownedStations) {
                System.out.println("- " + teststation.getName());
            }
            System.out.println("");
        } else {
            System.out.println("Vous êtes un SDF.");
        }

    }

    public boolean canAddHouses(Group group) {


        return group.isFullGroupOwner(this);

    }

    public void addHouses() {

        //On va chercher les groupes complets
        //On affiche les terrains de ces groupes



    }

    public void buy(Case currentCase) {
        if (currentCase.getClass() == Land.class) {
            this.buyLand((Land) currentCase);
        } else if (currentCase.getClass() == Station.class) {
            this.buyStation((Station) currentCase);
        }
    }

    public void buyLand(Land land) {

        System.out.println(this.name + " a acheté " + land.name + " pour " + land.price + " $.");

        if (land.price <= this.credit) {

            this.credit = this.credit - land.price;
            this.ownedLands.add(land);

            System.out.println("Credits de " + this.name + " : " + this.credit + " $.");

        } else {

            System.out.print("Vous ne pouvez pas vous payer cette propriété.");

        }

    }

    public void buyStation(Station station) {

        System.out.println(this.name + " a acheté " + station.name + " pour " + station.price + " $.");

        if (station.price <= this.credit) {

            this.credit = this.credit - station.price;
            this.ownedStations.add(station);

            System.out.println("Credits de " + this.name + " : " + this.credit + " $.");

        } else {

            System.out.print("Vous ne pouvez pas vous payer cette propriété.");

        }

    }

    public boolean canBuy(Land testcase) {
        return (testcase.price <= this.credit);
    }

    public boolean canBuy(Station station) {
        return (station.price <= this.credit);

    }

    public void takeRent(Player currentPlayer, Land land) {

        System.out.println(currentPlayer.name + " est tombé chez " + this.name + " et paie la somme de " + land.getRent() + " $.");

        currentPlayer.credit = currentPlayer.credit - land.getRent();
        this.credit = this.credit + land.getRent();

        System.out.println(this.name + " : " + this.credit + " $.");
        System.out.println(currentPlayer.name + " : " + currentPlayer.credit + " $.");
    }

    public void takeRent(Player currentPlayer, Station station) {

        System.out.println(currentPlayer.name + " est tombé chez " + this.name + " et paie la somme de " + station.getRent(this) + " $.");

        currentPlayer.credit = currentPlayer.credit - station.getRent(this);
        this.credit = this.credit + station.getRent(this);

        System.out.println(this.name + " : " + this.credit + " $.");
        System.out.println(currentPlayer.name + " : " + currentPlayer.credit + " $.");
    }

    public void addCredit(int credit) {

        this.credit += credit;

    }

    ////////////////////////////////////
    /////////////DISPLAY////////////////
    ////////////////////////////////////

    public void displayMoneyPlayer() {

        System.out.println(name + " a " + credit + " credits");

    }

    public ArrayList<Station> getStations() {
        return this.ownedStations;
    }
}