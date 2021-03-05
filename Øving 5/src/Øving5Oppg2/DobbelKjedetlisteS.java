package Øving5Oppg2;



public class DobbelKjedetlisteS<T extends Comparable<T>> {
	
	private DobbelNode<T> forste;
	private DobbelNode<T> siste;
	private int antall;

	public DobbelKjedetlisteS(T minverdi, T maksverdi){
		DobbelNode<T> nyNode1 = new DobbelNode<T>(minverdi);
		forste = nyNode1;
		
		DobbelNode<T> nyNode2 = new DobbelNode<T>(maksverdi);
		nyNode2.setElement(maksverdi);
		nyNode1.setNeste(nyNode2);
		nyNode2.setForrige(nyNode1);
		siste = nyNode2;
		
		antall=0;
	}
	public void leggTil(T ny) {
		
		DobbelNode<T> p = forste.getNeste();
		
		if((ny.compareTo(forste.getElement()) <= 0) || (ny.compareTo(siste.getElement()) >= 0)) {
		} else {	
		while(ny.compareTo(p.getElement()) >= 0) {
			p = p.getNeste();
		}
			DobbelNode<T> nyNode = new DobbelNode<>(ny);
			
			nyNode.setNeste(p);
			nyNode.setForrige(p.getForrige());
			p.getForrige().setNeste(nyNode);
			p.setForrige(nyNode);
			
			antall++;
		}
	}

	
	public T fjern(T x) {
		
		T resultat = null;
		
		DobbelNode<T> p = forste;
		
		if((x.compareTo(forste.getElement()) <= 0) || (x.compareTo(siste.getElement()) >= 0)) {
			return x;
		} else {
		}
			while(x.compareTo(p.getElement()) > 0) {
				p = p.getNeste();
			} 
			if (x.compareTo(p.getElement()) == 0) {
			
			resultat = p.getElement();
			
			p.getForrige().setNeste(p.getNeste());
			p.getNeste().setForrige(p.getForrige());
		
			antall--;
			
			}
		return resultat;
	}
	
	public boolean fins(T x){
		
		DobbelNode<T> p = forste.getNeste();
		
		if((x.compareTo(forste.getElement()) <= 0) || (x.compareTo(siste.getElement()) >= 0)) {
			return false;
		} else {
		}
			while(x.compareTo(p.getElement()) > 0) {
				p = p.getNeste();
			}
			if(x.compareTo(p.getElement()) == 0) {
				return true;
		}
		
		
		return false;
	}
	
//	private DobbelNode<T> finn(T el) {
//		
//		DobbelNode<T> node = null;
//		DobbelNode<T> p = null;
//
//		if ((el.compareTo(forste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
//			// Ugyldig. Alternativt kan vi ha det som et forkrav!
//			System.out.println("Ugyldig verdi. verdi > " + forste.getElement() + "verdi < " + siste.getElement());
//
//		}else {
//		}
//		while (el.compareTo(p.getElement()) > 0) {
//			p = p.getNeste();
//		}
//		if (el.compareTo(p.getElement()) == 0) {
//			node = p;
//		}
//		return node;
//	}

	
	public void visListe(){
		DobbelNode<T> p = forste;
			
			while (p != null) {
				if(p!=forste && p!=siste) {
					System.out.print(p.getElement() + " ");
				}
				p = p.getNeste();
			}
			System.out.println(
					"Foerste:" + forste.getElement() + " Siste:" + siste.getElement());
			System.out.println();
		}
	
}
