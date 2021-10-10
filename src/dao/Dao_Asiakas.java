package dao;

import java.util.ArrayList;

import model.Asiakas;

public class Dao_Asiakas extends Dao {
	
	public boolean lisaaAsiakas(Asiakas asiakas){
		boolean paluuArvo=true;
		sql="INSERT INTO VV_Asiakkaat(Etunimi, Sukunimi, Katuosoite, Postinumero, Sahkoposti, Salasana, Puhelin, Lisatietoja, Status) VALUES(?,?,?,?,?,?,?,?,?)";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, asiakas.getEtunimi());
			stmtPrep.setString(2, asiakas.getSukunimi());
			stmtPrep.setString(3, asiakas.getKatuosoite());
			stmtPrep.setString(4, asiakas.getPostinumero());
			stmtPrep.setString(5, asiakas.getSahkoposti());
			stmtPrep.setString(6, asiakas.getSalasana());
			stmtPrep.setString(7, asiakas.getPuhelin());
			stmtPrep.setString(8, asiakas.getLisatietoja());
			stmtPrep.setString(9, "1");
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	public boolean muutaAsiakas(Asiakas asiakas){
		boolean paluuArvo=true;
		sql="UPDATE VV_Asiakkaat SET Etunimi=?, Sukunimi=?, Katuosoite=?, Postinumero=?, Sahkoposti=?, Salasana=?, Puhelin=?, Lisatietoja=?, Status=? WHERE Asiakas_id=?";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, asiakas.getEtunimi());
			stmtPrep.setString(2, asiakas.getSukunimi());
			stmtPrep.setString(3, asiakas.getKatuosoite());
			stmtPrep.setString(4, asiakas.getPostinumero());
			stmtPrep.setString(5, asiakas.getSahkoposti());
			stmtPrep.setString(6, asiakas.getSalasana());
			stmtPrep.setString(7, asiakas.getPuhelin());
			stmtPrep.setString(8, asiakas.getLisatietoja());
			stmtPrep.setString(9, "1");
			stmtPrep.setInt(10, asiakas.getAsiakas_id());
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	public ArrayList<Asiakas> haeAsiakkaat(String hakusana) throws Exception{		
		ArrayList<Asiakas> asiakkaat = new ArrayList<Asiakas>();
		sql = "SELECT * FROM VV_Asiakkaat WHERE (Etunimi LIKE ? OR Sukunimi LIKE ?) AND Poistettu=0"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, "%"+hakusana+"%");
			stmtPrep.setString(2, "%"+hakusana+"%");
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					Asiakas asiakas = new Asiakas();
					asiakas.setAsiakas_id(rs.getInt("Asiakas_id"));
					asiakas.setEtunimi(rs.getString("Etunimi"));
					asiakas.setSukunimi(rs.getString("Sukunimi"));
					asiakas.setKatuosoite(rs.getString("Katuosoite"));
					asiakas.setPostinumero(rs.getString("Postinumero"));
					asiakas.setSahkoposti(rs.getString("Sahkoposti"));
					asiakas.setPuhelin(rs.getString("Puhelin"));
					asiakas.setLisatietoja(rs.getString("Lisatietoja"));
					asiakkaat.add(asiakas);
				}					
			}
			con.close();
		}			
		return asiakkaat;
	}
	
	public Asiakas haeAsiakas(int asiakas_id) throws Exception{
		Asiakas asiakas=null;		
		sql = "SELECT * FROM VV_Asiakkaat WHERE Asiakas_id=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, asiakas_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					asiakas = new Asiakas();
					asiakas.setAsiakas_id(rs.getInt("Asiakas_id"));
					asiakas.setEtunimi(rs.getString("Etunimi"));
					asiakas.setSukunimi(rs.getString("Sukunimi"));
					asiakas.setKatuosoite(rs.getString("Katuosoite"));
					asiakas.setPostinumero(rs.getString("Postinumero"));
					asiakas.setSahkoposti(rs.getString("Sahkoposti"));
					asiakas.setSalasana(rs.getString("Salasana"));
					asiakas.setPuhelin(rs.getString("Puhelin"));
					asiakas.setLisatietoja(rs.getString("Lisatietoja"));
				}					
			}
			con.close();
		}			
		return asiakas;
	}
	
	public Asiakas haeAsiakas(String email, String pwd) throws Exception{
		Asiakas asiakas=null;		
		sql = "SELECT * FROM VV_Asiakkaat WHERE Sahkoposti=? AND Salasana=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, email);	
			stmtPrep.setString(2, pwd);	
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					asiakas = new Asiakas();
					asiakas.setAsiakas_id(rs.getInt("Asiakas_id"));
					asiakas.setEtunimi(rs.getString("Etunimi"));
					asiakas.setSukunimi(rs.getString("Sukunimi"));
					asiakas.setKatuosoite(rs.getString("Katuosoite"));
					asiakas.setPostinumero(rs.getString("Postinumero"));
					asiakas.setSahkoposti(rs.getString("Sahkoposti"));
					asiakas.setSalasana(rs.getString("Salasana"));
					asiakas.setPuhelin(rs.getString("Puhelin"));
					asiakas.setLisatietoja(rs.getString("Lisatietoja"));
				}					
			}
			con.close();
		}			
		return asiakas;
	}
	
	public void poistaAsiakas(int Asiakas_id) throws Exception{		
		sql = "UPDATE VV_Asiakkaat SET Poistettu=1 WHERE Asiakas_id=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, Asiakas_id);			
			stmtPrep.executeUpdate();			
			con.close();
		}		
	}
}
