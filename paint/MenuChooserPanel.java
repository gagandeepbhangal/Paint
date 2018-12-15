package ca.utoronto.utm.paint;

/**
 * @author groupXXX (Gagandeep Bhangal made this) 
 * RESPONDS-TO View
 * This class is used to create a pop up panel that is used to set the colour of the shapes or the background colour of the paint panel.
 */

import javafx.scene.layout.GridPane;

public class MenuChooserPanel extends GridPane {

	private View view; // So we can talk to our parent or other components of the view

	/**
	 * @param view is used to be able to talk to our parent or other components of view
	 */
	public MenuChooserPanel(View view) {

		this.view = view;

	}

	/**
	 * Execute the correct methods in PaintPanel which clear all shapes drawn and erase them from the canvas
	 */
	public void clear() {
		this.view.getPaintPanel().setFinalShapes();
		this.view.getPaintPanel().repaint();
	}

	/**
	 * Execute the correct methods in PaintPanel to remove the last shape drawn and erase it
	 */
	public void undo() {
		this.view.getPaintPanel().undoFinalShapes();
		this.view.getPaintPanel().repaint();
	}

	/**
	 * Execute the correct methods in PaintPanel to add the last shape erased (if any) and show it
	 */
	public void redo() {
		this.view.getPaintPanel().redoFinalShapes();
		this.view.getPaintPanel().repaint();
	}

	/**
	 * Execute the correct methods in PaintPanel to copy all the current shapes on the canvas
	 */
	public void copy() {
		this.view.getPaintPanel().copy();
	}

	/**
	 * Execute the correct methods in PaintPanel to paste all copied shapes (if any) to the canvas
	 */
	public void paste() {
		this.view.getPaintPanel().paste();
		this.view.getPaintPanel().repaint();
	}

	/**
	 * Execute the correct methods in PaintPanel to copy all the current drawn shapes and then erase them from the canvas
	 */
	public void cut() {
		this.view.getPaintPanel().cut();
		this.view.getPaintPanel().repaint();
	}

}
