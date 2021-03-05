package no.hvl.dat102.filmarkiv;

public class Film {

	private int filmnr;
	private String produsent;
	private String tittel;
	private int lanseringsAar;
	private Sjanger sjanger;
	private String Filmselskap;

	public Film() {
	}

	public Film(int Filmnr, String produsent, String tittel, int lanseringsAar, Sjanger sjanger, String filmSelskap) {
		this.filmnr = Filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsAar = lanseringsAar;
		this.sjanger = sjanger;
		this.Filmselskap = filmSelskap;
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanseringsAar() {
		return lanseringsAar;
	}

	public void setLanseringsAar(int lanseringsAar) {
		this.lanseringsAar = lanseringsAar;
	}

	public String getFilmselskap() {
		return Filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		Filmselskap = filmselskap;
	}

	public String tilStreng() {
		return "Film \n" + "Filmnr = " + filmnr + "\n" + "Produsent = " + produsent + "\n" + "Tittel = " + tittel + "\n"
				+ "LanseringsÅr = " + lanseringsAar + "\n" + "Sjanger = " + sjanger + "\n" + "Filmselskap = "
				+ Filmselskap + "\n";
	}

}
