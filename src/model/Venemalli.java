package model;

public class Venemalli {
	private int malli_id, merkki_id, paino, tyyppi_id;
	private String malli;
	private double pituus, leveys;
	public Venemalli() {
		super();		
	}
	public Venemalli(int malli_id, int merkki_id, int paino, int tyyppi_id,
			String malli, String tyyppi, String vmerkki, double pituus,
			double leveys) {
		super();
		this.malli_id = malli_id;
		this.merkki_id = merkki_id;
		this.paino = paino;
		this.tyyppi_id = tyyppi_id;
		this.malli = malli;		
		this.pituus = pituus;
		this.leveys = leveys;
	}
	public int getMalli_id() {
		return malli_id;
	}
	public void setMalli_id(int malli_id) {
		this.malli_id = malli_id;
	}
	public int getMerkki_id() {
		return merkki_id;
	}
	public void setMerkki_id(int merkki_id) {
		this.merkki_id = merkki_id;
	}
	public int getPaino() {
		return paino;
	}
	public void setPaino(int paino) {
		this.paino = paino;
	}
	public int getTyyppi_id() {
		return tyyppi_id;
	}
	public void setTyyppi_id(int tyyppi_id) {
		this.tyyppi_id = tyyppi_id;
	}
	public String getMalli() {
		return malli;
	}
	public void setMalli(String malli) {
		this.malli = malli;
	}	
	public double getPituus() {
		return pituus;
	}
	public void setPituus(double pituus) {
		this.pituus = pituus;
	}
	public double getLeveys() {
		return leveys;
	}
	public void setLeveys(double leveys) {
		this.leveys = leveys;
	}
	@Override
	public String toString() {
		return "Venemalli [malli_id=" + malli_id + ", merkki_id=" + merkki_id
				+ ", paino=" + paino + ", tyyppi_id=" + tyyppi_id + ", malli="
				+ malli + ", pituus=" + pituus + ", leveys=" + leveys + "]";
	}
	
	
}
