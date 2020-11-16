package by.epam_tc.oop_basics.text_file.entity;

import java.util.*;

public class Directory extends DataUnit {

	
	private static final long serialVersionUID = -5633299041066706685L;
	private Directory parentDirectory;
	private List<DataUnit> content = new ArrayList<DataUnit>();

	public Directory(String name, Directory parentDirectory, List<DataUnit> files) throws Exception {
		super();
		setName(name);
		this.parentDirectory = parentDirectory;
		this.content = files;
		if (parentDirectory != null) {
			parentDirectory.content.add(this);
		}
	}
	
	public Directory() throws Exception {
		this("default name", null, new  ArrayList<DataUnit>());
	}
	
	public Directory getParentDirectory() {
		return parentDirectory;
	}

	public List<DataUnit> getContent() {
		return content;
	}

	public void removeDate(DataUnit data) {
		for (var el : content) {
			if (el.getName().equals(data.getName())) {
				content.remove(el);
			}
		}
	}

	public void setFiles(List<DataUnit> files) {
		this.content = files;
	}


	
	public void setParentDirectory(Directory parentDirectory) {
		this.parentDirectory = parentDirectory;
	}

	public void setContent(List<DataUnit> content) {
		this.content = content;
	}

	@Override
	public void showContent() {
		if (getName() == null) {
			System.out.println("Your directory was deleted");
			return;
		}
		System.out.println("Files and directories in directory " + getName());
		for (var el : content) {
			System.out.println(el.getName());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		Directory other = (Directory) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (parentDirectory == null) {
			if (other.parentDirectory != null)
				return false;
		} else if (!parentDirectory.equals(other.parentDirectory))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Directory [name=" + getName() + ", parentDirectory=" + parentDirectory + ", content=" + content + "]";
	}

	
}
