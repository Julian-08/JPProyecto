package view;

import java.util.Scanner;

public class FranjaVista {
    
   private Scanner scanner; // Objeto para leer la entrada del usuario desde la consola
   
   public FranjaVista(Scanner scanner) {
      this.scanner = scanner;
   }

   // Solicita al usuario el consumo en kW/H y lo retorna como un entero
   public int solicitarConsumo() {
      System.out.print("Ingrese el consumo en kW/H: "); // Mensaje para el usuario
      return this.scanner.nextInt(); // Lee un número entero ingresado por el usuario
   }

   // Solicita al usuario la hora actual en formato HH:mm y la retorna como una cadena
   public String solicitarHora() {
      this.scanner.nextLine(); // Limpia el buffer del Scanner para evitar problemas con la entrada
      System.out.print("Ingrese la hora actual (formato HH:mm, por ejemplo, 3:00 o 14:30): "); // Mensaje para el usuario
      return this.scanner.nextLine(); // Lee una línea de texto ingresada por el usuario
   }

   // Muestra un mensaje al usuario en la consola
   public void mostrarMensaje(String mensaje) {
      System.out.println(mensaje); // Imprime el mensaje proporcionado
   }
}
