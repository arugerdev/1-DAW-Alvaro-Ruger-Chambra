package daw.javafx.AlvaroRugerFX.Practica4_1;

public class Tiempo {
	private final int seconds;
	
	public Tiempo(int h, int m, int s) {
		this.seconds= convertTS(h,m,s);
	}
	
	public String Sumar(Tiempo t) {
		int[] rs = convertT(seconds + t.seconds);
		
		return rs[0]+":"+rs[1]+":"+rs[2];
	}
	
	public String Restar(Tiempo t) {
		int[] rs = convertT(Math.max(seconds - t.seconds,0));
		
		return rs[0]+":"+rs[1]+":"+rs[2];
	}
	
	public static int convertTS(int h, int m, int s) {
		return (h*3600) + (m * 60) + s;
	}
	
	public static int[] convertT(int s) {
		int h = (int)(s / 3600);
		
		s -= (int) ((int)s/3600) * 3600;
		
		int m = (int)(s/60);
		
		s -= (int) ((int)s/60) * 60;
		
		int[] r = {h,m,s};
		
		return r;
	}
	
	@Override
	public String toString() {
		int[] rs = convertT(seconds);

		return rs[0] + "h " + rs[1] + "m " + rs[2] + "s";
	}

}
