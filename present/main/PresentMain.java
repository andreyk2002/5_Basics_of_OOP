package by.epam_tc.oop_basics.present.main;

import java.util.*;

import by.epam_tc.oop_basics.present.builder.PresentCandyCreator;
import by.epam_tc.oop_basics.present.entity.*;
import by.epam_tc.oop_basics.present.view.PresentView;

public class PresentMain {

	public static final int PRESENTS_AMOUNT = 10;

	public static void main(String... argc) {
		List<Present> presents = new ArrayList<Present>();
		PresentView view = PresentView.getInstance();
		PresentCandyCreator[] creators = new PresentCandyCreator[PRESENTS_AMOUNT];
		for (int i = 0; i < creators.length; i++) {
			creators[i] = new PresentCandyCreator();
		}
		creators[0].buildPresentCandy("Sweet set \"Communarka\"", CandyType.SWEETS, 1000);
		creators[1].buildPresentCandy("Sweet set  \"Roshen\"", CandyType.SWEETS, 1000);
		creators[2].buildPresentCandy("Cake \"Napoleon\"", CandyType.CAKE, 850);
		creators[3].buildPresentCandy("Cakes Ekkler (5 шт)", CandyType.CAKE, 400);
		creators[4].buildPresentCandy("Apple pie", CandyType.PIE, 1200);
		creators[5].buildPresentCandy(" \"Alenka\" chocholate", CandyType.CHOCHOLATE, 100);
		creators[6].buildPresentCandy("Alpen Gold chocolate", CandyType.CHOCHOLATE, 90);
		creators[7].buildPresentCandy("Slodych \"Holiday\"", CandyType.COOKIES, 200);
		creators[8].buildPresentCandy("chocholate cookies", CandyType.COOKIES, 500);
		creators[9].buildPresentCandy("fruit jelly", CandyType.JELLY, 200);

		creators[0].buildPresentWrap(Color.RED, WrapMaterial.FOIL, 30);
		creators[1].buildPresentWrap(Color.YELLOW, WrapMaterial.WOOD, 400);
		creators[2].buildPresentWrap(Color.GREEN, WrapMaterial.FOIL, 30);
		creators[3].buildPresentWrap(Color.PINK, WrapMaterial.PAPER, 10);
		creators[4].buildPresentWrap(Color.BLACK, WrapMaterial.METAL, 700);
		creators[5].buildPresentWrap(Color.WHITE, WrapMaterial.CELLOPHANE, 7);
		creators[6].buildPresentWrap(Color.CYAN, WrapMaterial.FABRIC, 90);
		creators[7].buildPresentWrap(Color.GRAY, WrapMaterial.PAPER, 10);
		creators[8].buildPresentWrap(Color.ORANGE, WrapMaterial.FOIL, 30);
		creators[9].buildPresentWrap(Color.BLUE, WrapMaterial.CARDBOARD, 20);

		for (int i = 0; i < creators.length; i++) {
			presents.add(creators[i].getPresentCandy());
		}

		for (var present : presents) {
			view.showPresent(present);
			System.out.println();
		}
	}
}
