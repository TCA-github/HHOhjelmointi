package etatehtavat_11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class YstavaSovellus {
	private Lukija lukija = new Lukija();
	private HashMap<String, Ystava> ystavat = new HashMap<String, Ystava>();
	public YstavaSovellus(){
		naytaValikko();
	}
	
	private void naytaValikko() {
		System.out.println("1) Lis‰‰ yst‰v‰");
		System.out.println("2) Etsi yst‰v‰");
		System.out.println("3) Poista yst‰v‰");
		System.out.println("4) Tulosta yst‰v‰t");
		System.out.println("0) Lopeta");
		switch (lukija.lueKokonaisluku("Valitse:")) {
		case 1:
			lisaaYstava();
			break;
		case 2:
			etsiYstava();
			break;
		case 3:
			poistaYstava();
			break;
		case 4:
			tulostaKaikki();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			System.out.println("V‰‰r‰ valinta!");
			break;
		}
		naytaValikko();
	}

	private void lisaaYstava() {
		Ystava ystava = new Ystava();
		ystava.setLempinimi(lukija.lueTeksti("Anna yst‰v‰n lempinimi: "));
		if(ystavat.containsKey(ystava.getLempinimi())){
			System.out.println("Olet jo lis‰nnyt t‰m‰n yst‰v‰n");
			System.out.println("Yst‰v‰n tiedot: " + ystavat.get(ystava.getLempinimi()));
			return;
		}
		ystava.setNimi(lukija.lueTeksti("Anna yst‰v‰n nimi: "));
		ystava.setPuhelin(lukija.lueTeksti("Anna yst‰v‰n puhelinnumero: "));
		ystava.setSyntymaPaiva(lukija.luePaivamaara("Anna yst‰v‰n syntym‰p‰iv‰m‰‰r‰ muodossa pp.kk.vvvv:",
				"dd.MM.yyyy"));
		ystavat.put(ystava.getLempinimi(), ystava);
	}

	private void etsiYstava() {
		String lempiNimi = lukija.lueTeksti("Anna yst‰v‰n lempinimi:");
		if(ystavat.containsKey(lempiNimi)){
			System.out.println(ystavat.get(lempiNimi));
		}		
	}

	private void poistaYstava() {
		String lempiNimi = lukija.lueTeksti("Anna yst‰v‰n lempinimi:");
		if(ystavat.containsKey(lempiNimi)){
			System.out.println("Poistetaan yst‰v‰n tiedot:");
			System.out.println(ystavat.get(lempiNimi));
			ystavat.remove(lempiNimi);
		}		
	}

	private void tulostaKaikki() {
		Set<String> lempinimet= ystavat.keySet();
		Iterator<String> i = lempinimet.iterator();
		while (i.hasNext()) { 
			System.out.println(ystavat.get(i.next()));
		}		
	}

	public static void main(String[] args) {
		new YstavaSovellus();
	}
}
