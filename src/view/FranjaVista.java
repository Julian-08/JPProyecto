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
    * Solicita al usuario el consumo por hora en kW/H y lo retorna como un entero.
    * 
    * @return Consumo ingresado por el usuario en kW/H
    */
   public int mSolicitarConsumo() {
      System.out.print("Ingrese el consumo por hora en kW/H: ");
      return this.scanner.nextInt();
   }

   /**
    * Solicita al usuario el mes (1-12) y lo retorna como un entero.
    * 
    * @return Mes ingresado por el usuario (1-12)
    */
   public int mSolicitarMes() {
      System.out.print("Ingrese el mes (1-12): ");
      return this.scanner.nextInt();
   }

   /**
    * Solicita al usuario el año y lo retorna como un entero.
    * 
    * @return Año ingresado por el usuario
    */
   public int mSolicitarAnio() {
      System.out.print("Ingrese el año (por ejemplo, 2025): ");
      return this.scanner.nextInt();
   }

   /**
    * Solicita al usuario la hora en formato HH:mm y la retorna como una cadena.
    * 
    * @return Hora ingresada por el usuario (formato HH:mm)
    */
   public String mSolicitarHora() {
      System.out.print("Ingrese la hora (formato HH:mm): ");
      this.scanner.nextLine(); // Limpiar buffer
      return this.scanner.nextLine();
   }

   /**
    * Muestra un mensaje al usuario en la consola.
    * 
    * @param mensaje Mensaje a mostrar
    */
   public void mMostrarMensaje(String mensaje) {
      System.out.println(mensaje);
   }
}