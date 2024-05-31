package com.miapp.loginapi.request;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pago implements Serializable {




    private int contratoId;
    private Contrato contrato ;
    private  int numeroPago;
    private  String fechaPago;
    private String Fecha;

    private BigDecimal importe;

    public Pago() {
    }

    public Pago(int contratoId, Contrato contrato, int numeroPago, String fechaPago, String fecha, BigDecimal importe) {
        this.contratoId = contratoId;
        this.contrato = contrato;
        this.numeroPago = numeroPago;
        this.fechaPago = fechaPago;
        Fecha = fecha;
        this.importe = importe;
    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public int getNumeroPago() {
        return numeroPago;
    }

    public void setNumeroPago(int numeroPago) {
        this.numeroPago = numeroPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
}
