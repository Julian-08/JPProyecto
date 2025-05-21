package view;
import java.util.Scanner;


public class MedidorVista {
    private Scanner scanner;

    public MedidorVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("=== MENÚ MEDIDOR DE LUZ ===");
        System.out.println("1. Agregar nuevo medidor");
        System.out.println("2. Mostrar todos los medidores");
        System.out.println("3. Editar medidor");
        System.out.println("4. Registrar consumo");
        System.out.println("5. COnsultar consumo por cliente");
        System.out.println("6. Salir");
    }

    public String pedirDato(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarMedidores(String[][] datos, int cantidad) {
        System.out.println("\n--- LISTA DE MEDIDORES ---");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("ID: " + datos[i][0]
                    + ", Dirección: " + datos[i][1]
                    + ", Ciudad: " + datos[i][2]
                    + ", Cliente: " + datos[i][3]
                    + ", Consumo: " + datos[i][4] + " kWh");
        }
        System.out.println();
    }
}
