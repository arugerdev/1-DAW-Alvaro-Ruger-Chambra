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

public class Ejercicio3_17 extends Ejercicio{

	public Ejercicio3_17(String name, boolean finished) {
		super(name, finished);
	}

	//	Escribe un programa que diga cuál es la primera cifra de un número entero introducido por teclado. Se permiten números de hasta 5 cifras.
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("17. Escribe un programa que diga cuál es la primera cifra de un número entero introducido por teclado. Se permiten números de hasta 5 cifras."));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Inserta el numero que quiere saber su primera cifra (max 99.999): "));
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
		
		Spinner<Integer> n = new Spinner<>(-99999, 99999, 0);
		spinnerKeyboard(n);

		disp.getChildren().add(n);

		lineJump(disp);
    	
    	Button submit = new Button("Calcular");
    	disp.getChildren().add(submit);
    	submit.setOnAction(e -> {
    		
    		
    		disp.getChildren().add(new Label("La primera cifra es " + (Math.abs(n.getValue()) + "").toCharArray()[0] ));

    	});
		
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Primera cifra");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
}
