package tuntikoodeja;

public class PakettiAuto extends Auto implements Ovet {
	private int tilavuus;

	public PakettiAuto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PakettiAuto(String merkki, String malli) {
		super(merkki, malli);
		// TODO Auto-generated constructor stub
	}

	public PakettiAuto(int tilavuus) {
		super();
		this.tilavuus = tilavuus;
	}

	public int getTilavuus() {
		return tilavuus;
	}

	public void setTilavuus(int tilavuus) {
		this.tilavuus = tilavuus;
	}

	@Override
	public String toString() {
		return "PakettiAuto [tilavuus=" + tilavuus + ", getMerkki()="
				+ getMerkki() + ", getMalli()=" + getMalli() + "]";
	}

	@Override
	public int ovienLkm() {
		return 4;
	}
	
}
