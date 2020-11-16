package by.epam_tc.oop_basics.dragon_treasures.menu;

import java.util.Scanner;

import by.epam_tc.oop_basics.dragon_treasures.main.TreasuresMain;
import by.epam_tc.oop_basics.dragon_treasures.view.TreasureView;

public class ConsoleMenu {
	private Scanner sc = new Scanner(System.in);
	private TreasureView view = TreasureView.getInstance();

	public void showMenu() {
		System.out.println("Choose your option : ");
		System.out.println("- \"SHOW\" - for showing all treasures in the dragon cave");
		System.out.println("- \"FIND\" - for finding the most expensive treasure");
		System.out.println("- \"SELECT\" - for selecting treasures for entered amount");
		System.out.println("- \"QUIT\" - for ending the programm");
	}

	public void makeAction() {
		String userAction = sc.next();

		if (userAction.equalsIgnoreCase("SHOW")) {
			view.showAllTreasures(TreasuresMain.getCave());

		} else if (userAction.equalsIgnoreCase("FIND")) {
			view.showTheMostExpensiveTreasure(TreasuresMain.getCave());
		}

		else if (userAction.equalsIgnoreCase("SELECT")) {
			double minValue;
			double maxValue;
			minValue = readDouble("Enter the minimal price of the treasures :");
			maxValue = readDouble("Enter the maximal price of the treasures :");
			view.showTreasuresByValue(TreasuresMain.getCave(), minValue, maxValue);
		} else if (userAction.equalsIgnoreCase("QUIT")) {
			sc.close();
			System.exit(0);
		}

		else {
			System.out.println("An invalid command was entered");
			this.showMenu();

		}
		makeAction();
	}

	public double readDouble(String message) {
		double result;
		System.out.println(message);
		while (!sc.hasNextDouble()) {
			System.out.println(message);
			sc.next();
		}

		result = sc.nextDouble();
		return result;

	}
}
