package Puhelin;

import java.util.ArrayList;

public class puhelin {
	private String merkki,malli;
	private double hinta;

	public puhelin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public puhelin(String merkki, String malli) {
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


	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	@Override
	public String toString() {
		return "puhelin:" + merkki + " " +  malli + ", hinta " + hinta;
	}
	
	public String toCSV(String separator){
		return merkki + separator + malli;
	}

}
