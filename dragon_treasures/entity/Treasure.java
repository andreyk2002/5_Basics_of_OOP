package by.epam_tc.oop_basics.dragon_treasures.entity;

import java.io.Serializable;

public class Treasure implements Comparable<Treasure>, Serializable {


	private static final long serialVersionUID = 7048938678444297927L;
	private double cost;
	private String name;

	public Treasure(double cost, String name) {
		super();
		this.cost = cost;
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Treasure tr) {
		if (this.cost < tr.cost) {
			return 1;
		}
		if (this.cost == tr.cost) {
			return 0;
		}
		return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Treasure other = (Treasure) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Treasure [cost=" + cost + ", name=" + name + "]";
	}

}
