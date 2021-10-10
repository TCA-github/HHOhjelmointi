package tuntikoodeja;

public class Auto {
	private String merkki, malli;

	public Auto() {
		super();		
	}

	public Auto(String merkki, String malli) {
		super();
		this.merkki = merkki;
		this.malli = malli;
	}

	public String getMerkki() {
		return merkki;
	}

	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}

	public String getMalli() {
		return malli;
	}

	public void setMalli(String malli) {
		this.malli = malli;
	}

	@Override
	public String toString() {
		return "Auto [merkki=" + merkki + ", malli=" + malli + "]";
	}
	
}
