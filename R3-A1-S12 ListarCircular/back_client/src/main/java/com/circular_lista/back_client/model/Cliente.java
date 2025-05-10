package com.circular_lista.back_client.model;

public class Cliente {
    //establecer atributos
    private int cedula;
    private String nombre;

    public Cliente() {} 
    
    //crear constructor
    public Cliente(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    //estableciendo setters
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //estableciendo getters
    public int getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }

}
