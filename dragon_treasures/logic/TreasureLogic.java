package by.epam_tc.oop_basics.dragon_treasures.logic;

import by.epam_tc.oop_basics.dragon_treasures.entity.Cave;
import by.epam_tc.oop_basics.dragon_treasures.entity.Treasure;

public class TreasureLogic {

	private static TreasureLogic instance = null;

	public static TreasureLogic getInstance() {
		if (instance == null) {
			instance = new TreasureLogic();
		}
		return instance;
	}

	private TreasureLogic() {

	}
	
	public int getTreasuresCount(Cave cave) {
		int count = 0;
		for (var treasure : cave.getTreasures()) {
			if (treasure == null) {
				return count;
			}
			count++;
		}
		return count;
	}

	public int findTreasureIndex(Cave cave, Treasure tr) {
		for (int i = 0; i < this.getTreasuresCount(cave); i++) {
			if (cave.getTreasures()[i].getCost() == tr.getCost()) {
				if (cave.getTreasures()[i].getName().equals(tr.getName())) {
					return i;
				}
			}
		}
		return -1;
	}
}
