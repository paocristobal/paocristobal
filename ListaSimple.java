import java.util.Scanner;

public class ListaSimple{
	Node top;
	int size;
	Scanner teclado = new Scanner(System.in);

	//Métodos para los casos de inserción de nodos
	public boolean insertaPrimerNodo(String dato){
		size = 0;
		if (top == null) { //La lista no está vacía
			top = new Node();
			top.name = dato;
			top.next = null;

			return true;
		}
		else {
			return false;
		}
	}

	public void insertaAntesPrimerNodo(String nombre){
		Node temp; 
		temp = new Node ();
		temp.name = nombre;
		temp.next = this.top;
		this.top = temp;
		temp = null;
		size++;
	}

	public void insertaAlFinal(String nombre){
		Node temp = new Node ();
		temp.name = nombre;
		temp.next = null;
		//Node temp2;
		Node temp2 = this.top;

		while (temp2.next != null)
			temp2 = temp2.next;

		temp2.next = temp;
		temp = null;
		temp2 = null;

		size++;
	} 

	public void buscarNodo(String buscar){
		Node temp = new Node();
		temp = this.top;

		while (temp != null) {
			if(temp.name == buscar) {
			System.out.println("Si existe");
			}
			temp = temp.next;
		}
	}

	public void cambiarNodo(String buscado){
		Node temp = new Node();
		temp = this.top;

		while (temp != null) {
			if(temp.name == buscado) {
			System.out.println("Ingrese el nuevo dato para el nodo: ");
			temp.name = teclado.next();
			imprimir();
			}
			temp = temp.next;
		}	
	}

	public boolean insertarAntesDelFinal(String nombre, String buscado){
		Node temp = new Node();
		temp.name = nombre;
		Node temp2 = this.top;

		while((temp2 != null) 
			&& (temp2.name.equals(buscado))==false){
			temp2 = temp2.next;
	}
	size++;
		if(temp2 != null){
		temp.next = temp2.next;
		temp2.next= temp;
		temp = null;
		temp2 = null;
		return true;

		}
		else return false;

	}

	public void imprimir(){
		for (Node temp = this.top; temp != null; temp = temp.next){
			System.out.print("[ " + temp.name + " ] -> ");
		}
 
	}


	/*public String toString(){
		String cadAux = "";
		for (Node temp = this.top; temp != null; temp = temp.next){
			cadAux += "[ " + temp.name + " ] -> ";
		}
		return cadAux;
	}*/

	public int size(){
		return size;
	}

}
