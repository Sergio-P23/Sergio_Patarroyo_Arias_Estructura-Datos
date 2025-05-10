package com.circular_lista.back_client.controller;

import com.circular_lista.back_client.model.Cliente;
import com.circular_lista.back_client.model.ListaCircular;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControllerClient {

    private final ListaCircular lista = new ListaCircular();

    @PostMapping("/endpoint-insertar")
    public String insertar(@RequestBody Cliente cliente) {
        lista.insertarCliente(cliente);
        return "{\"mensaje\":\"Cliente insertado correctamente\"}";
    }

    @GetMapping("/endpoint-listarCircular")
    public Map<String, Object> listarCircular() {
        List<Cliente> clientes = lista.listarClientesComoLista();
        Map<String, Object> respuesta = new HashMap<>();

        respuesta.put("clientes", clientes);
        if (!clientes.isEmpty()) {
            Cliente primero = lista.getPrimerCliente();
            Cliente ultimo = lista.getUltimoCliente();

            Map<String, String> explicacion = new HashMap<>();
            explicacion.put("metodo",
                    "Se usa una lista circular que permite recorrer desde cualquier nodo sin perder el inicio.");
            String nombreSiguientePrimerNodo = lista.getPrimerCliente() != null
                    && lista.getPrimerCliente().getNombre() != null
                            ? lista.getSiguienteDe(lista.getPrimerCliente())
                            : "null";

            String nombreSiguienteUltimoNodo = lista.getUltimoCliente() != null
                    && lista.getUltimoCliente().getNombre() != null
                            ? lista.getSiguienteDe(lista.getUltimoCliente())
                            : "null";

            explicacion.put("primerNodo", primero.getNombre() + " (siguiente = " + nombreSiguientePrimerNodo + ")");
            explicacion.put("ultimoNodo", ultimo.getNombre() + " (siguiente = " + nombreSiguienteUltimoNodo + ")");
            respuesta.put("explicacion", explicacion);
        }

        return respuesta;
    }
}