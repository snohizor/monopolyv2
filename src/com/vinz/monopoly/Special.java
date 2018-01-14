package com.vinz.monopoly;

import com.vinz.monopoly.Main.SpecialsType;

public class Special extends Case implements ICase{

	public SpecialsType type;

	public Special(String name, SpecialsType type) {

		super(name);

		this.type = type;

	}

	public Action[] getStartActions() {

		return super.getStartActions();

	}

	public Action[] getEndActions(Game game) {
		// TODO Auto-generated method stub

		if (type == SpecialsType.Start) {

			System.out.println("Vous gagnez 40 000 !!! ");
			game.getCurrentPlayer().addCredit(40000);

		}

		if (type == SpecialsType.Jail) {

			System.out.println("Simple visite. Pas encore implémenté");
			return new Action[]{};

		}
		
		if (type == SpecialsType.Park) {

			System.out.println("Parc gratuit !!! Pas encore implémenté");
			return new Action[]{};

		}
		
		if (type == SpecialsType.GoToJail) {

			System.out.println("tmp : Ca ira pour cette fois. Circulez. Pas encore implémenté");
			return new Action[]{};

		}
		
		if (type == SpecialsType.Tax) {

			System.out.println("TAXES !");
			System.out.println(game.getCurrentPlayer().name + " donne 20000 $ aux imp�ts.");
			
			game.payTax(game.getCurrentPlayer(), 20000);

			return new Action[]{};

		}

		return new Action[]{};

	}


}
