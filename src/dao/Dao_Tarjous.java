package dao;

import java.util.ArrayList;

import model.Asiakas;
import model.Tarjous;

public class Dao_Tarjous extends Dao {
	
	public boolean lisaaTarjous(Tarjous tarjous){
		boolean paluuArvo=true;		
		sql="INSERT INTO VV_Tarjoukset(Vene_id, Asiakas_id, Tarjous, VoimPvm) VALUES(?,?,?,?);";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setInt(1, tarjous.getVene_id());
			stmtPrep.setInt(2, tarjous.getAsiakas_id());
			stmtPrep.setInt(3, tarjous.getTarjous());			
			stmtPrep.setDate(4, new java.sql.Date(tarjous.getVoimassapaiva().getTime()));				
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	public ArrayList<Tarjous> haeTarjoukset(int vene_id) throws Exception{		
		ArrayList<Tarjous> tarjoukset = new ArrayList<Tarjous>();
		sql = "SELECT * FROM VV_Tarjoukset WHERE Vene_id=? ORDER BY Tarjous DESC"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, vene_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					Tarjous tarjous = new Tarjous();
					tarjous.setTarjous_id(rs.getInt("Tarjous_id"));
					tarjous.setVene_id(rs.getInt("Vene_id"));
					tarjous.setAsiakas_id(rs.getInt("Asiakas_id"));
					tarjous.setTarjous(rs.getInt("Tarjous"));
					tarjous.setVoimassapaiva(rs.getDate("VoimPvm"));
					tarjous.setMyyntipaiva(rs.getDate("MyyntiPvm"));
					tarjous.setAikaleima(rs.getDate("Aikaleima"));
					tarjoukset.add(tarjous);
				}					
			}
			con.close();
		}			
		return tarjoukset;
	}
	
	public Asiakas etsiAsiakas(int tarjous_id)throws Exception{		
		Asiakas asiakas = null;
		sql= "SELECT * FROM VV_Tarjoukset, VV_Asiakkaat WHERE VV_Tarjoukset.Asiakas_id=VV_Asiakkaat.Asiakas_id AND Tarjous_id=?";			
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, tarjous_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					asiakas = new Asiakas();
					asiakas.setAsiakas_id(rs.getInt("Asiakas_id"));
					asiakas.setEtunimi(rs.getString("Etunimi"));
					asiakas.setSukunimi(rs.getString("Sukunimi"));
					asiakas.setPuhelin(rs.getString("Puhelin"));
				}					
			}
			con.close();
		}			
		return asiakas;
	}
	
	public void hyvaksyTarjous(int Tarjous_id) throws Exception{		
		sql = "UPDATE VV_Tarjoukset SET MyyntiPvm=NOW() WHERE Tarjous_id=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, Tarjous_id);			
			stmtPrep.executeUpdate();			
			con.close();
		}		
	}
	
	public void poistaTarjous(int Tarjous_id) throws Exception{		
		sql = "DELETE FROM VV_Tarjoukset WHERE Tarjous_id=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, Tarjous_id);			
			stmtPrep.executeUpdate();			
			con.close();
		}		
	}
	
}
