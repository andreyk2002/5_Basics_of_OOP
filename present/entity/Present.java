package by.epam_tc.oop_basics.present.entity;

import java.io.Serializable;

public abstract class Present implements Serializable {

	private static final long serialVersionUID = 937780606474588695L;
	private Wrap wrap;

	public Present() {
		this(new Wrap());
	}

	public Present(Wrap wrap) {
		super();
		this.wrap = wrap;
	}

	public Wrap getWrap() {
		return wrap;
	}

	public void setWrap(Wrap wrap) {
		this.wrap = wrap;
	}

	public abstract int getPresentWeight();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wrap == null) ? 0 : wrap.hashCode());
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
		Present other = (Present) obj;
		if (wrap == null) {
			if (other.wrap != null)
				return false;
		} else if (!wrap.equals(other.wrap))
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "Present [wrap=" + wrap + "]";
	}

	

}
