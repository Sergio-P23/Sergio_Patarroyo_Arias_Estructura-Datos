package com.listadoble.cliente.controller;

//importamos clases que necesitamos
import com.listadoble.cliente.model.Cliente;
import com.listadoble.cliente.model.ListaDoble;
import java.util.List;
//notaciones Spring para manejar solicitudes http
import org.springframework.web.bind.annotation.*;

//notacion que indica que esta clase es un controlador REST
@RestController
public class ClienteController {
    //inicializamos la lista doble
     private final ListaDoble lista = new ListaDoble();

    //se ejecuta cuando se hace una peticion POST a la URL /endpoint-insertar
    @PostMapping("/endpoint-insertar")
    //funcion insertar que recibe un cliente en el cuerpo de la peticion y retorna un mensaje
    public String insertar(@RequestBody Cliente cliente) {
        lista.insertar(cliente);
        //string en formato JSON
        return "{\"mensaje\":\"Cliente insertado correctamente\"}";
    }

    //se ejecuta cuando se hace una peticion GET a la URL /tu-endpoint-listar
    @GetMapping("/endpoint-listar")
    //funcion listar que recibe un parametro de consulta "direccion" y retorna una lista de clientes
    public List<Cliente> listar(@RequestParam String direccion) {
        if (direccion.equals("izquierda")) {
            return lista.getClientesIzq();
        } else if (direccion.equals("derecha")) {
            return lista.getClientesDer();
        } else {
            throw new IllegalArgumentException("Dirección no válida: " + direccion);
        }
    }   
}
 