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
            System.out.println("\n===== MENÚ LISTA DOBLE =====");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en posición");
            System.out.println("4. Insertar ordenado");
            System.out.println("5. Eliminar por valor");
            System.out.println("6. Eliminar en posición");
            System.out.println("7. Eliminar último");
            System.out.println("8. Mostrar adelante");
            System.out.println("9. Mostrar atrás");
            System.out.println("10. Ver tamaño");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor: ");
                    lista.insertarInicio(teclado.nextInt());
                    break;
                case 2:
                    System.out.print("Valor: ");
                    lista.insertarFinal(teclado.nextInt());
                    break;
                case 3:
                    System.out.print("Posición: ");
                    int posIns = teclado.nextInt();
                    System.out.print("Valor: ");
                    int valIns = teclado.nextInt();
                    lista.insertarEnPosicion(posIns, valIns);
                    break;
                case 4:
                    System.out.print("Valor a insertar ordenado: ");
                    lista.insertarOrdenado(teclado.nextInt());
                    break;
                case 5:
                    System.out.print("Valor a eliminar: ");
                    int x = teclado.nextInt();
                    System.out.println(lista.eliminarPorValor(x)
                            ? "Eliminado"
                            : "No encontrado");
                    break;
                case 6:
                    System.out.print("Posición a eliminar: ");
                    int posElim = teclado.nextInt();
                    int eliminadoPos = lista.eliminarEnPosicion(posElim);
                    if (eliminadoPos != -1) {
                        System.out.println("Elemento eliminado: " + eliminadoPos);
                    }
                    break;
                case 7:
                    System.out.println(lista.eliminarUltimo()
                            ? "Último elemento eliminado"
                            : "La lista está vacía");
                    break;
                case 8:
                    lista.mostrarAdelante();
                    break;
                case 9:
                    lista.mostrarAtras();
                    break;
                case 10:
                    System.out.println("Tamaño: " + lista.tamanio);
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        teclado.close();
    }
}