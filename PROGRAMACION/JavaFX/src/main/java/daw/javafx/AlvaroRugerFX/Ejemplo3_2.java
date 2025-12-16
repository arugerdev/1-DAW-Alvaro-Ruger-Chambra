package daw.javafx.AlvaroRugerFX;

import java.util.ArrayList;
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

public class Ejemplo3_2 extends Ejercicio{

	public Ejemplo3_2(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("Ejemplo 2 random"));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Probabilidades: "));
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
		
		Spinner<Integer> min = new Spinner<>(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
		Spinner<Integer> max = new Spinner<>(Integer.MIN_VALUE, Integer.MAX_VALUE, 10);

    	disp.getChildren().add(min);
    	disp.getChildren().add(max);



		lineJump(disp);
  
    	Button submit = new Button("Crear");
    	disp.getChildren().add(submit);

    	lineJump(disp);
    	
    	List<Integer> randoms = new ArrayList<Integer>();

    	submit.setOnAction(e -> {
    		
    		int rng = (int)(Math.random() * (max.getValue() - min.getValue() + 1) + min.getValue() );
    		randoms.add(rng);
    		disp.getChildren().add(new Label("" + rng));

    	});
 
		
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Cantidad de caracteres");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
	
}
