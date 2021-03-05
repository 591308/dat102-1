package no.hvl.dat102.filmarkiv;
import java.util.Scanner;

import no.hvl.data102.adt.FILMarkivADT;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private FILMarkivADT filma;

	public Meny(FILMarkivADT filma) {
		tekstgr = new Tekstgrensesnitt();
		this.filma = filma;
	}

	public void start() {

		// Fil.lesFraFil("Filmer.txt");

		// System.out.println(Fil.lesFraFil("Filmer.txt").hentFilmTabell()[0].getTittel());

		System.out.println("Legge til ein film trykk:    1");
		System.out.println("Lese filmer fra fil:         2");
		System.out.println("Skriv ut statistikk:         3");
		System.out.println("SØk etter film med tittel:   4");
		System.out.println("Søk etter produsent:         5");
		System.out.println("For å avslutte tast:         6");

		Scanner in = new Scanner(System.in);
		int inn = in.nextInt();

		if (inn == 1) {

			filma.leggTilFilm(tekstgr.lesFilm());

			Fil.skrivTilFil(filma, "Filmer.txt");

			start();

		} else if (inn == 2) {

			Fil.lesFraFil(filma, "Filmer.txt");

			start();

		} else if (inn == 3) {

			tekstgr.skrivUtStatistikk(filma);

			start();

		} else if (inn == 4) {
			
			System.out.println("Skriv inn tittel på film: " + "\n");
			
			String tittel = in.next();
			
			tekstgr.skrivUtFilmDelstrengITittel(filma, tittel);
			
			start();
		}

		else if (inn == 5) {
			
			System.out.println("Skriv inn navn på produsent " + "\n");
			
			String tittel = in.next();
			
			tekstgr.skrivUtFilmProdusent(filma, tittel);
			
			start();
			
			
		}
		else if(inn == 6) {
			
			in.close();
			System.out.println("Programmet er avsluttet!");
		}

	}
}
