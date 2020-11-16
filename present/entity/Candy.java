package by.epam_tc.oop_basics.present.entity;

import java.io.Serializable;

public class Candy implements Serializable {

	private static final long serialVersionUID = -2721401902465642972L;
	private String name;
	private CandyType type;
	private int weight;

	public Candy(String name, CandyType type, int weight) {
		super();
		setWeight(weight);
		this.name = name;
		this.type = type;
	}

	public Candy() {

	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = (weight > 0) ? weight : 0;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CandyType getType() {
		return type;
	}

	public void setType(CandyType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + weight;
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
		Candy other = (Candy) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candy [name=" + name + ", type=" + type + ", weight=" + weight + "]";
	}
}
