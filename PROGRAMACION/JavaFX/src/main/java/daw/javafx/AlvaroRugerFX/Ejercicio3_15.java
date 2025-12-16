package daw.javafx.AlvaroRugerFX;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_15 extends Ejercicio {

	public Ejercicio3_15(String name, boolean finished) {
		super(name, finished);
	}

	// Escribe un programa que pinte una pirámide rellena con un carácter
	// introducido por teclado que podrá ser una letra, un número o un símbolo como
	// *, +, -, $, &, etc. El programa debe permitir al usuario mediante un menú
	// elegir si el vértice de la pirámide está apuntando hacia arriba, hacia abajo,
	// hacia la izquierda o hacia la derecha.

	public enum DIR {
		ARRIBA, ABAJO, DERECHA, IZQUIERDA
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format(
				"15. Escribe un programa que pinte una pirámide rellena con un carácter introducido por teclado que podrá ser una letra, \n"
						+ " un número o un símbolo como *, +, -, $, &, etc. El programa debe permitir al usuario mediante un menú elegir si el vértice de la pirámide está \n"
						+ "apuntando hacia arriba, hacia abajo, hacia la izquierda o hacia la derecha."));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Inserta la direccion y el caracter de relleno: "));
		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		ChoiceBox<DIR> dir = new ChoiceBox<DIR>();
		dir.getItems().addAll(DIR.values());
		dir.setValue(DIR.ARRIBA);
		disp.getChildren().add(dir);

		lineJump(disp);

		TextField c = new TextField();

		disp.getChildren().add(c);

		lineJump(disp);

		Spinner<Integer> size = new Spinner<>(3, 150, 0);

		spinnerKeyboard(size);

		disp.getChildren().add(size);

		Button submit = new Button("Dibujar");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			String v = "";
			int n = size.getValue();
			String ch = c.getText();

			if (ch.isEmpty())
				ch = "*";

			switch (dir.getValue()) {
			case ARRIBA:
				for (int i = 1; i <= n; i++) {
					for (int j = i; j < n; j++) {
						v += "  ";
					}
					for (int j = 1; j <= (2 * i - 1); j++) {
						v += ch + " ";
					}
					v += "\n";
				}
				break;

			case DERECHA:
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= i; j++) {
						v += ch + " ";
					}
					v += "\n";
				}
				for (int i = n - 1; i >= 1; i--) {
					for (int j = 1; j <= i; j++) {
						v += ch + " ";
					}
					v += "\n";
				}
				break;

			case ABAJO:
				for (int i = n; i >= 1; i--) {
					for (int j = i; j < n; j++) {
						v += "  ";
					}
					for (int j = 1; j <= (2 * i - 1); j++) {
						v += ch + " ";
					}
					v += "\n";
				}
				break;

			case IZQUIERDA:
				for (int i = 1; i <= n; i++) {
					for (int j = i; j < n; j++) {
						v += "  ";
					}
					for (int j = 1; j <= i; j++) {
						v += ch + " ";
					}
					v += "\n";
				}
				for (int i = n - 1; i >= 1; i--) {
					for (int j = i; j < n; j++) {
						v += "  ";
					}
					for (int j = 1; j <= i; j++) {
						v += ch + " ";
					}
					v += "\n";
				}
				break;
			}
			Label l = new Label(v);
			l.setFont(Font.font("monospace"));
			disp.getChildren().add(l);

		});

		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Piramides");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
