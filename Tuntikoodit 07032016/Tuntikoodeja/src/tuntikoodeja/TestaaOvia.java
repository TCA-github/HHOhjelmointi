package tuntikoodeja;

public class TestaaOvia {

	public static void main(String[] args) {
		Ovet ovi = null;
		ovi = new KuormaAuto();
		System.out.println(ovi.ovienLkm());
		ovi = new PakettiAuto();
		System.out.println(ovi.ovienLkm());		
	}
}
