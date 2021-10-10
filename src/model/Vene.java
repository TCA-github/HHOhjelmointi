package model;

import java.util.Date;

public class Vene {
	private int vene_id, malli_id, merkki_id, vuosimalli, ostohinta, hintapyynto, tiukkahinta, omistaja, valitysvene;
	private String kuvaus, lisatietoja, malli, merkki;
	private Date tulopaiva;
	public Vene() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vene(int vene_id, int malli_id, int vuosimalli, int ostohinta,
			int hintapyynto, int tiukkahinta, int omistaja, int valitysvene,
			String kuvaus, String lisatietoja, Date tulopaiva) {
		super();
		this.vene_id = vene_id;
		this.malli_id = malli_id;
		this.vuosimalli = vuosimalli;
		this.ostohinta = ostohinta;
		this.hintapyynto = hintapyynto;
		this.tiukkahinta = tiukkahinta;
		this.omistaja = omistaja;
		this.valitysvene = valitysvene;
		this.kuvaus = kuvaus;
		this.lisatietoja = lisatietoja;
		this.tulopaiva = tulopaiva;
	}
	public int getVene_id() {
		return vene_id;
	}
	public void setVene_id(int vene_id) {
		this.vene_id = vene_id;
	}
	public int getMalli_id() {
		return malli_id;
	}
	public void setMalli_id(int malli_id) {
		this.malli_id = malli_id;
	}
	public int getVuosimalli() {
		return vuosimalli;
	}
	public void setVuosimalli(int vuosimalli) {
		this.vuosimalli = vuosimalli;
	}
	public int getOstohinta() {
		return ostohinta;
	}
	public void setOstohinta(int ostohinta) {
		this.ostohinta = ostohinta;
	}
	public int getHintapyynto() {
		return hintapyynto;
	}
	public void setHintapyynto(int hintapyynto) {
		this.hintapyynto = hintapyynto;
	}
	public int getTiukkahinta() {
		return tiukkahinta;
	}
	public void setTiukkahinta(int tiukkahinta) {
		this.tiukkahinta = tiukkahinta;
	}
	public int getOmistaja() {
		return omistaja;
	}
	public void setOmistaja(int omistaja) {
		this.omistaja = omistaja;
	}
	public int getValitysvene() {
		return valitysvene;
	}
	public void setValitysvene(int valitysvene) {
		this.valitysvene = valitysvene;
	}
	public String getKuvaus() {
		return kuvaus;
	}
	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	public String getLisatietoja() {
		return lisatietoja;
	}
	public void setLisatietoja(String lisatietoja) {
		this.lisatietoja = lisatietoja;
	}
	public Date getTulopaiva() {
		return tulopaiva;
	}
	public void setTulopaiva(Date tulopaiva) {
		this.tulopaiva = tulopaiva;
	}
	
	public String getMalli() {
		return malli;
	}
	public void setMalli(String malli) {
		this.malli = malli;
	}
	public String getMerkki() {
		return merkki;
	}
	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}
	public int getMerkki_id() {
		return merkki_id;
	}
	public void setMerkki_id(int merkki_id) {
		this.merkki_id = merkki_id;
	}
	@Override
	public String toString() {
		return "Vene [vene_id=" + vene_id + ", malli_id=" + malli_id
				+ ", merkki_id=" + merkki_id + ", vuosimalli=" + vuosimalli
				+ ", ostohinta=" + ostohinta + ", hintapyynto=" + hintapyynto
				+ ", tiukkahinta=" + tiukkahinta + ", omistaja=" + omistaja
				+ ", valitysvene=" + valitysvene + ", kuvaus=" + kuvaus
				+ ", lisatietoja=" + lisatietoja + ", malli=" + malli
				+ ", merkki=" + merkki + ", tulopaiva=" + tulopaiva + "]";
	}
	
	
}
