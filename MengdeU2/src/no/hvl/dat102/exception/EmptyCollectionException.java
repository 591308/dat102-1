package no.hvl.dat102.exception;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen n�r samlingen er tom
//********************************************************************
@SuppressWarnings("serial")
public class EmptyCollectionException extends RuntimeException {
	/******************************************************************
	 * Setter opp et unntak med passende melding.
	 ******************************************************************/
	public EmptyCollectionException(String samling) {
		super("" + samling + " er tom.");
	}
}
