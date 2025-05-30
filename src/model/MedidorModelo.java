package model;

/**
 * Modelo que gestiona los medidores de luz.
 * Permite agregar, editar y consultar medidores.
 * 
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas
 */
public class MedidorModelo {
    private String[][] matrizMedidores;
    private int contador;

    public MedidorModelo(int tamañoMaximo) {
        matrizMedidores = new String[tamañoMaximo][4]; // ID, Dirección, Ciudad, ID Cliente
        contador = 0;
    }

    // Agrega un nuevo medidor con datos completos
    public boolean agregarMedidor(String id, String direccion, String ciudad, String idCliente) {
        if (contador < matrizMedidores.length) {
            matrizMedidores[contador][0] = id;
            matrizMedidores[contador][1] = direccion;
            matrizMedidores[contador][2] = ciudad;
            matrizMedidores[contador][3] = idCliente;
            contador++;
            return true;
        }
        return false;
    }

    // Edita los datos de un medidor (excepto el ID)
    public boolean editarMedidor(String id, String nuevaDireccion, String nuevaCiudad, String nuevoIdCliente) {
        for (int i = 0; i < contador; i++) {
            if (matrizMedidores[i][0].equals(id)) {
                matrizMedidores[i][1] = nuevaDireccion;
                matrizMedidores[i][2] = nuevaCiudad;
                matrizMedidores[i][3] = nuevoIdCliente;
                return true;
            }
        }
        return false;
    }

    // Devuelve la matriz de medidores registrados
    public String[][] obtenerTodosLosMedidores() {
        return matrizMedidores;
    }

    // Devuelve el total de medidores registrados
    public int getCantidadMedidores() {
        return contador;
    }
}