package daw.javafx.AlvaroRugerFX;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Life extends Ejercicio {

	private final int CANVA_WIDTH = 50, CANVA_HEIGHT = 50, SCALE_RENDER = 10;
	private int[][] data = new int[CANVA_WIDTH][CANVA_HEIGHT];
	private Canvas canvas = new Canvas(CANVA_WIDTH * 10, CANVA_HEIGHT * 10);
	private Timeline gameLoop;

	public Life(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("Life"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		disp.getChildren().add(canvas);

		changeValue((CANVA_WIDTH / 2), (CANVA_HEIGHT / 2), 1);
		
		changeValue((CANVA_WIDTH / 2) + 1, (CANVA_HEIGHT / 2), 1);
		changeValue((CANVA_WIDTH / 2), (CANVA_HEIGHT / 2) + 1, 1);
		changeValue((CANVA_WIDTH / 2), (CANVA_HEIGHT / 2 - 1), 1);
		
		changeValue((CANVA_WIDTH / 2) - 2, (CANVA_HEIGHT / 2) - 1, 1);
		
		changeValue((CANVA_WIDTH / 2) - 1, (CANVA_HEIGHT / 2 - 2), 1);
		changeValue((CANVA_WIDTH / 2) - 1, (CANVA_HEIGHT / 2 + 2), 1);
		
//		fillRandomCenter(1050, 50);
//		render();
		
		EventHandler<ActionEvent> gameUpdate = event ->

		{
			nextGeneration();
			render();
		};

		gameLoop = new Timeline(new KeyFrame(Duration.seconds(0.05), gameUpdate));
		gameLoop.setCycleCount(Animation.INDEFINITE);
		gameLoop.play();

		lineJump(disp);

		var scene = new Scene(disp, 1920, 1080);
		stage.setTitle("Life!");
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}

	public void changeValue(int x, int y, int v) {
		data[y][x] = v;
	}

	private void fillRandomCenter(int amount, int radius) {
	    java.util.Random rand = new java.util.Random();

	    int centerX = CANVA_WIDTH / 2;
	    int centerY = CANVA_HEIGHT / 2;

	    for (int i = 0; i < amount; i++) {
	        // desplazamientos aleatorios dentro de un radio
	        int dx = rand.nextInt(radius * 2 + 1) - radius;
	        int dy = rand.nextInt(radius * 2 + 1) - radius;

	        int x = centerX + dx;
	        int y = centerY + dy;

	        // evitar salir del mapa
	        if (x >= 0 && x < CANVA_WIDTH && y >= 0 && y < CANVA_HEIGHT) {
	            changeValue(x, y, 1);
	        }
	    }
	}

	
	private int countNeighbors(int x, int y) {
		int count = 0;

		for (int dy = -1; dy <= 1; dy++) {
			for (int dx = -1; dx <= 1; dx++) {

				if (dx == 0 && dy == 0)
					continue; // no se cuenta a sí mismo

				int nx = x + dx;
				int ny = y + dy;

				if (nx >= 0 && nx < CANVA_WIDTH && ny >= 0 && ny < CANVA_HEIGHT) {
					count += data[ny][nx];
				}
			}
		}

		return count;
	}

	private void nextGeneration() {
		int[][] newData = new int[CANVA_WIDTH][CANVA_HEIGHT];

		for (int y = 0; y < CANVA_HEIGHT; y++) {
			for (int x = 0; x < CANVA_WIDTH; x++) {

				int neighbors = countNeighbors(x, y);

				if (data[y][x] == 1) {
					// reglas de supervivencia
					newData[y][x] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
				} else {
					// nacimiento
					newData[y][x] = (neighbors == 3) ? 1 : 0;
				}
			}
		}

		data = newData;
	}

	public void render() {
		var gc = canvas.getGraphicsContext2D();

		for (int y = 0; y < CANVA_HEIGHT; y++) {
			for (int x = 0; x < CANVA_WIDTH; x++) {
				gc.setFill(data[y][x] == 1 ? Color.BLACK : Color.WHITE);
				gc.fillRect(x * SCALE_RENDER, y * SCALE_RENDER, SCALE_RENDER, SCALE_RENDER);
			}
		}
	}

}
