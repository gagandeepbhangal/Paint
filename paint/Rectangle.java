package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * 
 * @author groupXXX
 * 
 * Rectangle is a Shape
 * 
 * This class instantiates the drawing of the PolyLine and the polyline instance draws
 * itself here in its class
 * 
 * 
 *
 */

public class Rectangle extends Shape implements Command, ShapeStrategy{

	private Point start;
	private Point end;
	private GraphicsContext g;
	private String name;
	

	/**
	 * This is the constructor the uses the Super class Shape that takes care of the
	 * start end graphics col thickness dotted and filled of the Rectangle instance
	 *
	 * 
	 * @param start
	 * @param end
	 * @param g
	 * @param col
	 * @param thickness
	 * @param dotted
	 * @param filled
	 */
	public Rectangle(Point start, Point end, GraphicsContext g, String col, double thickness, boolean dotted, boolean filled) {
		this.start = start;
		this.end = end;
		this.g = g;
		super.setColour(col);
		super.setThickness(thickness);
		super.setDotted(dotted);
		super.setFilled(filled);
	}
	
	/**
	 * Defines the name of the Rectangle instance
	 * @param name
	 */
	public Rectangle(String name){
		this.name = name;
	}
	
	/**
	 * Gets the name of this rectangle instance
	 * 
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Sets the name of this rectangle instance
	 * 
	 * @param String name
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * The rectangle draws itself here with respect to dotted filled and draws it accordingly
	 * 
	 */

	@Override
	public void execute() {		
		int edge_x = this.start.getX();
		int edge_y = this.start.getY();
		int width = Math.abs(edge_x- this.end.getX());
		int height = Math.abs(edge_y - this.end.getY());
		g.setStroke(super.getColour());
		g.setFill(super.getColour());
		g.setLineWidth(super.getThickness());
		
		if(!super.getFilled() && !super.getDotted()) {
			g.setLineDashes(1);
			g.strokeRect(Math.min(edge_x, this.end.getX()), Math.min(edge_y,this.end.getY()), width, height);
		}
		
		else if(!super.getFilled() && super.getDotted()) {
			g.setLineDashes(8);
			g.strokeRect(Math.min(edge_x, this.end.getX()), Math.min(edge_y,this.end.getY()), width, height);
			
			}
			
		else{
		
			g.fillRect(Math.min(edge_x, this.end.getX()), Math.min(edge_y,this.end.getY()), width, height);
		}

	}

	/**
	 * sets the start point of the rectangle
	 * 
	 * @param Point start
	 * @return void
	 */
	@Override
	public void setStartPoint(Point start) {
		this.start = start;
	}
	
	/**
	 * sets the end point of the rectangle
	 * 
	 * @param Point end
	 * @return void
	 * 
	 */
	@Override
	public void setEndPoint(Point end) {
		this.end = end;		
	}

}



