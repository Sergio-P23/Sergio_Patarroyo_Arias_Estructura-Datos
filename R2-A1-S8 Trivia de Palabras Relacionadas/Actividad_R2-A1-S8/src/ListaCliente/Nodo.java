package ListaCliente;

public class Nodo {
   //Datos del cliente almacenados en este nodo
   Cliente cliente; 
   //Referencia al siguiente nodo
   Nodo siguiente;
   
   //se crea el constructor y se inicializa la referencia al siguiente nodo como null, indicando que aún no hay otro nodo enlazado
   public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }
}
