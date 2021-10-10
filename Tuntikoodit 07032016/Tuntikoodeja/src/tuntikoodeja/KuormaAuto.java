package tuntikoodeja;

public class KuormaAuto extends Auto implements Ovet {
	private int kantavuus;

	public KuormaAuto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KuormaAuto(String merkki, String malli) {
		super(merkki, malli);
		// TODO Auto-generated constructor stub
	}

	public int getKantavuus() {
		return kantavuus;
	}

	public void setKantavuus(int kantavuus) {
		this.kantavuus = kantavuus;
	}

	@Override
	public String toString() {
		return "KuormaAuto [kantavuus=" + kantavuus + ", getMerkki()="
				+ getMerkki() + ", getMalli()=" + getMalli() + "]";
	}

	@Override
	public int ovienLkm() {
		return 3;
	}
	
}
