package ca.utoronto.utm.paint;

/**
 * @author groupXXX (Anthony made this)
 * This class is used to create a panel with options to change the thickness of the stroke of shapes
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ThicknessPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view;
	
	/**
	 * Create the panel with the buttons of the thicknesses and their respective images. Add the panel to the Canvas
	 * @param view is used to be able to talk to our parent or other components of view
	 */
	public ThicknessPanel(View view) {
		
		this.view = view;
		String [] buttonLabels = {"2" , "4", "8","12", "16" };

		int row = 0;
		for (String label : buttonLabels) {
			Button button = new Button(label);
			Image image = new Image(getClass().getResourceAsStream("thickness"+label+".PNG"));
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			imageView.setFitWidth(230);
			imageView.setFitHeight(Integer.parseInt(label));
			button.setMinWidth(400);
			button.setAlignment(Pos.TOP_CENTER);
			button.setGraphic(imageView);
			button.setMaxWidth(280);;
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
		}
	}
	
	/**
	 * Execute the correct method in PaintPanel to set the thickness to the double value of the button the user pressed
	 */
	@Override
	public void handle(ActionEvent event) {

		try {
			String command = ((Button) event.getSource()).getText();
			this.view.getPaintPanel().setThickness(Double.parseDouble(command));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}

}
