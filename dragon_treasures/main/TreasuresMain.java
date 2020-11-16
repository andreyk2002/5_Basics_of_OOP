package by.epam_tc.oop_basics.dragon_treasures.main;

/**
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 * • Приложение должно быть объектно-, а не процедурно-ориентированным.
 * • Каждый класс должен иметь отражающее смысл название и информативный состав.
 * • Наследование должно применяться только тогда, когда это имеет смысл.
 * • При кодировании должны быть использованы соглашения об оформлении кода java code convention.
 * • Классы должны быть грамотно разложены по пакетам.
 * • Консольное меню должно быть минимальным.
 * • Для хранения данных можно использовать файлы.
 * Дракон и его сокровища.  Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
 * дракона.  Реализовать  возможность  просмотра  сокровищ,  выбора  самого  дорогого  по  стоимости  сокровища  и
 * выбора сокровищ на заданную сумму.
 */

import java.io.FileNotFoundException;
import java.io.IOException;

import by.epam_tc.oop_basics.dragon_treasures.dao.TreasureReader;
import by.epam_tc.oop_basics.dragon_treasures.entity.Cave;
import by.epam_tc.oop_basics.dragon_treasures.menu.ConsoleMenu;

public class TreasuresMain {

	private static TreasureReader reader;
	private static Cave cave;

	static {

		reader = TreasureReader.getInstance();
		try {
			cave = reader.readFromFile();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public static Cave getCave() {
		return cave;
	}

	public void init() {
		ConsoleMenu menu = new ConsoleMenu();
		menu.showMenu();
		menu.makeAction();
	}

	public static void main(String... argc) {
		TreasuresMain program = new TreasuresMain();
		program.init();
	}

}
