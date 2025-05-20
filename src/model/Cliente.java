package model;

/**
 * Clase que representa un cliente y gestiona una colección de clientes.
 * @author Cesar Cardozo
 * @author Julian Barreto
 * @author Santiago Cabezas  
 */
public class Cliente {
    /** Nombre del cliente */
    private String nombre;
    /** Número de identificación del cliente */
    private String numeroIdentificacion;
    /** Tipo de identificación del cliente */
    private String tipoDeIdentificacion;
    /** Correo electrónico del cliente */
    private String correo;
    /** Dirección del cliente */
    private String direccion;
    /** Arreglo que almacena los clientes */
    private Cliente[] matrizClientes;
    /** Capacidad máxima de clientes que se pueden almacenar */
    private int capacidadMaximaClientes;
    /** Cantidad actual de clientes almacenados */
    private int cantidadClientes;

    /**
     * Constructor de la clase Cliente.
     * 
     * @param nombre Nombre del cliente
     * @param numeroIdentificacion Número de identificación
     * @param tipoDeIdentificacion Tipo de identificación
     * @param correo Correo electrónico
     * @param direccion Dirección
     * @param capacidadMaximaClientes Capacidad máxima de clientes
     * @param i Parámetro no utilizado
     * @param j Parámetro no utilizado
     */
    public Cliente(String nombre, String numeroIdentificacion, String tipoDeIdentificacion, String correo,
            String direccion, int capacidadMaximaClientes, int i, int j) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.correo = correo;
        this.direccion = direccion;
        this.capacidadMaximaClientes = capacidadMaximaClientes;
        this.matrizClientes = new Cliente[capacidadMaximaClientes];
        this.cantidadClientes = 0;
    }

    /** @return el nombre del cliente */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre el nuevo nombre del cliente */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return el número de identificación del cliente */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /** @param numeroIdentificacion el nuevo número de identificación */
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    /** @return el tipo de identificación del cliente */
    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    /** @param tipoDeIdentificacion el nuevo tipo de identificación */
    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }

    /** @return el correo electrónico del cliente */
    public String getCorreo() {
        return correo;
    }

    /** @param correo el nuevo correo electrónico */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /** @return la dirección del cliente */
    public String getDireccion() {
        return direccion;
    }

    /** @param direccion la nueva dirección */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Crea un nuevo cliente y lo agrega al arreglo si hay espacio disponible.
     * 
     * @param cliente El cliente a agregar
     * @return true si se agregó correctamente, false si no hay espacio
     */
    public boolean crearCliente(Cliente cliente) {
        if (cantidadClientes < capacidadMaximaClientes) {
            matrizClientes[cantidadClientes] = cliente;
            cantidadClientes++;
            return true;
        } 
        return false;
    }

    /**
     * Busca y retorna un cliente por su número de identificación.
     * 
     * @param idCliente Número de identificación a buscar
     * @return El cliente encontrado o null si no existe
     */
    public Cliente obtenerCliente(String idCliente) {
        for (int i = 0; i < cantidadClientes; i++) {
            if (matrizClientes[i].getNumeroIdentificacion().equals(idCliente)) {
                return matrizClientes[i];
            }
        }
        return null;
    }

    /**
     * Actualiza los datos de un cliente existente.
     * 
     * @param clienteActualizado Cliente con los datos actualizados
     * @return true si se actualizó correctamente, false si no se encontró
     */
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

    /**
     * Obtiene un arreglo con todos los clientes almacenados actualmente.
     * 
     * @return Arreglo de clientes actuales
     */
    public Cliente[] obtenerTodosClientes() {
        Cliente[] clientesActuales = new Cliente[cantidadClientes];
        System.arraycopy(matrizClientes, 0, clientesActuales, 0, cantidadClientes);
        return clientesActuales;
    }
}