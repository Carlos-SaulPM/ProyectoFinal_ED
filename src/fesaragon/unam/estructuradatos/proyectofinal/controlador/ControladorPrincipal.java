package fesaragon.unam.estructuradatos.proyectofinal.controlador;

import fesaragon.unam.estructuradatos.proyectofinal.controlador.vistas.MenuPrincipalController;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.JavaFX.Escena;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.JavaFX.MenuFX;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.adts.ArbolBinarioBusqueda;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.Producto;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorPrincipal {
    MenuFX menuFX;
    private MenuPrincipalController menuPrincipalController;
    ArbolBinarioBusqueda<Producto> arbol;
    BotonController botonController;
    BotonesLateralesController botonesLateralesController;

    public ControladorPrincipal() {
        this.arbol = new ArbolBinarioBusqueda<>();
    }

    public void iniciar() {
        leerFXML();
        menuFX = new MenuFX(menuPrincipalController);
        this.botonController = new BotonController(menuPrincipalController, arbol, menuFX);
        menuPrincipalController.setBotonController(botonController);
        this.botonesLateralesController = new BotonesLateralesController(menuFX);
        menuPrincipalController.setBotonesLateralesController(botonesLateralesController);
        botonesLateralesController.cambiarMenuBuscar();
    }

    private void leerFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fesaragon/unam/estructuradatos/proyectofinal/vista/MenuPrincipal.fxml"));
            AnchorPane root = loader.load();
            menuPrincipalController = loader.getController();
            Escena escena = new Escena("Menu", new Stage());
            escena.cambiarEscena(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setArbol(ArbolBinarioBusqueda<Producto> arbol) {
        this.arbol = arbol;
    }
}
