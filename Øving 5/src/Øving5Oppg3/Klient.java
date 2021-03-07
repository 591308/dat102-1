package Øving5Oppg3;

import java.util.Scanner;

public class Klient {
	public static void main(String[] args) {
		
		//2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30, 31
		Integer[] tall = {2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30, 31};
		
		
		System.out.println("Originale data ");
		for (int i = 0; i < tall.length; i++) {
			
			System.out.print(tall[i] + " ");
		}
	
		System.out.println("\nSkriv inn tall du vil finne");
		Scanner in = new Scanner(System.in);
		int inn = in.nextInt();
		
		System.out.println("Binaersøk av tallet: " + Binærsøk.binaerSoek(tall, 0, tall.length-1, inn));
		
		
		in.close();
		
	}
}
