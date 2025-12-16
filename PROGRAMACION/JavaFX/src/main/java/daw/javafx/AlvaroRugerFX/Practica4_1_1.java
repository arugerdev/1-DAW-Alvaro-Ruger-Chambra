package daw.javafx.AlvaroRugerFX;

import java.time.LocalTime;

import daw.javafx.AlvaroRugerFX.EjercicioAutobus.Autobus;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Practica4_1_1 extends Ejercicio {

	public Practica4_1_1(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("4.1.1 Practica Autobus"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Clases: Autobus"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		Autobus a1 = new Autobus("1234-ABC","GRANADA","SEVILLA",LocalTime.of(8, 0),3);
		
		Text auto1 = new Text(String.format("Autobus 1"));

		disp.getChildren().add(auto1);

		lineJump(disp);
		
		Button sumar1 = new Button("RESERVAR");
		disp.getChildren().add(sumar1);
		sumar1.setOnAction(e -> {
			
			createTextLabel(a1.Reservar(), disp, false);
			createTextLabel(a1.toString(), disp, false);
		});
		

		Button restar1 = new Button("CANCELAR");
		disp.getChildren().add(restar1);
		restar1.setOnAction(e -> {
			
			createTextLabel(a1.Cancelar(), disp, false);
			createTextLabel(a1.toString(), disp, false);
		});
		
		lineJump(disp);

		
		Autobus a2 = new Autobus("1235-DEF","ECIJA","CORDOBA",LocalTime.of(10, 0),5);
		
		Text auto2 = new Text(String.format("Autobus 2"));

		disp.getChildren().add(auto2);

		lineJump(disp);
		
		Button sumar2 = new Button("RESERVAR");
		disp.getChildren().add(sumar2);
		sumar2.setOnAction(e -> {
			
			createTextLabel(a2.Reservar(), disp, false);
			createTextLabel(a2.toString(), disp, false);
		});
		

		Button restar2 = new Button("CANCELAR");
		disp.getChildren().add(restar2);
		restar2.setOnAction(e -> {
			
			createTextLabel(a2.Cancelar(), disp, false);
			createTextLabel(a2.toString(), disp, false);
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
