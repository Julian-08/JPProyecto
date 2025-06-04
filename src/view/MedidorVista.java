package view;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Clase que gestiona la interacción con el usuario para operaciones relacionadas con medidores.
 * Permite solicitar datos y mostrar mensajes por ventana.
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
        String[] opciones = {"Agregar nuevo medidor", "Mostrar todos los medidores", "Editar medidor", "Salir"};
        JOptionPane.showOptionDialog(
            null,
            "=== MENÚ MEDIDOR DE LUZ ===",
            "Menú Medidor",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );
    }

    /**
     * Solicita un dato al usuario mostrando un mensaje.
     * @param mensaje Mensaje a mostrar
     * @return Dato ingresado por el usuario
     */
    public String pedirDato(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

    /**
     * Muestra un mensaje al usuario.
     * @param mensaje Mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * Muestra la lista de medidores registrados.
     * @param datos Matriz con los datos de los medidores
     * @param cantidad Cantidad de medidores registrados
     * @param StringBuilder sb StringBuilder para construir el mensaje concatenando varias lineas de texto
     * 
     */
    public void mostrarMedidores(String[][] datos, int cantidad) {
        StringBuilder sb = new StringBuilder("--- LISTA DE MEDIDORES ---\n");
        for (int i = 0; i < cantidad; i++) {
            sb.append("ID: ").append(datos[i][0])
              .append(", Dirección: ").append(datos[i][1])
              .append(", Ciudad: ").append(datos[i][2])
              .append(", Cliente: ").append(datos[i][3])
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}