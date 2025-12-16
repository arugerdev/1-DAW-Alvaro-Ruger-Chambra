package daw.javafx.AlvaroRugerFX;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_5_6 extends Ejercicio {

	public Ejercicio3_5_6(String name, boolean finished) {
		super(name, finished);
	}

	// Construye un programa que almacene un número de 1 a 100 generado
	// aleatóriamente y
	// juegue con el usuario a intentar acertarlo indicando “EL NÚMERO SECRETO ES
	// MAYOR” o que
	// sea menor.

	int steps = 1;
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String
				.format("3.5.6 Construye un programa que almacene un número de 1 a 100 generado aleatóriamente y\n"
						+ "juegue con el usuario a intentar acertarlo indicando “EL NÚMERO SECRETO ES MAYOR” o que sea menor."));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Juego de Adivinar el numero"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		Spinner<Integer> input = new Spinner<>(1, 100, 1);
		spinnerKeyboard(input);

		disp.getChildren().add(input);

		lineJump(disp);

		int rngN = (int) (Math.random() * 100) + 1;
		Button submit = new Button("ADIVINAR");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			
			lineJump(disp);

			if (rngN > input.getValue()) {
				disp.getChildren().add(new Label(steps + ". El numero a adivinar es MAYOR ⬆️"));
			}
			if (rngN < input.getValue()) {
				disp.getChildren().add(new Label(steps + ". El numero a adivinar es MENOR ⬇️"));
			}
			if (rngN == input.getValue()) {
				disp.getChildren().add(new Label(steps + ". HAS ADIVINADO EL NUMERO! 🎉"));
				disp.getChildren().remove(submit);
				
				Button again = new Button("JUGAR DE NUEVO");
				disp.getChildren().add(again);
				again.setOnAction(r -> {
		    		Ejercicio3_5_6 ejercicio3_5_6 = new Ejercicio3_5_6(null, false);
					ejercicio3_5_6.start(new Stage());
					stage.close();
				});
				}
			steps ++;
		});
		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Adivinar numero");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
