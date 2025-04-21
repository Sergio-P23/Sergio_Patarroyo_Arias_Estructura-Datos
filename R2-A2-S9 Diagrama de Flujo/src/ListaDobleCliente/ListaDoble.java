package ListaDobleCliente;

import javax.swing.JOptionPane;

public class ListaDoble {
    Nodo cabeza;
    Nodo ultimo;
    int numElem;

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

        // Evita insertar duplicados si quieres
        // if (actual.cliente.getCedula() == cliente.getCedula()) return;

        nuevoNodo.siguiente = actual.siguiente;
        nuevoNodo.anterior = actual;
        actual.siguiente = nuevoNodo;

        if (nuevoNodo.siguiente != null) {
            nuevoNodo.siguiente.anterior = nuevoNodo;
        } else {
            // Se insertó al final
            ultimo = nuevoNodo;
        }

        numElem++; // ¡Asegúrate de contar el nuevo nodo!
    }

    public void ListLeft(){
        Nodo actual = cabeza;
        StringBuilder listaClientes = new StringBuilder();

        while (actual != null) {
            listaClientes.append("Cliente: ").append(actual.cliente.ShowData()).append("\n");
            actual = actual.siguiente;
        }

        JOptionPane.showMessageDialog(null,
            listaClientes.length() > 0 ? listaClientes.toString() : "No hay clientes en la lista.",
            "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
    }

    public void ListRight(){
        Nodo actual = ultimo;
        StringBuilder listaClientes = new StringBuilder();

        while (actual != null) {
            listaClientes.append("Cliente: ").append(actual.cliente.ShowData()).append("\n");
            actual = actual.anterior;
        }

        JOptionPane.showMessageDialog(null,
            listaClientes.length() > 0 ? listaClientes.toString() : "No hay clientes en la lista.",
            "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
    }
}
