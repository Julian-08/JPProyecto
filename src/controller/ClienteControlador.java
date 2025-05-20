package controller;

import model.Cliente;
import view.ClienteView;
import java.util.Scanner;

public class ClienteControlador {
    private ClienteView objvista;
    private Cliente objmodelo;

    public void mNuevoCliente() {
        Cliente objNuevoCliente = objvista.mSolicitarIdCliente();
        if (objmodelo.crearCliente(objNuevoCliente)) {
            objvista.mMostrarMensaje("Cliente creado con éxito");

        } else {
            objvista.mMostrarMensaje("No se pudo crear el cliente");
        }
    }
   
    public void mEditarCliente() {
        String idCliente = objvista.mSolicitarIdCliente();
        Cliente objClienteEditar = objmodelo.buscarCliente(idCliente);
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


}
