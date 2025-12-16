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

public class Ejercicio3_3_4 extends Ejercicio{

	public Ejercicio3_3_4(String name, boolean finished) {
		super(name, finished);
	}

	//	Escribe un programa que calcule el factorial de un número entero leído por teclado. Hazlo con un bucle for() descendente acumulando el valor multiplicado hasta el momento en la misma variable.
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.3 4. Escribe un programa que calcule el factorial de un número entero leído por teclado. \n"
				+ " Hazlo con un bucle for() descendente acumulando el valor multiplicado hasta el momento en la misma variable."));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Calculador factorial "));
		
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
    	
		Spinner<Integer> num = new Spinner<>(1, Integer.MAX_VALUE, 5);
		spinnerKeyboard(num);

		disp.getChildren().add(num);
    	
    	lineJump(disp);

    	Button submit = new Button("Calcular");
    	disp.getChildren().add(submit);
    	
    	submit.setOnAction(e -> {
    		long acum = 1;
    		for (int i = num.getValue(); i > 1; i--) {
    			acum *= i;
    		}
    		
    		disp.getChildren().add(new Label("El resultado del fractal es: " + acum));
        	lineJump(disp);

    	});
		
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Calcular Fractal");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
}
