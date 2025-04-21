package ListaDobleCliente;

public class Nodo {
    //Atributos de la clase Nodo
    Cliente cliente; 
    Nodo siguiente; 
    Nodo anterior; 

    //Constructor de la clase Nodo
    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
        this.anterior = null;
    }
}
