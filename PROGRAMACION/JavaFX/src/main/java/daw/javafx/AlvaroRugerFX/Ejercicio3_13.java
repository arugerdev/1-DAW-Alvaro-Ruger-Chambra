package daw.javafx.AlvaroRugerFX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

public class Ejercicio3_13 extends Ejercicio{

	public Ejercicio3_13(String name, boolean finished) {
		super(name, finished);
	}

	//	Escribe un programa que ordene tres números enteros introducidos por teclado.
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("13. Escribe un programa que ordene tres números enteros introducidos por teclado."));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Inserta 3 numeros: "));
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
		
		Spinner<Integer> n1 = new Spinner<>(-Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
		Spinner<Integer> n2 = new Spinner<>(-Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
		Spinner<Integer> n3 = new Spinner<>(-Integer.MAX_VALUE, Integer.MAX_VALUE, 0);

		spinnerKeyboard(n1);
		spinnerKeyboard(n2);
		spinnerKeyboard(n3);
		
		disp.getChildren().add(n1);
		disp.getChildren().add(new Label(","));
		disp.getChildren().add(n2);
		disp.getChildren().add(new Label(","));
		disp.getChildren().add(n3);

		lineJump(disp);
    	
    	Button submit = new Button("Ordenar");
    	disp.getChildren().add(submit);
    	submit.setOnAction(e -> {
    		List<Integer> result = new ArrayList<>();
    		result.add(n1.getValue());
    		result.add(n2.getValue());
    		result.add(n3.getValue());
    		
    		Collections.sort(result);
    		
    		disp.getChildren().add(new Label(result.toString()));

    	});
		
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Ordenar numeros enteros");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
}
