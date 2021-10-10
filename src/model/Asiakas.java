package model;

public class Asiakas {
	private int asiakas_id, status;
	private String etunimi, sukunimi, katuosoite, postinumero;
	private String sahkoposti, salasana, puhelin, lisatietoja;
	public Asiakas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Asiakas(int asiakas_id, int status, String etunimi, String sukunimi,
			String katuosoite, String postinumero, String sahkoposti,
			String salasana, String puhelin, String lisatietoja) {
		super();
		this.asiakas_id = asiakas_id;
		this.status = status;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.katuosoite = katuosoite;
		this.postinumero = postinumero;
		this.sahkoposti = sahkoposti;
		this.salasana = salasana;
		this.puhelin = puhelin;
		this.lisatietoja = lisatietoja;
	}
	public int getAsiakas_id() {
		return asiakas_id;
	}
	public void setAsiakas_id(int asiakas_id) {
		this.asiakas_id = asiakas_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getKatuosoite() {
		return katuosoite;
	}
	public void setKatuosoite(String katuosoite) {
		this.katuosoite = katuosoite;
	}
	public String getPostinumero() {
		return postinumero;
	}
	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}
	public String getSahkoposti() {
		return sahkoposti;
	}
	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}
	public String getSalasana() {
		return salasana;
	}
	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}
	public String getPuhelin() {
		return puhelin;
	}
	public void setPuhelin(String puhelin) {
		this.puhelin = puhelin;
	}
	public String getLisatietoja() {
		return lisatietoja;
	}
	public void setLisatietoja(String lisatietoja) {
		this.lisatietoja = lisatietoja;
	}
	@Override
	public String toString() {
		return "Asiakas [asiakas_id=" + asiakas_id + ", status=" + status
				+ ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", katuosoite=" + katuosoite + ", postinumero=" + postinumero
				+ ", sahkoposti=" + sahkoposti + ", salasana=" + salasana
				+ ", puhelin=" + puhelin + ", lisatietoja=" + lisatietoja + "]";
	}
	
}
