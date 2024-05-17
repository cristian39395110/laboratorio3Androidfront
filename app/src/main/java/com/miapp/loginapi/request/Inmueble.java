package com.miapp.loginapi.request;


import java.io.Serializable;
import java.math.BigDecimal;

public class Inmueble implements Serializable {


    private Integer id;

    private Propietario propietario;

    private String direccion;

    private InmuebleTipos inmuebleTipo;

    private int cantidadAmbientes;
    private Boolean suspendido;
    private Boolean disponible;
    private BigDecimal precioBase;
    private String uso;

    private int foto;

    private String imagen;

    public String getFotobase() {
        return imagen;
    }

    public void setFotobase(String fotobase) {
        this.imagen = imagen;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
// Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public InmuebleTipos getInmuebleTipo() {
        return inmuebleTipo;
    }

    public void setInmuebleTipo(InmuebleTipos inmuebleTipo) {
        this.inmuebleTipo = inmuebleTipo;
    }

    public int getCantidadAmbientes() {
        return cantidadAmbientes;
    }

    public void setCantidadAmbientes(int cantidadAmbientes) {
        this.cantidadAmbientes = cantidadAmbientes;
    }

    public Boolean getSuspendido() {
        return suspendido;
    }

    public void setSuspendido(Boolean suspendido) {
        this.suspendido = suspendido;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "id=" + id +
                ", propietario=" + propietario +
                ", direccion='" + direccion + '\'' +
                ", inmuebleTipo=" + inmuebleTipo +
                ", cantidadAmbientes=" + cantidadAmbientes +
                ", suspendido=" + suspendido +
                ", disponible=" + disponible +
                ", precioBase=" + precioBase +
                ", uso='" + uso + '\'' +
                '}';
    }
}

