package by.epam_tc.oop_basics.present.builder;

import java.util.*;
import java.util.Scanner;

import by.epam_tc.oop_basics.present.entity.*;


public class PresentCandyCreator implements PresentCandyBuilder {
	private PresentCandy presentCandy;
	
	public PresentCandyCreator(PresentCandy present) {
		presentCandy = present;
	}
	
	public PresentCandyCreator() {
		presentCandy = new PresentCandy();
	}

	@Override
	public void buildPresentWrap(Color color, WrapMaterial material, int weight) {
		presentCandy.setWrap(new Wrap(color, material, weight));
		
	}

	@Override
	public void buildPresentCandy(String name, CandyType type, int weight) {
		presentCandy.setContent(new Candy(name, type, weight));
	}

	@Override
	public PresentCandy getPresentCandy() {
		return presentCandy;
	}
	
	

}
