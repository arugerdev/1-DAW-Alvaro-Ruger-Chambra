import java.util.Scanner;

public class Ejercicio1 {

	// Preguntar al usuario cuantos mantecados llevara la caja de chocolate y
	// cuantos mazapanes
	// por cada 3 de chocolate -> 2 polvorones
	// por cada 1 mazapan -> 2 roscos de vino
	// Elegir entre caja de 20 o 30 unidades (no intervencion usuario)
	// Resto de la caja con alfajores.
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int mantecados_choco = 0;
		int mazapanes = 0;

		int polvorones = 0;
		int roscos_de_vino = 0;

		int alfajores = 0;

		System.out.print("Indica cuántos mantecados de chocolate: ");
		mantecados_choco = Integer.parseInt(s.next());
		System.out.println("Indica cuántos mazapanes: ");
		mazapanes = Integer.parseInt(s.next());

		polvorones = (mantecados_choco / 3) * 2;
		roscos_de_vino = mazapanes * 2;

		int total_caja = mantecados_choco + mazapanes + polvorones + roscos_de_vino;
		int tamaño_caja = 20;

		if (total_caja > 30) {
			System.out.println("Error de configuracion: " + total_caja + " mantecados son demasiados");
			return;
		}

		if (total_caja > tamaño_caja) {
			tamaño_caja = 30;
		}

		alfajores = tamaño_caja - total_caja;
		
		System.out.println("Su surtido de " + tamaño_caja + " unidades esta listo:");
		System.out.println("* " + mantecados_choco + " chocolate");
		System.out.println("* " + polvorones + " polvorones");
		System.out.println("* " + mazapanes + " mazapanes");
		System.out.println("* " + roscos_de_vino + " roscos de vino");
		System.out.println("* " + alfajores + " alfajores");
		
		s.close();
		
	}

}
