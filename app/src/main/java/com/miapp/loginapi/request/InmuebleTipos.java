package com.miapp.loginapi.request;


public class InmuebleTipos {

    private int id;
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "tablaexternaInmueble: " + id + ", Tipotablaexternainmueble: " + tipo;
    }
}
