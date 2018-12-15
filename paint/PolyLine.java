package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * 
 * @author groupXXX
 * 
 * PolyLine is a Shape
 * 
 * This class initiates the PolyLine that extends the Shape class and implements
 * the interfaces Command and ShapeStrategy This class executes the PolyLine
 * command to draw the PolyLine object on its own using the GraphicsContext
 * 
 * 
 *
 */

public class PolyLine extends Shape implements Command, ShapeStrategy {
	private Point start;
	private Point end;
	private GraphicsContext g;
	private PaintPanel paintPanel;
	private String name;
	private PaintPanel p;

	/**
	 * 
	 * This PolyLine constructor initialises the start and end point. The col sets
	 * the col of the polyline The thickness sets the thickness of the PolyLine
	 * Takes in the dotted parameter that changes the stroke of the PolyLine
	 * 
	 * @param Point
	 *            start
	 * @param Point
	 *            end
	 * @param GraphicsContext
	 *            g
	 * @param PaintPanel
	 *            p
	 * @param String
	 *            col
	 * @param double
	 *            thickness
	 * @param boolean
	 *            dotted
	 * 
	 */
	public PolyLine(Point start, Point end, GraphicsContext g, PaintPanel p, String col, double thickness,
			boolean dotted) {
		this.start = start;
		this.end = end;
		this.g = g;
		this.p = p;
		super.setColour(col);
		super.setThickness(thickness);
		super.setDotted(dotted);
	}

	/**
	 * 
	 * Constructor parameter with a String name of the polyline
	 * 
	 * @param String name
	 */
	
	public PolyLine(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * Gets the start point of the PolyLine where the PolyLine starts to do draw itself
	 * 
	 * @param null
	 * @return Point start
	 * 
	 */
	public Point getStart() {
		return start;
	}

	
	/**
	 * 
	 * sets the polyline start point
	 * 
	 * @param Point start
	 * @return void
	 * 
	 */
	
	public void setStart(Point start) {
		this.start = start;
	}

	
	/**
	 * 
	 * 
	 * gets the end coordinate of the polyLine that is already drawn
	 * 
	 * @param null
	 * @return Point end
	 */
	public Point getEnd() {
		return end;
	}
	
	
	/**
	 * 
	 * Sets the end of the PolyLine for the next PolyLine to start drawing
	 * 
	 * @param end
	 * @return void
	 * 
	 */
	public void setEnd(Point end) {
		this.end = end;
	}

	/**
	 * 
	 * sets the Polyline start and end point
	 * 
	 * @param start
	 * @param end
	 * @return void
	 */
	public void setPolyline(Point start, Point end) {
		this.end = end;
		this.start = start;
	}

	
	/**
	 * 
	 * Gets the name of the PolyLine
	 * 
	 * @param null
	 * @return String name
	 * 
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * 
	 * Sets the name of the PolyLine
	 * 
	 * @param String name
	 * @return void
	 * 
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * 
	 * Draws the PolyLine using the start and end point after checking if the polyLine is set to be dashed or dotted
	 * and draws the PolyLine respectively
	 * 
	 * 
	 * @param null
	 * @return void
	 * 
	 */
	@Override
	public void execute() {
		g.setStroke(super.getColour());
		g.setLineWidth(super.getThickness());

		if (!super.getDotted()) {
			g.setLineDashes(1);
			g.strokeLine(this.start.getX(), this.start.getY(), this.end.getX(), this.end.getY());
		} else {
			g.setLineDashes(8);
			g.strokeLine(this.start.getX(), this.start.getY(), this.end.getX(), this.end.getY());
		}
	}
	
	
	/**
	 * 
	 * Sets the start point of the shape that is being drawn right now
	 * 
	 * @param Point 
	 * 
	 */
	@Override
	public void setStartPoint(Point start) {
		this.start = start;
	}
	
	/**
	 * 
	 * Sets the end point for the next polyline that is going to be drawn
	 * 
	 * @param Point end
	 * @return void
	 */
	@Override
	public void setEndPoint(Point end) {
		this.end = end;
	}


}
