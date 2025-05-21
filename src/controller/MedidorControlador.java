package controller;

import model.MedidorModelo;
import view.MedidorVista;

// Controlador: gestiona la lógica entre vista y modelo
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
                    String consumo = vista.pedirDato("Ingrese consumo inicial en kWh: ");
                    boolean agregado = modelo.agregarMedidor(id, direccion, ciudad, idCliente, consumo);
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

                    String clienteActualizar = vista.pedirDato("Ingrese ID del cliente: ");
                    String nuevoConsumo = vista.pedirDato("Ingrese nuevo consumo en kWh: ");
                    boolean actualizado = modelo.actualizarConsumoPorCliente(clienteActualizar, nuevoConsumo);
                    if (actualizado) {
                        vista.mostrarMensaje("Consumo actualizado correctamente.\n");
                    } else {
                        vista.mostrarMensaje("Cliente no encontrado.\n");
                    }
                    break;


                case "5":
                    String clienteBuscar = vista.pedirDato("Ingrese ID del cliente: ");
                    String consumoEncontrado = modelo.obtenerConsumoPorCliente(clienteBuscar);
                    if (consumoEncontrado != null) {
                        vista.mostrarMensaje("Consumo registrado: " + consumoEncontrado + " kWh\n");
                    } else {
                        vista.mostrarMensaje("Cliente no encontrado.\n");
                    }
                    break;


                case "6":


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