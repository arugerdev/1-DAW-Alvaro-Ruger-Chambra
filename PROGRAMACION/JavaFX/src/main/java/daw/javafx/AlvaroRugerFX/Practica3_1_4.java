package daw.javafx.AlvaroRugerFX;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Practica3_1_4 extends Ejercicio {

	public Practica3_1_4(String name, boolean finished) {
		super(name, finished);
	}

	// Solo pares

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.1.4. Solo paress"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Calcular cifras pares"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

		TextField input = new TextField();
		
		// ######################### Solo numeros - StackOverflow ######################### 
		//	 Añade un listener al input, 
		//	 si el valor nuevo no hace match con los numerales, 
		//	 no lo escribe
		input.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            input.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
		// ################################################################################ 
		
		disp.getChildren().add(input);

		lineJump(disp);
		Button submit = new Button("CALCULAR");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			int result = 0;
			String chars = "";
			for(int i = 0; i < input.getText().length(); i++) {
				if (Integer.parseInt("" + input.getText().charAt(i)) % 2 == 0) {
					result ++;
					chars += input.getText().charAt(i) + ", ";
				};
			}
			lineJump(disp);
			
			disp.getChildren().add( new Label("" + result + " caracteres pares" ));
			lineJump(disp);

			disp.getChildren().add( new Label(chars));

		});
		var scene = new Scene(disp, 480, 320);
		stage.setTitle("Caracteres pares");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}

}
