package by.epam_tc.oop_basics.present.entity;

import java.util.ArrayList;

public class PresentRange {
	private ArrayList<Wrap> avaibleWraps = new ArrayList<Wrap>();
	private ArrayList<Candy> avaibleCandies = new ArrayList<Candy>();

	public PresentRange() {

	}

	public ArrayList<Wrap> getAvaibleWraps() {
		return avaibleWraps;
	}

	public void setAvaibleWraps(ArrayList<Wrap> avaibleWraps) {
		this.avaibleWraps = avaibleWraps;
	}

	public ArrayList<Candy> getAvaibleCandies() {
		return avaibleCandies;
	}

	public void setAvaibleCandies(ArrayList<Candy> avaibleCandies) {
		this.avaibleCandies = avaibleCandies;
	}

	@Override
	public String toString() {
		return "PresentRange [avaibleWraps=" + avaibleWraps + ", avaibleCandies=" + avaibleCandies + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avaibleCandies == null) ? 0 : avaibleCandies.hashCode());
		result = prime * result + ((avaibleWraps == null) ? 0 : avaibleWraps.hashCode());
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
		PresentRange other = (PresentRange) obj;
		if (avaibleCandies == null) {
			if (other.avaibleCandies != null)
				return false;
		} else if (!avaibleCandies.equals(other.avaibleCandies))
			return false;
		if (avaibleWraps == null) {
			if (other.avaibleWraps != null)
				return false;
		} else if (!avaibleWraps.equals(other.avaibleWraps))
			return false;
		return true;
	}

}
