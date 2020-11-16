package by.epam_tc.oop_basics.text_file.entity;

public abstract class File extends DataUnit {

	private static final long serialVersionUID = 6288709076609947185L;
	private Directory parentDirectory;

	public File(String name, Directory parentDirectory) throws Exception {
		super();
		setName(name);
		this.parentDirectory = parentDirectory;
		if (parentDirectory != null) {
			parentDirectory.getContent().add(this);
		}

	}

	public File() throws Exception {
		this("default file name", null);
	}

	public void setParentDirectory(Directory parentDirectory) {
		this.parentDirectory = parentDirectory;
	}

	public Directory getParentDirectory() {
		return parentDirectory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((parentDirectory == null) ? 0 : parentDirectory.hashCode());
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
		File other = (File) obj;
		if (parentDirectory == null) {
			if (other.parentDirectory != null)
				return false;
		} else if (!parentDirectory.equals(other.parentDirectory))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "File name - " + getName() + ", parent directory name - " + parentDirectory.getName();
	}

	public void showInfo() {
		System.out.println(this.toString());
	}
}
