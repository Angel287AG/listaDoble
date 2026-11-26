/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listadoble;

public class listaDoble {
    
    private nodoD cabeza;
    private nodoD cola;
    private int tamanio;

    public listaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void insertarInicio(int valor) {
        nodoD nuevo = new nodoD(valor);
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

    public void insertarFinal(int valor) {
        nodoD nuevo = new nodoD(valor);
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

    public void insertarEnPosicion(int pos, int dato) {
        if (pos <= 0 || estaVacia()) {
            insertarInicio(dato);
            return;
        }
        if (pos >= tamanio) {
            insertarFinal(dato);
            return;
        }

        nodoD actual = cabeza;
        for (int i = 0; i < pos; i++) {
            actual = actual.siguiente;
        }

        nodoD nuevo = new nodoD(dato);
        nodoD previo = actual.anterior;

        previo.siguiente = nuevo;
        nuevo.anterior = previo;
        nuevo.siguiente = actual;
        actual.anterior = nuevo;
        tamanio++;
    }

    public void insertarOrdenado(int dato) {
        if (estaVacia() || dato <= cabeza.dato) {
            insertarInicio(dato);
            return;
        }
        if (dato >= cola.dato) {
            insertarFinal(dato);
            return;
        }

        nodoD actual = cabeza.siguiente;
        while (actual != null && actual.dato < dato) {
            actual = actual.siguiente;
        }

        nodoD nuevo = new nodoD(dato);
        nodoD previo = actual.anterior;

        previo.siguiente = nuevo;
        nuevo.anterior = previo;
        nuevo.siguiente = actual;
        actual.anterior = nuevo;
        tamanio++;
    }

    public boolean buscar(int valor) {
        nodoD actual = cabeza;
        while (actual != null) {
            if (actual.dato == valor) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean eliminarPorValor(int x) {
        if (estaVacia()) {
            return false;
        }

        nodoD actual = cabeza;
        while (actual != null && actual.dato != x) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            return false;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else if (actual == cabeza) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        } else if (actual == cola) {
            cola = cola.anterior;
            cola.siguiente = null;
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }

        tamanio--;
        return true;
    }

    public int eliminarEnPosicion(int pos) {
        if (estaVacia() || pos < 0 || pos >= tamanio) {
            return -1;
        }

        nodoD actual = cabeza;
        for (int i = 0; i < pos; i++) {
            actual = actual.siguiente;
        }

        int valorEliminado = actual.dato;

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else if (actual == cabeza) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        } else if (actual == cola) {
            cola = cola.anterior;
            cola.siguiente = null;
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }

        tamanio--;
        return valorEliminado;
    }

    public boolean eliminarUltimo() {
        if (estaVacia()) {
            return false;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.anterior;
            cola.siguiente = null;
        }

        tamanio--;
        return true;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("(lista vacía)");
            return;
        }
        nodoD actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" <-> ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
