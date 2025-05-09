package com.model_controller.src.controller;
//importamos clases que necesitamos
import com.model_controller.src.model.Cliente;
import com.model_controller.src.model.ListaSimple;
import java.util.List;
//notaciones Spring para manejar solicitudes http
import org.springframework.web.bind.annotation.*;


@RestController 
public class ClienteController{
    
    //inicializamos la lista doble
     private final ListaSimple lista = new ListaSimple();

    //se ejecuta cuando se hace una peticion POST a la URL /endpoint-insertar
    @PostMapping("/endpoint-insertar")
    //funcion insertar que recibe un cliente en el cuerpo de la peticion y retorna un mensaje
    public String insertar(@RequestBody Cliente cliente) {
        lista.inputNodo(cliente);
        //string en formato JSON
        return "{\"mensaje\":\"Cliente insertado correctamente\"}";
    }

    //se ejecuta cuando se hace una peticion GET a la URL /tu-endpoint-listar
    @GetMapping("/endpoint-listarDer")
    //funcion listar que recibe un parametro de consulta "direccion" y retorna una lista de clientes
    public List<Cliente> listar() {
        return lista.getClientesDer();
    }   
}
