package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shape implements Command, ShapeStrategy{
	
	private Point start;
	private Point end;
	private GraphicsContext g;
	private String name;
	
	public Circle(Point start, Point end, GraphicsContext g, String col, double thickness, boolean dotted, boolean filled) {
		this.start = start;
		this.end = end;
		this.g = g;
		super.setColour(col);
		super.setThickness(thickness);
		super.setDotted(dotted);
		super.setFilled(filled);
	}
	public Circle(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public void execute() {
		
		g.setStroke(super.getColour());
		g.setFill(super.getColour());
		g.setLineWidth(super.getThickness());
		
		int x = this.start.getX();
		int y = this.start.getY();
		int xFinal = this.end.getX() - this.start.getX();
		int yFinal = this.end.getY() - this.start.getY();
		int radius = (int)Math.hypot(xFinal, yFinal);
		
		if(!super.getFilled() && !super.getDotted()) {
			g.setLineDashes(1);
			g.strokeOval(x-radius, y-radius, 2*radius,2* radius);
		}
		else if(!super.getFilled() && super.getDotted()) {
			g.setLineDashes(8);
			g.strokeOval(x-radius, y-radius, 2*radius,2* radius);
		}
		else{				
			g.fillOval(x-radius, y-radius, 2*radius,2* radius);
		}
	}

	@Override
	public void setStartPoint(Point start) {
		this.start = start;
	}
	@Override
	public void setEndPoint(Point end) {
		this.end = end;		
	}

}
