package com.listadoble.cliente.model;

import java.util.ArrayList;
import java.util.List;

public class ListaDoble {
    //atributos
    private Nodo cabeza;
    private Nodo ultimo;
    private int numElem;

    //inicializa la lista vacia
    public ListaDoble(){
        cabeza = null;
        ultimo = null;
        numElem = 0;
    }

    //metodo insertar
    public void insertar(Cliente cliente){
        //crea un nuevo nodo con el cliente
        Nodo nuevoNodo = new Nodo(cliente);

        //si es el primer cliente
        if (cabeza == null) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
            numElem++;
            return;
        }

        //si la C.C. cliente es menor que el primero
        if (cliente.getCedula() < cabeza.cliente.getCedula()) {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
            numElem++;
            return;
        }

        //si la C.C. no va de primeras buscamos la posicion correcta
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.cliente.getCedula() < cliente.getCedula()) {
            actual = actual.siguiente;
        }
        //se detiene el while e insertamos el nuevo nodo
        nuevoNodo.siguiente = actual.siguiente;
        nuevoNodo.anterior = actual;
        actual.siguiente = nuevoNodo;

        //si el nuevo nodo no resulta ser el ultimo nodo y si si pues se actualiza el ultimo
        if (nuevoNodo.siguiente != null) {
            nuevoNodo.siguiente.anterior = nuevoNodo;
        } else {
            ultimo = nuevoNodo;
        }

        numElem++;
    }

    //funcion que retorna la lista de clientes de izquierda a derecha
    public List<Cliente> getClientesDer() {
        List<Cliente> clientes = new ArrayList<>();
        Nodo actual = cabeza;

        while (actual != null) {
            clientes.add(actual.cliente);
            actual = actual.siguiente;
        }
        return clientes;
    }

    //funcion que retorna la lista de clientes de derecha a izquierda
    public List<Cliente> getClientesIzq() {
        List<Cliente> clientes = new ArrayList<>();
        Nodo actual = ultimo;

        while (actual != null) {
            clientes.add(actual.cliente);
            actual = actual.anterior;
        }
        return clientes;
    }

    //funcion que retorna la cantidad de clientes
    public int getCantidadClientes() {
        return numElem;
    }
}
