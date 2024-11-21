package fesaragon.unam.estructuradatos.proyectofinal.controlador;

import fesaragon.unam.estructuradatos.proyectofinal.modelo.JavaFX.MenuFX;

public class BotonesLateralesController {

    MenuFX menuFX;

    public BotonesLateralesController(MenuFX menuFX) {
        this.menuFX = menuFX;
    }

    public void cambiarMenuBuscar() {
        menuFX.cambiarMenuABusqueda();
        BotonController.estadoActual = 0;
        menuFX.limpiarCamposDeTextfield();
    }

    public void cambiarMenuInsertar() {
        menuFX.cambiarMenuAInsertarProductos();
        BotonController.estadoActual = 1;
        menuFX.limpiarCamposDeTextfield();
    }

    public void cambiarMenuEliminar() {
        menuFX.cambiarMenuAEliminar();
        BotonController.estadoActual = 2;
        menuFX.limpiarCamposDeTextfield();
    }

    public void cambiarMenuListar() {
        menuFX.cambiarAListarProductos();
        BotonController.estadoActual = 3;
        menuFX.limpiarCamposDeTextfield();
    }

}
