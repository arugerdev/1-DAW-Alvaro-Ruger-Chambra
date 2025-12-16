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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_3_2 extends Ejercicio{

	public Ejercicio3_3_2(String name, boolean finished) {
		super(name, finished);
	}

	//	Escribe un programa que lea una lista de diez números y determine cuántos son positivos, y cuántos son negativos.
	
	List<Spinner<Integer>> spinners = new ArrayList<Spinner<Integer>>();
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.3 1.Escribe un programa que lea una lista de diez números y determine cuántos son positivos, y cuántos son negativos."));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Inserta los 10 numeros: "));
		
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
    	
		for (int i = 0; i < 10; i++) {
		
		Spinner<Integer> n = new Spinner<>(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
		spinnerKeyboard(n);

		disp.getChildren().add(n);
		
		spinners.add(n);

		}
		
		lineJump(disp);
    	
		
    	Button submit = new Button("Filtrar");
    	disp.getChildren().add(submit);
    	submit.setOnAction(e -> {

    		List<Integer> pos = new ArrayList<Integer>();
    		List<Integer> neg = new ArrayList<Integer>();
    		
    		for (Spinner<Integer> i : spinners) {
    			if (i.getValue() >= 0) {
    				pos.add(i.getValue());
    			}
    			else {
    				neg.add(i.getValue());
    			}
    		}

    	        Label positiveLabel = new Label("Positivos: " + pos.toString());
    	        Label negativeLabel = new Label("Negativos: " + neg.toString());
    	        
    			HBox posBox = new HBox(10);
    			HBox negBox = new HBox(10);
    			
    			posBox.getChildren().add(positiveLabel);
    			negBox.getChildren().add(negativeLabel);

    			VBox root = new VBox(10);
		        root.getChildren().addAll(posBox, negBox);
		        root.setPadding(new Insets(10,10,10,10));
		    	root.setStyle("-fx-background-color: #CCCCCC; ");
				disp.getChildren().add(root);
    		
    	});
		
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Cantidad de caracteres");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
}
