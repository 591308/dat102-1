package no.hvl.dat102.klient;
import no.hvl.dat102.adt.FILMarkivADT;
import no.hvl.dat102.filmarkiv2.Filmarkiv2;
import no.hvl.dat102.filmarkiv2.Meny;

public class KlientFilmArkiv {

	public static void main(String[] args) {

		FILMarkivADT filma = new Filmarkiv2(1);

		Meny meny = new Meny(filma);

		meny.start();

	}

}
