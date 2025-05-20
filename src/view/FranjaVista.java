package view;

import java.util.Scanner;

/**
 * Clase que gestiona la interacción con el usuario para operaciones relacionadas con franjas horarias.
 * Permite solicitar datos y mostrar mensajes por consola.
 * 
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas
 */
public class FranjaVista {
    
   /** Objeto para leer la entrada del usuario desde la consola */
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
    * Solicita al usuario el consumo en kW/H y lo retorna como un entero.
    * 
    * @return Consumo ingresado por el usuario en kW/H
    */
   public int solicitarConsumo() {
      System.out.print("Ingrese el consumo en kW/H: ");
      return this.scanner.nextInt();
   }

   /**
    * Solicita al usuario la hora actual en formato HH:mm y la retorna como una cadena.
    * 
    * @return Hora ingresada por el usuario en formato HH:mm
    */
   public String solicitarHora() {
      this.scanner.nextLine(); // Limpia el buffer del Scanner para evitar problemas con la entrada
      System.out.print("Ingrese la hora actual (formato HH:mm, por ejemplo, 3:00 o 14:30): ");
      return this.scanner.nextLine();
   }

   /**
    * Muestra un mensaje al usuario en la consola.
    * 
    * @param mensaje Mensaje a mostrar
    */
   public void mostrarMensaje(String mensaje) {
      System.out.println(mensaje);
   }
}