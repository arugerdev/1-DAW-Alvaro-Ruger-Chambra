package daw.javafx.AlvaroRugerFX;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_5_4 extends Ejercicio {

	public Ejercicio3_5_4(String name, boolean finished) {
		super(name, finished);
	}

	// Construir un programa que visualice por pantalla todos los caracteres correspondientes a letras minúsculas 

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(("3.5.4 Construir un programa que visualice por pantalla todos los caracteres\n"
				+ "correspondientes a letras minúsculas "));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Todas las minusculas"));
		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		char l = 'a';

		while (l <= 'z') {
			disp.getChildren().add(new Label(" " + l));
			l++;
		}

		lineJump(disp);


		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Trimestre");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
