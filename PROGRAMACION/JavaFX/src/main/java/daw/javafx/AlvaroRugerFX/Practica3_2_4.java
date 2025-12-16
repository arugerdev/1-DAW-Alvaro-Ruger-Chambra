package daw.javafx.AlvaroRugerFX;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Practica3_2_4 extends Ejercicio {

	public Practica3_2_4(String name, boolean finished) {
		super(name, finished);
	}

	// Solo pares

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.2.4. Mitad del numero"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Mitad del numero"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		TextField input = new TextField();

		// ######################### Solo numeros - StackOverflow
		// #########################
		// Añade un listener al input,
		// si el valor nuevo no hace match con los numerales,
		// no lo escribe
		input.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					input.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		// ################################################################################

		disp.getChildren().add(input);

		lineJump(disp);
		Button submit = new Button("CALCULAR");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			String texto = input.getText();

			if (texto.length() != 8) {
				disp.getChildren().add(new Label("El número debe tener exactamente 8 cifras."));
				return;
			}

			
			String primeraMitad = "";
			String segundaMitad = "";
			
			for (int i = 0; i <= input.getText().length() / 2 - 1; i++) {
				primeraMitad += input.getText().charAt(i);
			}
			for (int i = input.getText().length()/2; i <= input.getText().length() - 1; i++) {
				segundaMitad += input.getText().charAt(i);
			}
			
//			String primeraMitad = texto.substring(0, 4);
//			String segundaMitad = texto.substring(4);

			int coincidencias = 0;
			StringBuilder iguales = new StringBuilder();

			for (int i = 0; i < 4; i++) {
				if (primeraMitad.charAt(i) == segundaMitad.charAt(i)) {
					coincidencias++;
					iguales.append(primeraMitad.charAt(i)).append(" ");
				}
			}

			lineJump(disp);
			disp.getChildren().add(new Label("Primera mitad: " + primeraMitad));
			disp.getChildren().add(new Label("Segunda mitad: " + segundaMitad));
			lineJump(disp);
			disp.getChildren().add(new Label("Dígitos coincidentes: " + coincidencias));

			if (coincidencias > 0) {
				disp.getChildren().add(new Label("Coinciden: " + iguales.toString()));
			} else {
				disp.getChildren().add(new Label("No hay coincidencias."));
			}

		});
		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Mitad del numero");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
