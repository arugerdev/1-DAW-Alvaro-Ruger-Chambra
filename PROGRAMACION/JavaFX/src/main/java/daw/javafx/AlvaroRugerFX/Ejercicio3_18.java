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

public class Ejercicio3_18 extends Ejercicio{

	public Ejercicio3_18(String name, boolean finished) {
		super(name, finished);
	}

	//	Realiza un programa que nos diga cuántos dígitos tiene un número entero que puede ser positivo o negativo. Se permiten números de hasta 5 dígitos.
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("18. Realiza un programa que nos diga cuántos dígitos tiene un número entero que puede ser positivo o negativo. Se permiten números de hasta 5 dígitos."));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Inserta el numero que quiere saber su cantidad de caracteres (max 99.999): "));
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
    		
    		
    		disp.getChildren().add(new Label("La cantidad de caracteres es " + n.getValue().toString().toCharArray().length));

    	});
		
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Cantidad de caracteres");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
}
