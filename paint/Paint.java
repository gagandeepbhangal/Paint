package ca.utoronto.utm.paint;
/**
 * 
 * @author groupXXX
 * 
 * This class is the main of the program
 * It initiates the model, view, and the PaintPanel
 * the fieds for this class is the model and the View + controller
 * 
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Paint extends Application {

	PaintModel model; // Model
	View view; // View + Controller

	/**
	 * main of the program
	 * 
	 * @param String[]
	 *            args
	 * @return void
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Throws an exception if an event is not handled correctly
	 * 
	 * @param Stage
	 * @return void
	 */
	@Override
	public void start(Stage stage) throws Exception {

		this.model = new PaintModel();

		// View + Controller
		this.view = new View(model, stage);
		this.view.getPaintPanel().setColour("white");
	}
}