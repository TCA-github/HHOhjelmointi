package helper;

import java.util.Date;

public class Formatoija {
	public String muutaPaivays(Date d){
		String [] dArray = d.toString().split("-"); //paiva tulee kannasta yyyy-mm-dd
		return dArray[2]+"."+dArray[1]+"."+dArray[0]; //muutetaan muotoon dd.mm.yyyy
	}
}
