package model;

public class Franja {
   private int horaInicio;
   private int horaFin;
   private int precio;

   public Franja(int horaInicio, int horaFin, int precio) {
      this.horaInicio = horaInicio;
      this.horaFin = horaFin;
      this.precio = precio;
   }

   public int getHoraInicio() {
      return this.horaInicio;
   }

   public int getHoraFin() {
      return this.horaFin;
   }

   public int getPrecio() {
      return this.precio;
   }
}
