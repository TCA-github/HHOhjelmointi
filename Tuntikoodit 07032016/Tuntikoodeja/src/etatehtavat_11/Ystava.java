package etatehtavat_11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ystava {
	private String lempinimi, nimi, puhelin;
	private Date syntymaPaiva;
	public Ystava() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ystava(String lempinimi, String nimi, String puhelin,
			Date syntymaPaiva) {
		super();
		this.lempinimi = lempinimi;
		this.nimi = nimi;
		this.puhelin = puhelin;
		this.syntymaPaiva = syntymaPaiva;
	}
	public String getLempinimi() {
		return lempinimi;
	}
	public void setLempinimi(String lempinimi) {
		this.lempinimi = lempinimi;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getPuhelin() {
		return puhelin;
	}
	public void setPuhelin(String puhelin) {
		this.puhelin = puhelin;
	}
	public Date getSyntymaPaiva() {
		return syntymaPaiva;
	}
	public void setSyntymaPaiva(Date syntymaPaiva) {
		this.syntymaPaiva = syntymaPaiva;
	}
	@Override
	public String toString() {
		SimpleDateFormat fdate=new SimpleDateFormat("dd.MM.yyyy");		
		return "lempinimi=" + lempinimi + ", nimi=" + nimi
				+ ", puhelin=" + puhelin + ", syntpvm=" + fdate.format(syntymaPaiva);
	}
	
}









