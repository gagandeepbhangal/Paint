package ca.utoronto.utm.paint;

/**
 * 
 * @author groupXXX
 * IS-A Shape 
 * This class extends Shape
 * This class creates a point that is used by every shape to draw itself in the respective class.
 * Used by the Circle to get the radius and a point to draw the circumference of the circle
 * Used by the Square to compute the length width and the edges that are used to draw the rectagle
 * Used by the Squiggle to stroke the line between the points to draw the point to point strokes.
 * Used by the PolyLine to get the start and point to connect the lines.
 *
 */

public class Point extends Shape{
	int x, y;
	private String col = "white"; // presets the col to white default
	private double thickness = 1.0;//presets the thickness to 1.0 
	
	/**
	 * Constructor of the class used when an X and Y coordinate is known
	 * Set the correct values to the point (x-coordinate, y-coordinate, colour, thickness)
	 * @param int x
	 * @param int y
	 * @param x is the x-coordinate of the point
	 * @param y is the y-coordinate of the point
	 */
	Point(int x, int y) {
		this.x = x; //initialises the x coordinate
		this.y = y; //initialises the y coordinate
		super.setColour(col);
		super.setThickness(thickness);
	}
	
	/**
	 * Alternative constructor that is used when the points are not known and a reference to the point is needed
	 * @param null
	 * @return null
<<<<<<< HEAD
	 * 
=======
>>>>>>> 29b947a71e5e60c48e7c2f9648be52d455797f35
	 */
	Point(){
		
	}
	
	/**
<<<<<<< HEAD
	 * 
	 * Alternative constructor when the thickness is being set to thickness other than 1.0
	 * Alternative constructor used when the col is being set to a col other than white
	 * 
	 * @param x
	 * @param y
	 * @param col
	 * @param thickness
=======
	 * Alternative constructor when the thickness is being set to thickness other than 1.0
	 * Alternative constructor used when the col is being set to a col other than white
	 * @param x represents the x-coordinate
	 * @param y represents the y-coordinate
	 * @param col represents the String value of the colour of the point
	 * @param thickness is the double thickness value of the point
>>>>>>> 29b947a71e5e60c48e7c2f9648be52d455797f35
	 */
	Point(int x, int y, String col, double thickness) {
		this.x = x;
		this.y = y;
		this.col = col;
		super.setColour(col);
		super.setThickness(thickness);
	}
	

	/**
	 * 
	 * gets and returns the X coordinate of a point
	 * @param null
	 * @return int x 
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * sets the X coordinate of the current x coordinate
<<<<<<< HEAD
	 * 
	 * @param x
	 * @return void
=======
	 * @param x sets the x-coordinate of the point
>>>>>>> 29b947a71e5e60c48e7c2f9648be52d455797f35
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * gets and returns the Y coordinate of the current point
	 * 
	 * @param null
	 * @return int Y
	 * 
	 */
	
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param int y
	 * @return void
	 */
	public void setY(int y) {
		this.y = y;
	}
}