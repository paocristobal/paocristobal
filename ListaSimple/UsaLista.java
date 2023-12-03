import java.util.Scanner;

public class UsaLista{

	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		ListaSimple lista = new ListaSimple();
		int opcion = 0;

		do {
		System.out.println("\nLista Simple: \n" + "1.-Ingresar Nodos\n" + "2.-Buscar Nodo\n" + "3.-Modificar Nodo\n"
		+ "4.-Mostrar Nodos");
		System.out.print("Elija una opción:");
		opcion = teclado.nextInt();

		switch (opcion) {

			case 1:
				System.out.println("--Ingreso de NODOS--");

				System.out.println("Ingrese un dato para el primer nodo: ");
				String nodo = teclado.next();
				lista.insertaPrimerNodo(nodo);

				System.out.println("Ingrese un dato para antes del primer nodo: ");
				String nombre = teclado.next();
				lista.insertaAntesPrimerNodo(nombre);

				System.out.println("Ingrese un dato para el nodo final: ");
				String dato = teclado.next();
				lista.insertaAlFinal(dato);

				System.out.println("Ingrese un dato para antes del ultimo nodo: ");
				String dato2 = teclado.next();
				lista.insertarAntesDelFinal(dato2, nodo);

				break;
			case 2:
				System.out.println("Ingrese un nodo buscar: ");
				String buscar = teclado.next();
				lista.buscarNodo(buscar);

				break;
			case 3:
				System.out.println("Ingrese un nodo a cambiar: ");
				String cambiar = teclado.next();
				lista.cambiarNodo(cambiar);

			break;

			case 4:
				System.out.println("Tamaño de la lista: " + lista.size());
				lista.imprimir();

			break;

		}
	} while(opcion<5);
		
		//System.out.print(lista);
	}


}
