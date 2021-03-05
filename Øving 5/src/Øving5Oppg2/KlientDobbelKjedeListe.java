package Øving5Oppg2;

public class KlientDobbelKjedeListe {
	
	public static void main(String[] args) {
		
		int tall[] = {5,3,2,1};
		
		DobbelKjedetlisteS<Integer> liste = new DobbelKjedetlisteS<>(0,6);
		
		for (int i = 0; i < tall.length; i++) {
			liste.leggTil(tall[i]);
		}
		
		System.out.print("Liste : ");
		liste.visListe();
		
		
		liste.leggTil(4);
		System.out.println("Oppdatert liste med tall 4: ");
		liste.visListe();
		
		System.out.println("Finnes tallet 3 i listen? " + liste.fins(3) + "\n");
		
		System.out.println("Finnes tallet 6 i listen? " + liste.fins(6) + "\n");
		
		System.out.println("Slette tallet " + liste.fjern(3) + " og skriv ut oppdatert liste: ");
		
		liste.visListe();
		
		
	}
}
