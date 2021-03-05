package Oppg2;

import java.util.ArrayList;

import Oppg1.Nabomatrise;

public class Facebook {
	
	private String gruppeNavn;
	private Nabomatrise g;
	
	public Facebook(String navnPaaGruppe, String[] navn) {
		gruppeNavn = navnPaaGruppe;
		g = new Nabomatrise(navn);
		
	}
	
	public boolean leggTilVenner(String p1, String p2) {
		return g.leggTilKant(p1, p2);
		
	}
	public boolean erVenner(String p1, String p2) {
		return g.erNaboer(p1, p2);
		
	}
	public boolean ikkeVenner(String p1, String p2) {
		return g.fjern(p1, p2);
		
	}
	public int antalFellesVenner(String p1, String p2) {
		
	        int fellesVenner = 0;

	        for(String s : g.getNaboer(p1))
	        {
	            for(String t : g.getNaboer(p2))
	            {
	                if(s == t)
	                {
	                    fellesVenner++;
	                }
	            }
	        }

	        return fellesVenner;
		
	}
	
	public String flestVenner() {
        
        String flestnavn = null;
        int flest = 0;
        
        for (int i = 0; i < g.alleNoder().size(); i++) {
            if(flest < g.getNaboer(g.alleNoder().get(i)).size()) {
                flest = g.getNaboer(g.alleNoder().get(i)).size();
                flestnavn = g.alleNoder().get(i);
            }
        }
        return flestnavn;
    }
	
	public void visGraf() {
		
		int n = g.getAntallNoder();
		int m = g.getAntallKanter();
		
		
		System.out.println("Facebookgrafen for Deler av " + gruppeNavn);
		System.out.println("Antall personer i gruppen = " + n + ", antall vennskap = " + m);
		
		ArrayList<String> liste = new ArrayList<>(g.alleNoder());
		
		for(int i = 0; i < liste.size() ; i++) {
			System.out.println(liste.get(i) + ": " + g.getNaboer(liste.get(i)));
		}
	}
}
