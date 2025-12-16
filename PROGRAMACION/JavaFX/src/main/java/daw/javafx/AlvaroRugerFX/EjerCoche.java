package daw.javafx.AlvaroRugerFX;

import daw.javafx.AlvaroRugerFX.EjercicioCoche.Coche;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EjerCoche extends Ejercicio {

	public EjerCoche(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("4. Ejercicio Coche"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Clases: Coche"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		Coche c1 = new Coche(100, 2, 3);

		Box box = new Box(1600.0f, 800.0f, 1.0f);

		// create a Group
		Group group = new Group(box);

		c1.gp = group;
		c1.render();

		// translate the box to a position
		box.setTranslateX(100);
		box.setTranslateY(100);

		disp.getChildren().add(group);

		lineJump(disp);

		Label combustibleL = new Label(c1.combustible + "L");
		Label orientationL = new Label(c1.orientation + "º");
		Label velocidadL = new Label(c1.velocidad + " km/h");

		c1.combustibleL = combustibleL;
		c1.orientationL = orientationL;
		c1.velocidadL = velocidadL;

		disp.getChildren().add(combustibleL);

		Button girarIzq = new Button("<- ");
		disp.getChildren().add(girarIzq);
		girarIzq.setOnAction(e -> {
			c1.turnL();
		});

		disp.getChildren().add(orientationL);

		Button girarDer = new Button(" ->");
		disp.getChildren().add(girarDer);
		girarDer.setOnAction(e -> {
			c1.turnR();
		});

		Button marcha = new Button("FORWARD");
		disp.getChildren().add(marcha);
		marcha.setOnAction(e -> {
			if (c1.marcha.equals(Coche.MARCHA.ADELANTE)) {
				c1.setMarcha(Coche.MARCHA.ATRAS);
			} else if (c1.marcha.equals(Coche.MARCHA.ATRAS)) {
				c1.setMarcha(Coche.MARCHA.ADELANTE);
			}
		});

		c1.marchaB = marcha;

		Button acelerar = new Button("Acelerar");
		disp.getChildren().add(acelerar);
		acelerar.setOnAction(e -> {
			c1.acelerar();
		});

		disp.getChildren().add(velocidadL);

		Button frenar = new Button("Frenar");
		disp.getChildren().add(frenar);
		frenar.setOnAction(e -> {
			c1.frenar();
		});

		Button avanzar = new Button("Avanzar");
		disp.getChildren().add(avanzar);
		avanzar.setOnAction(e -> {
			c1.avanzar();
		});

		Button detener = new Button("Detener");
		disp.getChildren().add(detener);
		detener.setOnAction(e -> {
			c1.detener();
			velocidadL.setText(c1.velocidad + " km/h");
		});
		lineJump(disp);

		var scene = new Scene(disp, 1920, 1080);
		stage.setTitle("Coche!");
		stage.setScene(scene);
		stage.setWidth(1920);
		stage.setHeight(1080);
		stage.show();

		c1.enableControls(scene);
	}

}
