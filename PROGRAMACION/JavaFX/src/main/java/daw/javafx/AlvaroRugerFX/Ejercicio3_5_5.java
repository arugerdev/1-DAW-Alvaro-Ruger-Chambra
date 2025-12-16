package daw.javafx.AlvaroRugerFX;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_5_5 extends Ejercicio {

	public Ejercicio3_5_5(String name, boolean finished) {
		super(name, finished);
	}

	// Construir un programa que juegue con el usuario a PIEDRA, PAPEL y TIJERA.

	public enum TYPE {
		PIEDRA, PAPEL, TIJERA
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(
				String.format("3.5.5 Construir un programa que juegue con el usuario a PIEDRA, PAPEL y TIJERA."));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Juego de piedra papel tijeras "));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		
		ChoiceBox<TYPE> cb = new ChoiceBox<TYPE>();
		cb.getItems().addAll(TYPE.values());
		cb.setValue(TYPE.PAPEL);
		disp.getChildren().add(cb);

		lineJump(disp);

		Button submit = new Button("JUGAR");
		Label points = new Label("PUNTOS: P1 0 - CPU 0");
		int[] p1 = { 0 };
		int[] cpu = { 0 };

		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			lineJump(disp);
			TYPE machine_selection = TYPE.values()[(int) (Math.random() * 3)];

			disp.getChildren().add(new Label("La maquina elije: " + machine_selection.toString()));
			boolean win = winPlayer((TYPE) cb.getValue(), machine_selection);
			Label l = new Label("El ganador es " + (win ? "el jugador."
					: ((TYPE) cb.getValue()).equals(machine_selection) ? "nadie, ha sido empate." : "la maquina."));
			if (win) {
				l.setStyle("-fx-text-fill: #7FB685;");
				p1[0] = p1[0] + 1;
			} else if (((TYPE) cb.getValue()).equals(machine_selection)) {
				l.setStyle("-fx-text-fill: #F2C57C;");
			} else {
				l.setStyle("-fx-text-fill: #EF6F6C;");
				cpu[0] = cpu[0] + 1;
			}
			disp.getChildren().add(l);
			points.setText("PUNTOS: P1 " + p1[0] + " - CPU " + cpu[0]);

		});

		disp.getChildren().add(points);
		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Juego piedra papel tijeras");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

	public boolean winPlayer(TYPE player_play, TYPE machine_play) {
		switch (player_play) {
		case PAPEL:
			return machine_play.equals(TYPE.PIEDRA);
		case PIEDRA:
			return machine_play.equals(TYPE.TIJERA);
		case TIJERA:
			return machine_play.equals(TYPE.PAPEL);
		default:
			return false;
		}
	}

}
