package view;

import javax.swing.*;
import java.awt.*;
import model.Cliente;
import model.MedidorModelo;
import controller.ClienteControlador;
import controller.MedidorControlador;
import controller.FranjasControlador;

/**
 * Clase que representa el menú principal de la aplicación.
 * Permite navegar a diferentes secciones como Cliente, Registrador, Consumos e Imprimir Factura.
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas
 */


// Importaciones necesarias para la interfaz gráfica y el modelo de datos por herencia

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Cierra la aplicación al cerrar la ventana
        setSize(300, 400);// tamaño de la ventana
        setLocationRelativeTo(null);// centra la ventana en la pantalla

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));// ordena de manera vertical los botones
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));// agrega un borde vacío alrededor del panel

        JLabel lblTitulo = new JLabel("MENÚ");
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);// centra el título
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
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
        btnCliente.addActionListener(e -> abrirCliente());// cuando se presiona el botón Cliente, se abre la ventana de Cliente
        btnRegistrador.addActionListener(e -> abrirRegistrador());
        btnConsumos.addActionListener(e -> abrirConsumos());
        btnImprimirRecibo.addActionListener(e -> imprimirReciboYSalir());

        add(panel);
    }

    // Métodos para abrir las ventanas emergentes correspondientes a cada botón
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
        StringBuilder sb = new StringBuilder();
        sb.append("===== FACTURA DE SERVICIO =====\n");
        if (ultimoCliente != null) {
            sb.append("Cliente:\n");
            sb.append("  Nombre: ").append(ultimoCliente.getNombre()).append("\n");
            sb.append("  ID: ").append(ultimoCliente.getNumeroIdentificacion()).append("\n");
            sb.append("  Tipo ID: ").append(ultimoCliente.getTipoDeIdentificacion()).append("\n");
            sb.append("  Correo: ").append(ultimoCliente.getCorreo()).append("\n");
            sb.append("  Dirección: ").append(ultimoCliente.getDireccion()).append("\n");
        } else {
            sb.append("No hay datos de cliente.\n");
        }
            // sb.append sirve para agregar un texto a un StringBuilder
            // Un strungBuilder es una clase que permite construir cadenas de texto de manera eficiente

        if (ultimoMedidor != null) {
            sb.append("\nMedidor:\n");
            sb.append("  ID: ").append(ultimoMedidor[0]).append("\n");
            sb.append("  Dirección: ").append(ultimoMedidor[1]).append("\n");
            sb.append("  Ciudad: ").append(ultimoMedidor[2]).append("\n");
            sb.append("  ID Cliente: ").append(ultimoMedidor[3]).append("\n");
        } else {
            sb.append("\nNo hay datos de medidor.\n");
        }

        sb.append("\nConsumo:\n");
        if (ultimoConsumo > 0) {
            sb.append("  Consumo promedio por hora: ").append(ultimoConsumo).append(" kW/H\n");
            sb.append("  Mes: ").append(ultimoMes).append("\n");
            sb.append("  Año: ").append(ultimoAnio).append("\n");
            sb.append("  Total factura: ").append(ultimoTotalFactura).append(" COP\n");
        } else {
            sb.append("No hay datos de consumo.\n");
        }
        sb.append("==============================");

        JOptionPane.showMessageDialog(this, sb.toString(), "Factura de Servicio", JOptionPane.INFORMATION_MESSAGE);

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