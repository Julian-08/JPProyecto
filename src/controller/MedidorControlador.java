package controller;

import model.MedidorModelo;
import view.MedidorVista;

/**
 * Controlador que gestiona la lógica entre la vista y el modelo de medidores.
 * Permite agregar, mostrar y editar medidores.
 * 
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas
 */
public class MedidorControlador {
    private MedidorModelo modelo;
    private MedidorVista vista;

    public MedidorControlador(MedidorModelo modelo, MedidorVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            vista.mostrarMenu();
            String opcion = vista.pedirDato("Seleccione una opción: ");

            switch (opcion) {
                case "1":
                    String id = vista.pedirDato("Ingrese ID del medidor: ");
                    String direccion = vista.pedirDato("Ingrese dirección: ");
                    String ciudad = vista.pedirDato("Ingrese ciudad: ");
                    String idCliente = vista.pedirDato("Ingrese ID del cliente: ");
                    boolean agregado = modelo.agregarMedidor(id, direccion, ciudad, idCliente);
                    if (agregado) {
                        vista.mostrarMensaje("Medidor agregado exitosamente.\n");
                    } else {
                        vista.mostrarMensaje("No se pudo agregar el medidor (límite alcanzado).\n");
                    }
                    break;

                case "2":
                    vista.mostrarMedidores(modelo.obtenerTodosLosMedidores(), modelo.getCantidadMedidores());
                    break;

                case "3":
                    String idEditar = vista.pedirDato("Ingrese el ID del medidor que desea editar: ");
                    String nuevaDireccion = vista.pedirDato("Nueva dirección: ");
                    String nuevaCiudad = vista.pedirDato("Nueva ciudad: ");
                    String nuevoIdCliente = vista.pedirDato("Nuevo ID de cliente: ");
                    boolean editado = modelo.editarMedidor(idEditar, nuevaDireccion, nuevaCiudad, nuevoIdCliente);
                    if (editado) {
                        vista.mostrarMensaje("Medidor editado exitosamente.\n");
                    } else {
                        vista.mostrarMensaje("Medidor no encontrado.\n");
                    }
                    break;

                case "4":
                    continuar = false;
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida.\n");
                    break;
            }
        }
    }
}