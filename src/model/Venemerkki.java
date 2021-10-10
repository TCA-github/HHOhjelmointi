package model;

public class Venemerkki {
	private int VMerkki_id;
	private String VMerkki;
	public Venemerkki() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Venemerkki(int vMerkki_id, String vMerkki) {
		super();
		VMerkki_id = vMerkki_id;
		VMerkki = vMerkki;
	}
	public int getVMerkki_id() {
		return VMerkki_id;
	}
	public void setVMerkki_id(int vMerkki_id) {
		VMerkki_id = vMerkki_id;
	}
	public String getVMerkki() {
		return VMerkki;
	}
	public void setVMerkki(String vMerkki) {
		VMerkki = vMerkki;
	}
	@Override
	public String toString() {
		return "Venemerkit [VMerkki_id=" + VMerkki_id + ", VMerkki=" + VMerkki
				+ "]";
	}
	
}
