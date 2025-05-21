package model;


public class MedidorModelo {
    private String[][] matrizMedidores;
    private int contador;

    public MedidorModelo(int tamañoMaximo) {
        matrizMedidores = new String[tamañoMaximo][5]; // ID, Dirección, Ciudad, ID Cliente, Consumo
        contador = 0;
    }

    // Agrega un nuevo medidor con datos completos, incluyendo consumo inicial
    public boolean agregarMedidor(String id, String direccion, String ciudad, String idCliente, String consumo) {
        if (contador < matrizMedidores.length) {
            matrizMedidores[contador][0] = id;
            matrizMedidores[contador][1] = direccion;
            matrizMedidores[contador][2] = ciudad;
            matrizMedidores[contador][3] = idCliente;
            matrizMedidores[contador][4] = consumo;
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

    // Actualiza el consumo por ID de cliente
    public boolean actualizarConsumoPorCliente(String idCliente, String nuevoConsumo) {
        for (int i = 0; i < contador; i++) {
            if (matrizMedidores[i][3].equals(idCliente)) {
                matrizMedidores[i][4] = nuevoConsumo;
                return true;
            }
        }
        return false;
    }

    // Obtiene el consumo por ID de cliente
    public String obtenerConsumoPorCliente(String idCliente) {
        for (int i = 0; i < contador; i++) {
            if (matrizMedidores[i][3].equals(idCliente)) {
                return matrizMedidores[i][4];
            }
        }
        return null;
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

