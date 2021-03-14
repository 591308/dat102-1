package Øving5Oppg4;

public class Sortering {

	/*************************************************************************************************/
	// Sorteringsalgoritmer
	/*************************************************************************************************/
	/**
	 * Utvalgssortering
	 * 
	 * @param data er data som skal sorteres
	 * @return 
	 */
	//public static int selectionSortComparisons;
	public static <T extends Comparable<T>> int utvalgsSortering(T[] data) {
		int minste;
		T temp;
		int count = 0;
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int sok = neste + 1; sok < data.length; sok++) {
				if (data[sok].compareTo(data[minste]) < 0) {
					minste = sok;
					count++;
				}
			}// indre for-l�kke
		/** Bytt verdiene 3 9 6 1 2 -> 1 | 9 6 3 2*/
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		} // ytre for-l�kke	
		
		return count;
	}// metode

	/**
	 * Sortering ved innsetting
	 * 
	 * @param data er data som skal sorteres
	 */
	public static<T extends Comparable<T>> int sorteringVedInsetting(T[] data) {
		
		int count = 0;
		
		for (int indeks = 1; indeks < data.length; indeks++) {
			T nokkel= data[indeks];
			int p = indeks;
			// Forskyv større verdier mot hoyre
			while(p > 0 && nokkel.compareTo(data[p-1]) < 0){
				data[p] = data[p-1];
				p--; 
				count++;
				counts++;
			} //3  9  6  1  2
			data[p] = nokkel;
			}//ytre
		return count;
		}
	/**
	 * 
	 * @param <T>  generisk type
	 * @param data er tabellen som skal sorteres
	 */
	public static <T extends Comparable<T>> int bobleSort(T[] data) {
		T temp;
		int count = 0;
		for (int p = data.length - 1; p >= 0; p--) {
			
			for (int sok = 0; sok <= p - 1; sok++) {
				
				if (data[sok].compareTo(data[sok + 1]) > 0) {
					/* Bytt verdiene */
					temp = data[sok];
					data[sok] = data[sok + 1];
					data[sok + 1] = temp;
					count++;
				}
			} // indre l�kke
		}  // ytre l�kke
		return count;
	}// metode

	public static <T extends Comparable<T>> int bobleSortFlagg(T[] data) {
		/*
		 * Sjekker om det ha v�rt ombyttinger i n�v�rende gjennoml�p. Dersom ingen
		 * ombyttinger s� avbrytes prosessen.
		 */
		int count = 0;
		
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
					count++;
				}
			} // indre l�kke
			fase++;
			
		} while (byttet); // ytre l�kke
		return count;
	}// metode
	
	static int counters;
	//Quick sort 
	public static <T extends Comparable<T>> int kvikkSort(T[] data) {
		counters=0;
		kvikkSort(data, 0, data.length -1);
		return counters;
	}
	
	private static <T extends Comparable<T>> void kvikkSort(T data[], int min, int maks) {
		
        if (min < maks) {
            int partIndeks = finnPart(data, min, maks);
            
            kvikkSort(data, min, partIndeks-1);
            kvikkSort(data, partIndeks+1, maks);
        }
		
	}    
    private static <T extends Comparable<T>> int finnPart(T data[], int min, int maks) {
        int pivot = maks;
        
        int i = (min-1);

        for (int j = min; j < maks; j++) {
        	
            if (data[j].compareTo(data[pivot]) <= 0) {
                i++;
                swap(data, i, j);
                counters++;
                
                counter++;
            }
        }
        swap(data, i+1, maks);
        
        return i+1;
    }

	private static <T> void swap(T[] data, int i, int j) {
		
		T temp = data[i];
		data[i]=data[j];
		data[j]=temp;
	}
    //mergesort
	static int counter=0;
	
	public static<T extends Comparable<T>> int fletteSort(T[] data) {
		
		 fletteSort(data, data.length);
		
		return counter;
		
	}
		 public static <T extends Comparable<T>> void fletteSort(T[] a, int n) {
			
	      if (n < 2) {
	        	return;
	        }
	        int mid = n / 2;
	        
	        T[] l = (T[]) new Comparable[mid];
	        T[] r = (T[]) new Comparable[n - mid];

	        for (int i = 0; i < mid; i++) {
	            l[i] = a[i];
	        }
	        for (int i = mid; i < n; i++) {
	            r[i - mid] = a[i];
	        }
	        
	        fletteSort(l, mid);
	        fletteSort(r, n - mid);
	        flette(a, l, r, mid, n - mid);
	        
	        
	    }

	    private static <T extends Comparable<T>> void flette(T[] a, T[] l, T[] r, int left, int right) {

	        int i = 0, j = 0, k = 0;
	        while (i < left && j < right) {
	            if (l[i].compareTo(r[j]) <= 0) {
	            	counter++;
	                a[k++] = l[i++];
	            } else {
	                a[k++] = r[j++];
	            }  
	        }
	        
	        while (i < left) {
	            a[k++] = l[i++];
	        }
	        while (j < right) {
	            a[k++] = r[j++];
	        }
	    }
	    
	    static int counts;
	    
	    public static<T extends Comparable<T>> int kvikkSortNy(T[] data, int MIN){
	    	
	    	counts=0;
	    	
	    	kvikkSortNy(data, 0, data.length -1, MIN);
	    	sorteringVedInsetting(data);
	    	
	    	return counts;
	    }
	    
	    private static <T extends Comparable<T>> void kvikkSortNy(T[] data, int min, int maks, int MIN) {
	    
	    	int posPartisjon;
	    	
	    	if (maks -min +1 > MIN) {//antall elementer > MIN ? 
	    		posPartisjon = finnPart(data, min, maks);
	    		
	    		kvikkSortNy(data, min, posPartisjon -1, MIN);
	    		kvikkSortNy(data, posPartisjon + 1, maks, MIN);  
	    		}
	    	}
	   	
}

