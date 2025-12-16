package daw.javafx.AlvaroRugerFX.EjercicioCoche;

import java.io.InputStream;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coche {

	public enum MARCHA {
		ADELANTE, ATRAS
	};

	public double combustible;
	public double x;
	public double y;
	public double orientation;
	public MARCHA marcha;
	public double velocidad;

	public Group gp;
	ImageView imageView;

//	Labels and visuals
//	******************************************
	public Label combustibleL;
	public Label velocidadL;
	public Label orientationL;
	public Button marchaB;
//	******************************************

//	Keyboard Control
//	******************************************
	private boolean wPressed = false;
	private boolean sPressed = false;
	private boolean aPressed = false;
	private boolean dPressed = false;
//	******************************************

	private AnimationTimer gameLoop;

	public Coche(int combustible, int x, int y) {
		this.combustible = combustible;
		this.x = x;
		this.y = y;
		this.orientation = 0;
		this.marcha = MARCHA.ADELANTE;
		this.velocidad = 0;
	}

	public void acelerar() {
		velocidad = Math.min(velocidad + 1, 120);
		update();
	}

	public void frenar() {
		velocidad = Math.max(velocidad - 1, 0);
		update();
	}

	public void detener() {
		velocidad = 0;
		update();
	}

	public void turnL() {
		setOrientation(orientation - 45);
	}

	public void turnR() {
		setOrientation(orientation + 45);
	}

	public MARCHA getMarcha() {
		return marcha;
	}

	public void setMarcha(MARCHA newMarcha) {
		marcha = newMarcha;
		update();
	}

	public double getOrientation() {
		return orientation;
	}

	public void avanzar() {
		if (combustible <= 0) {
			detener();
			return;
		}

		double radians = Math.toRadians(orientation - 90);
		double distancia = velocidad * 0.04;
		double consumoPorUnidad = 0.005;
		double consumo = distancia * consumoPorUnidad;

		combustible = Math.max(0, combustible - consumo);

		if (marcha == MARCHA.ADELANTE) {
			x += Math.cos(radians) * distancia;
			y += Math.sin(radians) * distancia;
		} else {
			x -= Math.cos(radians) * distancia;
			y -= Math.sin(radians) * distancia;
		}

		x = (int) x;
		y = (int) y;

		update();
		
		setPos(x, y);
	}

	void setPos(double x, double y) {
//		Preciso
		imageView.setX(x);
		imageView.setY(y);
		
//		Con cuadricula
//		 
//		imageView.setX((int) x * (tamaño cuadricula ej. 10));
//		imageView.setY((int) y * (tamaño cuadricula ej. 10));
	}

	public void setOrientation(double newOrientation) {
		orientation = newOrientation % 360;

		update();
	}

	public void render() {
		InputStream is = null;
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();

		is = classloader.getResourceAsStream("car.png");
		imageView = new ImageView(new Image(is, 100, 100, true, true));

		gp.getChildren().add(imageView);
	}

	public void enableControls(Scene scene) {
		scene.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case W -> wPressed = true;
			case S -> sPressed = true;
			case A -> aPressed = true;
			case D -> dPressed = true;
			default -> {
			}
			}
		});

		scene.setOnKeyReleased(e -> {
			switch (e.getCode()) {
			case W -> wPressed = false;
			case S -> sPressed = false;
			case A -> aPressed = false;
			case D -> dPressed = false;
			default -> {
			}
			}
		});

		startGameLoop();
	}

	private void startGameLoop() {
		gameLoop = new AnimationTimer() {
			private long lastTime = 0;

			public void handle(long now) {
				if (lastTime == 0) {
					lastTime = now;
					return;
				}

				double deltaTime = (now - lastTime) / 1e9;
				lastTime = now;

				if (wPressed) {
					setMarcha(MARCHA.ADELANTE);
					velocidad = Math.min(velocidad + 20 * deltaTime, 120);
					avanzar();
				} else if (sPressed) {
					setMarcha(MARCHA.ATRAS);
					velocidad = Math.min(velocidad + 10 * deltaTime, 60);
					avanzar();
				} else {
					velocidad = Math.max(velocidad - 80 * deltaTime, 0);
					avanzar();

				}

				if (aPressed)
					setOrientation(orientation - 2);
				if (dPressed)
					setOrientation(orientation + 2);

			}
		};

		gameLoop.start();
	}

	private void update() {
		velocidadL.setText((int) velocidad + " km/h");
		combustibleL.setText((int) combustible + " L");
		orientationL.setText(orientation + "º");

		if (imageView != null) {
			imageView.setRotate(orientation);
		}

		if (marcha.equals(MARCHA.ADELANTE)) {
			marchaB.setText("FORWARD");
		} else if (marcha.equals(MARCHA.ATRAS)) {
			marchaB.setText("BACKWARD");
		}
	}

	public String toString() {
		return "Coche [combustible=" + combustible + ", x=" + x + ", y=" + y + ", orientation=" + orientation
				+ ", marcha=" + marcha + ", velocidad=" + velocidad + "]";
	}
}
