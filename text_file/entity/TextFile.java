package by.epam_tc.oop_basics.text_file.entity;

public class TextFile extends File {

	
	private static final long serialVersionUID = 9171589016937501681L;
	private String content;

	public static TextFile create() throws Exception {
		return new TextFile();
	}
	
	public static TextFile create(String name, Directory parent) throws Exception {
		return new TextFile(name, "", parent);
	}

	public static TextFile create(String name, String content, Directory parent) throws Exception {
		return new TextFile(name, content, parent);
	}

	public TextFile(String name, String content, Directory parentDirectory) throws Exception {
		super(name, parentDirectory);
		this.content = content;
		if (parentDirectory != null) {
			parentDirectory.getContent().add(this);
		}
	}
	
	public TextFile() throws Exception {
		super();
		this.content = "";
	}

	public String getContent() {
		return content.toString();
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void addText(String text) {
		StringBuilder newContent = new StringBuilder((String)this.content);
		newContent.append(text);
		this.content = newContent.toString();
	}

	public void addText(TextFile text) {
		StringBuilder newContent = new StringBuilder((String)this.content);
		newContent.append(text.content);
		this.content = newContent.toString();
	}
	
	
	@Override
	public String toString() {
		if (getName() == null) {
			return "probably, your file was deleted";
		}
		StringBuilder info = new StringBuilder();
		info.append("\t\tFile name - " + this.getName());
		info.append("\n\tparent directory name - " + getParentDirectory().getName() + "\n");
		info.append(content);

		return info.toString();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public void showContent() {
		if(getName() == null) {
			System.out.println("The file is deleted");
			return;
		}
		System.out.println(getName() + " : " + content);
		
	}

}
