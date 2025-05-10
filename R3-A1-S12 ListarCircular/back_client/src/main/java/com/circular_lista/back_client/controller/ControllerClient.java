package com.circular_lista.back_client.controller;

import com.circular_lista.back_client.model.Cliente;
import com.circular_lista.back_client.model.ListaCircular;

//notaciones Spring para manejar solicitudes http
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerClient {

// inicializamos la lista doble
    private final ListaCircular lista = new ListaCircular();

    // se ejecuta cuando se hace una peticion POST a la URL /endpoint-insertar
    @PostMapping("/endpoint-insertar")
    // funcion insertar que recibe un cliente en el cuerpo de la peticion y retorna
    // un mensaje
    public String insertar(@RequestBody Cliente cliente) {
        lista.insertarCliente(cliente);
        // string en formato JSON
        return "{\"mensaje\":\"Cliente insertado correctamente\"}";
    }

     @GetMapping("/endpoint-listarCircular")
    public Map<String, Object> listarCircular() {
    List<Cliente> clientes = lista.listarClientes();
    Map<String, Object> respuesta = new HashMap<>();

    respuesta.put("clientes", clientes);
    if (!clientes.isEmpty()) {
        Cliente primero = lista.getPrimerCliente();
        Cliente ultimo = lista.getUltimoCliente();

        Map<String, String> explicacion = new HashMap<>();
        explicacion.put("metodo", "Se usa una lista circular que permite recorrer desde cualquier nodo sin perder el inicio.");
        explicacion.put("primerNodo", primero.getNombre() + " (Inicio.siguiente)");
        explicacion.put("ultimoNodo", ultimo.getNombre() + " (Inicio)");

        respuesta.put("explicacion", explicacion);
    }

    return respuesta;
