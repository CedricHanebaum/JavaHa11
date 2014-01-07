package kochKurve;

public class KochKurve {
	
	/**Addiert zwei Winkel. Subbtrahiert ggf. 360.
	 * @param rotation 1. Winkel
	 * @param degree 2. Winkel
	 * @return Ergebnisswinkel
	 */
	public static int rotate(int rotation, int degree){
		rotation += degree;
		if(rotation > 360) rotation -= 360;
		return rotation;
	}

	/**rechnet einen im Gradmaß gegebenen Winkel ins Bogenmaß um.
	 * @param deg Winkel im Gradmaß
	 * @return Winkel im Bogenmaß
	 */
	public static double getRad(int deg){
		return deg * Math.PI/180.;
	}

	/**Berechnet rekursiv die Punkte einer Koch Kurve und gibt diese aus.
	 * @param ax x-Koordinate des Anfangspunktes
	 * @param ay y-Koordinate des Anfangspunktes
	 * @param bx x-Koordinate des Endpunktes
	 * @param by y-Koordinate des Endpunktes
	 * @param rek aktuelle Rekursionstiefe
	 * @param rotation Winkel der Kurve zur x-Achse
	 */
	private static void privateKochKurve(double ax, double ay, double bx, double by, double rek, int rotation) {
		if(Math.abs(rek) < 1e-9) {		// Kann mir mal jemand erklaeren, warum das ein double und kein integer ist ?
			System.out.println("(" + ax + "/" + ay + ")");
		} else {
			double zp1x, zp2x, zp3x, zp1y, zp2y, zp3y;
			double laenge = Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
			
			zp1x = ax + (bx - ax) / 3;
			zp1y = ay + (by - ay) / 3;
			
			zp2x = zp1x + Math.cos(KochKurve.getRad(rotation + 60)) * laenge / 3;
			zp2y = zp1y - Math.sin(KochKurve.getRad(rotation + 60)) * laenge / 3;
			
			zp3x = ax + 2 * ((bx - ax) / 3);
			zp3y = ay + 2 * ((by - ay) / 3);
			
			KochKurve.privateKochKurve(ax, ay, zp1x, zp1y, rek - 1, rotation);
			KochKurve.privateKochKurve(zp1x, zp1y, zp2x, zp2y, rek - 1, KochKurve.rotate(rotation, 60));
			KochKurve.privateKochKurve(zp2x, zp2y, zp3x, zp3y, rek - 1, KochKurve.rotate(rotation, -60));
			KochKurve.privateKochKurve(zp3x, zp3y, bx, by, rek - 1, rotation);
			
		}
	}
	
	/**Ruft die Methode zur rekursiven berechnung der Koch Kurve auf und gibt den letzten Punkt aus.
	 * @param ax x-Koordinate des Anfangspunktes
	 * @param ay y-Koordinate des Anfangspunktes
	 * @param bx x-Koordinate des Endpunktes
	 * @param by y-Koordinate des Endpunktes
	 * @param rek aktuelle Rekursionstiefe
	 */
	public static void kochKurve(double ax, double ay, double bx, double by, double rek) {
		privateKochKurve(ax, ay, bx, by, rek, (int) Math.asin((by - ay) / (bx - ax)));
		System.out.println("(" + bx + "/" + by + ")");
	}
	
}
