package Tema2;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Organizer {
    public static List<Integer> list = new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
        21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50));
    
    static double time = 0.0;
    static int index = 0;
    static boolean playing = true;

    static String algorithm = "quick";

    static Stack<int[]> stack = new Stack<>();
    static int quickLow = -1, quickHigh = -1;
    static int i = -1, j = -1;
    static int pivot = -1;
    static boolean partitioning = false;
    
    public static void main(String[] args) throws InterruptedException {
        list.clear();
        for(int i = 0; i <= 50; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        if (algorithm.equals("quick")) {
            stack.push(new int[]{0, list.size() - 1}); 
            partitioning = false;
        }

        while(playing) {
            clearScreen();
            
            System.out.println("Algoritmo: " + (algorithm.equals("bubble") ? "Bubble Sort" : "Quick Sort"));
            if (algorithm.equals("bubble")) {
                orderFrameBubble();
            } else if (algorithm.equals("quick")) {
                orderFrameQuick();
            }
            drawList();
            TimeUnit.MILLISECONDS.sleep(50);
            time += 0.05;
        }
    }

    static int sorted = 0;
    public static void orderFrameBubble() {
        if (index < list.size() - 1) {
            if (list.get(index) > list.get(index + 1)) {
                int temp = list.get(index);
                list.set(index, list.get(index + 1));
                list.set(index + 1, temp);
                sorted = 0;
            }
            sorted++;
        }

        index++;
        if (index >= list.size() - 1) {
            index = 0;
            if(sorted >= list.size() - 1) {
                playing = false;
                clearScreen();
                drawList();
            }
            sorted = 0;
        }
    }

    static int[] range = new int[0];
    public static void orderFrameQuick() {

        if (stack.size() <= 0 && range.length <= 0) {
        	playing = false;
        	return;
        }

        if (!partitioning) {
        	if(stack.size() <= 0) {
        		range = new int [0];
        		return;
        	}
        	range = stack.pop();
            quickLow = range[0];
            quickHigh = range[1];
            i = quickLow - 1;
            pivot = list.get(quickHigh);
            j = quickLow;
            partitioning = true;
        }

        
        if (j < quickHigh) {
            if (list.get(j) < pivot) {
                i++;
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
            j++;
        } else {
            int temp = list.get(i+1);
            list.set(i+1, list.get(quickHigh));
            list.set(quickHigh, temp);

            int pi = i+1;
            partitioning = false;

            if (pi - 1 > quickLow) {
                stack.push(new int[]{quickLow, pi - 1});
            }
            if (pi + 1 < quickHigh) {
                stack.push(new int[]{pi + 1, quickHigh});
            }
        }

        index = j <= quickHigh ? j : -1;
    }

    public static void drawList() {
        int max = 0;
        for (int val : list) {
            if (val > max) max = val; 
        }

        for (int row = max; row >= 1; row--) {
            for (int val : list) {
                if (val >= row) {
                    System.out.print(" | ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        for (int val : list) {
            System.out.printf("%2d ", val);
        }
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            if (algorithm.equals("bubble")) {
                if (i == index) {
                    System.out.print(" ^ ");
                } else {
                    System.out.print("   ");
                }
            } else if (algorithm.equals("quick")) {
                if (i == index) {
                    System.out.print(" > ");
                } else if (i == quickLow) {
                    System.out.print(" L ");
                } else if (i == quickHigh) {
                    System.out.print(" H ");
                } else {
                    System.out.print("   ");
                }
            }
        }
        System.out.println();
        System.out.println(time);
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
