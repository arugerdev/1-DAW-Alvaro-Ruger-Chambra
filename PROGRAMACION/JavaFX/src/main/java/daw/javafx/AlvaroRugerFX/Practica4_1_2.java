package daw.javafx.AlvaroRugerFX;

import daw.javafx.AlvaroRugerFX.Practica4_1.Tiempo;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Practica4_1_2 extends Ejercicio {

	public Practica4_1_2(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("4.1.2 Practica Tiempo"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Clases: Tiempo"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		Tiempo t1 = new Tiempo(1,15,30);
		
		Spinner<Integer> h = new Spinner<>(0, 100,0);
		spinnerKeyboard(h);

		Spinner<Integer> m = new Spinner<>(0, 59,0);
		spinnerKeyboard(m);
		
		Spinner<Integer> s = new Spinner<>(0, 59,1);
		spinnerKeyboard(s);
		
		disp.getChildren().add(h);
		disp.getChildren().add(m);
		disp.getChildren().add(s);
		
		Button sumar = new Button("SUMAR");
		disp.getChildren().add(sumar);
		sumar.setOnAction(e -> {
		
			createTextLabel(t1.Sumar(new Tiempo(h.getValue(), m.getValue(), s.getValue())), disp, false);
		});
		

		Button restar = new Button("RESTAR");
		disp.getChildren().add(restar);
		restar.setOnAction(e -> {
			createTextLabel(t1.Restar(new Tiempo(h.getValue(), m.getValue(), s.getValue())), disp, false);
		});
		
		
		lineJump(disp);
		var scene = new Scene(disp, 1920, 1080);
		stage.setTitle("Tiempo!");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}


}
