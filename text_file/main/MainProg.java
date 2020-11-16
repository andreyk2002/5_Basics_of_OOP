package by.epam_tc.oop_basics.text_file.main;

import java.util.ArrayList;
import java.util.InputMismatchException;

import by.epam_tc.oop_basics.text_file.entity.*;
import by.epam_tc.oop_basics.text_file.logic.*;

public class MainProg {

	public static void main(String[] argc) {
		Directory c = null;
		Directory documents = null;
		DataHandler hFile = DataHandler.getInstance();
		try {
			c = new Directory("C:", null, new ArrayList<DataUnit>());
			documents = new Directory("Documents", c, new ArrayList<DataUnit>());
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}

		try {
			TextFile digits = TextFile.create("Digits.txt", documents);
			digits.addText("1 2 3 4 5 6 7 8 9 ");
			digits.showContent();
			hFile.rename(digits, "Hexidecimal_digits.txt");
			digits.addText("A B C D F");
			digits.showContent();
			hFile.deleteFile(digits);
			digits.showContent();

		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
