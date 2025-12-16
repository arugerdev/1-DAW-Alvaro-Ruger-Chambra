package daw.javafx.AlvaroRugerFX;

import daw.javafx.AlvaroRugerFX.Practica4_1.Domino;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Practica4_1_3 extends Ejercicio {

	public Practica4_1_3(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		Pane dispDomino = new Pane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("4.1.3 Practica Domino"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Clases: Domino"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		disp.getChildren().add(dispDomino);

		for (int i = 0; i < 6; i++) {
			for (int o = 0; o < 6; o++) {
				Domino d1 = new Domino(i, o, dispDomino);
				d1.setPos(100*o, 40*i);
				dispDomino.getChildren().add(d1.l);
			}
		}

		lineJump(disp);
		var scene = new Scene(disp, 1920, 1080);
		stage.setTitle("Tiempo!");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
