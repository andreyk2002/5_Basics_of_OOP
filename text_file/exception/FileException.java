package by.epam_tc.oop_basics.text_file.exception;

public class FileException extends Exception{

	private static final long serialVersionUID = 1650144176546207290L;
	
	public FileException() {
		super();
	}
	
	public FileException(String string) {
		super(string);
	}
}
