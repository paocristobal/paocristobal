// Clase que utiliza la clase ABB
public class UsaABB {

    public static void main(String[] args) {
        ABB arbol = new ABB();

        // Insertar valores en el árbol
        arbol.insertarValor(25);
        arbol.insertarValor(8);
        arbol.insertarValor(29);
        arbol.insertarValor(38);
        arbol.insertarValor(27);

        // Imprimir la raíz y el árbol de forma horizontal
        System.out.println("Nodo raiz: " + arbol.regresaRaiz().dato);
        arbol.muestraAcostado(0, arbol.regresaRaiz());

        // Buscar un nodo en el árbol
        int valorABuscar = 29;
        Nodo nodoBuscado = arbol.buscarNodo(valorABuscar, arbol.regresaRaiz());
        System.out.println("Nodo encontrado con valor " + valorABuscar + ": " + (nodoBuscado != null ? nodoBuscado.dato : "No encontrado"));

        // Recorrer el árbol en diferentes órdenes
        System.out.println("Recorrido en Preorden:");
        arbol.recorrerPreorden(arbol.regresaRaiz());
        System.out.println();

        System.out.println("Recorrido en Inorden:");
        arbol.recorrerInorden(arbol.regresaRaiz());
        System.out.println();

        System.out.println("Recorrido en Postorden:");
        arbol.recorrerPostorden(arbol.regresaRaiz());
        System.out.println();

        // Eliminar un nodo
        int valorAEliminar = 29;
        System.out.println("Eliminando nodo con valor " + valorAEliminar);
        arbol.eliminarNodo(valorAEliminar, arbol.regresaRaiz());

        // Imprimir el árbol después de la eliminación
        System.out.println("Árbol después de eliminar nodo:");
        arbol.muestraAcostado(0, arbol.regresaRaiz());
    }
}
