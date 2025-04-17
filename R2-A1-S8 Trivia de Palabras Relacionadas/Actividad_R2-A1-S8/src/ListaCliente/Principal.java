package ListaCliente;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        // Se crea una lista enlazada simple para almacenar los clientes
        ListaSimple ls = new ListaSimple();
        
        // Variables auxiliares
        int opc;
        int cedula;
        String name;
        do{
         // Mostrar menú al usuario
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema de gestión de clientes", "Sistema de Clientes", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una opción del menú\\n"+
                                            "1. Insertar cliente\n2. Listar clientes hacia la derecha\\n"+ 
                                            "3. Salir","Sistema de Clientes", JOptionPane.INFORMATION_MESSAGE);
            opc = sc.nextInt();
            sc.nextLine();

            switch(opc) {
                case 1:
                    // Insertar cliente
                    System.out.print("Ingrese la cédula: ");
                    cedula = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    name = sc.nextLine();

                    // Crear objeto Cliente con los datos ingresados
                    Cliente nuevo = new Cliente(cedula, name);
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

        sc.close(); // Cerrar el escáner al final
    }
}
