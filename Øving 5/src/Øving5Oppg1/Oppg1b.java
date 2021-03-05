package Øving5Oppg1;

import java.util.Scanner;

public class Oppg1b {

	public static void main(String[] args) {
		
		System.out.println("Oppgi et positivt tall: ");
		Scanner inn = new Scanner(System.in);
		int in = inn.nextInt();
		for(int i = 0; i <= in; i++) {
			System.out.println("Summen av tallet: " + i);
			System.out.println("Tallføgljen: " + skriv10Forstetall(i));
		}
		
		inn.close();
	}
	public static int skriv10Forstetall(int tall) {
		
		if(tall==0) return 2;
		if(tall==1) return 5;
		return skriv10Forstetall(tall-1)*5-skriv10Forstetall(tall-2)*6 + 2;
		
	}
}
