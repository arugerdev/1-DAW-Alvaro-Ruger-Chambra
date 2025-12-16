package daw.javafx.AlvaroRugerFX;

import java.util.ArrayList;

import EjercicioMarcianos.Marciano;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EjerMarcianos extends Ejercicio {
	public EjerMarcianos(String name, boolean finished) {
		super(name, finished);
	}
	
	ArrayList<Marciano> mars = new ArrayList<Marciano>();


	int direction = 1;
	double speed = 20;
	double stepDown = 40;
	
	
	public void start(Stage stage) {
		Pane disp = new Pane();

		disp.setPadding(new Insets(0, 0, 0, 0));

		lineJump(disp);

		var bgImage = new javafx.scene.image.Image(getClass().getResource("/background.png").toExternalForm(), 256, 128,
				true, false);

		var backgroundSize = new BackgroundSize(100, 100, true, true, // width/height in %, scaled
				true // cover (mantiene proporciones y rellena la ventana)
				, true);

		var background = new Background(new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize));

		disp.setBackground(background);

	    createFormation(
	            3, 7,   // filas, columnas
	            0, 0, // offset inicial
	            150, 150    // separación entre marcianos
	        );
		

		Timeline loop = new Timeline(new KeyFrame(Duration.millis(500), event -> {

		    double left = getLeftBound();
		    double right = getRightBound();

		    if (right >= 1880) {          // borde derecho
		        direction = -1;           // cambiar dirección
		        for (Marciano m : mars)   // bajar todos
		            m.setY(m.getY() + stepDown);
		    }

		    if (left <= 0) {              // borde izquierdo
		        direction = 1;
		        for (Marciano m : mars)
		            m.setY(m.getY() + stepDown);
		    }

		    // 2. Mover todo el bloque en la dirección actual
		    for (Marciano m : mars) {
		        m.setX(m.getX() + direction * speed);
		        m.render(disp); // dibujar
		    }

		}));

		loop.setCycleCount(Animation.INDEFINITE);
		loop.play();

		var scene = new Scene(disp, 1920, 1080);
		stage.setTitle("Marcianos!");
		stage.setScene(scene);
		stage.setWidth(1920);
		stage.setHeight(1080);
		stage.show();
	}
	
	private void createFormation(int rows, int cols, int offsetX, int offsetY, int spacingX, int spacingY) {
	    for (int r = 0; r < rows; r++) {
	        for (int c = 0; c < cols; c++) {
	        	Instantiate(offsetX + c * spacingX, offsetY + r * spacingY);
	        }
	    }
	}

	
	private double getLeftBound() {
	    return mars.stream().mapToDouble(Marciano::getX).min().orElse(0);
	}

	private double getRightBound() {
	    return mars.stream().mapToDouble(Marciano::getX).max().orElse(0) + 200;
	}

	
	public void Instantiate(int x, int y) {
		mars.add(new Marciano(x|0, y|0, this));
	}

}
