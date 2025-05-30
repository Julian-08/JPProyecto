package view;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Clase que gestiona la interacción con el usuario para operaciones relacionadas con franjas horarias.
 * Permite solicitar datos y mostrar mensajes por ventana.
 * 
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas
 */
public class FranjaVista {
    
   /** Objeto para leer la entrada del usuario desde la consola (no se usa con JOptionPane, pero se deja por compatibilidad) */
   private Scanner scanner;
   
   /**
    * Constructor de la clase FranjaVista.
    * 
    * @param scanner Scanner para la entrada de datos del usuario
    */
   public FranjaVista(Scanner scanner) {
      this.scanner = scanner;
   }

   /**
    * Solicita al usuario el consumo por hora en kW/H y lo retorna como un entero.
    * 
    * @return Consumo ingresado por el usuario en kW/H
    */
   public int mSolicitarConsumo() {
      String input = JOptionPane.showInputDialog(null, "Ingrese el consumo por hora en kW/H:");
      return Integer.parseInt(input);
   }

   /**
    * Solicita al usuario el mes (1-12) y lo retorna como un entero.
    * 
    * @return Mes ingresado por el usuario (1-12)
    */
   public int mSolicitarMes() {
      String input = JOptionPane.showInputDialog(null, "Ingrese el mes (1-12):");
      return Integer.parseInt(input);
   }

   /**
    * Solicita al usuario el año y lo retorna como un entero.
    * 
    * @return Año ingresado por el usuario
    */
   public int mSolicitarAnio() {
      String input = JOptionPane.showInputDialog(null, "Ingrese el año (por ejemplo, 2025):");
      return Integer.parseInt(input);
   }

   /**
    * Solicita al usuario la hora en formato HH:mm y la retorna como una cadena.
    * 
    * @return Hora ingresada por el usuario (formato HH:mm)
    */
   public String mSolicitarHora() {
      return JOptionPane.showInputDialog(null, "Ingrese la hora (formato HH:mm):");
   }

   /**
    * Muestra un mensaje al usuario en una ventana.
    * 
    * @param mensaje Mensaje a mostrar
    */
   public void mMostrarMensaje(String mensaje) {
      JOptionPane.showMessageDialog(null, mensaje);
   }

   public int mostrarMenuFranjas() {
      String[] opciones = {"Calcular consumo", "Salir"};
      int opcion = JOptionPane.showOptionDialog(
         null,
         "Seleccione una opción:",
         "Menú Franjas",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.INFORMATION_MESSAGE,
         null,
         opciones,
         opciones[0]
      );
      return opcion + 1; // 1 para calcular, 2 para salir
   }
}