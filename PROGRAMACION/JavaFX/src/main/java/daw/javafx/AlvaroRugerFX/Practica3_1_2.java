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

public class Practica3_1_2 extends Ejercicio {

	public Practica3_1_2(String name, boolean finished) {
		super(name, finished);
	}

	// Cruz indicando tamaño

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.1.2. Cruz indicando tamaño"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Cruz indicando tamaño"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		Spinner<Integer> size = new Spinner<>(3, 100, 3);
		spinnerKeyboard(size);

		disp.getChildren().add(size);

		lineJump(disp);
		Button submit = new Button("GENERAR CRUZ");
		disp.getChildren().add(submit);
		Label error = new Label("Error, el tamaño debe ser inpar");
		submit.setOnAction(e -> {
			if (size.getValue() % 2 == 0) {
				
				disp.getChildren().add(error);
				return;
			}
			
			disp.getChildren().remove(error);
			
			String result = "";

			lineJump(disp);
			
			for (int y = 0; y < size.getValue(); y++) {
				for (int x = 0; x < size.getValue(); x++) {
					if ((y == size.getValue() / 2) || (x == size.getValue() / 2)) {
						result += "* ";
					} else {
						result += "  ";
					}
				}
				result += "\n";
			}
			Label l = new Label(result);
			l.setFont(Font.font("monospace"));
			disp.getChildren().add(l);
		});
		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Dibujar Cruz");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
