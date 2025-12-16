package daw.javafx.AlvaroRugerFX;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio5_1 extends Ejercicio {

	public Ejercicio5_1(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("5.1. Ingredientes tortilla"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		String[][] tortilla = {{"Huevos", "4"}, {"Cebolla", "150gr"}, {"Patatas", "500gr"}, {"Aceite", "50gr"}, {"Sal", "10gr"}};
		
		for (int i = 0; i < tortilla.length; i++) {
			Label l = createTextLabel((i+1) + ". ", disp, true); 
			for (String s : tortilla[i]) {
				l.setText(l.getText() + " " + s);
			}
		}

		lineJump(disp);
		var scene = new Scene(disp, 1920, 1080);
		stage.setTitle("Tortilla!");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
