package tuntikoodeja;

public class TestaaAutoja {

	public static void main(String[] args) {
		Auto eka = new Auto();
		eka.setMerkki("Honda");
		eka.setMalli("Civic");
		System.out.println(eka);
		KuormaAuto toka = new KuormaAuto();
		toka.setMerkki("Scania");
		toka.setMalli("F458");
		System.out.println(toka);
	}

}
