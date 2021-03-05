package Oppg1;

import java.util.List;

public interface Graf {

	int getAntallNoder();
	
	int getAntallKanter();
	
	List<String> alleNoder();
	
	boolean erNaboer(String u, String v);
	
	boolean leggTilNode(String w);
	
	boolean leggTilKant(String u, String v);
	
	boolean leggTilKanter(String w, String[] naboer);
	
	boolean fjern(String u, String v);
	
	List<String> getNaboer(String w);
	
}

