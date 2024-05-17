package com.miapp.loginapi.request;

import java.io.Serializable;

public class Propietario implements Serializable {

    private int id;
    private String nombre ;
    private String apellido;

    private String  dni;
    private String clave ;


    private String telefono ;
    private String email ;
    private String domicilio ;

    public Propietario() {

    }

    public Propietario(int id, String nombre, String apellido, String DNI, String clave, String telefono, String email,String domicilio) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = DNI;
        this.clave = clave;
        this.telefono = telefono;
        this.email = email;
        this.domicilio = domicilio;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        apellido = apellido;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String DNI) {
        this.dni = DNI;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "Id=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", DNI='" + dni + '\'' +
                ", Clave='" + clave + '\'' +
                ", Telefono='" + telefono + '\'' +
                ", Email='" + email + '\'' +
                ", Domicilio='" + domicilio + '\'' +
                '}';
    }
}
