package com.model_controller.src.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaSimple {
    // Referencia al primer y último nodo de la lista
    Nodo cabeza;
    Nodo ultimo;
    private int numElem;

    // Lista auxiliar para mantener el orden original
    private final List<Cliente> listaOriginal = new ArrayList<>();

    // Constructor: inicializa la lista vacía
    public ListaSimple() {
        cabeza = null;
        ultimo = null;
        numElem = 0;
    }

    // Método para agregar un nuevo nodo a la lista
    public void inputNodo(Cliente cliente) {
        Nodo nuevoNodo = new Nodo(cliente);

        // Si la lista está vacía, el nuevo nodo será la cabeza y el último
        if (cabeza == null) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            // Si la lista no está vacía, agregamos el nuevo nodo al final
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }

        // Agregamos el cliente a la lista auxiliar
        listaOriginal.add(cliente);

        // Incrementamos el contador de elementos
        numElem++;
    }

    // Método para ordenar los clientes usando el algoritmo Bubble Sort
    public List<Cliente> bubbleSort() {
        if (cabeza == null || cabeza.siguiente == null) {
            // Si la lista está vacía o tiene un solo elemento, no hay nada que ordenar
            return getClientes();
        }

        boolean huboIntercambio;
        do {
            Nodo actual = cabeza;
            Nodo siguiente = cabeza.siguiente;
            huboIntercambio = false;

            while (siguiente != null) {
                // Comparamos los clientes por cédula
                if (actual.cliente.getCedula() > siguiente.cliente.getCedula()) {
                    // Intercambiamos los datos de los nodos
                    Cliente temp = actual.cliente;
                    actual.cliente = siguiente.cliente;
                    siguiente.cliente = temp;
                    huboIntercambio = true;
                }

                // Avanzamos al siguiente par de nodos
                actual = siguiente;
                siguiente = siguiente.siguiente;
            }
        } while (huboIntercambio); // Repetimos mientras haya intercambios

        // Devolvemos la lista ordenada
        return getClientes();
    }

    // Método para ordenar los clientes usando el algoritmo Selection Sort
    public List<Cliente> selectionSort() {
        if (cabeza == null || cabeza.siguiente == null) {
            // Si la lista está vacía o tiene un solo elemento, no hay nada que ordenar
            return getClientes();
        }

        Nodo actual = cabeza;

        while (actual != null) {
            Nodo menor = actual;
            Nodo siguiente = actual.siguiente;

            // Encontramos el nodo con el menor valor de cédula en el resto de la lista
            while (siguiente != null) {
                if (siguiente.cliente.getCedula() < menor.cliente.getCedula()) {
                    menor = siguiente;
                }
                siguiente = siguiente.siguiente;
            }

            // Intercambiamos los datos del nodo actual con el nodo menor
            if (menor != actual) {
                Cliente temp = actual.cliente;
                actual.cliente = menor.cliente;
                menor.cliente = temp;
            }

            // Avanzamos al siguiente nodo
            actual = actual.siguiente;
        }

        // Devolvemos la lista ordenada
        return getClientes();
    }

    // Método para mostrar todos los datos de los clientes en la lista
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Nodo actual = cabeza;

        while (actual != null) {
            clientes.add(actual.cliente);
            actual = actual.siguiente;
        }
        return clientes;
    }

    // Método para ordenar los clientes usando el algoritmo QuickSort
    public List<Cliente> quickSort() {
        if (cabeza == null || cabeza.siguiente == null) {
            // Si la lista está vacía o tiene un solo elemento, no hay nada que ordenar
            return getClientes();
        }

        // Convertimos la lista enlazada a una lista auxiliar para facilitar el manejo
        List<Cliente> clientes = getClientes();
        quickSortHelper(clientes, 0, clientes.size() - 1);

        // Actualizamos la lista enlazada con los datos ordenados
        actualizarListaDesdeListaAuxiliar(clientes);

        return clientes;
    }

    // Método auxiliar para realizar QuickSort en una lista
    private void quickSortHelper(List<Cliente> clientes, int inicio, int fin) {
        if (inicio < fin) {
            // Obtenemos el índice del pivote después de la partición
            int indicePivote = particion(clientes, inicio, fin);

            // Ordenamos recursivamente las sublistas izquierda y derecha
            quickSortHelper(clientes, inicio, indicePivote - 1);
            quickSortHelper(clientes, indicePivote + 1, fin);
        }
    }

    // Método para particionar la lista y colocar el pivote en su posición correcta
    private int particion(List<Cliente> clientes, int inicio, int fin) {
        Cliente pivote = clientes.get(fin); // Elegimos el último elemento como pivote
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (clientes.get(j).getCedula() <= pivote.getCedula()) {
                i++;
                // Intercambiamos los elementos
                Cliente temp = clientes.get(i);
                clientes.set(i, clientes.get(j));
                clientes.set(j, temp);
            }
        }

        // Colocamos el pivote en su posición correcta
        Cliente temp = clientes.get(i + 1);
        clientes.set(i + 1, clientes.get(fin));
        clientes.set(fin, temp);

        return i + 1;
    }

    // Método para actualizar la lista enlazada desde la lista auxiliar ordenada
    private void actualizarListaDesdeListaAuxiliar(List<Cliente> clientes) {
        Nodo actual = cabeza;
        int index = 0;

        while (actual != null) {
            actual.cliente = clientes.get(index);
            actual = actual.siguiente;
            index++;
        }
    }

    // Método para obtener los pasos intermedios del algoritmo Bubble Sort
    public List<List<Integer>> getBubbleSortSteps() {
        List<List<Integer>> pasos = new ArrayList<>();
        if (cabeza == null || cabeza.siguiente == null) {
            // Si la lista está vacía o tiene un solo elemento, no hay pasos que registrar
            return pasos;
        }

        boolean huboIntercambio;
        do {
            Nodo actual = cabeza;
            Nodo siguiente = cabeza.siguiente;
            huboIntercambio = false;

            while (siguiente != null) {
                // Comparamos los clientes por cédula
                if (actual.cliente.getCedula() > siguiente.cliente.getCedula()) {
                    // Intercambiamos los datos de los nodos
                    Cliente temp = actual.cliente;
                    actual.cliente = siguiente.cliente;
                    siguiente.cliente = temp;
                    huboIntercambio = true;
                }

                // Avanzamos al siguiente par de nodos
                actual = siguiente;
                siguiente = siguiente.siguiente;
            }

            // Registramos el estado actual de la lista
            pasos.add(new ArrayList<>(getCedulas()));
        } while (huboIntercambio); // Repetimos mientras haya intercambios

        return pasos;
    }

    // Método auxiliar para obtener las cédulas de los clientes en la lista actual
    private List<Integer> getCedulas() {
        List<Integer> cedulas = new ArrayList<>();
        Nodo actual = cabeza;

        while (actual != null) {
            cedulas.add(actual.cliente.getCedula());
            actual = actual.siguiente;
        }

        return cedulas;
    }

    // Método para obtener los pasos intermedios del algoritmo Selection Sort
    public List<List<Integer>> getSelectionSortSteps() {
        List<List<Integer>> pasos = new ArrayList<>();
        if (cabeza == null || cabeza.siguiente == null) {
            // Si la lista está vacía o tiene un solo elemento, no hay pasos que registrar
            return pasos;
        }

        Nodo actual = cabeza;

        while (actual != null) {
            Nodo menor = actual;
            Nodo siguiente = actual.siguiente;

            // Encontramos el nodo con el menor valor de cédula en el resto de la lista
            while (siguiente != null) {
                if (siguiente.cliente.getCedula() < menor.cliente.getCedula()) {
                    menor = siguiente;
                }
                siguiente = siguiente.siguiente;
            }

            // Intercambiamos los datos del nodo actual con el nodo menor
            if (menor != actual) {
                Cliente temp = actual.cliente;
                actual.cliente = menor.cliente;
                menor.cliente = temp;
            }

            // Registramos el estado actual de la lista
            pasos.add(new ArrayList<>(getCedulas()));

            // Avanzamos al siguiente nodo
            actual = actual.siguiente;
        }

        return pasos;
    }

    // Método para obtener los pasos intermedios del algoritmo QuickSort
    public List<List<Integer>> getQuickSortSteps() {
        List<List<Integer>> pasos = new ArrayList<>();
        if (cabeza == null || cabeza.siguiente == null) {
            // Si la lista está vacía o tiene un solo elemento, no hay pasos que registrar
            return pasos;
        }

        // Convertimos la lista enlazada a una lista auxiliar para facilitar el manejo
        List<Cliente> clientes = getClientes();
        quickSortHelper(clientes, 0, clientes.size() - 1, pasos);

        return pasos;
    }

    // Método auxiliar para realizar QuickSort y registrar los pasos
    private void quickSortHelper(List<Cliente> clientes, int inicio, int fin, List<List<Integer>> pasos) {
        if (inicio < fin) {
            // Obtenemos el índice del pivote después de la partición
            int indicePivote = particion(clientes, inicio, fin, pasos);

            // Ordenamos recursivamente las sublistas izquierda y derecha
            quickSortHelper(clientes, inicio, indicePivote - 1, pasos);
            quickSortHelper(clientes, indicePivote + 1, fin, pasos);
        }
    }

    // Método para particionar la lista y registrar los pasos
    private int particion(List<Cliente> clientes, int inicio, int fin, List<List<Integer>> pasos) {
        Cliente pivote = clientes.get(fin); // Elegimos el último elemento como pivote
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (clientes.get(j).getCedula() <= pivote.getCedula()) {
                i++;
                // Intercambiamos los elementos
                Cliente temp = clientes.get(i);
                clientes.set(i, clientes.get(j));
                clientes.set(j, temp);
            }
        }

        // Colocamos el pivote en su posición correcta
        Cliente temp = clientes.get(i + 1);
        clientes.set(i + 1, clientes.get(fin));
        clientes.set(fin, temp);

        // Registramos el estado actual de la lista
        pasos.add(new ArrayList<>(clientes.stream().map(Cliente::getCedula).collect(Collectors.toList())));


        return i + 1;
    }

    // Método para obtener los clientes en el orden original de inserción
    public List<Cliente> getClientesOriginal() {
        return new ArrayList<>(listaOriginal); // Retornamos una copia de la lista original
    }

    // Método que retorna la cantidad de clientes
    public int getCantidadClientes() {
        return numElem;
    }
}