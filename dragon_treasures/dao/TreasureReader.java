package by.epam_tc.oop_basics.dragon_treasures.dao;

import java.io.*;
import java.util.*;

import by.epam_tc.oop_basics.dragon_treasures.entity.Cave;
import by.epam_tc.oop_basics.dragon_treasures.entity.Treasure;

public class TreasureReader {
	public static final String PATH = "resources\\dragon_treasures\\cave.txt";
	
	private static TreasureReader instance = null;

	public static TreasureReader getInstance() {
		if (instance == null) {
			instance = new TreasureReader();
		}
		return instance;
	}

	private TreasureReader() {

	}

	public Cave readFromFile() throws IOException {
		File file = new File(PATH);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> fileText = new ArrayList<String>();
		String line;
		while ((line = reader.readLine()) != null) {
			fileText.add(line);
		}
		Cave cave = parseFromString(fileText);
		reader.close();
		return cave;
	}

	private Cave parseFromString(List<String> text) {
		Cave cave = new Cave();
		int i = 0;
		for (String str : text) {
			int endOfValue;
			endOfValue = findSpaceIndex(str);
			Double value = Double.parseDouble(str.substring(0, endOfValue));

			String name = str.substring(endOfValue + 1);
			Treasure treasure = new Treasure(value, name);
			cave.getTreasures()[i] = treasure;
			i++;
		}
		return cave;
	}

	private int findSpaceIndex(String str) {
		int i = 0;
		while (str.charAt(i) != ' ') {
			i++;
		}
		return i;
	}
}
