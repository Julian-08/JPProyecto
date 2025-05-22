import java.util.Scanner;
import controller.FranjasControlador; // Importación de controller.FranjasControlador
import view.FranjaVista; // Importación de view.FranjaVista

public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        FranjaVista vista = new FranjaVista(teclado);
        FranjasControlador controlador = new FranjasControlador(vista);
        controlador.mEjecutarAplicacion();
        teclado.close();
    }
}