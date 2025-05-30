package controller;

import model.Cliente;
import view.ClienteView;

/**
 * Controlador que gestiona las operaciones relacionadas con clientes.
 * Permite crear, editar y mostrar el menú de cliente.
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas
 */
public class ClienteControlador {
    private ClienteView objvista;
    private Cliente objmodelo;

    // Constructor necesario para el flujo MVC
    public ClienteControlador(Cliente modelo, ClienteView vista) {
        this.objmodelo = modelo;
        this.objvista = vista;
    }

    public void mNuevoCliente() {
        Cliente objNuevoCliente = objvista.mPedirDatos();
        if (objmodelo.crearCliente(objNuevoCliente)) {
            objvista.mMostrarMensaje("Cliente creado con éxito");
        } else {
            objvista.mMostrarMensaje("No se pudo crear el cliente");
        }
    }
   
    public void mEditarCliente() {
        String idCliente = objvista.mSolicitarIdCliente();
        Cliente objClienteEditar = objmodelo.obtenerCliente(idCliente);
        if (objClienteEditar != null) {
            Cliente objClienteEditado = objvista.mEditarCliente(objClienteEditar);
            if (objmodelo.actualizarCliente(objClienteEditado)) {
                objvista.mMostrarMensaje("Cliente editado exitosamente");
            } else {
                objvista.mMostrarMensaje("Error al editar el cliente");
            }
        } else {
            objvista.mMostrarMensaje("No se encontró el cliente con el ID proporcionado");
        }
    }

    // Menú de cliente en ventana
    public void mostrarMenuCliente() {
        boolean salir = false;
        while (!salir) {
            int opcion = objvista.mostrarMenuCliente();
            switch (opcion) {
                case 1:
                    mNuevoCliente();
                    break;
                case 2:
                    mEditarCliente();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    objvista.mMostrarMensaje("Opción inválida.");
            }
        }
    }
}