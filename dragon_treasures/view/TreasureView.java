package by.epam_tc.oop_basics.dragon_treasures.view;

import java.util.*;

import by.epam_tc.oop_basics.dragon_treasures.entity.Cave;
import by.epam_tc.oop_basics.dragon_treasures.entity.Treasure;
import by.epam_tc.oop_basics.dragon_treasures.logic.TreasureLogic;

public class TreasureView {
	
	private TreasureLogic logic = TreasureLogic.getInstance();

	private static TreasureView instance = null;

	public static TreasureView getInstance() {
		if (instance == null) {
			instance = new TreasureView();
		}
		return instance;
	}

	private TreasureView() {

	}
	
	public void showAllTreasures(Cave cave) {
		int count = logic.getTreasuresCount(cave);
		int i = 0;
		while (i < count) {
			System.out.println(cave.getTreasures()[i].toString());
			i++;
		}
	}

	public void showTheMostExpensiveTreasure(Cave cave) {
		int count = logic.getTreasuresCount(cave);
		double maxValue = cave.getTreasures()[0].getCost();
		int maxIndex = 0;
		for (int i = 1; i < count; i++) {
			double treasureCost;
			treasureCost = cave.getTreasures()[i].getCost();
			if (treasureCost > maxValue) {
				maxValue = treasureCost;
				maxIndex = i;
			}
		}

		System.out.println(cave.getTreasures()[maxIndex].toString());
	}

	public void showTreasuresByValue(Cave cave, double minValue, double maxValue) {
		List<Treasure> treasures = new ArrayList<Treasure>();
		Arrays.sort(cave.getTreasures(), 0, logic.getTreasuresCount(cave));
		treasures = showTreasuresByValue(cave, minValue, maxValue, 0, treasures, 0.0);
		System.out.println("Avaible treasures for entered price : ");
		if (treasures != null) {
			for (var element : treasures) {
				System.out.println(element.toString());
			}
			return;
		}
		System.out.println("There are no avaible treasures for entered price");
	}

	private List<Treasure> showTreasuresByValue(Cave cave, double minValue, double maxValue, int pos,
			List<Treasure> treasures, double sum) {
		if (sum >= minValue && sum <= maxValue) {
			return treasures;
		}
		if (pos >= logic.getTreasuresCount(cave)) {
			if(sum > maxValue) {
				sum -= treasures.get(0).getCost();
				pos = logic.findTreasureIndex(cave, treasures.get(0)) + 1;
				treasures.remove(0);
				return showTreasuresByValue(cave, minValue, maxValue, pos, treasures, sum);
			}
			
			return null;
		}
		
		if (sum < minValue) {
			treasures.add(cave.getTreasures()[pos]);
			sum += cave.getTreasures()[pos].getCost();
			pos++;
			return showTreasuresByValue(cave, minValue, maxValue, pos, treasures, sum);
		}
		if (sum > maxValue) {
			int deleteIndex = treasures.size() - 1;
			sum -= treasures.get(deleteIndex).getCost();
			treasures.remove(deleteIndex);
			pos++;
			return showTreasuresByValue(cave, minValue, maxValue, pos, treasures, sum);
		}
		return null;
	}
}
