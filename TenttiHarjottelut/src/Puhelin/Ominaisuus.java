package Puhelin;

public class Ominaisuus {
	private String OminaisuusMuuttuja;

	public Ominaisuus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ominaisuus(String ominaisuusMuuttuja) {
		super();
		OminaisuusMuuttuja = ominaisuusMuuttuja;
	}

	public String getOminaisuusMuuttuja() {
		return OminaisuusMuuttuja;
	}

	public void setOminaisuusMuuttuja(String ominaisuusMuuttuja) {
		OminaisuusMuuttuja = ominaisuusMuuttuja;
	}

	@Override
	public String toString() {
		return "Ominaisuus [OminaisuusMuuttuja=" + OminaisuusMuuttuja + "]";
	}
	
	
}
