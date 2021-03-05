package no.hvl.data102.data102.klient;
import no.hvl.dat102.filmarkiv.Filmarkiv;
import no.hvl.dat102.filmarkiv.Meny;
import no.hvl.data102.adt.FILMarkivADT;

public class KlientFilmArkiv {

	public static void main(String[] args) {

		FILMarkivADT filma = new Filmarkiv(0);

		Meny meny = new Meny(filma);

		meny.start();

	}

}
