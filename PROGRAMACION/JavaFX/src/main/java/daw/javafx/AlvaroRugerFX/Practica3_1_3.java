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

public class Practica3_1_3 extends Ejercicio {

	public Practica3_1_3(String name, boolean finished) {
		super(name, finished);
	}

	// Dar la vuelta a caracteres

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.1.3. Dar la vuelta a caracteres"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Dar la vuelta a caracteres"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		TextField input = new TextField();
		disp.getChildren().add(input);

		lineJump(disp);
		Button submit = new Button("HFLIP");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			String result = "";
			for(int i = input.getText().length() - 1; i >= 0; i--) {
				result += input.getText().charAt(i);
			}
			lineJump(disp);
			
			disp.getChildren().add( new Label(result));
		});
		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Flip de texto");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
