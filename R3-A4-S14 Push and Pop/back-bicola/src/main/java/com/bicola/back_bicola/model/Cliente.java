package com.bicola.back_bicola.model;

public class Cliente {

    String nombre;
    int cedula;

    public Cliente(){}
    
    // Constructor de la clase Cliente
    public Cliente(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    //getters para los atributos
    public String getNombre() {
        return nombre;
    }
    public int getCedula() {
        return cedula;
    }

    //setters para los atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
}
