package view;

import model.Cliente;
import java.util.Scanner;

public class ClienteView {
    private Scanner teclado = new Scanner(System.in);

    public Cliente mPedirDatos()
    {
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
        return new Cliente(nombre, numeroIdentificacion, tipoDeIdentificacion, correo, direccion);
        
    }

    public String mSolicitarIdCliente()
    {
        System.out.println("Ingrese el numero de identificacion del cliente");
        String numeroIdentificacion = teclado.nextLine();
        return numeroIdentificacion;
    }
    public Cliente mEditarCliente (Cliente objCliente)
    {
        System.out.println("Editando cliente con numero de identificacion: " + objCliente.getNumeroIdentificacion());
        System.out.println("\n =========================");
        System.out.println("Ingrese el nuevo nombre del cliente (Dejar en blanco para no cambiar):");
        String nombre = teclado.nextLine();
        if (!nombre.isEmpty()) { // Verifica si el nombre no está vacío
            objCliente.setNombre(nombre);
        }
        System.out.println("Ingrese el nuevo correo del cliente (Dejar en blanco para no cambiar):");
        // Se solicita el correo al usuario
        String correo = teclado.nextLine();
        if (!correo.isEmpty()) { // Verifica si el correo no está vacío
            objCliente.setCorreo(correo);
        }
        
        System.out.println("Ingrese la nueva direccion del cliente (Dejar en blanco para no cambiar):");
        String direccion = teclado.nextLine();
        if (!direccion.isEmpty()) { // Verifica si la dirección no está vacía
            objCliente.setDireccion(direccion);
        }

        return objCliente;
    }
}
