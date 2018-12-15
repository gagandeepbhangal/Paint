package ca.utoronto.utm.paint;

/**
 * @author groupXXX
 * 
 * A Square is Shape.
 * This shape class extends shape and implements the interface command and ShapeStrategy
 * 
 */

import javafx.scene.canvas.GraphicsContext;

public class Square extends Shape implements Command, ShapeStrategy{

	private Point start;
	private Point end;
	private GraphicsContext g;
	private String name;

	/**
	 * The constructor of the class that uses the start end graphics col thickness dotted and boolean to draw the shape
	 * 
	 * @param start
	 * @param end
	 * @param g
	 * @param col
	 * @param thickness
	 * @param dotted
	 * @param filled
	 */
	
	public Square(Point start, Point end, GraphicsContext g, String col, double thickness, boolean dotted, boolean filled) {
		this.start = start;
		this.end = end;
		this.g = g;	
		super.setColour(col);
		super.setThickness(thickness);
		super.setDotted(dotted);
		super.setFilled(filled);
		}

	/***
	 * Assigns a name to this square instance
	 * 
	 * @param name
	 */
	public Square(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of this square instance
	 * 
	 * @param null
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of this square
	 * @param String name
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * Draws the square using the start and end point after checking if the square 
	 * is set to be dashed or dotted and draws the square respectively.
	 * 
	 * Checks which direction the square is being drawn and so that the point of 
	 * reference that the square uses to draw itself
	 * 
	 * @param null
	 * @return void
	 * 
	 */
	@Override
	public void execute() {		// TODO Auto-generated method stub
		int edge_x = this.start.getX();
		int edge_y = this.start.getY();
		int length = Math.abs(edge_x- this.end.getX());
		int width  = Math.abs(edge_y - this.end.getY());
		
		
		g.setStroke(super.getColour());
		g.setFill(super.getColour());
		g.setLineWidth(super.getThickness());
		g.setLineDashes(1);
		
		if (this.end.getX() > edge_x && this.end.getY() > edge_y) {
			if(!super.getDotted() && !super.getFilled()) {
				
				g.strokeRect(edge_x, edge_y, length, length);
			}
			else if (!super.getFilled() && super.getDotted()) {
				g.setLineDashes(8);
				g.strokeRect(edge_x, edge_y, length, length);
			}
			else {
				g.fillRect(edge_x, edge_y, length, length);
			}
			
			}

	
		else if (this.end.getX() < edge_x && this.end.getY() > edge_y) {
			if(!super.getDotted() && !super.getFilled()) {
				
				g.strokeRect(this.end.getX(), edge_y, length, length);
			}
			else if (!super.getFilled() && super.getDotted()) {
				g.setLineDashes(8);
				g.strokeRect(this.end.getX(), edge_y, length, length);
			}
			else {
				g.fillRect(this.end.getX(), edge_y, length, length);
			}
		}

		
		else if (this.end.getX() > edge_x && this.end.getY() < edge_y) {
			if(!super.getDotted() && !super.getFilled()) {	
				g.strokeRect(edge_x, this.end.getY(), width, width);
			}
			else if (!super.getFilled() && super.getDotted()) {
				g.setLineDashes(8);
				g.strokeRect(edge_x, this.end.getY(), width, width);
			}
			else {
				g.fillRect(edge_x, this.end.getY(), width, width);
			}
		}
		
		else if (this.end.getX() < edge_x && this.end.getY() < edge_y) {
			if(!super.getDotted() && !super.getFilled()) {	
				g.strokeRect(this.end.getX(), this.end.getY(), length, width);
			}
			else if (!super.getFilled() && super.getDotted()) {
				g.setLineDashes(8);
				g.strokeRect(this.end.getX(), this.end.getY(), length, width);
			}
			else {
				g.fillRect(this.end.getX(), this.end.getY(), length, width);
			}	
	}
}
	
	/**
	 * Sets the start point the square uses to draw itself in the excute method above
	 * 
	 * @param Point Start
	 * @return void
	 */
	@Override
	public void setStartPoint(Point start) {
		this.start = start;
	}
	
	/**
	 * Sets the end point the square uses to draw itself in the excute method above
	 * 
	 * @param Point end
	 * @return void
	 */
	@Override
	public void setEndPoint(Point end) {
		this.end = end;		
	}


}
