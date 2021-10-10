package model;

import java.util.Date;

public class Tarjous {
	private int tarjous_id, vene_id, asiakas_id, tarjous;
	private Date voimassapaiva, myyntipaiva, aikaleima;
	public Tarjous() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tarjous(int tarjous_id, int vene_id, int asiakas_id, int tarjous,
			Date voimassapaiva, Date myyntipaiva, Date aikaleima) {
		super();
		this.tarjous_id = tarjous_id;
		this.vene_id = vene_id;
		this.asiakas_id = asiakas_id;
		this.tarjous = tarjous;
		this.voimassapaiva = voimassapaiva;
		this.myyntipaiva = myyntipaiva;
		this.aikaleima = aikaleima;
	}
	public int getTarjous_id() {
		return tarjous_id;
	}
	public void setTarjous_id(int tarjous_id) {
		this.tarjous_id = tarjous_id;
	}
	public int getVene_id() {
		return vene_id;
	}
	public void setVene_id(int vene_id) {
		this.vene_id = vene_id;
	}
	public int getAsiakas_id() {
		return asiakas_id;
	}
	public void setAsiakas_id(int asiakas_id) {
		this.asiakas_id = asiakas_id;
	}
	public int getTarjous() {
		return tarjous;
	}
	public void setTarjous(int tarjous) {
		this.tarjous = tarjous;
	}
	public Date getVoimassapaiva() {
		return voimassapaiva;
	}
	public void setVoimassapaiva(Date voimassapaiva) {
		this.voimassapaiva = voimassapaiva;
	}
	public Date getMyyntipaiva() {
		return myyntipaiva;
	}
	public void setMyyntipaiva(Date myyntipaiva) {
		this.myyntipaiva = myyntipaiva;
	}
	public Date getAikaleima() {
		return aikaleima;
	}
	public void setAikaleima(Date aikaleima) {
		this.aikaleima = aikaleima;
	}
	@Override
	public String toString() {
		return "Tarjous [tarjous_id=" + tarjous_id + ", vene_id=" + vene_id
				+ ", asiakas_id=" + asiakas_id + ", tarjous=" + tarjous
				+ ", voimassapaiva=" + voimassapaiva + ", myyntipaiva="
				+ myyntipaiva + ", aikaleima=" + aikaleima + "]";
	}
	
	
}
