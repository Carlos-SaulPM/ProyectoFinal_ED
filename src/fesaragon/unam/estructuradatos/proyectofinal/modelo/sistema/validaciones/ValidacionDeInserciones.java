package fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.validaciones;

import fesaragon.unam.estructuradatos.proyectofinal.modelo.adts.ArbolBinarioBusqueda;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.Producto;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.excepciones.EntradaDeDatosIncorrecto;

public class ValidacionDeInserciones extends EntradaDeDatos {

    public ValidacionDeInserciones(ArbolBinarioBusqueda<Producto> arbol) {
        super(arbol);
    }

    public boolean comprobarEntradaNombreDeProducto(String entradaDeTexto) {
        if (!entradaDeTexto(entradaDeTexto)) {
            throw new EntradaDeDatosIncorrecto("No estas ingresando un texto valido en el nombre del producto");
        }
        return true;
    }

    public boolean comprobarEntradaCantidadEnInventario(String entradaDeTexto) {
        if (!entradaDeEnteros(entradaDeTexto)) {
            throw new EntradaDeDatosIncorrecto("No estas ingresando un numero valido en la cantidad de inventario");
        }
        return true;
    }

    public boolean comprobarEntradaPrecio(String entradaDeTexto) {
        if (!entradaDeFlotantes(entradaDeTexto)) {
            throw new EntradaDeDatosIncorrecto("No estas ingresando un numero valido en el precio");
        }
        return true;
    }


}
