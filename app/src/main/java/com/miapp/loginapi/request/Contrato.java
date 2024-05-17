package com.miapp.loginapi.request;


import java.math.BigDecimal;
import java.time.LocalDate;

public class Contrato {

    private int id;

    private Inmueble inmueble;

    private Inquilino inquilino;

    private LocalDate fechaFin;

    private LocalDate fechaFinAnticipada;

    private BigDecimal precioXMes;
    private boolean estado;

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

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaFinAnticipada() {
        return fechaFinAnticipada;
    }

    public void setFechaFinAnticipada(LocalDate fechaFinAnticipada) {
        this.fechaFinAnticipada = fechaFinAnticipada;
    }

    public BigDecimal getPrecioXMes() {
        return precioXMes;
    }

    public void setPrecioXMes(BigDecimal precioXMes) {
        this.precioXMes = precioXMes;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
