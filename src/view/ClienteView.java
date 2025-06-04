package view;

import model.Cliente;
import javax.swing.JOptionPane;

/**
 * Clase que gestiona la interacción con el usuario para operaciones relacionadas con clientes.  
 * Permite registrar, editar y mostrar mensajes por ventana.
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas
 */

public class ClienteView {

    public ClienteView() {}

    public int mostrarMenuCliente() {
        String[] opciones = {"Registrar nuevo cliente", "Editar cliente", "Salir"};
        int opcion = JOptionPane.showOptionDialog(
            null, // Ventana padre centrada, null para usar la ventana principal
            "Seleccione una opción:",
            "Menú Cliente",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );
        return opcion + 1; // Para que sea 1,2,3 como antes
    }

    public Cliente mPedirDatos() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre del cliente:");
        String numeroIdentificacion = JOptionPane.showInputDialog(null, "Numero de identificacion del cliente:");
        String tipoDeIdentificacion = JOptionPane.showInputDialog(null, "Tipo de identificacion:");
        String correo = JOptionPane.showInputDialog(null, "Ingrese el correo del cliente:");
        String direccion = JOptionPane.showInputDialog(null, "Direccion del cliente:");
        return new Cliente(nombre, numeroIdentificacion, tipoDeIdentificacion, correo, direccion, 100); 
    }

    public String mSolicitarIdCliente() {
        return JOptionPane.showInputDialog(null, "Ingrese el numero de identificacion del cliente:");
    }

    // @param .isEmpty() se usa para validar si el usuario no ingresa un valor

    public Cliente mEditarCliente (Cliente objCliente) {
        String nombre = JOptionPane.showInputDialog(null, "Nuevo nombre del cliente (actual: " + objCliente.getNombre() + "):", objCliente.getNombre());
        if (nombre != null && !nombre.isEmpty()) objCliente.setNombre(nombre);

        String correo = JOptionPane.showInputDialog(null, "Nuevo correo del cliente (actual: " + objCliente.getCorreo() + "):", objCliente.getCorreo());
        if (correo != null && !correo.isEmpty()) objCliente.setCorreo(correo);

        String direccion = JOptionPane.showInputDialog(null, "Nueva direccion del cliente (actual: " + objCliente.getDireccion() + "):", objCliente.getDireccion());
        if (direccion != null && !direccion.isEmpty()) objCliente.setDireccion(direccion);

        return objCliente;
    }

    // Método para mostrar mensajes al usuario en una ventana emergente
    public void mMostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}