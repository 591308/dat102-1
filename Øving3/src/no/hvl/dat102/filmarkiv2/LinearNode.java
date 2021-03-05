package no.hvl.dat102.filmarkiv2;

public class LinearNode<T> {

		private LinearNode<T> neste;
		private T element;
		
		//Oppretter en tom node
		public LinearNode() {
			neste   =  null;
			element = null;
		}
		//Oppretter en node med et element
		public LinearNode(T elem){
			neste   = null;
			element = elem;
		} 
		//returnerer etterfulger
		public LinearNode<T> getNeste(){
			return neste;
		} 
		//setter neste til node
		public void setNeste(LinearNode<T> node){
			neste = node;
		}
		//returnerer element til denne noden
		public T getElement(){
			return element;
		}
		//setter ny element i denne noden
		public void setElement(T elem){
			element = elem;
		}
}
