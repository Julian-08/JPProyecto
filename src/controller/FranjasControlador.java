package controller;

import java.util.ArrayList;
import java.util.List;
import model.Franja;
import view.FranjaVista;

public class FranjasControlador {
    /** Lista de franjas horarias */
    private List<Franja> objListaFranjas;
    /** Vista para interactuar con el usuario */
    private FranjaVista objVista;

    public FranjasControlador(FranjaVista vista) {
        this.objVista = vista;
        this.mInicializarFranjas(); 
    }

    private void mInicializarFranjas() {
        this.objListaFranjas = new ArrayList<>();
        this.objListaFranjas.add(new Franja(0, 6, 200));
        this.objListaFranjas.add(new Franja(7, 17, 300));
        this.objListaFranjas.add(new Franja(18, 23, 500));
    }

    public void mostrarMenuFranjas() {
        boolean salir = false;
        while (!salir) {
            int opcion = objVista.mostrarMenuFranjas();
            switch (opcion) {
                // case 1:
                //     mRegistrarFranja();
                //     break;
                case 2:
                    mEjecutarAplicacion();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    objVista.mMostrarMensaje("Opción inválida.");
            }
        }
    }

    public void mEjecutarAplicacion() {
        int consumoPromedio = objVista.mSolicitarConsumo();
        int mes = objVista.mSolicitarMes();
        int anio = objVista.mSolicitarAnio();
        String horaStr = objVista.mSolicitarHora(); // Ahora pide la hora como String

        int hora;
        try {
            if (horaStr.contains(":")) {
                hora = Integer.parseInt(horaStr.split(":")[0]);
            } else {
                hora = Integer.parseInt(horaStr);
            }
        } catch (NumberFormatException e) {
            objVista.mMostrarMensaje("Hora inválida. Debe ser un número entre 0 y 23.");
            return;
        }

        int[] consumosPorHora = mGenerarConsumosHorarios(consumoPromedio);

        Franja f = mCalcularFranja(hora);
        int diasDelMes = mObtenerDiasDelMes(mes, anio);

        if (f != null) {
            int total = consumosPorHora[hora] * f.mGetPrecio() * diasDelMes;
            objVista.mMostrarMensaje("\nHora seleccionada: " + hora + ":00");
            objVista.mMostrarMensaje("Consumo estimado: " + consumosPorHora[hora] + " kW/h");
            objVista.mMostrarMensaje("Franja: " + f.mGetPrecio() + " Cop/kw/h");
            objVista.mMostrarMensaje("Días del mes: " + diasDelMes);
            objVista.mMostrarMensaje("El total de su recibo es: " + total + " COP");
        } else {
            objVista.mMostrarMensaje("No existe franja para la hora indicada.");
        }
    }

    private int[] mGenerarConsumosHorarios(int promedio) {
        int[] consumos = new int[24];
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 24; i++) {
            if (i >= 0 && i <= 6) {
                consumos[i] = 5 + rand.nextInt(11);
            } else if (i >= 7 && i <= 17) {
                int min = (int)(promedio * 0.8);
                int max = (int)(promedio * 1.2);
                consumos[i] = min + rand.nextInt(Math.max(1, max - min + 1));
            } else {
                int min = (int)(promedio * 0.3);
                int max = (int)(promedio * 0.6);
                consumos[i] = min + rand.nextInt(Math.max(1, max - min + 1));
            }
        }
        return consumos;
    }

    private Franja mCalcularFranja(int hora) {
        for (Franja franja : this.objListaFranjas) {
            if (hora >= franja.mGetHoraInicio() && hora <= franja.mGetHoraFin()) {
                return franja;
            }
        }
        return null;
    }

    private int mObtenerDiasDelMes(int mes, int anio) {
        switch (mes) {
            case 2:
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

    public int calcularFactura(int consumoPromedio, int mes, int anio, view.FranjaVista vista) {
        int[] consumosPorHora = mGenerarConsumosHorarios(consumoPromedio);
        int diasDelMes = mObtenerDiasDelMes(mes, anio);
        int totalDiario = 0;
        for (int h = 0; h < 24; h++) {
            Franja f = mCalcularFranja(h);
            if (f != null) {
                totalDiario += consumosPorHora[h] * f.mGetPrecio();
            }
        }
        int totalFactura = totalDiario * diasDelMes;
        vista.mMostrarMensaje("\nEl total de su recibo es: " + totalFactura + " COP");
        return totalFactura;
    }
}