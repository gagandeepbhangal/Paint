package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

/**
 * 
 * @author groupXXX
 * 
 * The class extends Observable that notifies all the observers with changes
 * that occour to the shape objects that are being stored in the Shape Class
 * 
 * 
 *
 */

public class PaintModel extends Observable {

	private ArrayList<ArrayList<Shape>> shapes = new ArrayList<ArrayList<Shape>>();// ArrayList of Shape instances

	/**
	 * 
	 * @param ArrayList<Shape>
	 *            shape
	 * 
	 *            This method addes the shapes the to the shapes arrayList. Setting
	 *            and notifying the observers
	 * 
	 * @return void
	 */
	public void addShape(ArrayList<Shape> shape) {
		this.shapes.add(shape);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * @param null
	 *            returns the list with all the shapes that have been drawn on the
	 *            canvas
	 * @return ArrayList<ArrayList<Shape>> shapes
	 */
	public ArrayList<ArrayList<Shape>> getShapes() {
		return shapes;

	}

	/**
	 * cleares the shapes list
	 * 
	 * @param null
	 * @return void
	 * 
	 */
	public void setShapes() {
		shapes.clear();
	}

	/**
	 * sets the shapes list with the shape object
	 * 
	 * @param ArrayList<ArrayList<Shape>>
	 *            shape
	 * @return void
	 */
	public void setShapes(ArrayList<ArrayList<Shape>> shape) {
		shapes = shape;
	}

	/**
	 * removes the last Shape object that has been drawn on the canvas
	 * 
	 * @param null
	 * @return void
	 */
	public void remove() {
		shapes.remove(shapes.size() - 1);
	}

}