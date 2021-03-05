package no.hvl.dat102.filmarkiv;
import no.hvl.data102.adt.FILMarkivADT;

public class Filmarkiv implements FILMarkivADT {

	private Film[] tab;
	private int antall;

	public Filmarkiv(int lengde) {
		tab = new Film[lengde];
		antall = 0;
	}

	@Override
	public Film[] hentFilmTabell() {
		return trimTab(tab, antall);
	}

	@Override
	public void leggTilFilm(Film nyFilm) {

		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i].getFilmnr() == filmnr) {
				antall--;
				tab[i] = tab[antall];
				tab[antall] = null;
				trimTab(tab, antall); // NB! antall fordi slette fra original tabellen
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {

		Film[] newFilm = new Film[antall];
		int count = 0;

		for (int i = 0; i < antall; i++) {
			if (tab[i].getTittel().contains(delstreng)) {
				newFilm[count] = tab[i];
				count++;
			}
		}
		return trimTab(tab, count);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {

		Film[] newFilmTab = new Film[antall];
		int count = 0;

		for (int i = 0; i < antall; i++) {
			if (tab[i].getProdusent().contains(delstreng)) {
				newFilmTab[count] = tab[i];
				count++;
			}
		}
		return trimTab(tab, count);
	}

	@Override
	public int antall(Sjanger sjanger) {
		
		int antallSjanger = 0;
		for (int i = 0; i < antall; i++) {
			if (tab[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	@Override
	public int antall() {

		return antall;
	}

	private void utvidKapasitet() {
		Film[] hjelpetabell = new Film[antall + 1];

		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
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
