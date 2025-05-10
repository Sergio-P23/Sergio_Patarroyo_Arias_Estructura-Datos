package com.circular_lista.back_client.model;

public class ListaCircular {
   private Nodo Inicio = null; // apunta al ÚLTIMO nodo (el más reciente)
    
    public void insertarCliente(Cliente cliente) {
        Nodo nueva = new Nodo(cliente);

        if (Inicio == null) {
            // Primer nodo: apunta a sí mismo
            nueva.siguiente = nueva;
            Inicio = nueva;
        } else {
            nueva.siguiente = Inicio.siguiente; // nueva apunta al primero
            Inicio.siguiente = nueva;           // último apunta a nueva
            Inicio = nueva;                     // nueva se vuelve el último
        }
    }

    public String listarClientes() {
        if (Inicio == null) return "Lista vacía.";

        StringBuilder sb = new StringBuilder();
        Nodo aux = Inicio.siguiente; // comenzamos en el primer nodo lógico

        do {
            sb.append(aux.cliente.mostrarDatos()).append("\n");
            aux = aux.siguiente;
        } while (aux != Inicio.siguiente);

        return sb.toString();
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
}
   
   


    

