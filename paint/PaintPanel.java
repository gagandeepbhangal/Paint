package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


/**@author groupXXX
 * This class uses all the package classes to draw, customize, repaint and handle the mouse events. 
 * This class is the canvas and the heart of the program as it contains all the crucial components of the program.
 * IS-A: inheritance 	(Extends StackPane and implements Observer, EventHandler<MouseEvent>).
 * HAS-A: attributes 	(PaintModel mode, View view).
 * RESPONDS-TO: methods (repaint, setCommand, update, setMode, getMode, setColor, setBackgroundColor, setThickness, setShapes,
 * 						 getDotted, setDotted, getFilled, setFilled, handle, mouseMoved, mouseDragged, mouseClicked, mousePressed,
 * 						 mouseReleased, mouseEntered, mouseExited, setFinalShapes, undoFinalShapes, redoFinalShapes, copy, paste,cut ).
 */

class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {

	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private String mode; // modifies how we interpret input (could be better?)
	private String col = "black";
	private String command = "black";
	private double thickness = 1.0;
	private Shape currentShape;
	private Point previous_end;
	private boolean isDotted = false;
	private boolean isFilled = false;	
	private Canvas canvas;
	boolean start = false;
	boolean startP = false;
	private ArrayList<ArrayList<Shape>> finalShapes = new ArrayList<ArrayList<Shape>>();
	private ArrayList<Shape> points = new ArrayList<Shape>();
	private ArrayList<ArrayList<Shape>> undo = new ArrayList<ArrayList<Shape>>();
	private ArrayList<ArrayList<Shape>> copy = new ArrayList<ArrayList<Shape>>();
	private Point startT;
	
	/**
	 * Constructor new PaintPanel
	 * @param model Reference to the PaintModel which holds all the shapes
	 * @param view Used to be able to talk to our parent or made components of view 
	 */
	public PaintPanel(PaintModel model, View view) {
		
		this.canvas = new Canvas(450, 450);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: "+ this.command);
		this.addEventHandler(MouseEvent.ANY, this);

		this.mode = null; // bad code here?
		this.model = model;
		this.model.addObserver(this);
		this.view = view;
	}
	/**
	 * Clears the canvas and redraws in the order of the shapes drawn
	 */
	public void repaint() {
		
		ArrayList<ArrayList<Shape>> shapes = this.model.getShapes();
		GraphicsContext g = this.canvas.getGraphicsContext2D();

		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		this.setStyle("-fx-background-color: "+ this.command);
		
		for (ArrayList<Shape> l: finalShapes) {
			if (l.size() == 1) {
				for (Shape k: l) {
					if(k.getName() == "p") {
						this.setCommand(new PolyLine (k.getStart(), k.getEnd(), g, this, k.getCol(), k.getThickness(), k.getDotted()));

					}
					else if (k.getName() == "r") {
						this.setCommand(new Rectangle (k.getStart(),k.getEnd(),g, k.getCol(), k.getThickness(), k.getDotted(), k.getFilled()));
					}
					else if (k.getName() == "q") {
						this.setCommand(new Square (k.getStart(),k.getEnd(),g, k.getCol(), k.getThickness(), k.getDotted(), k.getFilled()));

					}
					else if (k.getName() == "c") {
						this.setCommand(new Circle (k.getStart(),k.getEnd(),g, k.getCol(), k.getThickness(), k.getDotted(), k.getFilled()));

					}
				}
			}
			else {
				this.setCommand(new Squiggle (l ,g));

			}

	}
		
		if (shapes.size() != 0) {
			ArrayList<Shape> t = shapes.get(shapes.size()-1);
			if (t.size() == 1) {
				for (Shape s: t) {
					if(s.getName() == "p") { 
						this.setCommand(new PolyLine (s.getStart(), s.getEnd(), g, this, s.getCol(), s.getThickness(), s.getDotted()));
					}
					else if (s.getName() == "r") {
						this.setCommand(new Rectangle (s.getStart(),s.getEnd(),g, s.getCol(), s.getThickness(), s.getDotted(), s.getFilled()));
					}
					else if (s.getName() == "q") { 
						this.setCommand(new Square (s.getStart(),s.getEnd(),g, s.getCol(), s.getThickness(), s.getDotted(), s.getFilled()));
					}
					else if (s.getName() == "c") {
						this.setCommand(new Circle (s.getStart(),s.getEnd(),g, s.getCol(), s.getThickness(), s.getDotted(), s.getFilled()));
					}
				}
			}
			
			else {
				this.setCommand(new Squiggle (t ,g));
			}
		 }
	}
	
	/**
	 * Executes the command
	 * @param command
	 */
	public void setCommand (Command command) {
		command.execute();
	}
	/**
	 * Repaints the canvas
	 */
	@Override
	public void update(Observable o, Object arg) {

		this.repaint();
	}

	/**
	 * Controller aspect of this
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * Returns the mode
	 * @return
	 */
	public String getMode() {
		return this.mode;
	}
	/**
	 * Set Color to command
	 * @param String command
	 */
	public void setColour(String command) {
		this.col = command;
	}
	/**
	 * Set Background Color to command
	 * @param String command
	 */
	public void setBackgroundColour(String command) {
		this.command = command;
	}
	/**
	 * Set Thickness to command
	 * @param double thickness
	 */
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	/**
	 * Set Set shape to the current Shape
	 * @param Shape currentShape
	 */
	public void setShapes(Shape currentShape) {
		this.currentShape = currentShape;
	}

	/**
	 * Return isDotted boolean
	 * @return
	 */
	public boolean getDotted() {
		return this.isDotted;
	}
	/**
	 * Set isDotted
	 * @param boolean isDotted
	 */
	public void setDotted(boolean isDotted) {
		this.isDotted = isDotted;
	}
	/**
	 * Return getFilled
	 * @return
	 */
	public boolean getFilled() {
		return this.isFilled;
	}
	/**
	 * Return isFilled
	 * @param boolean isFilled
	 */
	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	/**
	 * Handles all the mouse events
	 */
	@Override
	public void handle(MouseEvent event) {

		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			mouseDragged(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			mousePressed(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			mouseMoved(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			mouseClicked(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			mouseReleased(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			mouseEntered(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
			mouseExited(event);
		}
	}
	/**
	 * 
	 * @param MouseEvent e
	 */
	private void mouseMoved(MouseEvent e) {

	}
	/**
	 * Handles the dragged and adds each mouse drag move to a list
	 * @param MouseEvent e
	 */
	
	private void mouseDragged(MouseEvent e) {
		Point endPoint = new Point((int)e.getX(),(int) e.getY(), col, thickness);
		if (this.getMode() == "Squiggle") {
			if (points.size() >= 1) {
				this.model.remove();
			}
			points.add(endPoint);
			this.model.addShape(points);
		}
		else {
			ArrayList<Shape> shape = new ArrayList<Shape>();
			if (this.getMode() == "Polyline") {
				this.currentShape.setStartPoint(previous_end);
				this.currentShape.setEndPoint(endPoint);
				this.currentShape.setColour(col);
				this.currentShape.setThickness(thickness);
				shape.add(currentShape);
				this.model.addShape(shape);
			}
			else {
				this.currentShape.setEndPoint(endPoint);
				this.currentShape.setColour(col);
				this.currentShape.setThickness(thickness);
				shape.add(currentShape);
				this.model.addShape(shape);
			}
			
		}

	}
	
	/**
	 * 
	 * @param e
	 */
	private void mouseClicked(MouseEvent e) {

	}
	/**
	 * Handles the mouse clicked and creates a shape
	 * @param mousePressed e
	 */
	private void mousePressed(MouseEvent e) {
		if (startP == false) {
			previous_end = new Point((int) e.getX(), (int) e.getY(), col, thickness);
			startT = new Point((int) e.getX(), (int) e.getY(), col, thickness);
		}
		else {
			startT = new Point((int) e.getX(), (int) e.getY(), col, thickness);
		}
	
		if (this.getMode() == "Polyline") {
			this.currentShape = new Shape(previous_end,startT, this.currentShape.getName(), col, thickness, isDotted, isFilled);	
			this.currentShape.setColour(col);
			this.currentShape.setDotted(this.currentShape.getDotted());
		}
		else {
			if (this.currentShape == null) {
				this.currentShape = new Shape(startT, this.currentShape.getEnd(), this.currentShape.getName(), col, thickness, isDotted, isFilled);
				this.currentShape.setColour(col);
			}
			else {
				this.currentShape = new Shape(startT,this.currentShape.getEnd(), this.currentShape.getName(), col, thickness, isDotted, isFilled);	
				this.currentShape.setColour(col);
			}
		}
	}

	/**
	 * Mouse Event for released and adds the finished shape to a list
	 * @param MouseEVent e
	 */
	private void mouseReleased(MouseEvent e) {
		ArrayList<Shape> shape = new ArrayList<Shape>();
		if (this.getMode() == "Polyline") {
			if (startP == false) {
				startP = true;
			}
			Point end = new Point((int) e.getX(), (int) e.getY(), col, thickness);
			this.currentShape.setEndPoint(end);
			shape.add(this.currentShape);
			this.model.addShape(shape);
			previous_end = end;
		}
		
		else if (this.getMode() == "Squiggle") {
			shape = new ArrayList<Shape>(points);
			points.clear();
			this.model.addShape(shape);
		}
		else {
			Point end = new Point((int) e.getX(), (int) e.getY(), col, thickness);
			this.currentShape.setEndPoint(end);
			shape.add(this.currentShape);
			this.model.addShape(shape);
			
		}
		finalShapes.add(shape);
	}
		
	/**
	 * 
	 * @param MouseEvent e
	 */
	private void mouseEntered(MouseEvent e) {

	}
	/**
	 * 
	 * @param MouseEvent e
	 */
	private void mouseExited(MouseEvent e) {
	}
	/**
	 * Clears final shapes and sets shapes
	 */
	public void setFinalShapes() {
		this.finalShapes.clear();
		this.undo.clear();
		this.model.setShapes();
	}
	/**
	 * Returns finalShapes
	 * @return
	 */
	public ArrayList<ArrayList<Shape>> getFinalShapes() {
		return this.finalShapes;
	}
	/**
	 * undoes the last shape
	 */
	public void undoFinalShapes() {
		if (finalShapes.size() != 0) {
			ArrayList<Shape> temp = finalShapes.get(finalShapes.size()-1);
			undo.add(temp);
			finalShapes.remove(finalShapes.get(finalShapes.size()-1));
			this.model.setShapes(finalShapes);
		}
	}
	/**
	 * Repaste the final shapes
	 */
	public void redoFinalShapes() {
		if (undo.size() != 0) {
			finalShapes.add(undo.get(undo.size()-1));
			undo.remove(undo.get(undo.size()-1));
			this.model.setShapes(finalShapes);
		}
	}
	/**
	 * Copy the last element of the shape list
	 */
	public void copy() {
		if (copy.size() == 0) {
			for (ArrayList<Shape> s: finalShapes) {
				copy.add(s);
			}
		}	
		else {
			copy.clear();
			for (ArrayList<Shape> s: finalShapes) {
				copy.add(s);
			}
		}
	}
	/**
	 * Repaste the last element that was copied or cut
	 */
	public void paste() {
		if (copy.size() != 0) {
			for (ArrayList<Shape> s: copy) {
				finalShapes.add(s);
			}
		}	
	}
	/**
	 * Removes the last element of the array list and saves it in a temporary array
	 */
	public void cut() {
		if (copy.size() == 0) {
			for (ArrayList<Shape> s: finalShapes) {
				copy.add(s);
			}
			finalShapes.clear();
			this.model.setShapes();
		}
		else {
			copy.clear();
			for (ArrayList<Shape> s: finalShapes) {
				copy.add(s);
			}
			finalShapes.clear();
			this.model.setShapes();
		}
	}
}
