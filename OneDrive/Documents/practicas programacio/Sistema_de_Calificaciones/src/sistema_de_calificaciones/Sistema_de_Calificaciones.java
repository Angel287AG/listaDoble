/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema_de_calificaciones;

/**
 *
 * @author angel
 */
public class Sistema_de_Calificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaEnlazada calificaciones = new ListaEnlazada();

        calificaciones.insertarOrdenado(80);
        calificaciones.insertarOrdenado(95);
        calificaciones.insertarOrdenado(70);
        calificaciones.insertarOrdenado(85);

        calificaciones.mostrar();
        System.out.println("Posición 1: " + calificaciones.obtenerEnPosicion(1));
        System.out.println("Mínima: " + calificaciones.obtenerMinima());
        System.out.println("Máxima: " + calificaciones.obtenerMaxima());
        System.out.println("Mediana: " + calificaciones.obtenerMediana());
        System.out.println("Existe 85: " + calificaciones.buscar(85));
        System.out.println("Total entregas: " + calificaciones.getTamanio());

        calificaciones.corregir(70, 75);
        calificaciones.eliminar(95);
        calificaciones.mostrar();
        System.out.println("Total entregas: " + calificaciones.getTamanio());
    
    }
    
}
