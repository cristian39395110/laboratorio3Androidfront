package com.miapp.loginapi.request;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Contrato implements Serializable {

    private int id;

    private Inmueble inmueble;

    private Inquilino inquilino;

    private String fechaFin;



    private BigDecimal precioXmes;
    private boolean estado;
    private String fechaInicio;
    private String fechaFinAnticipada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPrecioXmes() {
        return precioXmes;
    }

    public void setPrecioXmes(BigDecimal precioXmes) {
        this.precioXmes = precioXmes;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinAnticipada() {
        return fechaFinAnticipada;
    }

    public void setFechaFinAnticipada(String fechaFinAnticipada) {
        this.fechaFinAnticipada = fechaFinAnticipada;
    }

}