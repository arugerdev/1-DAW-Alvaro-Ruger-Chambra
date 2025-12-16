package daw.javafx.AlvaroRugerFX;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_2_1 extends Ejercicio {

	public Ejercicio3_2_1(String name, boolean finished) {
		super(name, finished);
	}

	// Escribe un programa que pida por teclado un día de la semana y que diga qué
	// módulo/asignatura toca a primera hora ese día.

	public enum DAY {
		LUNES, MARTES, MIERCOLES, JUEVES, VIERNES
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format(
				"3.2. 1. Escribe un programa que pida por teclado un día de la semana y que diga qué módulo/asignatura toca a primera hora ese día."));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Inserta el dia: "));
		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		ChoiceBox<DAY> cb = new ChoiceBox<DAY>();
		cb.getItems().addAll(DAY.values());
		cb.setValue(DAY.LUNES);
		disp.getChildren().add(cb);

		lineJump(disp);

		Button submit = new Button("Consultar");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			String val = "";
			switch (cb.getValue()) {
			case LUNES:
				val = "Entorno de desarrollo";
				break;
			case MARTES:
			case MIERCOLES:
			case JUEVES:
			case VIERNES:
				val = "Programación";
				break;
			}

			disp.getChildren().add(new Label("La primera asignatura del " + cb.getValue().toString() + " es: " + val));
			lineJump(disp);

		});

		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Asignatura dependiendo dia");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
