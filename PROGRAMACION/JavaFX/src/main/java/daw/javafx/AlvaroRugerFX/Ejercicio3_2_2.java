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

public class Ejercicio3_2_2 extends Ejercicio {

	public Ejercicio3_2_2(String name, boolean finished) {
		super(name, finished);
	}

	// Realiza un programa que pida una hora por teclado y que muestre luego buenos
	// días, buenas tardes o buenas noches según la hora. Se utilizarán los tramos
	// de 6 a 12, de 13 a 20 y de 21 a 5. respectivamente. Solo se tienen en cuenta
	// las horas, los minutos no se deben introducir por teclado.

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String
				.format("3.2. 2. Realiza un programa que pida una hora por teclado y que muestre luego buenos días, \n"
						+ "buenas tardes o buenas noches según la hora. Se utilizarán los tramos de 6 a 12, de 13 a 20 y de 21 a 5. \n"
						+ "respectivamente. Solo se tienen en cuenta las horas, los minutos no se deben introducir por teclado."));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Inserta el dia: "));
		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		Spinner<Integer> hours = new Spinner<>(0, 23, 12);
		Spinner<Integer> minutes = new Spinner<>(0, 59, 30);

		spinnerKeyboard(hours);
		spinnerKeyboard(minutes);

		disp.getChildren().add(hours);
		disp.getChildren().add(new Label(":"));
		disp.getChildren().add(minutes);

		lineJump(disp);

		Button submit = new Button("Saludar");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			String v = "";
			switch (hours.getValue()) {
			case 6, 7, 8, 9, 10, 11, 12:
				v = "Buenos dias";
				break;
			case 13, 14, 15, 16, 17, 18, 19, 20:
				v = "Buenas tardes";
				break;
			case 21, 22, 23, 0, 1, 2, 3, 4, 5:
				v = "Buenas noches";
				break;

			}

			disp.getChildren().add(new Label(v));

		});

		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Saludo dependiendo hora");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
