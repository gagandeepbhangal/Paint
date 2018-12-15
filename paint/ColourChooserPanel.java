package ca.utoronto.utm.paint;

/**
 * @author groupXXX (Gagandeep Bhangal made this) 
 * This class is used to create a pop up panel that is used to set the colour of the shapes or the background colour of the paint panel.
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class ColourChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	/**
	 * Declare necessary variables
	 */
	private View view;
	private String type;

	/**
	 * Create the buttons needed for the respective colour possibilities and set their colours to the colour of the button itself. Adjust 
	 * colour of text accordingly for readability.
	 * @param view is used to be able to talk to our parent or other components of view
	 */
	public ColourChooserPanel(View view) {

		this.view = view;

		String[] buttonLabels = { "Red", "Blue", "Green", "Orange", "Yellow", "Purple", "Black", "White", "Cyan" };

		int row = 0;
		for (String label : buttonLabels) {
			Button button = new Button(label);
			button.setTextFill(Color.WHITE);
			if (label == "White" || label == "Yellow" || label == "Cyan") {
				button.setTextFill(Color.BLACK);
			}
			button.setMinWidth(400);
			button.setBackground(new Background (new BackgroundFill(Color.web(label), CornerRadii.EMPTY, Insets.EMPTY)));
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
		}
	}

	/**
	 * @param type sets whether Colour or Background was pressed in the EditChooserPanel
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Execute the correct function in PaintPanel based on which button is clicked in which type (Colour or Background)
	 */
	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getText();
		if (this.type == "Colour") {
			this.view.getPaintPanel().setColour(command);
		}
		else {
			this.view.getPaintPanel().setBackgroundColour(command);
			this.view.getPaintPanel().repaint();
		}
	}
}