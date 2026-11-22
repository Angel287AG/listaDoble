/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_de_calificaciones;

/**
 *
 * @author angel
 */
public class ListaEnlazada {
    private Nodo cabeza;
    private int tamanio;

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    // Inserta manteniendo la lista ordenada
    public void insertarOrdenado(int valor) {
        Nodo nuevo = new Nodo(valor);

        if (estaVacia() || valor < cabeza.dato) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            tamanio++;
            return;
        }

        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;
        while (actual != null && actual.dato <= valor) {
            anterior = actual;
            actual = actual.siguiente;
        }

        anterior.siguiente = nuevo;
        nuevo.siguiente = actual;
        tamanio++;
    }

    // Ver la lista
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("(sin entregas)");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Consultar calificación en cualquier posición 
    
    public int obtenerEnPosicion(int posicion) {
        if (estaVacia() || posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }
        Nodo actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    // Calificación mínima
    public int obtenerMinima() {
        if (estaVacia()) {
            throw new IllegalStateException("No hay calificaciones registradas.");
        }
        return cabeza.dato;
    }

    // Calificación máxima
    public int obtenerMaxima() {
        if (estaVacia()) {
            throw new IllegalStateException("No hay calificaciones registradas.");
        }
        return obtenerEnPosicion(tamanio - 1);
    }

    // Calificación mediana
    public double obtenerMediana() {
        if (estaVacia()) {
            throw new IllegalStateException("No hay calificaciones registradas.");
        }
        int mitad = tamanio / 2;
        if (tamanio % 2 != 0) {
            return obtenerEnPosicion(mitad);
        } else {
            int izquierdo = obtenerEnPosicion(mitad - 1);
            int derecho = obtenerEnPosicion(mitad);
            return (izquierdo + derecho) / 2.0;
        }
    }

    //calificación específica
    public boolean buscar(int valor) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == valor) {
                return true;
            }
            if (actual.dato > valor) {
                return false;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Eliminar 
    public boolean eliminar(int valor) {
        if (estaVacia()) {
            return false;
        }
        if (cabeza.dato == valor) {
            cabeza = cabeza.siguiente;
            tamanio--;
            return true;
        }
        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;
        while (actual != null) {
            if (actual.dato == valor) {
                anterior.siguiente = actual.siguiente;
                tamanio--;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    // Corregir calificaciones
    public boolean corregir(int valorAnterior, int valorNuevo) {
        if (!eliminar(valorAnterior)) {
            return false;
        }
        insertarOrdenado(valorNuevo);
        return true;
    }
    
}
