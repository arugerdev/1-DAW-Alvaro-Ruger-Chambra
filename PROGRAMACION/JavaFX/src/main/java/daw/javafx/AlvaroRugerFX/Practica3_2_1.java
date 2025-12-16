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

public class Practica3_2_1 extends Ejercicio {

	public Practica3_2_1(String name, boolean finished) {
		super(name, finished);
	}

	// Fecha aleatoria

	static int dia = 0;
	static EMES mes = EMES.Enero;
	static int año = 0;

	static enum EMES {
		Enero(31),
		Febrero(28),
		Marzo(31),
		Abril(30),
		Mayo(31),
		Junio(30),
		Julio(31),
		Agosto(31),
		Septiembre(30),
		Octubre(31),
		Noviembre(30),
		Diciembre(31);

	    public final int maxDay;
		
		EMES(int i) {
			this.maxDay = i;
		}
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.2.1. Fecha aleatoria"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Fecha aleatoria"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		Button submit = new Button("GENERAR FECHA");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			
			mes = EMES.values()[(int) (Math.random() * EMES.values().length)];
			dia = (int) (Math.random() * mes.maxDay + 1);
			año = (int)(Math.random() * (2060 - 1961) + 1960 );
					

			disp.getChildren().add(new Label("" + dia + " de " + mes + " del " + año));
			lineJump(disp);
		});
		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Fecha aleatoria");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
