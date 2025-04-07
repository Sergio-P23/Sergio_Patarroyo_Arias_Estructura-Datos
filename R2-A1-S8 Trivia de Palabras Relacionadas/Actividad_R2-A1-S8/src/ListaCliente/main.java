package ListaCliente;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Se crea una lista enlazada simple para almacenar los clientes
        ListaSimple ls = new ListaSimple();
        
        // Variables auxiliares
        int opc;
        int cedula;
        String name;
        do{
         // Mostrar menú al usuario
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Insertar cliente");
            System.out.println("2. Listar clientes hacia la derecha");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch(opc) {
                case 1:
                    // Insertar cliente
                    System.out.print("Ingrese la cédula: ");
                    cedula = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.nextLine();

                    // Crear objeto Cliente con los datos ingresados
                    Cliente nuevo = new Cliente(cedula, nombre);
                     // Insertar el cliente en la lista
                    ls.inputNodo(nuevo);
                    System.out.println("Cliente insertado correctamente.");
                    break;
                    
                case 2:
                    // Mostrar lista llamando al metodo
                    ls.verList();
                    break;
                    
                case 3:
                    // Salir del programa
                    System.out.println("Gracias por usar el sistema.");
                    break;
                    
                default:
                    System.out.println("Opción inexistente. Intente de nuevo.");
            }
        }while(opc != 3); 
    }
}
