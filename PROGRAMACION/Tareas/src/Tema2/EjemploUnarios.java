package Tema2;

public class EjemploUnarios {

	public static void main(String[] args) {
		int x;
		int y;
		
		x = 1;
		x = x + 1;
		System.out.println(x);
		
		y = 1;
		y++;
		System.out.println(y);
		
		x = 100;
		y = 200;
		
		float z;
		
		z=++x - --y + (x++ + y++);
		
		System.out.println(z);
	}

}
