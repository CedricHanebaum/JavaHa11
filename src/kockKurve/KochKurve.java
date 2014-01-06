package kockKurve;

import laHa04.VektorRn;

public class KochKurve {

	private static void privateKochKurve(double ax, double ay, double bx, double by, double rek) {
		if(Math.abs(rek) < 1e-9) {		// Kann mir mal jemand erklaeren, warum das ein double und kein integer ist ?
			System.out.println("(" + ax + "/" + ay + ")");
		} else {
			double zp1x, zp2x, zp3x, zp1y, zp2y, zp3y;
			double laenge = Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
			double hoehe;
			VektorRn richtung = new VektorRn(bx - ax, by - ay);
			VektorRn orth = richtung.bestimmeSenkrechteVektoren()[0].mult(1/richtung.betrag());
			System.out.println(">>" + orth);
			VektorRn vektorHoehe, zp2;
			
			zp1x = ax + (bx - ax) / 3;
			zp1y = ay + (by - ay) / 3;
			
			hoehe = Math.sqrt(Math.pow(laenge / 3, 2) + Math.pow(laenge / 6, 2));
			System.out.println(">>" + hoehe);
			vektorHoehe = orth.mult(hoehe);
			zp2 = new VektorRn(ax + (bx - ax) / 2, ay + (by - ay) / 2);
			System.out.println(">>" + zp2);
			zp2 = zp2.add(vektorHoehe);
			zp2x = zp2.getElements()[0];
			zp2y = zp2.getElements()[1];
			System.out.println(">>" + zp2y);
			
			zp3x = ax + 2 * ((bx - ax) / 3);
			zp3y = ay + 2 * ((by - ay) / 3);
			
			KochKurve.privateKochKurve(ax, ay, zp1x, zp1y, rek - 1);
			KochKurve.privateKochKurve(zp1x, zp1y, zp2x, zp2y, rek - 1);
			KochKurve.privateKochKurve(zp2x, zp2y, zp3x, zp3y, rek - 1);
			KochKurve.privateKochKurve(zp3x, zp3y, bx, by, rek - 1);
			
		}
	}
	
	public static void kochKurve(double ax, double ay, double bx, double by, double rek) {
		privateKochKurve(ax, ay, bx, by, rek);
		System.out.println("(" + bx + "/" + by + ")");
	}
	
}
