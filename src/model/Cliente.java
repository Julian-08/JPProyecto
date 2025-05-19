package model;

public class Cliente {
    private String nombre;
    private String numeroIdentificacion;
    private String tipoDeIdentificacion;
    private String correo;
    private String direccion;

    
    public Cliente(String nombre, String numeroIdentificacion, String tipoDeIdentificacion, String correo,
            String direccion) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.correo = correo;
        this.direccion = direccion;
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

    
}
