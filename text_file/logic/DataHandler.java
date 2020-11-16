package by.epam_tc.oop_basics.text_file.logic;

import by.epam_tc.oop_basics.text_file.entity.*;
import by.epam_tc.oop_basics.text_file.exception.*;

public class DataHandler {
	private static DataHandler instance = null;

	private DataHandler() {

	}

	public static DataHandler getInstance() {
		if (instance == null) {
			instance = new DataHandler();
		}
		return instance;
	}

	public void rename(DataUnit d, String newName) throws Exception {
		if (newName == null) {
			throw new FileException("You can't create files without name!");
		}
		d.setName(newName);
	}

	public void deleteFile(File f) throws Exception {
		if (!(f instanceof TextFile)) {
			f.setName(null);
			return;

		}
		TextFile tFile = (TextFile) f;
		tFile.setParentDirectory((Directory) null);
		tFile.setContent(null);
		tFile.setName(null);
	}

	public void deleteDirectory(Directory directory) throws Exception {
		directory.setParentDirectory((Directory) null);
		directory.setContent(null);
		directory.setName(null);
	}

}
