/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listadoble;
import java.util.Scanner;
/**
 *  
 * @author angel
 */  
public class Main {

   public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        listaDoble lista = new listaDoble();
        int opcion;

        do {
            System.out.println("\n===== MENU LISTA DOBLE =====");
            System.out.println("1. Insertar ordenado");
            System.out.println("2. Insertar al inicio");
            System.out.println("3. Insertar al final");
            System.out.println("4. Insertar en posicion");
            System.out.println("5. Buscar valor");
            System.out.println("6. Eliminar por valor");
            System.out.println("7. Eliminar en posicion");
            System.out.println("8. Eliminar ultimo");
            System.out.println("9. Mostrar lista");
            System.out.println("10. Ver tamanio");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Dato: ");
                    lista.insertarOrdenado(teclado.nextInt());
                    lista.mostrar();
                    break;
                case 2:
                    System.out.print("Dato: ");
                    lista.insertarInicio(teclado.nextInt());
                    lista.mostrar();
                    break;
                case 3:
                    System.out.print("Dato: ");
                    lista.insertarFinal(teclado.nextInt());
                    lista.mostrar();
                    break;
                case 4:
                    System.out.print("Posici0n: ");
                    int posIns = teclado.nextInt();
                    System.out.print("Dato: ");
                    int datoIns = teclado.nextInt();
                    lista.insertarEnPosicion(posIns, datoIns);
                    lista.mostrar();
                    break;
                case 5:
                    System.out.print("Valor a buscar: ");
                    System.out.println(lista.buscar(teclado.nextInt()) ? "Encontrado" : "No encontrado");
                    break;
                case 6:
                    System.out.print("Valor a eliminar: ");
                    System.out.println(lista.eliminarPorValor(teclado.nextInt()) ? "Eliminado" : "No encontrado");
                    lista.mostrar();
                    break;
                case 7:
                    System.out.print("Posicion a eliminar: ");
                    int eliminadoPos = lista.eliminarEnPosicion(teclado.nextInt());
                    System.out.println(eliminadoPos != -1 ? "Eliminado: " + eliminadoPos : "Posición inválida o lista vacia");
                    lista.mostrar();
                    break;
                case 8:
                    System.out.println(lista.eliminarUltimo() ? "Ultimo elemento eliminado" : "Lista vacia");
                    lista.mostrar();
                    break;
                case 9:
                    lista.mostrar();
                    break;
                case 10:
                    System.out.println("Tamanio: " + lista.getTamanio());
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 0);

        teclado.close();
    }
}