package by.epam_tc.oop_basics.dragon_treasures.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Cave implements Serializable {

	private static final long serialVersionUID = 7295787487039684289L;

	public final static int MAX_SIZE = 100;

	private Treasure[] treasures;
	{
		treasures = new Treasure[MAX_SIZE];
	}

	public Cave() {

	}

	public Cave(Treasure[] treasures) throws Exception {
		setTreasures(treasures);
	}

	public static int getMaxSize() {
		return MAX_SIZE;
	}

	public Treasure[] getTreasures() {
		return treasures;
	}

	public void setTreasures(Treasure[] treasures) throws Exception {
		if (treasures.length > MAX_SIZE) {
			throw new Exception("Maximal capacity of the cave is " + MAX_SIZE);
		}
		for (int i = 0; i < treasures.length; i++) {
			this.treasures[i] = treasures[i];
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(treasures);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cave other = (Cave) obj;
		if (!Arrays.equals(treasures, other.treasures))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CaveTreasures [treasures=" + Arrays.toString(treasures) + "]";
	}

}
