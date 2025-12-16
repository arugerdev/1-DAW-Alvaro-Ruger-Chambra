package daw.javafx.AlvaroRugerFX;

import daw.javafx.AlvaroRugerFX.EjercicioJarra.Jarra;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EjerJarra extends Ejercicio {

	public EjerJarra(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("4. Ejercicio Jarra"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Clases: Jarra"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		ProgressBar pb1 = new ProgressBar(0);
		ProgressBar pb2 = new ProgressBar(0);
		
		Label l1 = new Label();
		Label l2 = new Label();

		Jarra jarra = new Jarra(5, pb1, l1);
		Jarra otrajarra = new Jarra(3, pb2, l2);

		lineJump(disp);

		disp.getChildren().add(pb1);
		disp.getChildren().add(l1);
		
		lineJump(disp);

		disp.getChildren().add(pb2);
		disp.getChildren().add(l2);
		
		lineJump(disp);
		
		Spinner<Integer> rellenarLitros = new Spinner<>(0, 10,0);
		spinnerKeyboard(rellenarLitros);

		disp.getChildren().add(rellenarLitros);
		
		Button rellenar = new Button("RELLENAR");
		disp.getChildren().add(rellenar);
		rellenar.setOnAction(e -> {
			jarra.rellenar(rellenarLitros.getValue());
		});
		
		lineJump(disp);


		Spinner<Integer> transpasarLitros = new Spinner<>(0, 10,0);
		spinnerKeyboard(transpasarLitros);

		disp.getChildren().add(transpasarLitros);
		
		Button transpasar = new Button("TRANSPASAR");
		disp.getChildren().add(transpasar);
		transpasar.setOnAction(e -> {
			jarra.traspasar(otrajarra, transpasarLitros.getValue());
		});
		
		lineJump(disp);

		
		Button llenar = new Button("LLENAR");
		disp.getChildren().add(llenar);
		llenar.setOnAction(e -> {
			jarra.llenar();
		});
		
		Button vaciar = new Button("VACIAR");
		disp.getChildren().add(vaciar);
		vaciar.setOnAction(e -> {
			jarra.vaciar();
		});
		
		createTextLabel(jarra.toString(), disp, true);
		lineJump(disp);
		var scene = new Scene(disp, 1920, 1080);
		stage.setTitle("Jarra!");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}


}
