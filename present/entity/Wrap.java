package by.epam_tc.oop_basics.present.entity;

import java.io.Serializable;

public class Wrap implements Serializable{
	
	private static final long serialVersionUID = -4655413264402099331L;
	private Color color;
	private WrapMaterial material;
	private int weight;

	public Wrap(Color color, WrapMaterial material,int weight) {
		super();
		this.color = color;
		this.material = material;
		setWeight(weight);
	}

	public Wrap() {
		this(Color.WHITE, WrapMaterial.CELLOPHANE,0);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public WrapMaterial getMaterial() {
		return material;
	}

	public void setMaterial(WrapMaterial material) {
		this.material = material;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight < 0) {
			weight = 0;
			return;
		}
		
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
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
		Wrap other = (Wrap) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wrap [color=" + color + ", material=" + material + ", weight=" + weight + "]";
	}

	

}
