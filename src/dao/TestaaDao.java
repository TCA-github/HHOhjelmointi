package dao;

import java.util.ArrayList;

import model.Postinumero;

public class TestaaDao {

	public static void main(String[] args) {
		Dao_Postinumero dao = new Dao_Postinumero();
		ArrayList<Postinumero> pnrot = new ArrayList<Postinumero>();
		try {
			pnrot = dao.listaaKaikki();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<pnrot.size();i++){
			System.out.println(pnrot.get(i));
		}
	}
}
