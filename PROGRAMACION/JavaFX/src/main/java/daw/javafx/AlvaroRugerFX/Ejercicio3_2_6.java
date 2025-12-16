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

public class Ejercicio3_2_6 extends Ejercicio {

	public Ejercicio3_2_6(String name, boolean finished) {
		super(name, finished);
	}

	// Crea un programa que pida un número tipo byte y escriba “El número acaba en ____”, donde ____ es el texto  que indica el dígito final. Para ello usa el operador % con el operando derecho 10. Por ejemplo, si se introduce 45 debe mostrar “El número acaba en cinco”.

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(("3.2. 6. Crea un programa que pida un número tipo byte y escriba “El número acaba en ”, \n"
						+ " donde es el texto  que indica el dígito final. Para ello usa el operador % con el operando derecho 10. \n"
						+ " Por ejemplo, si se introduce 45 debe mostrar “El número acaba en cinco”."));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Digito final "));
		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		lineJump(disp);

//		No es posible hacer esto con Byte ya que el componente Spinner no lo permite (cast to int)
		Spinner<Integer> n = new Spinner<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE,0);
		spinnerKeyboard(n);
		disp.getChildren().add(n);
		
		lineJump(disp);

		Button submit = new Button("Calcular");
		disp.getChildren().add(submit);
		submit.setOnAction(e -> {
			String num = "";
			
			switch (n.getValue() % 10) {
			case 0:
				num = "cero" ;
				break;
			case 1:
				num = "uno" ;
				break;
			case 2:
				num = "dos" ;
				break;
			case 3:
				num = "tres" ;
				break;
			case 4:
				num = "cuatro" ;
				break;
			case 5:
				num = "cinco" ;
				break;
			case 6:
				num = "seis" ;
				break;
			case 7:
				num = "siete" ;
				break;
			case 8:
				num = "ocho" ;
				break;
			case 9:
				num = "nueve" ;
				break;
			}

			
//			Esto se podria hacer con un array de los numeros escritos ya en letras,
//			al tener el array ordenado el index obteniendo el numero final se puede obtener solo:
//			
//			String[] numerosEscritos = {"cero", "uno", "dos" ...}
//			
//			numerosEscritos[n.getValue()];
			
			
			disp.getChildren().add(new Label("El ultimo acaba en " + num));
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
