package com.miapp.loginapi.request;

import java.util.List;

public class Inquilino {
    private int Id ;
    private String DNI;
    private String Nombre ;
    private String Apellido ;
    private String Telefono;

    private String Email;
    private String Domicilio;
    private List<Contrato> ListaContratos;

    public Inquilino() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String domicilio) {
        Domicilio = domicilio;
    }

    public List<Contrato> getListaContratos() {
        return ListaContratos;
    }

    public void setListaContratos(List<Contrato> listaContratos) {
        ListaContratos = listaContratos;
    }

    @Override
    public String toString() {
        return "Inquilino{" +
                "Id=" + Id +
                ", DNI='" + DNI + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Email='" + Email + '\'' +
                ", Domicilio='" + Domicilio + '\'' +
                ", ListaContratos=" + ListaContratos +
                '}';
    }
}
