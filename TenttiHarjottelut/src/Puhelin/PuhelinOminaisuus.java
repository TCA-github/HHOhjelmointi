package Puhelin;

import java.util.ArrayList;

public class PuhelinOminaisuus extends puhelin {
	private ArrayList<String> ominaisuus = new ArrayList<String>();

	public PuhelinOminaisuus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PuhelinOminaisuus(String merkki, String malli) {
		super(merkki, malli);
		// TODO Auto-generated constructor stub
	}

	public PuhelinOminaisuus(ArrayList<String> ominaisuus) {
		super();
		this.ominaisuus = ominaisuus;
	}

	public ArrayList<String> getOminaisuus() {
		return ominaisuus;
	}

	public void setOminaisuus(ArrayList<String> ominaisuus) {
		this.ominaisuus = ominaisuus;
	}

	@Override
	public String toString() {
		return "PuhelinOminaisuus [ominaisuus=" + ominaisuus + ", getMerkki()=" + getMerkki() + ", getMalli()="
				+ getMalli() + "]";
	}
	
	
}
