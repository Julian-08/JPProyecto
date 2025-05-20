package model;

public class Cliente {
    private String nombre;
    private String numeroIdentificacion;
    private String tipoDeIdentificacion;
    private String correo;
    private String direccion;
    private Cliente[] matrizClientes;
    private int capacidadMaximaClientes;
    private int cantidadClientes;

    
    public Cliente(String nombre, String numeroIdentificacion, String tipoDeIdentificacion, String correo,
            String direccion, int capacidadMaximaClientes) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.correo = correo;
        this.direccion = direccion;
        this.capacidadMaximaClientes = capacidadMaximaClientes;
        this.matrizClientes = new Cliente[capacidadMaximaClientes];
        this.cantidadClientes = 0;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }


    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }


    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }


    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean crearCliente(Cliente cliente) {
        if (cantidadClientes < capacidadMaximaClientes) {
            matrizClientes[cantidadClientes] = cliente;
            cantidadClientes++;
            return true;
        } 
            return false;
        }
        
    public Cliente obtenerCliente(String idCliente) {
        for (int i = 0; i < cantidadClientes; i++) {
            if (matrizClientes[i].getNumeroIdentificacion().equals(idCliente)) {
                return matrizClientes[i];
            }
        }
        return null;
    }

    public boolean actualizarCliente(Cliente clienteActualizado) {
        for (int i = 0; i < matrizClientes.length; i++) {
            if (matrizClientes[i].getNumeroIdentificacion().equals(clienteActualizado.getNumeroIdentificacion())) {
                matrizClientes[i].setNombre(clienteActualizado.getNombre());
                matrizClientes[i].setDireccion(clienteActualizado.getDireccion());
                matrizClientes[i].setCorreo(clienteActualizado.getCorreo());
                matrizClientes[i].setTipoDeIdentificacion(clienteActualizado.getTipoDeIdentificacion());
                return true;
            }
        }
        return false;
    }
    public Cliente[] obtenerTodosClientes() {
        Cliente[] clientesActuales = new Cliente[cantidadClientes];
        System.arraycopy(matrizClientes, 0, clientesActuales, 0, cantidadClientes);
        return clientesActuales;
    }
    //Metodos similares para Registrador, consumo, etc. (con sus respectivas matrices)
}
