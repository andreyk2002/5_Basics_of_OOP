package by.epam_tc.oop_basics.present.builder;

import by.epam_tc.oop_basics.present.entity.*;
public interface PresentCandyBuilder {
	
	void buildPresentWrap(Color color, WrapMaterial material, int weight);
	void buildPresentCandy(String name, CandyType type, int weight);
	PresentCandy getPresentCandy();
}
