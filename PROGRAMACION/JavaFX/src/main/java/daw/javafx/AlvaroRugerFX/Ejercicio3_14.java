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

public class Ejercicio3_14 extends Ejercicio{

	public Ejercicio3_14(String name, boolean finished) {
		super(name, finished);
	}

	//	Realiza un programa que diga si un número introducido por teclado es par y/o divisible entre 5.
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("14. Realiza un programa que diga si un número introducido por teclado es par y/o divisible entre 5."));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Inserta el numero a comprobar: "));
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
		
		Spinner<Integer> n = new Spinner<>(-Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
		spinnerKeyboard(n);
		
		disp.getChildren().add(n);

		lineJump(disp);
    	
    	Button submit = new Button("Comprobar");
    	disp.getChildren().add(submit);
    	submit.setOnAction(e -> {
    		
    		
    		disp.getChildren().add(new Label("Es " + (isDiv(n.getValue(), 2) ? "par" : "impar") + ", " + (isDiv(n.getValue(), 5) ? "SI" : "NO") + " es divisible por 5."));

    	});
		
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Par y/o divisible 5");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
	public static boolean isDiv(Integer value, int div) {
		return (value % div == 0);
	}
	
}
