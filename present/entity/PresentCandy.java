package by.epam_tc.oop_basics.present.entity;

public class PresentCandy extends Present {

	private static final long serialVersionUID = 5283504496940293692L;
	private Candy candyContent;

	public PresentCandy() {
		super();
	}

	public PresentCandy(Wrap wrap, Candy candy) {
		super(wrap);
		this.candyContent = candy;
	}

	public Candy getCandy() {
		return candyContent;
	}

	public void setContent(Candy candy) {
		this.candyContent = candy;
	}

	@Override
	public int getPresentWeight() {
		return getWrap().getWeight() + candyContent.getWeight();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((candyContent == null) ? 0 : candyContent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PresentCandy other = (PresentCandy) obj;
		if (candyContent == null) {
			if (other.candyContent != null)
				return false;
		} else if (!candyContent.equals(other.candyContent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PresentCandy [content=" + candyContent + "]";
	}

}
