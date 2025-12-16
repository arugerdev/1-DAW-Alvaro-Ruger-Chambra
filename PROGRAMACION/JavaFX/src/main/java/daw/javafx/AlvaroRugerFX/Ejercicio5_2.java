package daw.javafx.AlvaroRugerFX;

// #######################################
// METODO EN JAVA SIN JAVAFX
// #######################################
//
//		int sizeArray = 0;
//		do {
//			try {
//				sizeArray = Integer.parseInt(JOptionPane.showInputDialog("Indica un numero del 1 al 100: "));
//			} catch (Exception err) {
//				System.exit(1);
//			}
//
//		} while (sizeArray < 1 || sizeArray > 100);
//
//		String[] arrayS = new String[sizeArray];
//
//		for (String s : arrayS) {
//			System.out.print(s + ", ");
//		}
//
//		int pointer = -1;
//		do {
//			try {
//				pointer = Integer
//						.parseInt(JOptionPane.showInputDialog("Indica un numero del 0 al " + arrayS.length + ": "));
//			} catch (Exception err) {
//				System.exit(1);
//			}
//		} while (pointer < 0 || pointer >= arrayS.length);
//
//		String insertS = JOptionPane.showInputDialog("Indica una cadena de texto a insertar: ");
//
//		arrayS[pointer] = insertS;
//
//		System.out.println("\n");
//		
//		int c = 0;
//		for (String s : arrayS) {
//			c++;
//			System.out.print(s + (c % 5 == 0 ? ", \n" : ", "));
//		}
//
// ###########################################################################################################################

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio5_2 extends Ejercicio {

	public Ejercicio5_2(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("5.2. Ejercicio Arrays"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Spinner<Integer> sizeArray = new Spinner<>(1, 100, 1);
		spinnerKeyboard(sizeArray);

		disp.getChildren().add(sizeArray);

		Button submit = new Button("ENVIAR");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {

			clearRemove();
			
			Control[] controls = {sizeArray, submit};
			addRemove(controls);
			
			commitRemove(disp);
			
			String[] arrayStrings = new String[sizeArray.getValue()];

			int c = 0;
			for (String string : arrayStrings) {
				createTextLabel(c + ". " + string, disp, false);
				c++;
			}
			lineJump(disp);
			lineJump(disp);

			Label l1 = createTextLabel("Puntero: ", disp, false);
			Spinner<Integer> pointer = new Spinner<>(0, arrayStrings.length, 0);
			spinnerKeyboard(pointer);

			disp.getChildren().add(pointer);

			lineJump(disp);

			Label l2 = createTextLabel("Texto a insertar: ", disp, false);
			TextField insertS = new TextField();
			disp.getChildren().add(insertS);

			Button submit2 = new Button("ENVIAR");
			disp.getChildren().add(submit2);
			submit2.setOnAction(ev -> {

				clearRemove();
				
				Control[] controls2 = {l2, insertS, pointer, l1, submit2};
				addRemove(controls2);
				
				commitRemove(disp);

				arrayStrings[pointer.getValue()] = insertS.getText();

				int i = 0;
				for (String string : arrayStrings) {
					createTextLabel(i + ". " + string, disp, (i % 5 == 0));
					i++;
				}
			});

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
