package fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.validaciones;

import fesaragon.unam.estructuradatos.proyectofinal.modelo.adts.ArbolBinarioBusqueda;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.Producto;
import javafx.scene.control.Alert;


public abstract class Validaciones {
    ArbolBinarioBusqueda<Producto> arbol;

    public Validaciones(ArbolBinarioBusqueda<Producto> arbol) {
        this.arbol = arbol;
    }

    protected abstract boolean entradaDeEnteros(String entradaDeDatos);

    protected abstract boolean entradaDeTexto(String entradeDeTexto);

    protected abstract boolean entradaDeFlotantes(String entradeDeTexto);

    public static void mensajeDeError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void mensajeDeInfo(String mensaje, String tituloVentana) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(tituloVentana);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
