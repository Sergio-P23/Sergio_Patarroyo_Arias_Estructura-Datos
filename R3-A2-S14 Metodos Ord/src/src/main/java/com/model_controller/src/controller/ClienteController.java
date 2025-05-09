package com.model_controller.src.controller;

//importamos clases que necesitamos
import com.model_controller.src.model.Cliente;
import com.model_controller.src.model.ListaSimple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//notaciones Spring para manejar solicitudes http
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ClienteController {

    // inicializamos la lista doble
    private final ListaSimple lista = new ListaSimple();

    // se ejecuta cuando se hace una peticion POST a la URL /endpoint-insertar
    @PostMapping("/endpoint-insertar")
    // funcion insertar que recibe un cliente en el cuerpo de la peticion y retorna
    // un mensaje
    public String insertar(@RequestBody Cliente cliente) {
        lista.inputNodo(cliente);
        // string en formato JSON
        return "{\"mensaje\":\"Cliente insertado correctamente\"}";
    }

    // se ejecuta cuando se hace una peticion GET a la URL /tu-endpoint-listar
    @GetMapping("/endpoint-listarOriginal")
    // funcion listar que recibe un parametro de consulta "direccion" y retorna una
    // lista de clientes
    public List<Cliente> listarOriginal() {
        return lista.getClientesOriginal();
    }

    @GetMapping("/endpoint-bubbleSort")
    public List<Cliente> listarBubbleSort() {
        return lista.bubbleSort();
    }

    @GetMapping("/endpoint-selectionSort")
    public List<Cliente> listarSelectionSort() {
        return lista.selectionSort();
    }

    @GetMapping("/endpoint-quickSort")
    public List<Cliente> listarQuickSort() {
        return lista.quickSort();
    }

    @GetMapping("/endpoint-bubbleSortEx")
    public Map<String, Object> listarBubbleSortEx() {
        List<List<Integer>> pasos = lista.getBubbleSortSteps(); // Método que devuelve los pasos
        List<Cliente> clientesOrdenados = lista.bubbleSort(); // Lista final ordenada

        Map<String, Object> response = new HashMap<>();
        response.put("pasos", pasos);
        response.put("ordenado", clientesOrdenados.stream().map(Cliente::getCedula).collect(Collectors.toList()));
        return response;
    }

    @GetMapping("/endpoint-selectionSortEx")
    public Map<String, Object> listarSelectionSortEx() {
        List<List<Integer>> pasos = lista.getSelectionSortSteps(); // Método que devuelve los pasos
        List<Cliente> clientesOrdenados = lista.selectionSort(); // Lista final ordenada

        Map<String, Object> response = new HashMap<>();
        response.put("pasos", pasos);
        response.put("ordenado", clientesOrdenados.stream().map(Cliente::getCedula).collect(Collectors.toList()));
        return response;
    }

    @GetMapping("/endpoint-quickSortEx")
    public Map<String, Object> listarQuickSortEx() {
        List<List<Integer>> pasos = lista.getQuickSortSteps(); // Método que devuelve los pasos
        List<Cliente> clientesOrdenados = lista.quickSort(); // Lista final ordenada

        Map<String, Object> response = new HashMap<>();
        response.put("pasos", pasos);
        response.put("ordenado", clientesOrdenados.stream().map(Cliente::getCedula).collect(Collectors.toList()));
        return response;
    }

    @GetMapping("/endpoint-listarOriginalEx")
    public Map<String, Object> listarOriginalEx() {
        List<Cliente> clientesOriginal = lista.getClientesOriginal(); // Método que devuelve la lista original

        Map<String, Object> response = new HashMap<>();
        response.put("original", clientesOriginal.stream().map(Cliente::getCedula).collect(Collectors.toList()));
        return response;
    }

}
