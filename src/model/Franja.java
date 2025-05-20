package model;

/**
 * Clase que representa una franja horaria con un precio asociado.
 * 
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas
 */
public class Franja {
   /** Hora de inicio de la franja */
   private int horaInicio;
   /** Hora de fin de la franja */
   private int horaFin;
   /** Precio asociado a la franja */
   private int precio;

   /**
    * Constructor de la clase Franja.
    * 
    * @param horaInicio Hora de inicio de la franja
    * @param horaFin Hora de fin de la franja
    * @param precio Precio de la franja
    */
   public Franja(int horaInicio, int horaFin, int precio) {
      this.horaInicio = horaInicio;
      this.horaFin = horaFin;
      this.precio = precio;
   }

   /** @return la hora de inicio de la franja */
   public int getHoraInicio() {
      return this.horaInicio;
   }

   /** @return la hora de fin de la franja */
   public int getHoraFin() {
      return this.horaFin;
   }

   /** @return el precio de la franja */
   public int getPrecio() {
      return this.precio;
   }
}
