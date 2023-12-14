// Clase que representa un árbol binario de búsqueda
public class ABB {
    private Nodo raiz;  // Nodo raíz del árbol

    // Constructor, inicializa la raíz como nula
    ABB() {
        this.raiz = null;
    }

    // Verifica si el árbol está vacío
    public boolean esVacio() {
        return (this.raiz == null);
    }

    // Getter para la raíz del árbol
    public Nodo regresaRaiz() {
        return this.raiz;
    }

    // Método para insertar un valor en el árbol
    public void insertarValor(int valor) {
        if (this.raiz == null) {
            // Si la raíz es nula, crea un nuevo nodo como raíz
            System.out.println("Insertando raíz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        } else {
            // Si la raíz no es nula, llama a insertarNodo para insertar el valor en el lugar adecuado
            insertarNodo(valor, this.raiz);
        }
    }

    // Método auxiliar para insertar un nodo en el árbol
    public void insertarNodo(int valor, Nodo nodoRef) {
        if (valor <= nodoRef.dato) {
            // Si el valor es menor o igual, lo inserta en el subárbol izquierdo
            if (nodoRef.izquierdo == null) {
                System.out.println("Insertando hijo izquierdo de " + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo = new Nodo();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            } else {
                insertarNodo(valor, nodoRef.izquierdo);
            }
        } else {
            // Si el valor es mayor, lo inserta en el subárbol derecho
            if (valor > nodoRef.dato) {
                if (nodoRef.derecho == null) {
                    System.out.println("Insertando hijo derecho de " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho = new Nodo();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                } else {
                    insertarNodo(valor, nodoRef.derecho);
                }
            }
        }
    }

    // Método para mostrar el árbol horizontalmente
    public void muestraAcostado(int nivel, Nodo nodoRef) {
        if (nodoRef == null) {
            return;
        } else {
            // Recorre recursivamente el subárbol derecho, imprime el nodo actual y recorre recursivamente el subárbol izquierdo
            muestraAcostado(nivel + 1, nodoRef.derecho);
            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }
            System.out.println(nodoRef.dato);
            muestraAcostado(nivel + 1, nodoRef.izquierdo);
        }
    }
    
    // Método para buscar un nodo con un valor dado en el árbol
    public Nodo buscarNodo(int valor, Nodo nodoRef) {
        if (nodoRef == null || nodoRef.dato == valor) {
            return nodoRef;
        }

        // Si el valor es menor, busca en el subárbol izquierdo; si es mayor, busca en el subárbol derecho
        if (valor < nodoRef.dato) {
            return buscarNodo(valor, nodoRef.izquierdo);
        } else {
            return buscarNodo(valor, nodoRef.derecho);
        }
    }

    // Método para recorrer el árbol en preorden
    public void recorrerPreorden(Nodo nodoRef) {
        if (nodoRef != null) {
            System.out.print(nodoRef.dato + " ");
            recorrerPreorden(nodoRef.izquierdo);
            recorrerPreorden(nodoRef.derecho);
        }
    }

    // Método para recorrer el árbol en inorden
    public void recorrerInorden(Nodo nodoRef) {
        if (nodoRef != null) {
            recorrerInorden(nodoRef.izquierdo);
            System.out.print(nodoRef.dato + " ");
            recorrerInorden(nodoRef.derecho);
        }
    }

    // Método para recorrer el árbol en postorden
    public void recorrerPostorden(Nodo nodoRef) {
        if (nodoRef != null) {
            recorrerPostorden(nodoRef.izquierdo);
            recorrerPostorden(nodoRef.derecho);
            System.out.print(nodoRef.dato + " ");
        }
    }

    // Nuevo método para eliminar un nodo en el árbol
    public Nodo eliminarNodo(int valor, Nodo nodoRef) {
        if (nodoRef == null) {
            return nodoRef;
        }

        if (valor < nodoRef.dato) {
            nodoRef.izquierdo = eliminarNodo(valor, nodoRef.izquierdo);
        } else if (valor > nodoRef.dato) {
            nodoRef.derecho = eliminarNodo(valor, nodoRef.derecho);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (nodoRef.izquierdo == null) {
                return nodoRef.derecho;
            } else if (nodoRef.derecho == null) {
                return nodoRef.izquierdo;
            }

            // Nodo con dos hijos, obtener sucesor inorden
            nodoRef.dato = minimoValor(nodoRef.derecho);

            // Eliminar el sucesor inorden
            nodoRef.derecho = eliminarNodo(nodoRef.dato, nodoRef.derecho);
        }

        return nodoRef;
    }
    private int minimoValor(Nodo nodoRef) {
        int minValue = nodoRef.dato;
        while (nodoRef.izquierdo != null) {
            minValue = nodoRef.izquierdo.dato;
            nodoRef = nodoRef.izquierdo;
        }
        return minValue;
    }
}
