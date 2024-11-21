package fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema;

import fesaragon.unam.estructuradatos.proyectofinal.modelo.adts.ArbolBinarioBusqueda;

import java.util.List;

public class Operaciones implements SistemaDeGestion<Producto> {
    ArbolBinarioBusqueda<Producto> arbol;

    public Operaciones(ArbolBinarioBusqueda<Producto> arbol) {
        this.arbol = arbol;
    }

    @Override
    public Producto buscar(Producto datoABuscar) {
        if (arbol.obtener(datoABuscar) != null) {
            return arbol.obtener(datoABuscar);
        }
        return null;
    }

    @Override
    public void insertar(Producto datoAInsertar) {
        arbol.insertar(datoAInsertar);
    }

    @Override
    public void eliminar(Producto datoAEliminar) {
        arbol.eliminar(datoAEliminar);
    }


    @Override
    public List<Producto> listaDeProductos() {
        return arbol.obtenerDataInOrder();
    }
}
