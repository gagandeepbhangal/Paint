package ca.utoronto.utm.paint;

/**
 * @author groupXXX (Created by Gagandeep Bhangal) 
 * This class is used to add the panel to the right side of the PaintPanel which holds buttons to change thickness, colour, and background colour.
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EditChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	/**
	 * Declare variables
	 */
	private View view;
	private ColourChooserPanel colourChooserPanel;
	private ThicknessPanel thicknessPanel;

	/**
	 * Set the necessary panels used by the buttons added to this panel
	 * Add the buttons to the panel and add the panel to PaintPanel
	 * @param view is used to be able to talk to our parent or other components of view
	 */
	public EditChooserPanel(View view) {
		
		this.view = view;
		this.colourChooserPanel = new ColourChooserPanel(view);
		this.thicknessPanel = new ThicknessPanel(view);
		String[] buttonLabels = {"Thickness", "Colour", "Background "};

		int row = 0;
		
		for (String label: buttonLabels) {
			Button button = new Button(label);
			button.setFont(Font.font("Times New Roman", 18));				
			button.setMinWidth(120);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
			
		}
	}
	
	/**
	 * Set the thickness in the PaintPanel class
	 * @param thick is the thickness value we wish to set the shapes to
	 */
	public void setThick(Double thick) {
		this.view.getPaintPanel().setThickness(thick);
	}
	
	/**
	 * Carry out the necessary commands for the respective button pressed.
	 * Pop up the respective panel for the correct button, colourchooserpanel for when Colour or Background is pressed and
	 * thicknesschooserpanel when the thickness button is pressed.
	 */
	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getText();
		if (command == "Colour" || command == "Background ") {
			String type = command;
			this.colourChooserPanel.setType(type);
			BorderPane colours = new BorderPane();
			colours.setCenter(this.colourChooserPanel);
			Scene scene2 = new Scene(colours);
			Stage stage2 = new Stage();
			stage2.setScene(scene2);
			if (command != "Background ") {
				command = "";
			}
			stage2.setTitle("Change " + command + "Colour");
			stage2.show();		
		}
		else {
			BorderPane thickness = new BorderPane();
			thickness.setCenter(this.thicknessPanel);
			Scene scene2 = new Scene(thickness);
			Stage stage2 = new Stage();
			stage2.setScene(scene2);
			stage2.setTitle("Change Thickness");
			stage2.show();	
		}
	}
}
