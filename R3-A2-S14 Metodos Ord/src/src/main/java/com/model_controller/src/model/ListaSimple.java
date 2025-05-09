package com.model_controller.src.model;

import java.util.ArrayList;
import java.util.List;

public class ListaSimple {
    // Referencia al primer y último nodo de la lista
    Nodo cabeza;
    Nodo ultimo; 
    private int numElem;

    // Lista auxiliar para mantener el orden original
    private final List<Cliente> listaOriginal = new ArrayList<>();

    // Constructor: inicializa la lista vacía
    public ListaSimple() {
        cabeza = null;
        ultimo = null;
        numElem = 0;
    }    

    // Método para agregar un nuevo nodo a la lista
    public void inputNodo(Cliente cliente) {
        Nodo nuevoNodo = new Nodo(cliente);

        // Si la lista está vacía, el nuevo nodo será la cabeza y el último
        if (cabeza == null) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            // Si la lista no está vacía, agregamos el nuevo nodo al final
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }

        // Agregamos el cliente a la lista auxiliar
        listaOriginal.add(cliente);

        // Incrementamos el contador de elementos
        numElem++;
    }

    // Método para ordenar los clientes usando el algoritmo Bubble Sort
    public List<Cliente> bubbleSort() {
        if (cabeza == null || cabeza.siguiente == null) {
            // Si la lista está vacía o tiene un solo elemento, no hay nada que ordenar
            return getClientes();
        }

        boolean huboIntercambio;
        do {
            Nodo actual = cabeza;
            Nodo siguiente = cabeza.siguiente;
            huboIntercambio = false;

            while (siguiente != null) {
                // Comparamos los clientes por cédula
                if (actual.cliente.getCedula() > siguiente.cliente.getCedula()) {
                    // Intercambiamos los datos de los nodos
                    Cliente temp = actual.cliente;
                    actual.cliente = siguiente.cliente;
                    siguiente.cliente = temp;
                    huboIntercambio = true;
                }

                // Avanzamos al siguiente par de nodos
                actual = siguiente;
                siguiente = siguiente.siguiente;
            }
        } while (huboIntercambio); // Repetimos mientras haya intercambios

        // Devolvemos la lista ordenada
        return getClientes();
    }

    // Método para mostrar todos los datos de los clientes en la lista
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Nodo actual = cabeza;

        while (actual != null) {
            clientes.add(actual.cliente);
            actual = actual.siguiente;
        }
        return clientes;
    }

    // Método para obtener los clientes en el orden original de inserción
    public List<Cliente> getClientesOriginal() {
        return new ArrayList<>(listaOriginal); // Retornamos una copia de la lista original
    }

    // Método que retorna la cantidad de clientes
    public int getCantidadClientes() {
        return numElem;
    }
}