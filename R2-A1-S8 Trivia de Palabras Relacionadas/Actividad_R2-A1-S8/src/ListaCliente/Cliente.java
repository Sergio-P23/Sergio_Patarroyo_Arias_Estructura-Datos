package ListaCliente;

public class Cliente {
    //establecer atributos
    private int cedula;
    private String name;
    
    //crear constructor
    public Cliente(int cedula, String name) {
        this.cedula = cedula;
        this.name = name;
    }
    //estableciendo setters
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public void setName(String name) {
        this.name = name;
    }
    //estableciendo getters
    public int getCedula() {
        return cedula;
    }
    public String getName() {
        return name;
    }
    
    // Método para mostrar datos del cliente
    public String ShowData(){
        return "| Cedula: "+cedula+"  -  Nombre: "+name+" |";
    }
    
}
