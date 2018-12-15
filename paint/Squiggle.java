package ca.utoronto.utm.paint;

/**
 * @author groupXXX 
 * This class is used to create a Squiggle and draw it
 */

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

public class Squiggle extends Shape implements Command, ShapeStrategy {

	/**
	 * Create variables
	 */
	private GraphicsContext g;
	private ArrayList<Shape> t = new ArrayList<>();


	/**
	 * 
	 * @param t is the arraylist of Points which is used to draw a squiggle
	 * @param g is a reference to the GraphicsContext in repaint in PaintPanel
	 */
	public Squiggle(ArrayList<Shape> t, GraphicsContext g) {
		this.t = t;
		this.g = g;
	}

	/**
	 * Draw the squiggle. Loop through the arraylist of points and stroke lines from point to point to draw the squiggle. Set the colour
	 * and thickness of the squiggle relative to the points in the arraylist.
	 */
	@Override
	public void execute() {
		for (int i = 0; i < t.size() - 1; i++) {
			Point p1 = (Point) t.get(i);
			Point p2 = (Point) t.get(i + 1);
			g.setStroke(p2.getColour());
			g.setLineWidth(p2.getThickness());
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}



}
