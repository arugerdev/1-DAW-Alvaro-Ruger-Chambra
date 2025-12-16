package daw.javafx.AlvaroRugerFX;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_2_5 extends Ejercicio {

	public Ejercicio3_2_5(String name, boolean finished) {
		super(name, finished);
	}

	// Realiza un programa que pida dos números tipo byte y a continuación un carácter que podrá ser + ,- ,* o /. El programa hará la operación indicada con esos dos números, informando de que no es posible la división por cero cuando se dé esa circunstancia.

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String
				.format("3.2. 5. Realiza un programa que pida dos números tipo byte y a continuación un carácter que podrá ser + ,- ,* o /. \n"
						+ " El programa hará la operación indicada con esos dos números, informando de que no es posible la división por cero \n"
						+ " cuando se dé esa circunstancia."));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Calculadora "));
		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

//		No es posible hacer esto con Byte ya que el componente Spinner no lo permite (cast to int)
		Spinner<Integer> fByte = new Spinner<Integer>(0, 127,0);
		spinnerKeyboard(fByte);
		disp.getChildren().add(fByte);
		
		ChoiceBox<Character> cb = new ChoiceBox<Character>();
		Character[] chars = {'*', '/', '+', '-'};
		cb.getItems().addAll(chars);
		cb.setValue('*');
		disp.getChildren().add(cb);

//		No es posible hacer esto con Byte ya que el componente Spinner no lo permite (cast to int)
		Spinner<Integer> sByte = new Spinner<Integer>(0, 127,0);
		spinnerKeyboard(sByte);
		disp.getChildren().add(sByte);
		
		lineJump(disp);

		Button submit = new Button("Calcular");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			double result = 0.0;
			
			switch (cb.getValue()) {
			case '*':
				result = (fByte.getValue() * sByte.getValue()) ;
				break;
			case '/':
				result =  (fByte.getValue() / sByte.getValue()) ;
				break;
			case '+':
				result = (fByte.getValue() + sByte.getValue()) ;
				break;
			case '-':
				result =  (fByte.getValue() - sByte.getValue()) ;
				break;
			}
//			
			disp.getChildren().add(new Label("El resultado es " + result));
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
