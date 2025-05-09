package com.model_controller.src.model;

import java.util.ArrayList;
import java.util.List;


public class ListaSimple {
    //Referencia al primer y ultimo nodo de la lista
    Nodo cabeza;
    Nodo ultimo; 
    private int numElem;
    
    //Constructor: inicializa la lista vacía
    public ListaSimple(){
        cabeza = null;
        ultimo = null;
    }    
    
    // Método para agregar un nuevo nodo a la lista creando un nuevo nodo con el objeto Cliente recibido
    public void inputNodo(Cliente cliente){
        Nodo nuevoNodo = new Nodo(cliente);

        // Si la lista está vacía o el nuevo cliente debe ir antes de la cabeza
        if (cabeza == null || cliente.getCedula() < cabeza.cliente.getCedula()) {
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
            // Si la lista estaba vacía, también actualiza 'ultimo'
            if (ultimo == null) {
                ultimo = nuevoNodo;
                }
        return;
        }

        // Recorremos la lista hasta encontrar el punto de inserción
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.cliente.getCedula() < cliente.getCedula()) {
            actual = actual.siguiente;
        }

        // Insertamos el nuevo nodo en su lugar
        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;

        // Si se insertó al final, actualizamos 'ultimo'
        if (nuevoNodo.siguiente == null) {
        ultimo = nuevoNodo;
        }
    }
    
    // Método para mostrar todos los datos de los clientes en la lista
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

    //funcion que retorna la cantidad de clientes
    public int getCantidadClientes() {
        return numElem;
    }
        
}
