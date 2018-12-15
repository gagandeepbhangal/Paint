package ca.utoronto.utm.paint;

/**
 * @author groupXXX
 * This class is used to create the panel on the canvas which holds all the possible shapes, the fill/dotted mode and the current shape
 * label. It is the bread and butter for what mode the user chooses to draw with.
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	/**
	 * Declare variables
	 */
	private View view; // So we can talk to our parent or other components of the view
	private Label shape;
	public  boolean isDotted = false;
	private boolean  isFill = false;
	private CheckBox chkDotted = new CheckBox();
	private CheckBox chkFilled = new CheckBox();

	/**
	 * Creates the panel with all necessary buttons and labels for the user to choose from to select their mode. 
	 * @param view is used to be able to talk to our parent or other components of view
	 */
	public ShapeChooserPanel(View view) {

		this.view = view;
		PaintPanel p = this.view.getPaintPanel();
		this.view.getPaintPanel().setMode("Cirlce");
		p.setShapes(new Circle("c"));
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline","Dotted", "Fill", "Current Selected Shape:", "1", ""};

		
		int row = 0;
		for (String label : buttonLabels) {
			//Set the default shape chosen label to Circle
			if (label == "") {
				shape = new Label("Circle");
				ImageView imageView = new ImageView();

				Image image = new Image(getClass().getResourceAsStream("Circle.png"));
				imageView.setImage(image);
				imageView.setFitHeight(28);
				imageView.setFitWidth(28);
				shape.setGraphic(imageView);
				shape.setMinWidth(100);
				shape.setFont(Font.font("Verdana", FontWeight.BOLD, 15.5));
				this.add(shape, 0, row);
				row++;
			}
			//Add the label which displays "Current Shape:"
			else if (label == "Current Selected Shape:") {
				Label currentShape = new Label("Current Shape:");
				currentShape.setMaxWidth(100);
				this.add(currentShape, 0, row);
				row++;
			}
			//Add a space
			else if (label == "1") {
				Label currentShape = new Label("");
				currentShape.setMaxWidth(100);
				this.add(currentShape, 0, row);
				row++;
			}
			//Create dotted checkbox
			else if(label == "Dotted") {
				Label dottedLabel = new Label("Dotted: ");
				dottedLabel.setGraphic(chkDotted);
				dottedLabel.setContentDisplay(ContentDisplay.RIGHT);
				dottedLabel.setMaxWidth(Double.MAX_VALUE);
				
				chkDotted.setOnAction(d);
				chkDotted.selectedProperty().addListener(new ChangeListener<Boolean>() {
					@Override
					public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
						if(arg2) {
							view.getPaintPanel().setDotted(true);
						}
						else { 	
							view.getPaintPanel().setDotted(false);


						}
					}
				});
				
				this.add(dottedLabel , 0, row);
				row++;
			}
			//Create fill checkbox
			else if(label == "Fill") {
				Label fillLabel = new Label("Fill:        ");
				fillLabel.setGraphic(chkFilled);
				fillLabel.setContentDisplay(ContentDisplay.RIGHT);
				fillLabel.setAlignment(Pos.CENTER_LEFT);
				fillLabel.setMaxWidth(Double.MAX_VALUE);
				chkFilled.setOnAction(e);
				chkFilled.selectedProperty().addListener(new ChangeListener<Boolean>() {
					@Override
					public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
						if(arg2) {
							setFilled(true);
						}
						else { 	
							setFilled(false);
						}
					}
				});

					this.add(fillLabel , 0, row);
					row++;
			}
			//Create the buttons for the rest of the shapes and set their images
			else{
				Button button = new Button(label);
				ImageView imageView = new ImageView();
				Image image = new Image(getClass().getResourceAsStream( label+ ".png"));
				imageView.setImage(image);
	

				imageView.setFitHeight(28);
				imageView.setFitWidth(28);
				button.setGraphic(imageView);				
				button.setMinWidth(120);
				this.add(button, 0, row);
				row++;
				button.setOnAction(this);
			}
			
		}
	}
	/**
	 * Tell the PaintPanel whether the filled checkbox is chosen or not
	 */
	EventHandler<ActionEvent> e = new EventHandler<ActionEvent>() {
		@Override
		public void handle (ActionEvent event) {
			if (event.getSource() instanceof CheckBox) {
				if(chkFilled.isSelected()) {
					view.getPaintPanel().setFilled(true);
				}
				else {
					view.getPaintPanel().setFilled(false);
				}
			}
		}
		};
	/**
	 * Tell the PaintPanel whether the dotted checkbox is chosen or not
	 */
	EventHandler<ActionEvent> d = new EventHandler<ActionEvent>() {
		@Override
		public void handle (ActionEvent event) {
			if (event.getSource() instanceof CheckBox) {
				if(chkDotted.isSelected()) {
					view.getPaintPanel().setDotted(true);
				}
				else {
					view.getPaintPanel().setDotted(false);
				}
			}
		}
		};
	/**
	 * 
	 * @return whether the filled checkbox is filled or not (true or false)
	 */
	public boolean getFilled() {
		return this.isFill;
	}
	/**
	 * 
	 * @param isFill sets the filled value to true or false depending on whether the checkbox is selected or not
	 */
	public void setFilled(boolean isFill) {
		this.isFill = isFill;
	}

	/**
	 * Set the command to the appropriate shape button pressed and update the current selected shape
	 */
	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getText();
		PaintPanel p = this.view.getPaintPanel();
		this.view.getPaintPanel().setMode(command);
		
		if(command == "Circle") {
			p.setShapes(new Circle("c"));
			}
		else if (command == "Rectangle") {
			p.setShapes(new Rectangle("r"));
		}
		else if (command == "Square") {
			p.setShapes (new Square("q"));
		}
		else if (command == "Polyline") {
			p.setShapes(new PolyLine("p"));
		}
		
		ImageView imageView = new ImageView();

		Image image = new Image(getClass().getResourceAsStream(command+".png"));
		imageView.setImage(image);
		imageView.setFitHeight(28);
		imageView.setFitWidth(28);
		shape.setText(command);
		shape.setGraphic(imageView);
		
	}
}