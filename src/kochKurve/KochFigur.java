package kochKurve;

import java.awt.Point;

public class KochFigur extends Figur{

	
	private void privateKochKurve(double ax, double ay, double bx, double by, double rek, int rotation){
		if(Math.abs(rek) < 1e-9) {		// Kann mir mal jemand erklaeren, warum das ein double und kein integer ist ?
			this.punkte.add(new Point((int) ax, (int) ay));
		} else {
			double zp1x, zp2x, zp3x, zp1y, zp2y, zp3y;
			double laenge = Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
			
			zp1x = ax + (bx - ax) / 3;
			zp1y = ay + (by - ay) / 3;
			
			zp2x = zp1x + Math.cos(KochKurve.getRad(rotation + 60)) * laenge / 3;
			zp2y = zp1y - Math.sin(KochKurve.getRad(rotation + 60)) * laenge / 3;
			
			zp3x = ax + 2 * ((bx - ax) / 3);
			zp3y = ay + 2 * ((by - ay) / 3);
			
			this.privateKochKurve(ax, ay, zp1x, zp1y, rek - 1, rotation);
			this.privateKochKurve(zp1x, zp1y, zp2x, zp2y, rek - 1, rotation + 60);
			this.privateKochKurve(zp2x, zp2y, zp3x, zp3y, rek - 1, rotation - 60);
			this.privateKochKurve(zp3x, zp3y, bx, by, rek - 1, rotation);
			
		}
	}
	
	public void kochKurve(double ax, double ay, double bx, double by, double rek){
		privateKochKurve(ax, ay, bx, by, rek, (int) Math.asin((by - ay) / (bx - ax))); //TODO bogenmaß und so, aufpassen!
		this.punkte.add(new Point((int) bx, (int) by));
	}
	
}
