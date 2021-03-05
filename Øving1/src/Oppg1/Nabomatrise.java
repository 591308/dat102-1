package Oppg1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Nabomatrise implements Graf {

	private int n; //antall noder
	private int m; //antall kanter
	
	private boolean[][] matrise;  
	/** Nodene er strenger, men for å kunne bruke nabomatrise-representasjon av grafen
	 *trenger vi heltall. Bruker en HashMap, der vi knytter navn på noden til et heltall (0 til n-1). 
	 *For å gå andre veien, har vi en Strengtabell med navn på nodene.
	 *Det betyr at viss Per mappes til 5, så vil navn[5] være Per **/
	private HashMap<String, Integer> nodenavn; //String is a key, Integer is value here
	private String[] navn; 						//Creating table with names
	
	public Nabomatrise(String[] navnPaaNoder) {
		n = navnPaaNoder.length; //n will be length of list of node names
        m = 0; //m starting value 0 because in the beginning no relations
        matrise = new boolean[n][n];
        /**
         * Kan også bruke standardkonstruktøren nedanfor, men får vi veit storkleiken vil
         * koden bli meir effektiv ved angi størrelsen i konstruktøren.
         */
        nodenavn = new HashMap<>(n); //creating HashMap with n as parameter with length of nameOfNodes
        for(int i = 0; i < n; i++) {
        	nodenavn.put(navnPaaNoder[i], i); 
        }
        /**
         * Treng ikkje lage ny tabell, men berre ha referanse til tabellen som vi får inn som parantesar
         */
        navn = navnPaaNoder; /** String table with names will be equal to table with names of nodes 
        					* which is now located in hash map with key and value of each node in matrix
        					*/
        	
	}
	
	@Override
	public int getAntallNoder() {
		//returnere antall noder
		return n;
	}

	@Override
	public int getAntallKanter() {
		// returnere antall kanter
		return m;
	}

	@Override
	public List<String> alleNoder() {
		// gi alle nodenavn i grafen. Trenger ikke komme i en bestemt rekkefølgje
		
		ArrayList<String> listeMedAlleNoder = new ArrayList<> (n);
		
		for(String s: navn) {
			listeMedAlleNoder.add(s);
		}
		
		return listeMedAlleNoder;
		
	}

	@Override
	public boolean erNaboer(String u, String v) {
		
		/*
		 * set that 2 nods are neighbours, extract their key from hashmap
		 *  and return true or false value into matrix
		 */
		int x = nodenavn.get(u);
		int y = nodenavn.get(v);
		
		return matrise[x][y];
	}

	@Override
	public boolean leggTilNode(String w) {
		/** Legg til ein node til grafen. 
		Denne metoden treng ikkje fungere.Man kan bare la metoden returnere false
		**/
		
		return false;
	}

	@Override
	public boolean leggTilKant(String u, String v) {
		
		/** Legg til ein kant mellom nodene u og v i grafen
		 * u frå node 
		 * v til node
		 * true om kanten er lagt til, false om u eller v ikkje er lovlige nodenavn.
		 * Også false om kanten finst frå før
		 **/
		if(erLovligNode(u) && erLovligNode(v)) { //check if nodes have legit values if not return false
			int x = nodenavn.get(u);			//remember always get index of name in array 
			int y = nodenavn.get(v);			//^^^
			if(!matrise[x][y]) {  		//create new relation if relation deosnt exist in matrix from before
				leggTilKant(x,y);
			}else {
				return false;
			}
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean leggTilKanter(String v, String[] naboer) {
		/**
		 * Metoden kan legge flere kanter til en operasjon
		 * w node i grafen
		 * noboer Tabell med noder som skal bli nabo med w
		 * true derson ingen kanter finnes i grafen fra før, false ellers,
		 * Dersom en kant finnes frå før, blir kanter lagt til
		 */
		if(erLovligNode(v)) {
			int x = nodenavn.get(v);
			for(String w: naboer) {
				if(!erLovligNode(w)) {
					return false;
				}
			}
			for(String w: naboer) {
				int y = nodenavn.get(w);
				leggTilKant(x,y);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean fjern(String u, String v) {
		/** 
		 * fjerner en kant i grafen, u node i grafen, v node i grafen, true dersom der var en kant mellom u og v i grafen, false ellers
		 */
		if(nodenavn.containsKey(u) && nodenavn.containsKey(v)) {
			int x = nodenavn.get(u);
			int y = nodenavn.get(v);
				if(matrise[x][y]) {
					matrise[x][y] = false;
					matrise[y][x] = false;
					m--;
					return true;
				}
		}return false;
	}

		@Override 
	public List<String> getNaboer(String w) {
		/** Henter liste av alle naboene til en gitt node
		 * w node i grafen
		 * Liste med alle naboane til w */
		ArrayList<String> naboer = new ArrayList<> ();
		for(String str: navn) {
			
			if(erNaboer(w, str)) {
				naboer.add(str);
			}
		}
			
		return naboer;
	}
		
		private boolean erLovligNode(String v) { //lager kort metode for å sjekke om node har lovig navn i tabellen
			return nodenavn.containsKey(v);
		}
		
		public void leggTilKant(int u, int v) {
			matrise[u][v] = true;
			matrise[v][u] = true;
			m++;
		}

}

