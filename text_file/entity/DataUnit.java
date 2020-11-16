package by.epam_tc.oop_basics.text_file.entity;

import java.io.Serializable;
import java.util.InputMismatchException;

public abstract class DataUnit implements Serializable{

	
	private static final long serialVersionUID = -4179692689491961519L;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if(name == null) {
			this.name = null;
			return;
		}
		if (name.equals("")) {
			throw new InputMismatchException("You can't create files without name!");
		}
		this.name = name;
	}

	public abstract void showContent();
	public abstract Object getContent();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		DataUnit other = (DataUnit) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DataUnit [name=" + name + "]";
	}
		
}
