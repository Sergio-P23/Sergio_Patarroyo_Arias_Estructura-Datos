package com.listadoble.cliente.controller;

import com.listadoble.cliente.model.Cliente;
import com.listadoble.cliente.model.ListaDoble;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
     private final ListaDoble lista = new ListaDoble();

    @PostMapping("/tu-endpoint-insertar")
    public String insertar(@RequestBody Cliente cliente) {
        lista.insertar(cliente);
        return "{\"mensaje\":\"Cliente insertado correctamente\"}";
    }

    @GetMapping("/tu-endpoint-listar")
    public List<Cliente> listar(@RequestParam String direccion) {
        if (direccion.equals("izquierda")) {
            return lista.getClientesReversa();
        } else if (direccion.equals("derecha")) {
            return lista.getClientes();
        } else {
            throw new IllegalArgumentException("Dirección no válida: " + direccion);
        }
    }   
}
