package view;

import model.Cliente;
import java.util.Scanner;

public class ClienteView {
    private Scanner teclado = new Scanner(System.in);

    public Cliente mPedirDatos()
    {
        System.out.println("Ingrese el nombre del cliente");
        String nombre = teclado.nextLine();
        System.out.println("Numero de identificacion del cliente");
        String numeroIdentificacion = teclado.nextLine();
        System.out.println("Ingrese el tipo de identificacion");
        String tipoDeIdentificacion =  teclado.nextLine();
        System.out.println("Ingrese el correo del cliente");
        String correo = teclado.nextLine();
        
    }
}
