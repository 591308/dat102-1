package Øving5Oppg4;

public class Sortering {
	/*************************************************************************************************/
	// Sorteringsalgoritmer
	/*************************************************************************************************/
	/**
	 * Utvalgssortering
	 * 
	 * @param data er data som skal sorteres
	 */
	public static int selectionSortComparisons;
	public static int insertionSortComparisons;
	public static int bubbleSortComparisons;
	public static int quickSortComparisons;
	public static int mergeSortComparisons;
	
	public static <T extends Comparable<T>> void utvalgsSortering(T[] data) {
		int minste;
		T temp;
	
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			
			for (int sok = neste + 1; sok < data.length; sok++) {
				if (data[sok].compareTo(data[minste]) < 0) {
					minste = sok;
					selectionSortComparisons++;
				}
			} // indre for-l�kke
			/** Bytt verdiene 3 9 6 1 2 -> 1 | 9 6 3 2*/
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		} // ytre for-l�kke	
	}// metode

	/**
	 * Sortering ved innsetting
	 * 
	 * @param data er data som skal sorteres
	 */
	public static<T extends Comparable<T>> void sorteringVedInsetting(T[] data) {
		
		for (int indeks = 1; indeks < data.length; indeks++) {
			T nokkel= data[indeks];
			int p = indeks;
			
			// Forskyv større verdier mot hoyre
			while(p > 0 && nokkel.compareTo(data[p-1]) >= 0){
				data[p] = data[p-1];
				p--; 
				
			} //3  9  6  1  2
			data[p] = nokkel;
			insertionSortComparisons++;
			}//ytre}
		}
	
	/**
	 * 
	 * @param <T>  generisk type
	 * @param data er tabellen som skal sorteres
	 */
	public static <T extends Comparable<T>> void bobleSort(T[] data) {
		T temp;
		for (int p = data.length - 1; p >= 0; p--) {
			
			for (int sok = 0; sok <= p - 1; sok++) {
				
				if (data[sok].compareTo(data[sok + 1]) > 0) {
					/* Bytt verdiene */
					temp = data[sok];
					data[sok] = data[sok + 1];
					data[sok + 1] = temp;
					
				}
			} bubbleSortComparisons++;// indre l�kke
		}  // ytre l�kke

	}// metode

	public static <T extends Comparable<T>> void bobleSortFlagg(T[] data) {
		/*
		 * Sjekker om det ha v�rt ombyttinger i n�v�rende gjennoml�p. Dersom ingen
		 * ombyttinger s� avbrytes prosessen.
		 */
		T temp = null;
		int fase = 1;
		boolean byttet = false;
		do {
			byttet = false;
			for (int i = 0; i < data.length - fase; i++) {
				if (data[i].compareTo(data[i + 1]) > 0) {
					/* Bytt verdiene */
					temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					byttet = true;
				}
			} // indre l�kke
			fase++;

		} while (byttet); // ytre l�kke

	}// metode
	
//	//Quick sort 
//	public static <T extends Comparable<T>> void kvikkSortNy(T[] data, int min, int maks) {
//		final int MIN = 10;
//		int posPartisjon;
//		if (maks -min +1 > MIN) {
//			//antall elementer > MIN ? 
//			posPartisjon = finnPartisjon(data, min, maks);
//			kvikkSortNy(data, min, posPartisjon -1);
//			kvikkSortNy(data, posPartisjon + 1, maks);  
//			}
//		}	
//	private static <T extends Comparable<T>> int finnPartisjon(T[] data, int min, int maks) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public static <T extends Comparable<T>> void kvikkSortNy(T[] data) {
//		kvikkSortNy(data, 0, data.length -1);
//		sorteringVedInnsetting(data);
//		}

}
