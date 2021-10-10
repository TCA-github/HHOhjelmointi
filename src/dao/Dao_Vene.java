package dao;


import java.util.ArrayList;

import model.Vene;
import model.Venemalli;

public class Dao_Vene extends Dao {
			
	public ArrayList<Vene> haeVeneet(String hakusana) throws Exception{		
		ArrayList<Vene> veneet = new ArrayList<Vene>();
		sql = "SELECT * FROM VV_Veneet, VV_Mallit, VV_Venemerkit, VV_Tyypit ";
		sql+= "WHERE VV_Veneet.Malli_id=VV_Mallit.Malli_id "; 
		sql+= "AND VV_Mallit.Tyyppi_id=VV_Tyypit.Tyyppi_id "; 
		sql+= "AND VV_Mallit.Merkki_id=VV_Venemerkit.VMerkki_id ";	
		sql+= "AND (VV_Mallit.Malli LIKE ? OR VV_Venemerkit.VMerkki LIKE ?)";	
		sql+= "AND Poistettu=0 ";
		sql+= "AND VV_Veneet.Vene_id NOT IN (SELECT Vene_id FROM VV_Tarjoukset WHERE MyyntiPvm IS NOT NULL)";	
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, "%"+hakusana+"%");		
			stmtPrep.setString(2, "%"+hakusana+"%");	
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					Vene vene = new Vene();
					vene.setVene_id(rs.getInt("Vene_id"));
					vene.setMalli_id(rs.getInt("Malli_id"));
					vene.setVuosimalli(rs.getInt("Vuosimalli"));
					vene.setOstohinta(rs.getInt("Ostohinta"));
					vene.setHintapyynto(rs.getInt("Hintapyynto"));
					vene.setTiukkahinta(rs.getInt("Tiukkahinta"));
					vene.setKuvaus(rs.getString("Kuvaus"));
					vene.setTulopaiva(rs.getDate("Tulopaiva"));
					vene.setOmistaja(rs.getInt("Omistaja_id"));
					vene.setLisatietoja(rs.getString("Lisatietoja"));	
					vene.setMalli(rs.getString("Malli"));
					vene.setMerkki(rs.getString("VMerkki"));
					veneet.add(vene);
				}					
			}
			con.close();
		}			
		return veneet;
	}	
	public boolean lisaaMerkki(String merkki) throws Exception{
		boolean paluuArvo=true;
		merkki = merkki.trim();
		//tutkitaan ensin onko merkki jo kannassa		
		sql="SELECT * FROM VV_Venemerkit WHERE VMerkki = ?";
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, merkki);
    		rs = stmtPrep.executeQuery();  
    		if(rs.isBeforeFirst()){ //jos kysely tuotti dataa, eli rekNo on käytössä
    			paluuArvo=false; //merkki on jo kannassa    			 			       			
			}	
    		con.close(); 
		}		
		if(paluuArvo==true){
			sql="INSERT INTO VV_Venemerkit(VMerkki) VALUES(?)";						  
			try {
				con = yhdista();
				stmtPrep=con.prepareStatement(sql); 
				stmtPrep.setString(1, merkki);
				stmtPrep.executeUpdate();
		        con.close();
			} catch (Exception e) {				
				e.printStackTrace();
				paluuArvo=false;
			}				
		}		
		return paluuArvo;
	}
	public boolean lisaaMalli(Venemalli venemalli) throws Exception{
		boolean paluuArvo=true;		
		//tutkitaan ensin onko merkki+malli yhdistelmä jo kannassa?	
		sql="SELECT * FROM VV_Mallit WHERE Malli = ? AND Merkki_id = ?";
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, venemalli.getMalli());
			stmtPrep.setInt(2, venemalli.getMerkki_id());
    		rs = stmtPrep.executeQuery();  
    		if(rs.isBeforeFirst()){ //jos kysely tuotti dataa, eli rekNo on käytössä
    			paluuArvo=false; //merkki on jo kannassa    			 			       			
			}	
    		con.close(); 
		}		
		if(paluuArvo==true){
			sql="INSERT INTO VV_Mallit(Malli, Merkki_id, Pituus, Leveys, Paino, Tyyppi_id) VALUES(?,?,?,?,?,?)";						  
			try {
				con = yhdista();
				stmtPrep=con.prepareStatement(sql); 
				stmtPrep.setString(1, venemalli.getMalli());
				stmtPrep.setInt(2, venemalli.getMerkki_id());
				stmtPrep.setDouble(3, venemalli.getPituus());
				stmtPrep.setDouble(4, venemalli.getLeveys());
				stmtPrep.setInt(5, venemalli.getPaino());
				stmtPrep.setInt(6, venemalli.getTyyppi_id());
				stmtPrep.executeUpdate();
		        con.close();
			} catch (Exception e) {				
				e.printStackTrace();
				paluuArvo=false;
			}				
		}		
		return paluuArvo;
	}
	public boolean lisaaVene(Vene vene){
		boolean paluuArvo=true;		
		sql="INSERT INTO VV_Veneet(Malli_id, Vuosimalli, Ostohinta, Hintapyynto, Tiukkahinta, Kuvaus, Tulopaiva, Omistaja_id, Valitysvene, Lisatietoja) VALUES(?,?,?,?,?,?,?,?,?,?);";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setInt(1, vene.getMalli_id());
			stmtPrep.setInt(2, vene.getVuosimalli());
			stmtPrep.setInt(3, vene.getOstohinta());
			stmtPrep.setInt(4, vene.getHintapyynto());
			stmtPrep.setInt(5, vene.getTiukkahinta());
			stmtPrep.setString(6, vene.getKuvaus());	
			if(vene.getTulopaiva()!=null){
				stmtPrep.setDate(7, new java.sql.Date(vene.getTulopaiva().getTime()));
			}else{
				stmtPrep.setDate(7,null);
			}
			stmtPrep.setInt(8, vene.getOmistaja());
			stmtPrep.setInt(9, vene.getValitysvene());
			stmtPrep.setString(10, vene.getLisatietoja());			
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	public Vene haeVene(int vene_id) throws Exception{
		Vene vene=null;		
		sql = "SELECT * FROM VV_Veneet, VV_Mallit, VV_Venemerkit ";
		sql+= "WHERE VV_Veneet.Malli_id=VV_Mallit.Malli_id "; 		
		sql+= "AND VV_Mallit.Merkki_id=VV_Venemerkit.VMerkki_id ";
		sql+= "AND Vene_id=?";			
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, vene_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					vene = new Vene();
					vene.setVene_id(rs.getInt("Vene_id"));
					vene.setMalli_id(rs.getInt("Malli_id"));
					vene.setVuosimalli(rs.getInt("Vuosimalli"));
					vene.setOstohinta(rs.getInt("Ostohinta"));
					vene.setHintapyynto(rs.getInt("Hintapyynto"));
					vene.setTiukkahinta(rs.getInt("Tiukkahinta"));
					vene.setKuvaus(rs.getString("Kuvaus"));
					vene.setTulopaiva(rs.getDate("Tulopaiva"));
					vene.setOmistaja(rs.getInt("Omistaja_id"));
					vene.setLisatietoja(rs.getString("Lisatietoja"));	
					vene.setMalli(rs.getString("Malli"));
					vene.setMerkki(rs.getString("VMerkki"));
					vene.setMerkki_id(rs.getInt("Merkki_id"));
					vene.setValitysvene(rs.getInt("Valitysvene"));
				}					
			}
			con.close();
		}			
		return vene;
	}
	
	public boolean muutaVene(Vene vene){
		boolean paluuArvo=true;		
		sql="UPDATE VV_Veneet SET Malli_id=?, Vuosimalli=?, Ostohinta=?, Hintapyynto=?, Tiukkahinta=?, Kuvaus=?, Tulopaiva=?, Omistaja_id=?, Valitysvene=?, Lisatietoja=? WHERE Vene_id=?;";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setInt(1, vene.getMalli_id());
			stmtPrep.setInt(2, vene.getVuosimalli());
			stmtPrep.setInt(3, vene.getOstohinta());
			stmtPrep.setInt(4, vene.getHintapyynto());
			stmtPrep.setInt(5, vene.getTiukkahinta());
			stmtPrep.setString(6, vene.getKuvaus());	
			if(vene.getTulopaiva()!=null){
				stmtPrep.setDate(7, new java.sql.Date(vene.getTulopaiva().getTime()));
			}else{
				stmtPrep.setDate(7,null);
			}
			stmtPrep.setInt(8, vene.getOmistaja());
			stmtPrep.setInt(9, vene.getValitysvene());
			stmtPrep.setString(10, vene.getLisatietoja());	
			stmtPrep.setInt(11, vene.getVene_id());
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	public void poistaVene(int Vene_id) throws Exception{		
		sql = "UPDATE VV_Veneet SET Poistettu=1 WHERE Vene_id=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, Vene_id);			
			stmtPrep.executeUpdate();			
			con.close();
		}		
	}
	
	public ArrayList<String> haeKuvat(int vene_id) throws Exception{
		ArrayList<String> kuvat = null;
		sql= "SELECT * FROM VV_Kuvat WHERE Vene_id=? ORDER BY Prioriteetti";	
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, vene_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				kuvat = new ArrayList<String>();
				while(rs.next()){
					kuvat.add(rs.getString("Kuva_id"));
				}					
			}
			con.close();
		}			
		return kuvat;		
	}
	
	public void lisaaKuva(String kuva, int vene_id) throws Exception{		
		sql = "INSERT INTO VV_Kuvat(Kuva_id, Vene_id, Prioriteetti) VALUES(?,?,?)"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, kuva);
			stmtPrep.setInt(2, vene_id);
			stmtPrep.setInt(3, 0);
			stmtPrep.executeUpdate();			
			con.close();
		}		
	}
	
	public void poistaKuva(String kuva_id) throws Exception{		
		sql = "DELETE FROM VV_Kuvat WHERE Kuva_id=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, kuva_id);			
			stmtPrep.executeUpdate();			
			con.close();
		}		
	}
	
	public void jarjestaKuvat(String kuvatStr) throws Exception{
		con=yhdista();
		if(con!=null){ 
			String [] kuvat = kuvatStr.split(";");
			for(int i=0;i<kuvat.length;i++){
				sql = "Update VV_Kuvat SET Prioriteetti=? WHERE Kuva_id=?"; 	
				stmtPrep = con.prepareStatement(sql); 
				stmtPrep.setInt(1, i);
				stmtPrep.setString(2, kuvat[i]);
				stmtPrep.executeUpdate();	
			}					
			con.close();
		}		
	}
	
	public String haePaaKuva(int vene_id) throws Exception{
		String kuva=null;
		sql= "SELECT * FROM VV_Kuvat WHERE Vene_id=? ORDER BY Prioriteetti LIMIT 1";	
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, vene_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					kuva=rs.getString("Kuva_id");
				}					
			}
			con.close();
		}		
		return kuva;
	}
}












