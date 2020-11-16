package by.epam_tc.oop_basics.present.view;

import by.epam_tc.oop_basics.present.entity.*;

public class PresentView {
	
	private static PresentView instance = null;

	private PresentView() {
	}

	public static PresentView getInstance() {
		if (instance == null) {
			instance = new PresentView();
		}
		return instance;
	}

	
	public void showPresent(Present p) {
		System.out.print("Wrap : ");
		showWrap(p.getWrap());
		if (p instanceof PresentCandy) {
			System.out.print("Present content : ");
			showCandy(((PresentCandy) p).getCandy());
		}
	}

	public void showWrap(Wrap w) {
		System.out.print("color : " + w.getColor().toString());
		System.out.print(", material : " + w.getMaterial().toString());
		System.out.println(", weight : " + w.getWeight() + "g.");
	}
	

	public void showCandy(Candy c) {
		System.out.print("Name : " + c.getName());
		System.out.print(", type : " + c.getType());
		System.out.println(", weight : " + c.getWeight() + "g.");

	}
}
