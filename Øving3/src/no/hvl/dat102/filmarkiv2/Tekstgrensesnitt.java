package no.hvl.dat102.filmarkiv2;
import java.util.Scanner;

import no.hvl.dat102.adt.FILMarkivADT;

public class Tekstgrensesnitt {

	// lese opplysningene om en Film fra tastatur
	public Film lesFilm() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Skriv inn film nummer: \n");
		int filmNr = sc.nextInt();

		System.out.print("Skriv inn navn på produsent: \n");
		String produsent = sc.next();

		System.out.print("Skriv inn tittel: \n");
		String tittel = sc.next();

		System.out.print("Skriv inn lanseringsår: \n");
		int lanseringsAar = sc.nextInt();

		System.out.print("Skriv inn Sjanger: \n");
		Sjanger sjanger1 = Sjanger.finnSjanger(sc.next().toUpperCase());

		System.out.print("Skriv inn filmselskap: \n");
		String filmSelskap = sc.next();

		Film nyFilm = new Film(filmNr, produsent, tittel, lanseringsAar, sjanger1, filmSelskap);
		

		return nyFilm;

	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {

		System.out.println(film.tilStreng());

	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FILMarkivADT filma, String delstreng) {

		for (Film nyFilm : filma.soekTittel(delstreng)) {
			visFilm(nyFilm);
		}

	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FILMarkivADT filma, String delstreng) {

		for (Film nyFilm : filma.soekProdusent(delstreng)) {
			visFilm(nyFilm);
		}

	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FILMarkivADT filma) {

		System.out.println("Antall Filmer totalt: " + filma.antall());

		for(int i = 0; i < Sjanger.values().length; i++) {
			System.out.println("Antall Filmer med " + Sjanger.values()[i]+ " sjanger: " + filma.antall(Sjanger.values()[i]));
		}
		System.out.println("\n");
	}
	// Evt.andre metoder
}
