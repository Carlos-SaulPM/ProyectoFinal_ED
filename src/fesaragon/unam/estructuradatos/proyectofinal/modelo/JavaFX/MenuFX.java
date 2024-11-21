package fesaragon.unam.estructuradatos.proyectofinal.modelo.JavaFX;

import fesaragon.unam.estructuradatos.proyectofinal.controlador.vistas.MenuPrincipalController;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class MenuFX {
    MenuPrincipalController menuController;
    List<String> tituloDeSubMenu;


    public MenuFX(MenuPrincipalController menuController) {
        this.menuController = menuController;
        this.tituloDeSubMenu = new ArrayList<>();
        cargarTitulosSubMenu();
    }

    private void cargarTitulosSubMenu() {
        this.tituloDeSubMenu.add("BÚSQUEDA DE PRODUCTOS");
        this.tituloDeSubMenu.add("INSERTAR PRODUCTOS");
        this.tituloDeSubMenu.add("ELIMINAR PRODUCTOS");
        this.tituloDeSubMenu.add("PRODUCTOS EN INVENTARIO");
    }

    //Menu
    public void cambiarMenuABusqueda() {
        cambiarTexto(menuController.getTextDinamico(), "BÚSQUEDA DE PRODUCTOS");
        cambiarTexto(menuController.getButtonDinamico(), tituloDeSubMenu.get(0).split(" ")[0]);
        habilitarComponente(menuController.getButtonDinamico());
        habilitarComponente(menuController.getLblId());
        habilitarComponente(menuController.getTextFId());
        deshabilitarComponentesBusquedaEliminacion();
        limpiarCamposDeTextfield();
    }


    public void cambiarMenuAInsertarProductos() {
        cambiarTexto(menuController.getTextDinamico(), "INSERTAR PRODUCTOS");
        cambiarTexto(menuController.getButtonDinamico(), tituloDeSubMenu.get(1).split(" ")[0]);
        habilitarComponente(menuController.getButtonDinamico());
        habilitarComponente(menuController.getLblNombreDelProducto());
        habilitarComponente(menuController.getLblCantidad());
        habilitarComponente(menuController.getLblPrecio());
        habilitarComponente(menuController.getTextFNombreDelProducto());
        habilitarComponente(menuController.getTextFCantidad());
        habilitarComponente(menuController.getTextFPrecio());
        limpiarCamposDeTextfield();
    }

    public void cambiarMenuAEliminar() {
        cambiarTexto(menuController.getTextDinamico(), "ELIMINAR PRODUCTOS");
        cambiarTexto(menuController.getButtonDinamico(), tituloDeSubMenu.get(2).split(" ")[0]);
        habilitarComponente(menuController.getButtonDinamico());
        habilitarComponente(menuController.getLblId());
        habilitarComponente(menuController.getTextFId());

        deshabilitarComponentesBusquedaEliminacion();
        limpiarCamposDeTextfield();
    }

    public void cambiarAListarProductos() {
        cambiarTexto(menuController.getTextDinamico(), "PRODUCTOS EN INVENTARIO");
        cambiarTexto(menuController.getButtonDinamico(), "LISTAR");
        habilitarComponente(menuController.getTextDinamico());
        deshabilitarComponente(menuController.getLblId());
        deshabilitarComponente(menuController.getTextFId());
        deshabilitarComponentesBusquedaEliminacion();
        limpiarCamposDeTextfield();
    }

    private void deshabilitarComponentesBusquedaEliminacion() {
        deshabilitarComponente(menuController.getLblNombreDelProducto());
        deshabilitarComponente(menuController.getLblCantidad());
        deshabilitarComponente(menuController.getLblPrecio());

        deshabilitarComponente(menuController.getTextFNombreDelProducto());
        deshabilitarComponente(menuController.getTextFCantidad());
        deshabilitarComponente(menuController.getTextFPrecio());
    }

    private void deshabilitarComponente(Node nodo) {
        nodo.setVisible(false);
        nodo.setDisable(true);
    }

    private void habilitarComponente(Node nodo) {
        nodo.setVisible(true);
        nodo.setDisable(false);
    }

    private void cambiarTexto(Node nodo, String textoNuevo) {
        if (nodo instanceof Text) {
            ((Text) nodo).setText(textoNuevo);
        } else if (nodo instanceof Button) {
            ((Button) nodo).setText(textoNuevo);
        }
    }

    public void limpiarCamposDeTextfield() {
        menuController.getTextFId().setText("");
        menuController.getTextFNombreDelProducto().setText("");
        menuController.getTextFCantidad().setText("");
        menuController.getTextFPrecio().setText("");
    }

    public MenuPrincipalController getMenuController() {
        return menuController;
    }
}
