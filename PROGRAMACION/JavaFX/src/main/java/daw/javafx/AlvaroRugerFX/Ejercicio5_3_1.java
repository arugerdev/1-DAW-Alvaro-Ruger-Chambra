package daw.javafx.AlvaroRugerFX;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio5_3_1 extends Ejercicio {

	public Ejercicio5_3_1(String name, boolean finished) {
		super(name, finished);
	}

	int eva = -1;

	public void start(Stage stage) {
		double[][][] notasArray = new double[3][20][6];

		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("5.2. Ejercicio Arrays"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);
		clearRemove();

		Button submit = new Button("Empezar");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			submit.setText("Siguiente");

			eva++;
			
			// Mostrar resultados al terminar
			if (eva >= notasArray.length) {
				addRemove(submit);
				commitRemove(disp);

				int i = 0;
				for (double[][] ds : notasArray) {
					createTextLabel((i + 1) + "ª Evaluacion", disp, true);

					int i2 = 0;
					for (double[] ds2 : ds) {
						createTextLabel("Alumno " + (i2 + 1) + ": ", disp, true);

						int i3 = 0;
						for (double ds3 : ds2) {
							createTextLabel("Nota " + (i3 + 1) + ": " + ds3, disp, false);

							i3++;
						}

						i2++;
					}
					i++;
				}
				return;
			}
			//

			commitRemove(disp);
			clearRemove();

			
			
// 			En vez de borrar y volver a crear, se puede modificar los valores directamente de los Spinner y demas elementos,
//			pero he decidido hacerlo asi ya que de otra manera haria el codigo mas largo y mas ilegible solo para mejorar el 
//			rendimiento y el coste de hardware.
			
			Label evaluacionL = createTextLabel((eva + 1) + "ª Evaluacion", disp, false);
			addRemove(lineJump(disp));
			addRemove(evaluacionL);

			int alum = 0;
			for (double[] alumno : notasArray[eva]) {
				Label l = createTextLabel("Alumno " + (alum + 1) + ": ", disp, false);
				addRemove(l);

				int asig = 0;
				for (double asignatura : notasArray[eva][alum]) {
					Spinner<Double> n = new Spinner<>(0.0, 10.0, asignatura);
					spinnerKeyboard(n);

					final int alumIndex = alum;
					final int asigIndex = asig;

					n.valueProperty().addListener((obs, oldValue, newValue) -> {
						notasArray[eva][alumIndex][asigIndex] = newValue;
					});

					addRemove(n);
					disp.getChildren().add(n);
					asig++;
				}

				addRemove(lineJump(disp));
				alum++;
			}

		});

		lineJump(disp);
		var scene = new Scene(disp, 1920, 1080);
		stage.setTitle("Tortilla!");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
