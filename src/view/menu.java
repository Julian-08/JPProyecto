package view;

import javax.swing.*;
import java.awt.*;
import model.Cliente;
import model.MedidorModelo;
import controller.ClienteControlador;
import controller.MedidorControlador;
import controller.FranjasControlador;
import view.ClienteView;
import view.MedidorVista;
import view.FranjaVista;

public class menu extends JFrame {
    private JButton btnCliente;
    private JButton btnRegistrador;
    private JButton btnConsumos;
    private JButton btnImprimirRecibo;

    // Instancia global para que los datos persistan
    private Cliente modeloCliente = new Cliente(100);
    private Cliente ultimoCliente;
    private String[] ultimoMedidor;
    private int ultimoConsumo;
    private int ultimoMes;
    private int ultimoAnio;
    private int ultimoTotalFactura;

    public menu() {
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel lblTitulo = new JLabel("MENÚ");
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(lblTitulo);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        btnCliente = new JButton("Cliente");
        btnCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCliente.setMaximumSize(new Dimension(200, 40));
        panel.add(btnCliente);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        btnRegistrador = new JButton("Registrador");
        btnRegistrador.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegistrador.setMaximumSize(new Dimension(200, 40));
        panel.add(btnRegistrador);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        btnConsumos = new JButton("Consumos");
        btnConsumos.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnConsumos.setMaximumSize(new Dimension(200, 40));
        panel.add(btnConsumos);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        btnImprimirRecibo = new JButton("Imprimir Factura y Salir");
        btnImprimirRecibo.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnImprimirRecibo.setMaximumSize(new Dimension(200, 40));
        panel.add(btnImprimirRecibo);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Acciones de los botones
        btnCliente.addActionListener(e -> abrirCliente());
        btnRegistrador.addActionListener(e -> abrirRegistrador());
        btnConsumos.addActionListener(e -> abrirConsumos());
        btnImprimirRecibo.addActionListener(e -> imprimirReciboYSalir());

        add(panel);
    }

    // Métodos para abrir las ventanas correspondientes
    private void abrirCliente() {
        ClienteView vista = new ClienteView();
        ClienteControlador controlador = new ClienteControlador(modeloCliente, vista);
        controlador.mostrarMenuCliente();
        // Guardar el último cliente ingresado (si hay alguno)
        if (modeloCliente.getCantidadClientes() > 0) {
            ultimoCliente = modeloCliente.obtenerCliente(modeloCliente.getCantidadClientes() - 1);
        }
    }

    private void abrirRegistrador() {
        MedidorModelo modelo = new MedidorModelo(100);
        MedidorVista vista = new MedidorVista();
        MedidorControlador controlador = new MedidorControlador(modelo, vista);
        controlador.iniciar();

        // Guardar el último medidor ingresado (si hay alguno)
        if (modelo.getCantidadMedidores() > 0) {
            ultimoMedidor = modelo.obtenerTodosLosMedidores()[modelo.getCantidadMedidores() - 1];
        }
    }

    private void abrirConsumos() {
        FranjaVista vista = new FranjaVista(new java.util.Scanner(System.in));
        FranjasControlador controlador = new FranjasControlador(vista);

        // Guardar los datos de consumo
        ultimoConsumo = vista.mSolicitarConsumo();
        ultimoMes = vista.mSolicitarMes();
        ultimoAnio = vista.mSolicitarAnio();

        // Calcula el total de la factura y lo guarda
        ultimoTotalFactura = controlador.calcularFactura(ultimoConsumo, ultimoMes, ultimoAnio, vista);
    }

    // Método para imprimir el recibo con los datos guardados y salir
    private void imprimirReciboYSalir() {
        System.out.println("\n===== FACTURA DE SERVICIO =====");
        if (ultimoCliente != null) {
            System.out.println("Cliente:");
            System.out.println("  Nombre: " + ultimoCliente.getNombre());
            System.out.println("  ID: " + ultimoCliente.getNumeroIdentificacion());
            System.out.println("  Tipo ID: " + ultimoCliente.getTipoDeIdentificacion());
            System.out.println("  Correo: " + ultimoCliente.getCorreo());
            System.out.println("  Dirección: " + ultimoCliente.getDireccion());
        } else {
            System.out.println("No hay datos de cliente.");
        }

        if (ultimoMedidor != null) {
            System.out.println("\nMedidor:");
            System.out.println("  ID: " + ultimoMedidor[0]);
            System.out.println("  Dirección: " + ultimoMedidor[1]);
            System.out.println("  Ciudad: " + ultimoMedidor[2]);
            System.out.println("  ID Cliente: " + ultimoMedidor[3]);
        } else {
            System.out.println("\nNo hay datos de medidor.");
        }

        System.out.println("\nConsumo:");
        if (ultimoConsumo > 0) {
            System.out.println("  Consumo promedio por hora: " + ultimoConsumo + " kW/H");
            System.out.println("  Mes: " + ultimoMes);
            System.out.println("  Año: " + ultimoAnio);
            System.out.println("  Total factura: " + ultimoTotalFactura + " COP");
        } else {
            System.out.println("No hay datos de consumo.");
        }
        System.out.println("==============================\n");

        // Cierra el programa después de imprimir la factura
        System.exit(0);
    }

    // Método para iniciar el menú
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new menu().setVisible(true);
        });
    }
}