package kochKurve;

public class TestClass {

	public static void main(String[] args) {
		Grafik g = new Grafik(600, 600);
		
		KochFigur flocke1 = new KochFigur();
		KochFigur flocke2 = new KochFigur();
		KochFigur flocke3 = new KochFigur();
		
		flocke1.kochKurve(50, 150, 550, 180, 1);
		flocke2.kochKurve(50, 300, 550, 330, 4);
		flocke3.kochKurve(50, 500, 550, 530, 7);
		
		g.add(flocke1);
		g.add(flocke2);
		g.add(flocke3);
		
		g.aktualisiere(0);
		
//		KochKurve.kochKurve(0, 500, 500, 500, 2);
	}

}
