package com.miapp.loginapi.request;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

public class Inmueble implements Serializable {


    private Integer id;

    private Propietario propietario;

    private String direccion;

    private String inmuebleTipoId;

    private int cantidadAmbientes;
    private Boolean suspendido;
    private Boolean disponible;
    private BigDecimal precioBase;
    private String uso;
    private byte[] pumba;



    private int foto;

    private String imagen;
    private String imagenBase64;

    public String getImagenBase64() {
        return imagenBase64;
    }

    public void setImagenBase64(String imagenBase64) {
        this.imagenBase64 = imagenBase64;
    }

    public Inmueble( ) {

    }

    public Inmueble(Propietario propietario, String direccion, String inmuebleTipoId, int cantidadAmbientes, Boolean suspendido, Boolean disponible, BigDecimal precioBase, String uso) {
        this.propietario = propietario;
        this.direccion = direccion;
        this.inmuebleTipoId = inmuebleTipoId;
        this.cantidadAmbientes = cantidadAmbientes;
        this.suspendido = suspendido;
        this.disponible = disponible;
        this.precioBase = precioBase;
        this.uso = uso;

    }
    public Inmueble(  String direccion, String inmuebleTipoId, int cantidadAmbientes, Boolean disponible, BigDecimal precioBase, String uso) {

        this.direccion = direccion;
        this.inmuebleTipoId = inmuebleTipoId;
        this.cantidadAmbientes = cantidadAmbientes;
        this.disponible = disponible;
        this.precioBase = precioBase;
        this.uso = uso;

    }

    public byte[] getPumba() {
        return pumba;
    }

    public void setPumba(byte[] pumba) {
        this.pumba = pumba;
    }

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

    public String getInmuebleTipo() {
        return inmuebleTipoId;
    }

    public void setInmuebleTipo(String inmuebleTipoId) {
        this.inmuebleTipoId = inmuebleTipoId;
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
                ", inmuebleTipoId='" + inmuebleTipoId + '\'' +
                ", cantidadAmbientes=" + cantidadAmbientes +
                ", suspendido=" + suspendido +
                ", disponible=" + disponible +
                ", precioBase=" + precioBase +
                ", uso='" + uso + '\'' +
                ", pumba=" + Arrays.toString(pumba) +
                '}';
    }


}

