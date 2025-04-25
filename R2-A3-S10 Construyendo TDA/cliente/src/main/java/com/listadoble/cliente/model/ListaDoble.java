package com.listadoble.cliente.model;

import java.util.ArrayList;
import java.util.List;

public class ListaDoble {
    private Nodo cabeza;
    private Nodo ultimo;
    private int numElem;

    public ListaDoble(){
        cabeza = null;
        ultimo = null;
        numElem = 0;
    }

    public void insertar(Cliente cliente){
        Nodo nuevoNodo = new Nodo(cliente);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
            numElem++;
            return;
        }

        if (cliente.getCedula() < cabeza.cliente.getCedula()) {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
            numElem++;
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null && actual.siguiente.cliente.getCedula() < cliente.getCedula()) {
            actual = actual.siguiente;
        }

        nuevoNodo.siguiente = actual.siguiente;
        nuevoNodo.anterior = actual;
        actual.siguiente = nuevoNodo;

        if (nuevoNodo.siguiente != null) {
            nuevoNodo.siguiente.anterior = nuevoNodo;
        } else {
            ultimo = nuevoNodo;
        }

        numElem++;
    }

    // 🔄 Devuelve la lista de clientes de izquierda a derecha
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Nodo actual = cabeza;

        while (actual != null) {
            clientes.add(actual.cliente);
            actual = actual.siguiente;
        }

        return clientes;
    }

    // 🔄 Devuelve la lista de clientes de derecha a izquierda (opcional)
    public List<Cliente> getClientesReversa() {
        List<Cliente> clientes = new ArrayList<>();
        Nodo actual = ultimo;

        while (actual != null) {
            clientes.add(actual.cliente);
            actual = actual.anterior;
        }

        return clientes;
    }

    public int getCantidadClientes() {
        return numElem;
    }
}
