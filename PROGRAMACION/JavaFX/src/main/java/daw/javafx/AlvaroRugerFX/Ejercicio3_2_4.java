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

public class Ejercicio3_2_4 extends Ejercicio {

	public Ejercicio3_2_4(String name, boolean finished) {
		super(name, finished);
	}

	// Crea un programa que lea desde teclado el nombre de un mes del año y responda indicando el número del trimestre al que pertenece. En el caso de no introducir un mes correcto debe mostrar “ERROR EN EL NOMBRE DEL MES”.

	public enum MONTH {
		ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
	}
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String
				.format("3.2. 4. Crea un programa que lea desde teclado el nombre de un mes del año y \n"
						+ " responda indicando el número del trimestre al que pertenece. \n"
						+ "En el caso de no introducir un mes correcto debe mostrar “ERROR EN EL NOMBRE DEL MES”."));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Inserta el mes: "));
		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		ChoiceBox<MONTH> cb = new ChoiceBox<MONTH>();
		cb.getItems().addAll(MONTH.values());
		cb.setValue(MONTH.ENERO);
		disp.getChildren().add(cb);

		lineJump(disp);

		Button submit = new Button("Calcular");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			String val = "";
			switch (cb.getValue()) {
			case ENERO:
			case FEBRERO:
			case MARZO:
			case ABRIL:
				val = "1º trimestre";
				break;
			case MAYO:
			case JUNIO:
			case JULIO:
			case AGOSTO:
				val = "2º trimestre";
				break;
			case SEPTIEMBRE:
			case OCTUBRE:
			case NOVIEMBRE:
			case DICIEMBRE:
				val = "3º trimestre";
				break;
			}
			
//			Tambien funcionaria de la siguiente manera:
/*
 * 			(Math.round((cb.getValue().ordinal()) / 4) + 1)
*/
			

			disp.getChildren().add(new Label("El trimestre del mes " + cb.getValue().toString() + " es: " + val));
			lineJump(disp);

		});

		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Trimestre");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
