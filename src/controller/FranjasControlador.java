package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Franja; // Importación de model.Franja
import view.FranjaVista; // Importación de view.FranjaVista

public class FranjasControlador {
    private List<Franja> objListaFranjas; // Lista de franjas horarias
    private FranjaVista objVista; // Vista para interactuar con el usuario

    // Constructor que inicializa la vista y las franjas horarias
    public FranjasControlador(FranjaVista vista) {
        this.objVista = vista;
        this.mInicializarFranjas(); 
    }

    // Método para inicializar las franjas horarias
    private void mInicializarFranjas() {
        this.objListaFranjas = new ArrayList<>();
        this.objListaFranjas.add(new Franja(0, 6, 200));  // Franja de 0:00 a 6:00 con precio 200 COP
        this.objListaFranjas.add(new Franja(7, 17, 300)); // Franja de 7:00 a 17:00 con precio 300 COP
        this.objListaFranjas.add(new Franja(18, 23, 500)); // Franja de 18:00 a 23:00 con precio 500 COP
    }

    // Método principal para ejecutar la lógica del controlador
    public void mEjecutarAplicacion() {
        int objConsumo = objVista.solicitarConsumo(); // Solicitar el consumo al usuario
        String objHoraInput = objVista.solicitarHora(); // Solicitar la hora al usuario
        double objHora = this.mConvertirHora(objHoraInput); // Convertir la hora a formato decimal

        if (objHora == -1.0) {
            objVista.mostrarMensaje("La hora ingresada no es válida."); // Mensaje de error
        } else {
            Franja objFranja = this.mCalcularFranja(objHora); // Calcular la franja correspondiente
            if (objFranja != null) {
                int objTotal = objFranja.getPrecio() * objConsumo; // Calcular el total a pagar
                objVista.mostrarMensaje("El precio por kW/H es: " + objFranja.getPrecio() + " COP");
                objVista.mostrarMensaje("El total de su recibo es: " + objTotal + " COP");
            } else {
                objVista.mostrarMensaje("La  no está dentro de las franjas definidas."); // Mensaje si no hay franja
            }
        }
    }

    // Método para convertir una hora en formato "HH:mm" a un valor decimal
    private double mConvertirHora(String objHoraInput) {
        try {
            String[] objPartes = objHoraInput.split(":"); // Dividir la hora en horas y minutos
            int objHoras = Integer.parseInt(objPartes[0]);
            int objMinutos = Integer.parseInt(objPartes[1]);
            // Validar que las horas y minutos estén en el rango permitido
            return objHoras >= 0 && objHoras <= 23 && objMinutos >= 0 && objMinutos <= 59
                    ? (double) objHoras + (double) objMinutos / 60.0
                    : -1.0; // Retornar -1 si la hora no es válida
        } catch (Exception e) {
            return -1.0; // Retornar -1 si ocurre un error al procesar la hora
        }
    }

    // Método para calcular la franja horaria correspondiente a una hora dada
    private Franja mCalcularFranja(double objHora) {
        Iterator<Franja> objIterator = this.objListaFranjas.iterator();

        Franja objFranja;
        do {
            if (!objIterator.hasNext()) {
                return null; // Retornar null si no se encuentra una franja
            }
            objFranja = objIterator.next();
        } while (!(objHora >= (double) objFranja.getHoraInicio()) || !(objHora <= (double) objFranja.getHoraFin()));

        return objFranja; // Retornar la franja encontrada
    }
}