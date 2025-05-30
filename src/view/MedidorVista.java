package view;
import java.util.Scanner;

/**
 * Clase que gestiona la interacción con el usuario para operaciones relacionadas con medidores.
 * Permite solicitar datos y mostrar mensajes por consola.
 * 
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas
 */
public class MedidorVista {
    private Scanner scanner;

    public MedidorVista() {
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal de medidores y las opciones disponibles.
     */
    public void mostrarMenu() {
        System.out.println("=== MENÚ MEDIDOR DE LUZ ===");
        System.out.println("1. Agregar nuevo medidor");
        System.out.println("2. Mostrar todos los medidores");
        System.out.println("3. Editar medidor");
        System.out.println("4. Salir");
    }

    /**
     * Solicita un dato al usuario mostrando un mensaje.
     * @param mensaje Mensaje a mostrar
     * @return Dato ingresado por el usuario
     */
    public String pedirDato(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    /**
     * Muestra un mensaje al usuario.
     * @param mensaje Mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Muestra la lista de medidores registrados.
     * @param datos Matriz con los datos de los medidores
     * @param cantidad Cantidad de medidores registrados
     */
    public void mostrarMedidores(String[][] datos, int cantidad) {
        System.out.println("\n--- LISTA DE MEDIDORES ---");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("ID: " + datos[i][0]
                    + ", Dirección: " + datos[i][1]
                    + ", Ciudad: " + datos[i][2]
                    + ", Cliente: " + datos[i][3]);
        }
        System.out.println();
    }
}