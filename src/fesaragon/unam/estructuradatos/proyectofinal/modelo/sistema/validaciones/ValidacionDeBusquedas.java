package fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.validaciones;

import fesaragon.unam.estructuradatos.proyectofinal.modelo.adts.ArbolBinarioBusqueda;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.Producto;

public class ValidacionDeBusquedas extends EntradaDeDatos {
    public ValidacionDeBusquedas(ArbolBinarioBusqueda<Producto> arbol) {
        super(arbol);
    }

    public boolean busquedaPorID(String datoID) {
        if (comprobarEntradaDeID(datoID) && arbol.buscar(new Producto(Integer.parseInt(datoID)))) {
            return true;
        }

        Validaciones.mensajeDeInfo("No existe el producto con ese ID", "Producto no encontrado");
        return false;
    }

}
