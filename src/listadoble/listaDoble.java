/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listadoble;

public class listaDoble {
    nodoD cabeza;
    nodoD cola;
    int tamanio;

    public listaDoble() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    // Inserta al inicio cuando ya sabes que vas a poner algo en la posicion 0
    public void insertarInicio(int dato) {
        nodoD nuevo = new nodoD(dato);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        tamanio++;
    }

    // Inserta al final cuando ya sabes que va despues de la cola
    public void insertarFinal(int dato) {
        nodoD nuevo = new nodoD(dato);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        tamanio++;
    }

    // 1) insertarEnPosicion(int pos, int dato)
    // Corregido respecto a "instarEnPosicion" de ListaLigada
    public void insertarEnPosicion(int pos, int dato) {
        // Si la posicion es negativa o pasa del tamanio, no hacemos nada
        if (pos < 0 || pos > tamanio) {
            System.out.println("Posicion fuera de rango: " + pos);
            return;
        }

        // Si es 0, va al principio
        if (pos == 0) {
            insertarInicio(dato);
            return;
        }

        // Si es igual a tamanio, va al final
        if (pos == tamanio) {
            insertarFinal(dato);
            return;
        }

        // Si va en medio, avanzamos hasta el nodo que actualmente ocupa esa posicion
        nodoD actual = cabeza;
        for (int i = 0; i < pos; i++) {
            actual = actual.siguiente;
        }

        // Acomodamos "nuevo" entre actual.anterior y actual
        nodoD nuevo = new nodoD(dato);
        nodoD antes = actual.anterior;

        antes.siguiente = nuevo;
        nuevo.anterior = antes;
        nuevo.siguiente = actual;
        actual.anterior = nuevo;

        tamanio++;
    }

    // 2) eliminarPorValor(int x) : boolean
    // Corregido respecto a "elimiarPorValor" de ListaLigada
    public boolean eliminarPorValor(int x) {
        if (estaVacia()) {
            return false;
        }

        nodoD actual = cabeza;
        while (actual != null && actual.dato != x) {
            actual = actual.siguiente;
        }

        // No estaba el numero x
        if (actual == null) {
            return false;
        }

        // Solo habia un nodo
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else if (actual == cabeza) {
            // Era el primero
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        } else if (actual == cola) {
            // Era el ultimo
            cola = cola.anterior;
            cola.siguiente = null;
        } else {
            // Estaba en medio: conectamos el de atras con el de adelante
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }

        tamanio--;
        return true;
    }

    // 3) eliminarEnPosicion(int pos) : int
    public int eliminarEnPosicion(int pos) {
        if (estaVacia() || pos < 0 || pos >= tamanio) {
            System.out.println("No se puede eliminar en posicion " + pos);
            return -1;
        }

        int borrado;

        if (pos == 0) {
            borrado = cabeza.dato;
            if (cabeza == cola) {
                cabeza = null;
                cola = null;
            } else {
                cabeza = cabeza.siguiente;
                cabeza.anterior = null;
            }
            tamanio--;
            return borrado;
        }

        if (pos == tamanio - 1) {
            borrado = cola.dato;
            eliminarUltimo();
            return borrado;
        }

        nodoD actual = cabeza;
        for (int i = 0; i < pos; i++) {
            actual = actual.siguiente;
        }

        borrado = actual.dato;
        actual.anterior.siguiente = actual.siguiente;
        actual.siguiente.anterior = actual.anterior;
        tamanio--;
        return borrado;
    }

    // 4) eliminarUltimo() : boolean
    public boolean eliminarUltimo() {
        if (estaVacia()) {
            return false;
        }

        if (cabeza == cola) {
            // Solo quedaba uno
            cabeza = null;
            cola = null;
        } else {
            // Movemos cola un paso hacia atras y cortamos el enlace hacia adelante
            cola = cola.anterior;
            cola.siguiente = null;
        }

        tamanio--;
        return true;
    }

    // 5) insertarOrdenado(int dato)
    // Mantiene los valores de menor a mayor
    public void insertarOrdenado(int dato) {
        // Si esta vacia o el dato es menor o igual que la cabeza, va al inicio
        if (estaVacia() || dato <= cabeza.dato) {
            insertarInicio(dato);
            return;
        }

        // Si el dato es mayor o igual que la cola, va al final
        if (dato >= cola.dato) {
            insertarFinal(dato);
            return;
        }

        // Buscamos el primer nodo cuyo dato sea mayor que el nuevo dato
        nodoD actual = cabeza;
        while (actual != null && actual.dato < dato) {
            actual = actual.siguiente;
        }

        // Insertamos justo antes de "actual"
        nodoD nuevo = new nodoD(dato);
        nodoD antes = actual.anterior;

        antes.siguiente = nuevo;
        nuevo.anterior = antes;
        nuevo.siguiente = actual;
        actual.anterior = nuevo;

        tamanio++;
    }

    // Recorre de izquierda a derecha usando "siguiente"
    public void mostrarAdelante() {
        if (estaVacia()) {
            System.out.println("Lista vacia (tamanio: " + tamanio + ")");
            return;
        }
        nodoD aux = cabeza;
        System.out.print("Adelante: ");
        while (aux != null) {
            System.out.print(aux.dato);
            if (aux.siguiente != null) {
                System.out.print(" <-> ");
            }
            aux = aux.siguiente;
        }
        System.out.println("  | tamanio = " + tamanio);
    }

    // Recorre de derecha a izquierda usando "anterior"
    // Sirve mucho para comprobar que ningun enlace hacia atras quedo mal
    public void mostrarAtras() {
        if (estaVacia()) {
            System.out.println("Lista vacia (tamanio: " + tamanio + ")");
            return;
        }
        nodoD aux = cola;
        System.out.print("Atras:    ");
        while (aux != null) {
            System.out.print(aux.dato);
            if (aux.anterior != null) {
                System.out.print(" <-> ");
            }
            aux = aux.anterior;
        }
        System.out.println("  | tamanio = " + tamanio);
    }
}
