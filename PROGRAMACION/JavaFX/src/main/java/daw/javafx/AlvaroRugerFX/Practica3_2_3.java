package daw.javafx.AlvaroRugerFX;

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

public class Practica3_2_3 extends Ejercicio {

	public Practica3_2_3(String name, boolean finished) {
		super(name, finished);
	}

	// Sumar en uno

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.2.3. Sumar en uno"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Sumar en uno"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		TextField input = new TextField();
		disp.getChildren().add(input);

		lineJump(disp);
		Button submit = new Button("SUMAR EN UNO");
		disp.getChildren().add(submit);
		Label errL = new Label("El contenido introducido no son numeros, reviselo.");
		submit.setOnAction(e -> {
			try {
				disp.getChildren().remove(errL);
				String result = "";
				for (int i = 0; i < input.getText().length(); i++) {
					int digit = Integer.parseInt("" + input.getText().charAt(i));
					result += (digit == 9 ? "0" : digit + 1);
				}
				lineJump(disp);

				disp.getChildren().add(new Label(result));

			} catch (Exception err) {
				disp.getChildren().add(errL);
				return;
			}

		});
		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Sumar en uno");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
