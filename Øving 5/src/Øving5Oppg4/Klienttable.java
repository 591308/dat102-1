package Øving5Oppg4;
import java.util.Random;


public class Klienttable {
    
	public static void main(String[] args) {
		//1600
		long c = 16000;
		
		int n = 500;
		int n1= 1300;
		int n2= 15133;
		int antall = 10;
		
		KonsollTabell st = new KonsollTabell();
		
		double teoretiskTid = (double)(tid(tabell(c, antall), antall)/Math.pow(c, 2));
		double teoretiskTid1 = (double)(tid1(tabell(c, antall), antall)/Math.pow(c, 2));
		double teoretiskTid2 = (double)(tid2(tabell(c, antall), antall)/Math.pow(c, 2));
		//teoretisk tid 9.00390625*10^(-6) miliseconds
		
		System.out.println("Resultat av utvalgsortering: ");
		st.setShowVerticalLines(true);
		st.setHeaders("n", "Antall målinger", "Målt tid (Gjennomsnitt)", "Teoretisk tid c*n^2");
		st.addRow(String.valueOf(n), String.valueOf(Sortering.selectionSortComparisons), String.valueOf(tid(tabell(n, antall), antall)), String.valueOf(Math.round(teoretiskTid*(Math.pow(n,2)))));
		st.addRow(String.valueOf(n1), String.valueOf(Sortering.selectionSortComparisons), String.valueOf(tid(tabell(n1, antall), antall)), String.valueOf(Math.round(teoretiskTid*(Math.pow(n1,2)))));
		st.addRow(String.valueOf(n2), String.valueOf(Sortering.selectionSortComparisons), String.valueOf(tid(tabell(n2, antall), antall)), String.valueOf(Math.round(teoretiskTid*(Math.pow(n2, 2)))));
		st.print();
		
		KonsollTabell st1 = new KonsollTabell();
		
		System.out.println("Resultat av sorteringvedInnsetting: ");
		st1.setShowVerticalLines(true);
		st1.setHeaders("n", "Antall målinger", "Målt tid (Gjennomsnitt)", "Teoretisk tid c*n^2");
		st1.addRow(String.valueOf(n), String.valueOf(Sortering.insertionSortComparisons), String.valueOf(tid1(tabell(n, antall), antall)), String.valueOf(Math.round(teoretiskTid1*(Math.pow(n,2)))));
		st1.addRow(String.valueOf(n1), String.valueOf(Sortering.insertionSortComparisons), String.valueOf(tid1(tabell(n1, antall), antall)), String.valueOf(Math.round(teoretiskTid1*(Math.pow(n1,2)))));
		st1.addRow(String.valueOf(n2), String.valueOf(Sortering.insertionSortComparisons), String.valueOf(tid1(tabell(n2, antall), antall)), String.valueOf(Math.round(teoretiskTid1*(Math.pow(n2,2)))));
		st1.print();

		KonsollTabell st2 = new KonsollTabell();
		
		System.out.println("Resultat av bobble sortering: ");
		
		st2.setShowVerticalLines(true);
		st2.setHeaders("n", "Antall målinger", "Målt tid (Gjennomsnitt)", "Teoretisk tid c*n^2");
		st2.addRow(String.valueOf(n), String.valueOf(Sortering.bubbleSortComparisons), String.valueOf(tid2(tabell(n, antall), antall)), String.valueOf(Math.round(teoretiskTid2*(Math.pow(n,2)))));
		st2.addRow(String.valueOf(n1), String.valueOf(Sortering.bubbleSortComparisons), String.valueOf(tid2(tabell(n1, antall), antall)), String.valueOf(Math.round(teoretiskTid2*(Math.pow(n1,2)))));
		st2.addRow(String.valueOf(n2), String.valueOf(Sortering.bubbleSortComparisons), String.valueOf(tid2(tabell(n2, antall), antall)), String.valueOf(Math.round(teoretiskTid2*(Math.pow(n2,2)))));
		st2.print();
		
	}
	
	public static <T> Integer[][] tabell(long c, int antall){
		
		Random tilfeldig = new Random();
		
		Integer[][] a = new Integer[antall][(int) c];
	
		for (int i = 0; i < antall; i++){
			for (int j = 0; j < c; j++){
				a[i][j] = tilfeldig.nextInt();
				}
			}
		return a;
	}
	
	public static <T> long tid(Integer[][] tab, int antall) {
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			
			Sortering.utvalgsSortering(tab[i]);
		}
		
		long endTime = System.currentTimeMillis();
		
		long tid= endTime-startTime;
		return tid;
	}

	public static <T> long tid1(Integer[][] tab, int antall) {
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			
			Sortering.sorteringVedInsetting(tab[i]);
		}
		
		long endTime = System.currentTimeMillis();
		
		long tid= endTime-startTime;
		return tid;
	}
	
	public static <T> long tid2(Integer[][] tab, int antall) {
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			
			Sortering.bobleSort(tab[i]);
		}
		
		long endTime = System.currentTimeMillis();
		
		long tid= endTime-startTime;
		return tid;
	}
}
