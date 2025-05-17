package com.bicola.back_bicola.model;

import java.util.ArrayList;
import java.util.List;

public class Bicola {
    private Nodo cabeza;
    private Nodo ultimo;
    private int numElem;

    public Bicola() {
        cabeza = null;
        ultimo = null;
        numElem = 0;
    }

         cabeza = null;
        ultimo = null;
        numElem = 0;
    }

    // Insertar por la izquierda (frente)
    public void insertarIzquierda(Cliente cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (cabeza == null) {
            cabeza = ultimo = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        numElem++;
    }

    // Insertar por la derecha (final)
    public void insertarDerecha(Cliente cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (ultimo == null) {
            cabeza = ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        numElem++;
    }


    // Atender por la izquierda (cabeza)
    public Cliente atenderIzq() {
        if (cabeza == null) return null;
        Cliente cliente = cabeza.cliente;
        cabeza = cabeza.siguiente;
        if (cabeza != null) {
            cabeza.anterior = null;
        } else {
            ultimo = null; // La lista quedó vacía
        }
        numElem--;
        return cliente;
    }

    // Atender por la derecha (ultimo)
    public Cliente atenderDer() {
        if (ultimo == null) return null;
        Cliente cliente = ultimo.cliente;
        ultimo = ultimo.anterior;
        if (ultimo != null) {
            ultimo.siguiente = null;
        } else {
            cabeza = null; // La lista quedó vacía
        }
        numElem--;
        return cliente;
    }

    // Listar
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            clientes.add(actual.cliente);
            actual = actual.siguiente;
        }
        return clientes;
    }

    public int getCantidadClientes() {
        return numElem;
    }
}