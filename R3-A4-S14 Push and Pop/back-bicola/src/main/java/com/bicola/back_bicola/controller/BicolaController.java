package com.bicola.back_bicola.controller;

import com.bicola.back_bicola.model.Bicola;
import com.bicola.back_bicola.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bicola")
@CrossOrigin(origins = "*")
public class BicolaController {

    private static final Bicola bicola = new Bicola();

    // Insertar cliente por la derecha
    @PostMapping("/insertar")
    public void insertar(@RequestBody Cliente cliente) {
        bicola.insertarDerecha(cliente);
    }

    // Insertar cliente por la izquierda
    @PostMapping("/insertarIzq")
    public void insertarIzq(@RequestBody Cliente cliente) {
        bicola.insertarIzquierda(cliente);
    }

    // Atender por la izquierda (cabeza)
    @DeleteMapping("/atenderIzq")
    public Cliente atenderIzq() {
        return bicola.atenderIzq();
    }

    // Atender por la derecha (último)
    @DeleteMapping("/atenderDer")
    public Cliente atenderDer() {
        return bicola.atenderDer();
    }

    // Listar todos los clientes (de cabeza a último)
    @GetMapping("/listar")
    public List<Cliente> listar() {
        return bicola.listar();
    }

    // Obtener cantidad de clientes
    @GetMapping("/cantidad")
    public int cantidad() {
        return bicola.getCantidadClientes();
    }
}