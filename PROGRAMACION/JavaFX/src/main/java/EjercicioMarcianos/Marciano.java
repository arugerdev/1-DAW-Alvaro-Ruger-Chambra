package EjercicioMarcianos;

import daw.javafx.AlvaroRugerFX.EjerMarcianos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Marciano {

    private static int totalCreados = 0;
    private static int totalConVida = 0;

    private final int id;
    private double x, y;          
    private int vida;
    private Image sprite;
    private ImageView view;
    
    private EjerMarcianos context;
    
    public Marciano(double x, double y, EjerMarcianos ctx) {
        this.id = ++totalCreados;
        this.x = x;
        this.y = y;
        this.vida = 10;
        totalConVida++;
        this.sprite = new Image(
                getClass().getResource("/marciano.png").toExternalForm(),
                200, 200, false, false
        );
        this.context = ctx;
        this.view = new ImageView(sprite);
        this.view.setTranslateX(x);
        this.view.setTranslateY(y);
    }

    public static int getTotalCreados() { return totalCreados; }

    public static int getTotalConVida() { return totalConVida; }

    public static int getTotalDestruidos() {
        return totalCreados - totalConVida;
    }

    public int getId() { return id; }

    public double getX() { return x; }

    public double getY() { return y; }

    public void setX(double x) { 
        this.x = x;
        view.setTranslateX(x);
    }

    public void setY(double y) {
        this.y = y;
        view.setTranslateY(y);
    }

    public int getVida() { return vida; }

    public void llamar(Marciano otro) {
        System.out.printf("Marcianito número %d llamando a Marcianito número %d%n",
                this.id, otro.id);
    }

    public void transferirVida(Marciano destino, int cantidad) {
        if (vida <= 0) return;
        if (cantidad < 1) return;
        if (this.vida < cantidad) cantidad = this.vida;

        this.vida -= cantidad;
        destino.vida = Math.min(10, destino.vida + cantidad);
    }

    public void recibirDisparo() {
        if (vida <= 0) return;

        vida--;
        if (vida == 0) {
            totalConVida--;
            System.out.println("Marcianito " + id + " destruido!");
        }
    }

    public void render(Pane contenedor) {
        if (!contenedor.getChildren().contains(view)) {
            contenedor.getChildren().add(view);
        }
    }
}
