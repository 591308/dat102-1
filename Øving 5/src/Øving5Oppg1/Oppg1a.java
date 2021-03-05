package Øving5Oppg1;

import java.util.Scanner;

public class Oppg1a {
		
	public static void main(String[] args) {
		
		System.out.println("Oppgi et positivt tall: ");
		Scanner inn = new Scanner(System.in);
		int in = inn.nextInt();
		
		System.out.println("Sum av n første naturlige tall: " + sum(in));

		inn.close();
	}
	
	//Lage program for å summere n naturlege tall
		public static int sum(int n) {
			return n == 1 ? n : n + sum(n-1);
		}

}
