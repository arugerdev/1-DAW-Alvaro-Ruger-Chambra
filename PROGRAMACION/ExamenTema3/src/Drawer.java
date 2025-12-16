import java.util.Arrays;

public class Drawer {

    public final static int WIDTH = 100, HEIGHT = 100;
    public static char[][] matrix;

    public static void main(String[] args) throws InterruptedException {

        matrix = new char[WIDTH][HEIGHT];
        clearCanvas();

        // Ejemplos de varias líneas animadas
        drawLineAnimated(0, 0, 30, 10, '#');
    }

    // ========================
    //  DIBUJAR LINEA (BRESENHAM)
    // ========================
    public static void drawLineAnimated(int x0, int y0, int x1, int y1, char c) throws InterruptedException {
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;

        int err = dx - dy;

        while (true) {

            setPixel(x0, y0, c);

            clearConsole();
            render();
            Thread.sleep(0); // <-- Delay de animación

            if (x0 == x1 && y0 == y1)
                break;

            int e2 = 2 * err;

            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }

            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }

    // ========================
    //  CONSOLA Y RENDER
    // ========================
    public static void clearConsole() {
//        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void render() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(getPixel(x, y));
            }
            System.out.println();
        }
    }

    // ========================
    //  MATRIZ
    // ========================
    public static void clearCanvas() {
        for (int x = 0; x < WIDTH; x++)
            Arrays.fill(matrix[x], ' ');
        render();
    }

    public static char getPixel(int x, int y) {
        return matrix[x][y];
    }

    public static void setPixel(int x, int y, char newC) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT)
            matrix[x][y] = newC;
    }
}
