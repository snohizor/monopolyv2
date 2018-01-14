package com.vinz.monopoly;

import java.util.ArrayList;

import static com.vinz.monopoly.Dices.isDoubleDices;

public class Game {

    Map map;

    int currentPlayerIndex = 0;
    int jackpot = 0;

    ArrayList<Player> players = new ArrayList<Player>();

    public Game(ArrayList<Player> players) {

        this.players = players;

        map = new Map();

        startGame();

    }

    public void startGame() {

        while (true) {

            for (Player player : players) {

                currentPlayerPlay(player);


            }

        }

    }

    //Tour d'un joueur
    private void currentPlayerPlay(Player player) {

        //On montre les informations
        map.cases[player.position].showStartInformations(this);

        onePlayerRound(player);

        passTurn();


    }

    private void onePlayerRound(Player player) {

        int throwsIndex = 0;

        Action[] actionsPossibles;
        int choix = 0;

        //Tant que le joueur n'a pas fini son tour
        do {

            //On recupere les actions possibles
            actionsPossibles = map.cases[player.position].getStartActions();

            //On lui propose les actions
            for (int i = 0; i < actionsPossibles.length; i++) {
                System.out.println(i + 1 + ". " + actionsPossibles[i].name);
            }

            //On récupere son choix
            choix = player.getInput();

            while(choix < 0 || choix > actionsPossibles.length+1){
                System.out.println("KEVIN !!! ");
                choix = player.getInput();
            }


            //On execute l'action de son choix
            map.cases[player.position].startExecuteAction(choix, this);

            //On continue tant que l'action choisie n'est pas finale
        } while (!actionsPossibles[choix-1].isFinale);

        /*****************************************************************
        ******************* LES DES ONT ETE JETES ***********************
         *****************************************************************/

        // Les dés ont été forcement étés lancés(le seul choix final de start)
        //On affiche donc la nouvelle position du joueur
        map.cases[player.position].showInformations(this);


        //ON ARRIVE SUR LA NOUVELLE CASE
        //NOUS PASSONS AUX CHOIX DE FIN DE TOUR

        do {

            //On récupere les actions de fin de tour
            actionsPossibles = map.cases[player.position].getEndActions(this);


            //Si des actions sont possibles
            if (actionsPossibles.length > 0){

                //On lui propose les actions
                for (int i = 0; i < actionsPossibles.length; i++) {
                    System.out.println(i + 1 + ". " + actionsPossibles[i].name);
                }

                //On récupere son choix
                choix = player.getInput();

                while(choix < 0 && choix > actionsPossibles.length+1){
                    System.out.println("KEVIN !!! ");
                    choix = player.getInput();
                }


                map.cases[player.position].endExecuteAction(choix, this);

            }

        } while (actionsPossibles.length > 0 && actionsPossibles[choix].isFinale);

        //Controle double dés
        if (isDoubleDices() && throwsIndex < 2)
            onePlayerRound(player);

        if (isDoubleDices() && throwsIndex > 2)
            System.out.println("VOUS ALLEZ EN PRISON POUR EXCES DE VITESSE");
        //PRISON

    }

    public void passTurn() {

        System.out.println("Fin du tour de " + this.getCurrentPlayer().name + ".\n");
        System.out.println("\n------------------------------------");
        System.out.println("------------------------------------\n");

        for(Player testplayer : players){
            System.out.println(testplayer.name + " : " + testplayer.credit + " $");
        }

        System.out.println("\n------------------------------------");
        System.out.println("------------------------------------\n");

        if (players.size() - 1 == currentPlayerIndex)
            currentPlayerIndex = 0;
        else
            currentPlayerIndex++;

        System.out.println("Début du tour de " + this.getCurrentPlayer().name + ".");


    }

    public Player getCurrentPlayer() {
        // TODO Auto-generated method stub
        return players.get(currentPlayerIndex);
    }

    public Player getLandOwner(Land land) {

        for (Player player : this.players) {

            if (player.ownedLands.contains(land))
                return player;

        }

        return null;

    }

    public Player getStationOwner(Station station) {

        for (Player player : this.players) {

            if (player.ownedStations.contains(station))
                return player;

        }

        return null;

    }

    public boolean isAvailable(Land land) {
        // TODO Auto-generated method stub
        return (getLandOwner(land) == null);
    }

    public boolean isAvailable(Station station) {
        // TODO Auto-generated method stub
        return (getStationOwner(station) == null);
    }

    public void payTax(Player player, int due) {
        player.credit -= due;
        jackpot += due;

        System.out.println("Le pot est de : " + jackpot + " $");
    }

}
