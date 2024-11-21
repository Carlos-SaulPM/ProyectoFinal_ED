package fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.validaciones;

import fesaragon.unam.estructuradatos.proyectofinal.modelo.adts.ArbolBinarioBusqueda;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.Producto;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.excepciones.EntradaDeDatosIncorrecto;

public class EntradaDeDatos extends Validaciones {

    public EntradaDeDatos(ArbolBinarioBusqueda<Producto> arbol) {
        super(arbol);
    }

    public boolean comprobarEntradaDeID(String entradaDeTexto) throws EntradaDeDatosIncorrecto {
        if (!entradaDeEnteros(entradaDeTexto)) {
            throw new EntradaDeDatosIncorrecto("No estas ingresando un numero valido en el campo del ID");
        }
        return true;
    }


    @Override
    protected boolean entradaDeEnteros(String textoDeEntrada) {
        return textoDeEntrada.matches("\\d+");
    }

    @Override
    protected boolean entradaDeTexto(String entradaDeTexto) {
        return entradaDeTexto.matches("[a-zA-Z0-9 ]+");
    }

    @Override
    protected boolean entradaDeFlotantes(String entradeDeTexto) {
        return entradeDeTexto.matches("\\d+(\\.\\d+)?");
    }
}
