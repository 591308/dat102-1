package Øving5Oppg1c;


public class SpillTårnIHanoi {
	public static void main(String[] args){
		//Max antall ringer for n antall forflytnigner er 31
		TårnIHanoi tårn = new TårnIHanoi(1);
		
		TårnIHanoi tårn1 = new TårnIHanoi(15);
		
		TårnIHanoi tårn2 = new TårnIHanoi(31);
		
		tårn.tid();
		
		tårn1.tid();
		
		tårn2.tid();
		
		}
}

