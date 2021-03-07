package Øving5Oppg3;


public class Binærsøk {
	/*sett funnet til usann
	 * hvis del av tabell er tom
	 * 	sett funnet til usann
	 * 	ellers hvis midtelementet er lik søkeelementet så 
	 * 	sett funnet til sann
	 * 	ellers hvis søkeelementet er mindre enn midtelementet så
	 * 	binærsøk delen til venstre for midtelementet
	 * 	ellers søkeelementet er større enn midtelementet så 
	 * 	binærsøk delen til høyre for midtelementet
	 * 	returner funnet
	 */
	public static <T extends Comparable<T>> boolean binaerSoek(T[] data, int min, int maks, T el) {
		
		if(min > maks) { //basistilfellet ingen element
			return false;
		}
		int midtpunkt=(min+maks)/2;
		
		Integer resultat = el.compareTo(data[midtpunkt]);
		
		if(resultat == 0) {
			return true;
		}
		if(resultat < 0) {
			return binaerSoek(data, min, midtpunkt-1, el);
		} else {
			return binaerSoek(data, midtpunkt+1, maks, el);
		}
	}
	
	public static <T extends Comparable<T>> boolean binaerSoek2(T[] data, int min, int maks, T el) {
		boolean funnet;
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);

		if (min > maks) { // basistilfelle, ingen element
			funnet = false;
		} else if (resultat == 0) { // basistilfelle, funnet
			funnet = true;
		} else if (resultat < 0) {
			funnet = binaerSoek2(data, min, midtpunkt - 1, el);
		} else {
			funnet = binaerSoek2(data, midtpunkt + 1, maks, el);
		}

		return funnet;

	}
	public static <T extends Comparable<T>> int binaerSoek4(T[] data, int min, int maks, T el){
		// Returnerer indeksen til målelementet hvis det fins ellers -1
		
		int foerste= min; int siste = maks; int indeks = -1; boolean funnet = false; int resultat = 0;
		while((foerste<= siste) && !funnet){
			
			int midtpunkt = (foerste + siste)/2;
			
			resultat = el.compareTo(data[midtpunkt]);
			
			if(resultat == 0){
				
				funnet = true; 
				
				indeks = midtpunkt;
				}else
					if(resultat < 0){
				//Søk i nedre halvdel
						siste = midtpunkt -1;
						}
					else{//Søk i øvre halvdel
						foerste= midtpunkt + 1;
						} 
			}//while
		return indeks;
		}
			
		
	}
	

