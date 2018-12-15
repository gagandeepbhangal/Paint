package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**@author groupXXX
 * This class creates shape objects that will be used to draw the user's requested shape.
 * This class contain all the main methods that will be used to draw and customize the user requested shape. 
 * IS-A: inheritance 	(no inheritance is needed for this class however this class implements the ShapeStrategy interface).
 * HAS-A: attributes 	(Point start, Point end, String name, String col, double thickness, boolean dotted, boolean filled).
 * RESPONDS-TO: methods (getDotted, setDotted, getCol, getName, setName, setColour, getColour,  toString, setThickness, getPaintPanel,
 *  getThickness, setFilled, getEnd, setEnd, getStart, setStart, addCurrentShape, setStartPoint, setEndPoint, setPaintPanel, setShape).
 */
public class Shape implements ShapeStrategy{

	private Paint colour = Color.BLACK;
	private double thickness;
	private boolean filled;
	private Point start;
	private Point end;
	private String col = "black";
	private String name;
	private boolean isDotted = false;

	/**
	 * Constructs new shape object.
	 * @param start		The starting point of the object (the initial point when the user clicks).
	 * @param end		The ending point of the object (the final point when the user releases).
	 * @param name		The name of the shape object that is being created.
	 * @param col		The color of the shape object being created.
	 * @param thickness	The thickness of the shape object being created.
	 * @param dotted	Boolean representing whether the object being created is dotted or not.
	 * @param filled	Boolean representing whether the object being created is filled or not.
	 */
	Shape(Point start, Point end, String name, String col, double thickness, boolean dotted, boolean filled) {
		this.start = start;
		this.end = end;
		this.name = name;
		this.col = col;
		this.setColour(col);
		this.setThickness(thickness);
		this.setDotted(dotted);
		this.setFilled(filled);
	}
	
	/**
	 * Second constructor for the shape class.
	 * No parameters are being taken in this constructor.
	 */
	Shape() {
		this.colour = Color.BLACK;
		this.thickness = 1.0;
	}
	
	/**
	 * Return the value of isDotted.
	 * @return	Boolean isDotted.
	 */
	public boolean getDotted() {
		return this.isDotted;
	}
	
	/**
	 * Set the value of field isDotted to isDotted.
	 * @param isDotted	Boolean representing whether the object being created is dotted or not.
	 */
	public void setDotted(boolean isDotted) {
		this.isDotted = isDotted;
	}

	
	/**
	 * Return the value of col.
	 * @return	String col.
	 */
	public String getCol() {
		return this.col;
	}

	/**
	 * Return the value of name.
	 * @return	String name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of name to the provided value of name.
	 * @param name		The name of the shape object that is being created.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the value of col to the provided value of col.
	 * @param col	The color of the shape object being created.
	 */
	public void setColour(String col){
		this.col = col;
		this.colour = Color.web(col);
	}
	
	/**
	 * Returns the color of the current shape object.
	 * @return	Paint colour
	 */
	public Paint getColour() {
		return this.colour;
	}
	
	/**
	 * Set thickness to the provided thickness.
	 * @param thickness		The thickness of the shape object being created.
	 */
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	/**
	 * Return the thickness of the current shape object.
	 * @return	double thickness
	 */
	public double getThickness() {
		return this.thickness;
	}

	/**
	 * Set the value of filled to the provided filled value.
	 * @param filled	Boolean representing whether the object being created is filled or not.
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	/**
	 * Return whether the current object is filled.
	 * @return	boolean filled.
	 */
	public boolean getFilled() {
		return this.filled;
	}
	
	/**
	 * Return the end point of the current object (the final point when the user releases).
	 * @return	point end
	 */
	public Point getEnd() {
		return end;
	}
	
	/**
	 * Set point end to the provided value destination.
	 * @param destination	The end point of the current object (the final point when the user releases). 
	 */
	public void setEnd(Point destination) {
		this.end = destination;
	}
	
	/**
	 * Return the starting point of the object (the initial point when the user clicks).
	 * @return	point start
	 */
	public Point getStart() {
		return start;
	}
	
	/**
	 * Set start point to the provided value of edge. 
	 * @param edge		The starting point of the object (the initial point when the user clicks).
	 */
	public void setStart(Point edge) {
		this.start = edge;
	}


	/**
	 * Set start point to the provided value of start.  
	 */
	@Override
	public void setStartPoint(Point start) {
		this.start = start;		
	}

	/**
	 * Set end point to the provided value of end.
	 */
	@Override
	public void setEndPoint(Point end) {
		this.end = end;		
		
	}	

}
