package no.hvl.dat102.filmarkiv2;
import no.hvl.dat102.adt.FILMarkivADT;

public class Filmarkiv2 implements FILMarkivADT {

	private int antall;
	private LinearNode<Film> start;
	private Film[] filmtabell;
	
	public Filmarkiv2(int antall){
		
		start = new LinearNode<>();
		antall = 0;
		
	}
	
	@Override
	public Film[] hentFilmTabell() {
	
		Film[] filmtabell = new Film[antall];
		LinearNode<Film> node = start;
		
		for(int i = 0; i < antall; i++) {
			
			filmtabell[i] = node.getElement();
			node = node.getNeste();
		}
		return filmtabell;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		
		
		
		LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
		
		filmtabell[antall] = nyNode.getElement();
		
		nyNode.setNeste(start);
		
		start = nyNode;
		
		antall++;
		
	}


	@Override
	public boolean slettFilm(int filmnr) {
		
	
	  if(start != null && start.getElement().getFilmnr() == filmnr) { 
			start = start.getNeste();
			antall--;
			return true;
		}
		
		int i = 0;
		boolean funnet = false;
		LinearNode<Film> forrige = start;
		LinearNode<Film> denne = forrige.getNeste();
		
		
		while(i < antall) {
			if(filmnr == denne.getElement().getFilmnr()) {
				forrige.setNeste(denne.getNeste());;
				antall--;
				funnet = true;
			} else {
				forrige = denne;
				denne = denne.getNeste();
			}
			i++;
		}
		return funnet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		
		LinearNode<Film> nyNode = start;
		
		Film[] ny = new Film[antall];
		
		int count = 0;
		
		for (int i = 0; i < antall; i++) {
			if (nyNode.getElement().getTittel().contains(delstreng)) {
				ny[count] = nyNode.getElement();
				count++;
			}
		}
		return trimTab(filmtabell, count);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		
		LinearNode<Film> nyNode = start;
		
		Film[] ny = new Film[antall];
		
		int count = 0;
		
		for (int i = 0; i < antall; i++) {
			if (nyNode.getElement().getProdusent().contains(delstreng)) {
				ny[count] = nyNode.getElement();
				count++;
			}
		}
		return trimTab(filmtabell, count);
	}

	@Override
	public int antall(Sjanger sjanger) {
		
		int antallSjanger = 0;
		LinearNode<Film> nyNode = start;
		
		
		for(int i = 0; i < antall; i++) {
	
			if(nyNode.getElement().getSjanger().equals(sjanger)) {
				antallSjanger++;
			} 
				nyNode = nyNode.getNeste();
				
		}
		return antallSjanger;
		
	}

	@Override
	public int antall() {
		
		return antall;
	}
	
	private Film[] trimTab(Film[] tab, int n) {

		Film[] filmtab2 = new Film[n];
		int i = 0;
		while (i < n) {
			filmtab2[i] = tab[i];
			i++;
		}
		return filmtab2;
	}

}
