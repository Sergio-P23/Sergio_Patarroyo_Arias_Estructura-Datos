package com.circular_lista.back_client.model;

import java.util.ArrayList;
import java.util.List;

public class ListaCircular {
    private Nodo Inicio = null;

    public void insertarCliente(Cliente cliente) {
        Nodo nuevo = new Nodo(cliente);

        // Si la lista está vacía
        if (Inicio == null) {
            nuevo.siguiente = nuevo;
            Inicio = nuevo;
            return;
        }

        Nodo actual = Inicio;
        Nodo anterior = Inicio; // Inicializamos `anterior` como `Inicio` para evitar null pointer

        // Caso especial: Insertar antes del primer nodo (cuando la cédula es menor que
        // la del primer cliente)
        if (cliente.getCedula() < Inicio.siguiente.cliente.getCedula()) {
            // Encontrar el último nodo para actualizar su referencia
            while (actual.siguiente != Inicio.siguiente) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = Inicio.siguiente;
            actual.siguiente = nuevo;
            Inicio.siguiente = nuevo;
            return;
        }

        // Recorrer la lista para encontrar la posición correcta
        do {
            anterior = actual;
            actual = actual.siguiente;

            if (cliente.getCedula() < actual.cliente.getCedula()) {
                break;
            }
        } while (actual != Inicio.siguiente);

        // Insertar el nuevo nodo en la posición encontrada
        nuevo.siguiente = actual;
        anterior.siguiente = nuevo;

        // Si el nuevo nodo es mayor que todos, actualizar el inicio
        if (actual == Inicio.siguiente && cliente.getCedula() > Inicio.cliente.getCedula()) {
            Inicio = nuevo;
        }
    }

    // Este método fue reemplazado
    public List<Cliente> listarClientesComoLista() {
        List<Cliente> clientes = new ArrayList<>();
        if (Inicio == null)
            return clientes;

        Nodo aux = Inicio.siguiente;
        do {
            clientes.add(aux.cliente);
            aux = aux.siguiente;
        } while (aux != Inicio.siguiente);

        return clientes;
    }

    public boolean estaVacia() {
        return Inicio == null;
    }

    public Cliente getPrimerCliente() {
        return Inicio != null ? Inicio.siguiente.cliente : null;
    }

    public Cliente getUltimoCliente() {
        return Inicio != null ? Inicio.cliente : null;
    }

    public String getSiguienteDe(Cliente cliente) {
        if (Inicio == null)
            return "null";

        Nodo aux = Inicio.siguiente;
        do {
            if (aux.cliente.getCedula() == cliente.getCedula()) {
                return aux.siguiente.cliente.getNombre();
            }
            aux = aux.siguiente;
        } while (aux != Inicio.siguiente);

        return "desconocido";
    }

}
