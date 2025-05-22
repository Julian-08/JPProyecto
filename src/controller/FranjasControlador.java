package controller;

import java.util.ArrayList;
import java.util.List;
import model.Franja;
import view.FranjaVista;

/**
 * Controlador que gestiona la lógica relacionada con las franjas horarias y el cálculo del total a pagar.
 * Interactúa con la vista para solicitar datos y mostrar resultados al usuario.
 * 
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas
 */
public class FranjasControlador {
    /** Lista de franjas horarias */
    private List<Franja> objListaFranjas;
    /** Vista para interactuar con el usuario */
    private FranjaVista objVista;

    /**
     * Constructor que inicializa la vista y las franjas horarias.
     * 
     * @param vista Vista para la interacción con el usuario
     */
    public FranjasControlador(FranjaVista vista) {
        this.objVista = vista;
        this.mInicializarFranjas(); 
    }

    /**
     * Inicializa las franjas horarias con sus respectivos precios.
     */
    private void mInicializarFranjas() {
        this.objListaFranjas = new ArrayList<>();
        this.objListaFranjas.add(new Franja(0, 6, 200));   // Franja de 0:00 a 6:00 con precio 200 COP
        this.objListaFranjas.add(new Franja(7, 17, 300));  // Franja de 7:00 a 17:00 con precio 300 COP
        this.objListaFranjas.add(new Franja(18, 23, 500)); // Franja de 18:00 a 23:00 con precio 500 COP
    }

    /**
     * Método principal para ejecutar la lógica del controlador.
     * Solicita el consumo promedio, el mes y el año al usuario,
     * genera 24 consumos horarios realistas según la franja,
     * muestra la franja y calcula el total mensual.
     */
    public void mEjecutarAplicacion() {
        int consumoPromedio = objVista.mSolicitarConsumo();
        int mes = objVista.mSolicitarMes();
        int anio = objVista.mSolicitarAnio();

        // Generar 24 consumos horarios realistas según la franja
        int[] consumosPorHora = mGenerarConsumosHorarios(consumoPromedio);

        objVista.mMostrarMensaje("\nConsumo horario simulado para un día:");
        for (int h = 0; h < 24; h++) {
            Franja f = mCalcularFranja(h);
            String franjaInfo = (f != null) ?  + f.mGetPrecio() + " Cop/kw/h" : "Sin franja";
            objVista.mMostrarMensaje(String.format("%02d:00 - %d kw/h (%s)", h, consumosPorHora[h], franjaInfo));
        }

        int diasDelMes = mObtenerDiasDelMes(mes, anio);

        // Sumar el total diario (solo consumo * precio de franja)
        int totalDiario = 0;
        for (int h = 0; h < 24; h++) {
            Franja f = mCalcularFranja(h);
            if (f != null) {
                totalDiario += consumosPorHora[h] * f.mGetPrecio();
            }
        }

        // Multiplicar el total diario por los días del mes
        int totalFactura = totalDiario * diasDelMes;

        objVista.mMostrarMensaje("\nPara el mes " + mes + " del año " + anio + " (" + diasDelMes + " días):");
        objVista.mMostrarMensaje("El total de su recibo es: " + totalFactura + " COP");
    }

    /**
     * Genera un arreglo de 24 consumos horarios realistas según la franja.
     * 
     * @param promedio Promedio de consumo por hora ingresado por el usuario
     * @return Arreglo de 24 consumos horarios simulados
     */
    private int[] mGenerarConsumosHorarios(int promedio) {
        int[] consumos = new int[24];
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 24; i++) {
            if (i >= 0 && i <= 6) {
                // Madrugada: consumo bajo (5 a 15)
                consumos[i] = 5 + rand.nextInt(11);
            } else if (i >= 7 && i <= 17) {
                // Día: consumo alrededor del promedio (80% a 120%)
                int min = (int)(promedio * 0.8);
                int max = (int)(promedio * 1.2);
                consumos[i] = min + rand.nextInt(Math.max(1, max - min + 1));
            } else {
                // Noche: consumo medio (30% a 60% del promedio)
                int min = (int)(promedio * 0.3);
                int max = (int)(promedio * 0.6);
                consumos[i] = min + rand.nextInt(Math.max(1, max - min + 1));
            }
        }
        return consumos;
    }

    /**
     * Calcula la franja horaria correspondiente a una hora dada.
     * 
     * @param hora Hora en formato entero (0-23)
     * @return La franja correspondiente o null si no se encuentra ninguna
     */
    private Franja mCalcularFranja(int hora) {
        for (Franja franja : this.objListaFranjas) {
            if (hora >= franja.mGetHoraInicio() && hora <= franja.mGetHoraFin()) {
                return franja;
            }
        }
        return null;
    }

    /**
     * Devuelve el número de días del mes, considerando años bisiestos para febrero.
     * 
     * @param mes Mes del año (1-12)
     * @param anio Año correspondiente
     * @return Número de días del mes
     */
    private int mObtenerDiasDelMes(int mes, int anio) {
        switch (mes) {
            case 2:
                // Febrero: 28 o 29 días
                if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }
}