package ListaCliente;

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
        Nodo newNodo = new Nodo(cliente);        
        
        
        //Si la lista está vacía, el nuevo nodo es la cabeza y también el último
        if (cabeza == null){    
            cabeza = newNodo; // El nuevo nodo se convierte en la cabeza
            cabeza.siguiente = null;// Su siguiente es null porque es el único nodo
            ultimo = cabeza; // También es el último de la lista (por ahora)
        }
        // Si ya hay nodos, agregamos el nuevo al final
        else{
        ultimo.siguiente = newNodo; // El nodo actual al final apunta al nuevo
        newNodo.siguiente = null;// El nuevo nodo no apunta a nadie (es el último)
        ultimo = newNodo; // El nuevo nodo ahora es el último de la lista
        }
        
    }
    // Método para mostrar todos los datos de los clientes en la lista
    public void verList(){
        Nodo actual = cabeza; //Comenzamos desde la cabeza
        // Mientras no lleguemos al final de la lista
        while (actual != null) {
        System.out.println(actual.cliente.ShowData());
        actual = actual.siguiente;
    }

        
    }
   
   
}

    

