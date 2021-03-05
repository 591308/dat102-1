package no.hvl.dat102.adt;
import no.hvl.dat102.filmarkiv2.Film;
import no.hvl.dat102.filmarkiv2.Sjanger;

public interface FILMarkivADT {

	// returnere en tabell av Filmer
	Film[] hentFilmTabell();

	// Legger til en ny Film
	void leggTilFilm(Film nyFilm);

	// Sletter en Film hvis den fins
	boolean slettFilm(int filmnr);

	// Søker og henter Filmer med en gitt delstreng
	Film[] soekTittel(String delstreng);

	// Søker og henter produsenter med en gitt delstreng
	Film[] soekProdusent(String delstreng);

	// Henter antall Filmer for en gitt sjanger
	int antall(Sjanger sjanger);

	// Returnere antall Filmer
	int antall();

}
