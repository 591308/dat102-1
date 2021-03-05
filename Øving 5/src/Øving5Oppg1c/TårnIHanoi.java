package Øving5Oppg1c;

public class TårnIHanoi{

	private int antallRinger;
	private int kort = 0;
	
	//sette opp spillet med spesifisert antall ringer
	public TårnIHanoi(int startRinger){
		antallRinger = startRinger;
	}
	//utfører det første kallet til flyttingen
	//Flytter ringene fra tårn 1 til tårn 3ved å bruke tårn 2.
	public void spill() {
		
		flyttRinger(antallRinger, 1, 3, 2);
//		System.out.println("Antall ganger køyrt: " + kort);
		System.out.println("Antall gonger køyrt: " + antallFlyttinger(antallRinger));
		
		
	}
	private void flyttRinger(int antRinger,int start, int slutt, int temp){
		
		if(antRinger== 1){// Basistilfellet
			
			flyttEnRing(start, slutt);
			
		} else{//Rolleskifte fra, til, mellom, 
			
			flyttRinger(antRinger-1, start, temp, slutt);
			flyttEnRing(start, slutt);
			flyttRinger(antRinger-1, temp, slutt, start);
			}
		}
	
	//Skriver ut mellomresultatene ved flytting.
	 private void flyttEnRing(int start, int slutt){
		 kort++;
	 }
	
	 @SuppressWarnings("unused")
//	private void SkrivUtAntalFlytninger(int startRinger) {
//		 System.out.println("Antall flyttninger" + antallRinger + antallFlyttinger(antallRinger));
//	 }

	public void tid() {
		long startTime = System.currentTimeMillis();
		
		spill();
		
		long endTime = System.currentTimeMillis();

		System.out.println("Tiden det tok for " + antallRinger + " ringer er " + (endTime-startTime) + " milliseconds");
	}
	 
	private static int antallFlyttinger(int n){
		 
		 if(n==1) {
			 return 1;
		 } else {
			 return 2*antallFlyttinger(n-1)+1;
		 }
		 
	 }
	
}