package ListaDobleCliente;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        ListaDoble ls = new ListaDoble();

        int opc = 0;
        do {
            try {
                opc = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Menú:\n1. Insertar cliente\n2. Listar clientes hacia la derecha\n" + 
                    "3. Listar clientes hacia la izquierda\n4. Salir\n\nSeleccione una opción:"));

                switch (opc) {
                    case 1:
                        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del cliente:"));
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                        Cliente nuevo = new Cliente(nombre, cedula);
                        ls.insertar(nuevo);
                        JOptionPane.showMessageDialog(null, "Cliente insertado correctamente.");
                        break;

                    case 2:
                        ls.ListLeft(); // Mostrar de izquierda a derecha
                        break;

                    case 3:
                        ls.ListRight(); // Mostrar de derecha a izquierda
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                        break;
                        

                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        } while (opc != 4);
    }
}
