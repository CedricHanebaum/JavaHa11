package kochKurve;

//Zur Verfuegung gestellte Klasse f�r PUE 09
import javax.swing.*;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Grafik {

	private JFrame frame;
	private JPanel panel;
	private ArrayList<Figur> figuren = new ArrayList<Figur>();

	// Oeffnet ein Grafikfenster der mit einer Zeichenflaeche der
	// angegebenen Hoehe und Breite
	public Grafik(int width, int height) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				for (int i = 0; i < figuren.size(); i++) {
					figuren.get(i).paint(g);
				}
			}
		};
		panel.setPreferredSize(new Dimension(width, height));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	/*
	 * Aktualisiert die Zeichenflaeche. Aenderungen werden erst sichtbar,
	 * nachdem diese Methode aufgerufen wurde. Wartet vorher ms Milisekunden.
	 * Damit ist eine eine einfache Animation moeglich.
	 */
	public void aktualisiere(int verzoegerung) {
		// frame.repaint();
		try {
			Thread.sleep(verzoegerung);
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					panel.paint(panel.getGraphics());
				}
			});
		} catch (InterruptedException e) {
		} catch (InvocationTargetException e) {
		}
	}

	/* F�gt die angegebene geometrische Figur in die Zeichenfl�che ein */
	public void add(Figur f) {
		figuren.add(f);
	}

	/*
	 * Entfernt die geometrische Figur aus der Zeichenflaeche
	 */
	public void remove(Figur f) {
		figuren.remove(f);
	}
}

class Figur {

	protected ArrayList<Point> punkte = new ArrayList<Point>();

	// Zwischen den jeweils benachbarten Punkten der Liste werden
	// Verbindungslinien gezeichnet
	public void paint(Graphics g) {
		for (int i = 0; i < punkte.size() - 1; i++) {
			g.drawLine(punkte.get(i).x, punkte.get(i).y, punkte.get(i + 1).x,
					punkte.get(i + 1).y);
		}
	}

	// Alle Punkte aus der Arraylist werden um den angegebenen Wert verschoben
	public void verschiebe(int x, int y) {
		for (Point a : punkte) {
			a.translate(x, y);

		}
	}

	@Override
	public String toString() {
		return "Figur:" + this.punkte.toString();
	}
}
