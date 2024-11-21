package fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema;

import java.util.List;

public interface SistemaDeGestion<T> {
    void insertar(T datoAInsertar);

    void eliminar(T datoAEliminar);

    T buscar(T datoABuscar);

    List<T> listaDeProductos();
}
