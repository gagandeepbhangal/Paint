package ca.utoronto.utm.paint;

/**
 * ShapeStrategy interface
 * @author groupXXX
 *
 */
public interface ShapeStrategy {
	
	/**
	 * Sets starting point to start.
	 * @param start 	Starting point when the user presses.
	 */
	public void setStartPoint(Point start);
	
	/**
	 * Sets the ending point to end.
	 * @param end	Ending point when the user releases.
	 */
	public void setEndPoint (Point end);
	
}