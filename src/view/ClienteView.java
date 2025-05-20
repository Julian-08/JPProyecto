package view;

import model.Cliente;
import java.util.Scanner;

/**
 * Clase que gestiona la interacción con el usuario para operaciones relacionadas con clientes.
 * Permite solicitar datos, editar información y mostrar mensajes por consola.
 * 
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas
 */
public class ClienteView {
    /** Objeto para leer la entrada del usuario desde la consola */
    private Scanner teclado = new Scanner(System.in);

    /**
     * Constructor de la clase ClienteView.
     */
    public ClienteView() {
        // Constructor vacío
    }

    /**
     * Solicita al usuario los datos para crear un nuevo cliente.
     * 
     * @return Un nuevo objeto Cliente con los datos ingresados
     */
    public Cliente mPedirDatos() {
        System.out.println("Creando un cliente nuevo");
        System.out.println("\n =========================");
        System.out.println("\n Nombre del cliente:");
        String nombre = teclado.nextLine();
        System.out.println("Numero de identificacion del cliente:");
        String numeroIdentificacion = teclado.nextLine();
        System.out.println("Tipo de identificacion:");
        String tipoDeIdentificacion =  teclado.nextLine();
        System.out.println("Ingrese el correo del cliente:");
        String correo = teclado.nextLine();
        System.out.println("Direccion del cliente:");
        String direccion = teclado.nextLine();
        return new Cliente(nombre, numeroIdentificacion, tipoDeIdentificacion, correo, direccion, 0, 0, 0); 
    }

    /**
     * Solicita al usuario el número de identificación de un cliente.
     * 
     * @return Número de identificación ingresado por el usuario
     */
    public String mSolicitarIdCliente() {
        System.out.println("Ingrese el numero de identificacion del cliente");
        String numeroIdentificacion = teclado.nextLine();
        return numeroIdentificacion;
    }

    /**
     * Permite editar los datos de un cliente existente.
     * Solo se actualizan los campos que el usuario ingresa (no vacíos).
     * 
     * @param objCliente Cliente a editar
     * @return El cliente con los datos actualizados
     */
    public Cliente mEditarCliente (Cliente objCliente) {
        System.out.println("Editando cliente con numero de identificacion: " + objCliente.getNumeroIdentificacion());
        System.out.println("\n =========================");
        System.out.println("Ingrese el nuevo nombre del cliente (Dejar en blanco para no cambiar):");
        String nombre = teclado.nextLine();
        if (!nombre.isEmpty()) /*  Verifica si el nombre no está vacío por medio de .isEmpty() de ser verdadero 
        cambiara el nombre, si esya vacio dejara el que ya se tenia*/{
            objCliente.setNombre(nombre);
        }
        System.out.println("Ingrese el nuevo correo del cliente (Dejar en blanco para no cambiar):");
        String correo = teclado.nextLine();
        if (!correo.isEmpty()) {
            objCliente.setCorreo(correo);
        }
        System.out.println("Ingrese la nueva direccion del cliente (Dejar en blanco para no cambiar):");
        String direccion = teclado.nextLine();
        if (!direccion.isEmpty()) {
            objCliente.setDireccion(direccion);
        }
        return objCliente;
    }
}