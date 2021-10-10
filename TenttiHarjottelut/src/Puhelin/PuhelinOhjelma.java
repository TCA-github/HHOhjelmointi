package Puhelin;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;


public class PuhelinOhjelma {
	private Map<String, PuhelinOminaisuus> puhelimet = new HashMap<String,PuhelinOminaisuus>();
	
	
	Reader lukija = new Reader();
	
	private PuhelinOhjelma(){
		
		naytaValikko();
		
	}
	
	private void naytaValikko() {
		System.out.print("1) Lisaa puhelin\n"
				+ "2) Etsi puhelin\n"
				+ "3) Poista Puhelin\n"
				+ "4) Tulosta puhelimet\n"
				+ "5) Muuta puhelimen hintaa\n"
				+ "0) Lopeta\n");
		switch (lukija.readInteger("Kirjoita valintasi: ")) {
		case 1:
			lisaaPuhelin();
			break;
		case 2:
			etsiPuhelin();
			break;
		case 3:
			poistaPuhelin();
			break;
		case 4:
			tulostaPuhelimet();
			break;
		case 5:
			muutaHintaa();
			break;
		case 0:
			lopetaOhjelma();
			break;

		default:
			break;
		}
		naytaValikko();
	}

	
	


	private void lisaaPuhelin() {
		PuhelinOminaisuus uusiPuhelin = new PuhelinOminaisuus();
		boolean ominaisuudetOk = false;
		String lisaaOminaisuus = "";
		ArrayList<String> ominaisuudet = new ArrayList<String>();
		
		uusiPuhelin.setMerkki(lukija.readString("Kirjoita puhelimen merkki: "));
		uusiPuhelin.setMalli(lukija.readString("Kirjotia puhelimen malli: "));
		uusiPuhelin.setHinta(lukija.readDouble("Kirjoita puhelimen Hinta: "));
		uusiPuhelin.setOminaisuus(ominaisuudet);
		do {
			lisaaOminaisuus = lukija.readString("lisaa Ominaisuus (LOPPU = lopettaa lisayksen)");
			if (lisaaOminaisuus.equals("LOPPU")){
				ominaisuudetOk = true;
			}else{
				ominaisuudet.add(lisaaOminaisuus);
			}	
			
		} while (!ominaisuudetOk);
		uusiPuhelin.setOminaisuus(ominaisuudet);
		puhelimet.put(uusiPuhelin.getMalli(), uusiPuhelin);
	}

	private void etsiPuhelin() {
		String malli = lukija.readString("Kirjoita malli: ");
		if (puhelimet.containsKey(malli)){
			System.out.println(puhelimet.get(malli));
		}else {
			System.out.println("Kyseistä puhelinta ei löydy");
		}
		
	}

	private void poistaPuhelin() {
		String malli = lukija.readString("Kirjoita poistettavan puhelimen malli: ");
		if (puhelimet.containsKey(malli)){
			System.out.println("Poistetaan puhelin: "+puhelimet.get(malli));
			puhelimet.remove(malli);
		}else{
			System.out.println("Kyseistä puhelinta ei ole tiedossa.");
		}
		
	}

	private void tulostaPuhelimet() {
		Set<String> avaimet = puhelimet.keySet();
		Iterator<String> i = avaimet.iterator();
		
		PuhelinOminaisuus puhelin = null;
		ArrayList<String> ominaisuudet = null;
		
		while (i.hasNext()) {
			 puhelin = puhelimet.get(i.next());
			 ominaisuudet = puhelin.getOminaisuus();
			 
			 System.out.println("Puhelin: " + puhelin.getMerkki() + " " +puhelin.getMalli() + ", hinta " + puhelin.getHinta());
			 System.out.print("Ominaisuudet: ");
			 for(int j = 0; j<ominaisuudet.size();j++){
				 System.out.print(" " + ominaisuudet.get(j).toString());
			 }
			 System.out.println("");
			}
			
	}
		
	
	private void muutaHintaa() {
		String malli = lukija.readString("Kirjoita malli: ");
		if (puhelimet.containsKey(malli)){
			puhelimet.get(malli).setHinta(lukija.readDouble("anna puhelimen uusi hinta"));
		}else {
			System.out.println("Kyseistä puhelinta ei löydy");
		}
		
	}


	private void lopetaOhjelma() {
		tallennaTiedostoon();
		lukija = null;
		System.exit(0);
		
	}

	private void tallennaTiedostoon() {
		Writer write = null;
		String line = "";
		try {
			write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("phones.csv")));
		} catch (Exception e) {
			System.exit(0);
		}
			
			Set<String> avaimet = puhelimet.keySet();
			Iterator<String> i = avaimet.iterator();
			while (i.hasNext()) {
				line = puhelimet.get(i.next()).toCSV(";");
				try {
					write.write(line + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			try {
				write.flush();
				write.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			write = null;
		
	}
	public static void main(String[] args) {
		new PuhelinOhjelma();

	}

}
