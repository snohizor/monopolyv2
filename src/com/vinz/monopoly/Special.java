package com.vinz.monopoly;

import com.vinz.monopoly.Main.SpecialsType;

public class Special extends Case implements ICase{

	public SpecialsType type;

	public Special(String name, SpecialsType type) {

		super(name);

		this.type = type;

	}

	public void startShowActions() {

		super.startShowActions();

		if (type == SpecialsType.Start) {

			return;

		}

	}

	public void endShowActions(Game game) {
		// TODO Auto-generated method stub

		if (type == SpecialsType.Start) {

			System.out.println("Vous gagnez 40 000 !!! ");
			game.getCurrentPlayer().addCredit(40000);

		}
		
		if (type == SpecialsType.Jail) {

			System.out.println("Simple visite. ");

		}
		
		if (type == SpecialsType.Park) {

			System.out.println("Parc gratuit !!! ");

		}
		
		if (type == SpecialsType.GoToJail) {

			System.out.println("tmp : Ca ira pour cette fois. Circulez. ");

		}
		
		if (type == SpecialsType.Tax) {

			System.out.println("TAXES !");
			System.out.println(game.getCurrentPlayer().name + " donne 20000 $ aux impôts.");
			
			game.payTax(game.getCurrentPlayer(), 20000);

		}

	}

	public boolean endExecuteAction(int number, Game game) {

		// Pas d'actions a la fin du tour sur une case speciale
		return true;

	}

}
