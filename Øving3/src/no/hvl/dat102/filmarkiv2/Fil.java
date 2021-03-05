package no.hvl.dat102.filmarkiv2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat102.adt.FILMarkivADT;

public class Fil {

	final static String SKILLE = "#";

	// Lese et Filmarkiv fra tekstfil
	public static void lesFraFil(FILMarkivADT filmarkiv, String filnavn) {

		final String SKILLE = "#";

		try {
			FileReader minFil = new FileReader(filnavn);
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(minFil);
			String linje = in.readLine();

			int n = Integer.parseInt(linje);

			String post = in.readLine();

			Filmarkiv2 filma = new Filmarkiv2(n);

			for (int i = 0; i < n; i++) {
				String[] felt = post.split(SKILLE);

				int filmNr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittel = felt[2];
				int lanserinsAar = Integer.parseInt(felt[3]);
				Sjanger sjanger1 = Sjanger.finnSjanger(felt[4]);
				String filmSelskap = felt[5];

				Film a = new Film(filmNr, produsent, tittel, lanserinsAar, sjanger1, filmSelskap);

				filma.leggTilFilm(a);
				post = in.readLine();

				System.out.println(a.tilStreng());
			}

		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}
	}

	public static FILMarkivADT lesFraFil(String filnavn) {

		final String SKILLE = "#";

		try {
			FileReader minFil = new FileReader(filnavn);
			BufferedReader in = new BufferedReader(minFil);
			String linje = in.readLine();

			int n = Integer.parseInt(linje);

			String post = in.readLine();

			Filmarkiv2 filma = new Filmarkiv2(n);

			for (int i = 0; i < n; i++) {
				String[] felt = post.split(SKILLE);

				int filmNr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittel = felt[2];
				int lanserinsAar = Integer.parseInt(felt[3]);
				Sjanger sjanger1 = Sjanger.finnSjanger(felt[4]);
				String filmSelskap = felt[5];

				Film a = new Film(filmNr, produsent, tittel, lanserinsAar, sjanger1, filmSelskap);

				filma.leggTilFilm(a);

			}
			in.close();
			return filma;

		} catch (FileNotFoundException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Feil ved utføring av spørring: " + e);
			e.printStackTrace();
		}
		return null;
	}

	// Lagre et Filmarkiv til tekstfil
	public static void skrivTilFil(FILMarkivADT filmarkiv, String filnavn) {
		final String SKILLE = "#";
		final String filNavn = filnavn;

		int antall = filmarkiv.antall();

		try {

			PrintWriter utfil = new PrintWriter(filNavn); // PrintWriter for å printe data til fil

			utfil.println(antall); // skrive ut først antall filmer

			for (int i = 0; i < antall; i++) {
				utfil.print(filmarkiv.hentFilmTabell()[i].getFilmnr());
				utfil.print(SKILLE);
				utfil.print(filmarkiv.hentFilmTabell()[i].getProdusent());
				utfil.print(SKILLE);
				utfil.print(filmarkiv.hentFilmTabell()[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(filmarkiv.hentFilmTabell()[i].getLanseringsAar());
				utfil.print(SKILLE);
				utfil.print(filmarkiv.hentFilmTabell()[i].getSjanger());
				utfil.print(SKILLE);
				utfil.print(filmarkiv.hentFilmTabell()[i].getFilmselskap());
				utfil.print("\n");

			}

			utfil.close();

		} catch (IOException e) {
			System.out.println("Feil ved skriving til fil : " + e);
			System.exit(3);
		}
	}
}
