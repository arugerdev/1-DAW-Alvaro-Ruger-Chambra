package daw.javafx.AlvaroRugerFX;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Practica3_1_1 extends Ejercicio {

	public Practica3_1_1(String name, boolean finished) {
		super(name, finished);
	}

	// Menu del dia de restaurante

	static String[] primeros = {"sopa de verduras", "ensalada", "salmon ahumado", "tabla de quesos"}; 
	static String[] segundos = {"huevo con patatas", "chuleton de ternera", "pollo en salsa"};
	static String[] postres = {"tarta de queso", "helado de fresa"};
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String
				.format("3.1.1. Menu del dia de restaurante"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Menu del dia"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		Button submit = new Button("GENERAR CARTA");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			String primerPlato = primeros[(int)( Math.random() * primeros.length)];
			String segundoPlato = segundos[(int)( Math.random() * segundos.length)];
			String postre = postres[(int)( Math.random() * postres.length)];
			
			
			lineJump(disp);
			lineJump(disp);

			disp.getChildren().add(new Label("1º Plato: " + primerPlato));
			lineJump(disp);
			disp.getChildren().add(new Label("2º Plato: " + segundoPlato));
			lineJump(disp);
			disp.getChildren().add(new Label("Postre: " + postre));
		});
		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Menu del dia");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
