package ListaCliente;

import javax.swing.JOptionPane;

public class ListaSimple {
    //Referencia al primer y ultimo nodo de la lista
    Nodo cabeza;
    Nodo ultimo; 
    
    //Constructor: inicializa la lista vacía
    public ListaSimple(){
        cabeza = null;
        ultimo = null;
    }    
    
    // Método para agregar un nuevo nodo a la lista creando un nuevo nodo con el objeto Cliente recibido
    public void  inputNodo(Cliente cliente){
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
    public void verList(){
        Nodo actual = cabeza; //Comenzamos desde la cabeza
        StringBuilder listaClientes = new StringBuilder(); // Usamos StringBuilder para concatenar los datos

        // Mientras no lleguemos al final de la lista
        while (actual != null) {
            listaClientes.append("Cliente: ").append(actual.cliente.ShowData()).append("\n");
            actual = actual.siguiente;
        }
    
        // Mostramos todos los clientes en un solo JOptionPane
        if (listaClientes.length() > 0) {
            JOptionPane.showMessageDialog(null, listaClientes.toString(), "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes en la lista.", "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

        
}
   
   


    

