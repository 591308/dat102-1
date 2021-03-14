package Øving5Oppg4;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;




public class Klienttable {
    public static String usortert = "usortert";
    public static String sortert = "sortert";
	public static <T> void main(String[] args) {
		//1600
		long M = 16000;
		
		int n = 1000;
		int n1= 16000;
		int n2= 32000;
		int antall = 10;
		
		
		double cUtvalgsortering = (tid(tabell(M, antall), antall)/Math.pow(M, 2));
		double cSorteringVedInnsetting = (tid1(tabell(M, antall), antall)/Math.pow(M, 2));
		double cBobbleSortering = (tid2(tabell(M, antall), antall)/Math.pow(M, 2));
		double cBobbleSorteringMedFlagg = (tid3(tabell(M, antall), antall)/Math.pow(M, 2));
		double cKvikkSortering = (tid4(tabell(M, antall), antall)/(M*(Math.log10(M))));
		double cFletteSortering = (tid5(tabell(M, antall), antall)/(M*(Math.log10(M))));
	
		//teoretisk tid 9.00390625*10^(-6) miliseconds
		
		System.out.println("Resultat av utvalgsortering: ");
		//Sjekker om tabellen faktisk sorter
		
		System.out.println(tabellenUtvalgSort(10));
		KonsollTabell st = new KonsollTabell();
		st.setShowVerticalLines(true);
		st.setHeaders("n", "Antall målinger" ,"Antall sammenligninger", "Målt tid (Gjennomsnitt)", "Teoretisk tid c*n^2");
		st.addRow(String.valueOf(n), String.valueOf(antall),String.valueOf(Sortering.utvalgsSortering(tabellen(n))), String.valueOf(tid(tabell(n, antall), antall)), String.valueOf(Math.round(cUtvalgsortering*(Math.pow(n,2)))));
		st.addRow(String.valueOf(n1), String.valueOf(antall),String.valueOf(Sortering.utvalgsSortering(tabellen(n1))), String.valueOf(tid(tabell(n1, antall), antall)), String.valueOf(Math.round(cUtvalgsortering*(Math.pow(n1,2)))));
		st.addRow(String.valueOf(n2), String.valueOf(antall),String.valueOf(Sortering.utvalgsSortering(tabellen(n2))), String.valueOf(tid(tabell(n2, antall), antall)), String.valueOf(Math.round(cUtvalgsortering*(Math.pow(n2, 2)))));
		st.print();
		
		
		
		System.out.println("Resultat av sorteringvedInnsetting: ");
		System.out.println(tabellenInnsetningsSort(10));
		KonsollTabell st1 = new KonsollTabell();
		st1.setShowVerticalLines(true);
		st1.setHeaders("n","Antall målinger", "Antall sammenligninger", "Målt tid (Gjennomsnitt)", "Teoretisk tid c*n^2");
		st1.addRow(String.valueOf(n), String.valueOf(antall), String.valueOf(Sortering.sorteringVedInsetting(tabellen(n))), String.valueOf(tid1(tabell(n, antall), antall)), String.valueOf(Math.round(cSorteringVedInnsetting*(Math.pow(n,2)))));
		st1.addRow(String.valueOf(n1),String.valueOf(antall), String.valueOf(Sortering.sorteringVedInsetting(tabellen(n1))), String.valueOf(tid1(tabell(n1, antall), antall)), String.valueOf(Math.round(cSorteringVedInnsetting*(Math.pow(n1,2)))));
		st1.addRow(String.valueOf(n2),String.valueOf(antall), String.valueOf(Sortering.sorteringVedInsetting(tabellen(n2))), String.valueOf(tid1(tabell(n2, antall), antall)), String.valueOf(Math.round(cSorteringVedInnsetting*(Math.pow(n2,2)))));
		st1.print();

		
		
		System.out.println("Resultat av bobble sortering: ");
		//Sjekker om tabellen faktisk sorter
		System.out.println(tabellenBobblesort(10));
		KonsollTabell st2 = new KonsollTabell();
		st2.setShowVerticalLines(true);
		st2.setHeaders("n", "Antall målinger","Antall sammenlinginger", "Målt tid (Gjennomsnitt)", "Teoretisk tid c*n^2");
		st2.addRow(String.valueOf(n),String.valueOf(antall), String.valueOf(Sortering.bobleSort(tabellen(n))), String.valueOf(tid2(tabell(n, antall), antall)), String.valueOf(Math.round(cBobbleSortering*(Math.pow(n,2)))));
		st2.addRow(String.valueOf(n1),String.valueOf(antall), String.valueOf(Sortering.bobleSort(tabellen(n1))), String.valueOf(tid2(tabell(n1, antall), antall)), String.valueOf(Math.round(cBobbleSortering*(Math.pow(n1,2)))));
		st2.addRow(String.valueOf(n2),String.valueOf(antall), String.valueOf(Sortering.bobleSort(tabellen(n2))), String.valueOf(tid2(tabell(n2, antall), antall)), String.valueOf(Math.round(cBobbleSortering*(Math.pow(n2,2)))));
		st2.print();
		
		
		
		System.out.println("Resultat av bobble sortering med flagg: ");
		//Sjekker om tabellen faktisk sorter
		System.out.println(tabellenBobblesortFlagg(10));
		KonsollTabell st3 = new KonsollTabell();
		st3.setShowVerticalLines(true);
		st3.setHeaders("n", "Antall målinger","Antall sammenlinginger", "Målt tid (Gjennomsnitt)", "Teoretisk tid c*n^2");
		st3.addRow(String.valueOf(n), String.valueOf(antall),String.valueOf(Sortering.bobleSortFlagg(tabellen(n))), String.valueOf(tid3(tabell(n, antall), antall)), String.valueOf(Math.round(cBobbleSorteringMedFlagg*(Math.pow(n,2)))));
		st3.addRow(String.valueOf(n1), String.valueOf(antall),String.valueOf(Sortering.bobleSortFlagg(tabellen(n1))), String.valueOf(tid3(tabell(n1, antall), antall)), String.valueOf(Math.round(cBobbleSorteringMedFlagg*(Math.pow(n1,2)))));
		st3.addRow(String.valueOf(n2), String.valueOf(antall),String.valueOf(Sortering.bobleSortFlagg(tabellen(n2))), String.valueOf(tid3(tabell(n2, antall), antall)), String.valueOf(Math.round(cBobbleSorteringMedFlagg*(Math.pow(n2,2)))));
		st3.print();
	
		
		
		System.out.println("Resultat av kvikk sortering: ");
		//Sjekker om tabellen faktisk sorter
		System.out.println(tabellenKvikk(10));
		KonsollTabell st4 = new KonsollTabell();
		st4.setShowVerticalLines(true);
		st4.setHeaders("n", "Antall målinger","Antall sammenlinginger", "Målt tid (Gjennomsnitt)", "Teoretisk tid c*nlogn");
		st4.addRow(String.valueOf(n), String.valueOf(antall),String.valueOf(Sortering.kvikkSort(tabellen(n))), String.valueOf(tid4(tabell(n, antall), antall)), String.valueOf(Math.round(cKvikkSortering*(n*Math.log(n)))));
		st4.addRow(String.valueOf(n1), String.valueOf(antall),String.valueOf(Sortering.kvikkSort(tabellen(n1))), String.valueOf(tid4(tabell(n1, antall), antall)), String.valueOf(Math.round(cKvikkSortering*(n1*Math.log10(n1)))));
		st4.addRow(String.valueOf(n2), String.valueOf(antall), String.valueOf(Sortering.kvikkSort(tabellen(n2))), String.valueOf(tid4(tabell(n2, antall), antall)), String.valueOf(Math.round(cKvikkSortering*(n2*Math.log10(n2)))));
		st4.print();
		
		System.out.println("Resultat av flette sortering: ");
		//Sjekker om tabellen faktisk sorter
		System.out.println(tabellenFlette(10));
		
		KonsollTabell st5 = new KonsollTabell();
		st5.setShowVerticalLines(true);
		st5.setHeaders("n", "Antall målinger","Antall sammenlinginger", "Målt tid (Gjennomsnitt)", "Teoretisk tid c*nlogn");
		st5.addRow(String.valueOf(n), String.valueOf(antall),String.valueOf(Sortering.fletteSort(tabellen(n))), String.valueOf(tid5(tabell(n, antall), antall)), String.valueOf(Math.round(cFletteSortering*(n*(Math.log10(n))))));
		st5.addRow(String.valueOf(n1), String.valueOf(antall),String.valueOf(Sortering.fletteSort(tabellen(n1))), String.valueOf(tid5(tabell(n1, antall), antall)), String.valueOf(Math.round(cFletteSortering*(n1*(Math.log10(n1))))));
		st5.addRow(String.valueOf(n2), String.valueOf(antall),String.valueOf(Sortering.fletteSort(tabellen(n2))) , String.valueOf(tid5(tabell(n2, antall), antall)), String.valueOf(Math.round(cFletteSortering*(n2*(Math.log10(n2))))));
		st5.print();
		
		System.out.println("Resultat av kvikk sortering NY: ");
		//Sjekker om tabellen faktisk sorter
		System.out.println(tabellenKvikkNy(10,10));
		
		KonsollTabell st6 = new KonsollTabell();
		st6.setShowVerticalLines(true);
		st6.setHeaders("n","Antall målinger","MIN", "Antall sammenlinginger", "Målt tid (Gjennomsnitt)");
		st6.addRow(String.valueOf(n1),String.valueOf(antall),"10",  String.valueOf(Sortering.kvikkSortNy(tabellen(n1), 10)), String.valueOf(tid6(tabell(n1, antall), antall, 10)));
		st6.addRow(String.valueOf(n1),String.valueOf(antall), "50",String.valueOf(Sortering.kvikkSortNy(tabellen(n1), 50)), String.valueOf(tid6(tabell(n1, antall), antall, 50)));
		st6.addRow(String.valueOf(n1),String.valueOf(antall),"100" ,String.valueOf(Sortering.kvikkSortNy(tabellen(n1), 100)) , String.valueOf(tid6(tabell(n1, antall), antall, 100)));
		st6.print();
		
		System.out.println("Resultat av kvikk sort med samme elementane");
		
		int copiesCount=1000;
		int number=1;
		
		Integer[] copies = Collections.nCopies(copiesCount, number).toArray(new Integer[copiesCount]);
		//System.out.print(Arrays.toString(copies));
		
		long startTime = System.currentTimeMillis();

			Sortering.kvikkSort(copies);
	
		long endTime = System.currentTimeMillis();
		
		long tid= endTime-startTime;
		
		System.out.println("Tid for å sortere " + copiesCount + " elementer "  + String.valueOf(tid) + " milisekund");
		
	}
	
	//lage tabellen med random tall med lengden sendt som parameter
	public static <T> Integer[] tabellen(int c){
		
		Random tilfeldig = new Random();
		
		Integer[] tab = new Integer[c];
		
			for (int j = 0; j < tab.length; j++){
				tab[j] = tilfeldig.nextInt();
			}
			return tab;
	}
	
	//sjekker at algoritmene sorter
	public static <T> String tabellenUtvalgSort(int c){
		Random tilfeldig = new Random();
		Integer[] tab = new Integer[c];
			for (int j = 0; j < tab.length; j++){
				tab[j] = tilfeldig.nextInt(10);
			}
			System.out.println(Arrays.toString(tab) + usortert);
			Sortering.utvalgsSortering(tab);
			return Arrays.toString(tab) + sortert;
	}
	
	public static <T> String tabellenInnsetningsSort(int c){
		Random tilfeldig = new Random();
		Integer[] tab = new Integer[c];
			for (int j = 0; j < tab.length; j++){
				tab[j] = tilfeldig.nextInt(10);
			}
			System.out.println(Arrays.toString(tab) + usortert);
			Sortering.sorteringVedInsetting(tab);
			return Arrays.toString(tab) + sortert;
	}
	public static <T> String tabellenBobblesort(int c){
		Random tilfeldig = new Random();
		Integer[] tab = new Integer[c];
			for (int j = 0; j < tab.length; j++){
				tab[j] = tilfeldig.nextInt(10);
			}
			System.out.println(Arrays.toString(tab) + usortert);
			Sortering.bobleSort(tab);
			return Arrays.toString(tab) + sortert;
	}
	public static <T> String tabellenBobblesortFlagg(int c){
		Random tilfeldig = new Random();
		Integer[] tab = new Integer[c];
			for (int j = 0; j < tab.length; j++){
				tab[j] = tilfeldig.nextInt(10);
			}
			System.out.println(Arrays.toString(tab) + usortert);
			Sortering.bobleSortFlagg(tab);
			return Arrays.toString(tab) + sortert;
	}
	
	public static <T> String tabellenKvikk(int c){
		Random tilfeldig = new Random();
		Integer[] tab = new Integer[c];
			for (int j = 0; j < tab.length; j++){
				tab[j] = tilfeldig.nextInt(10);
			}
			System.out.println(Arrays.toString(tab) + usortert);
			Sortering.kvikkSort(tab);
			return Arrays.toString(tab) + sortert;
	}
	public static <T> String tabellenFlette(int c) {
		
		Random tilfeldig = new Random();
		Integer[] tab = new Integer[c];
			for (int j = 0; j < tab.length; j++){
				tab[j] = tilfeldig.nextInt(10);
			}
			System.out.println(Arrays.toString(tab) + usortert);
			Sortering.fletteSort(tab);
			return Arrays.toString(tab) + sortert;
	}
	
	public static <T> String tabellenKvikkNy(int c, int MIN){
		
		Random tilfeldig = new Random();
		Integer[] tab = new Integer[c];
			for (int j = 0; j < tab.length; j++){
				tab[j] = tilfeldig.nextInt(10);
			}
			System.out.println(Arrays.toString(tab) + usortert);
			Sortering.kvikkSortNy(tab, MIN);
			return Arrays.toString(tab) + sortert;
	}
	
	//lager tabell for å måle tiden
	public static Integer[][] tabell(long c, int antall){
		
		Random tilfeldig = new Random();
		
		Integer[][] a = new Integer[antall][(int) c];
	
		for (int i = 0; i < antall; i++){
			for (int j = 0; j < c; j++){
				a[i][j] = tilfeldig.nextInt(antall);
				}
			}
		return a;
	}
	
	public static long tid(Integer[][] tab, int antall) {
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			
			Sortering.utvalgsSortering(tab[i]);
		}
		
		long endTime = System.currentTimeMillis();
		
		long tid= endTime-startTime;
		return tid/antall;
	}

	public static <T> long tid1(Integer[][] tab, int antall) {
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			
			Sortering.sorteringVedInsetting(tab[i]);
		}
		
		long endTime = System.currentTimeMillis();
		
		long tid= endTime-startTime;
		return tid/antall;
	}
	
	public static <T> long tid2(Integer[][] tab, int antall) {
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			
			Sortering.bobleSort(tab[i]);
		}
		
		long endTime = System.currentTimeMillis();
		
		long tid= endTime-startTime;
		return tid/antall;
	}
	
	public static <T> long tid3(Integer[][] tab, int antall) {
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			
			Sortering.bobleSortFlagg(tab[i]);
		}
		
		long endTime = System.currentTimeMillis();
		
		long tid= endTime-startTime;
		return tid/antall;
	}
	
	public static <T> long tid4(Integer[][] tab, int antall) {
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			
			Sortering.kvikkSort(tab[i]);
		}
		
		long endTime = System.currentTimeMillis();
		
		long tid= endTime-startTime;
		return tid/antall;
	}
	public static <T> long tid5(Integer[][] tab, int antall) {
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			
			Sortering.fletteSort(tab[i]);
		}
		
		long endTime = System.currentTimeMillis();
		
		long tid= endTime-startTime;
		return tid/antall;
	}
	
	public static <T> long tid6(Integer[][] tab, int antall, int MIN) {
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			
			Sortering.kvikkSortNy(tab[i], MIN);
		}
		
		long endTime = System.currentTimeMillis();
		
		long tid= endTime-startTime;
		return tid/antall;
	}
}
