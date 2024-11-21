package fesaragon.unam.estructuradatos.proyectofinal.controlador;

import fesaragon.unam.estructuradatos.proyectofinal.controlador.vistas.MenuPrincipalController;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.JavaFX.MenuFX;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.adts.ArbolBinarioBusqueda;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.Operaciones;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.Producto;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.excepciones.EntradaDeDatosIncorrecto;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.validaciones.ValidacionDeBusquedas;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.validaciones.ValidacionDeInserciones;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.validaciones.Validaciones;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class BotonController {

    private MenuPrincipalController menuPrincipalC;
    private ArbolBinarioBusqueda<Producto> arbol;
    private MenuFX menuFX;

    public static int estadoActual = 0;
    public static List<Integer> estados = new ArrayList<>(4);
    private Operaciones op;
    private ValidacionDeBusquedas validacionDeBusquedas;
    private ValidacionDeInserciones validacionDeInserciones;


    public BotonController(MenuPrincipalController menuPrincipalC, ArbolBinarioBusqueda<Producto> arbol, MenuFX menuFX) {
        this.menuPrincipalC = menuPrincipalC;
        this.arbol = arbol;
        this.menuFX = menuFX;
        this.op = new Operaciones(arbol);
        this.validacionDeBusquedas = new ValidacionDeBusquedas(arbol);
        this.validacionDeInserciones = new ValidacionDeInserciones(arbol);
        for (int i = 0; i < estados.size(); i++) estados.set(i, i);
    }


    public void accionarBoton() {
        List<Producto> productos = new ArrayList<>();
        try {
            switch (estadoActual) {

                case 0: //Buscar
                    if (validacionDeBusquedas.busquedaPorID(menuPrincipalC.getTextFId().getText())) {
                        Producto productoEncontrado = op.buscar(new Producto(Integer.parseInt(menuPrincipalC.getTextFId().getText())));
                        productos.add(productoEncontrado);
                        actualizarTabla(productos);
                    }
                    break;
                case 1: //Insertar
                    boolean validacionDeCampos = validacionDeInsertar();
                    if (validacionDeCampos) {
                        Producto producto = obtenerNuevoProducto();
                        op.insertar(producto);
                        listarTabla();
                    }
                    break;
                case 2: //Eliminar
                    if (validacionDeBusquedas.busquedaPorID(menuPrincipalC.getTextFId().getText())) {
                        op.eliminar(new Producto(Integer.parseInt(menuPrincipalC.getTextFId().getText())));
                        Validaciones.mensajeDeInfo("El producto ha sido eliminado", "Producto Eliminado");

                    }
                    listarTabla();
                    break;
                case 3: //Listar Productos
                    listarTabla();
                    break;
            }
            menuFX.limpiarCamposDeTextfield();
        } catch (EntradaDeDatosIncorrecto e) {
            System.out.println(e);
            ;
        }


    }

    private void listarTabla() {
        actualizarTabla(arbol.obtenerDataInOrder());
    }


    private Producto obtenerNuevoProducto() {
        int id = Integer.parseInt(menuPrincipalC.getTextFId().getText());
        int cantidadInventario = Integer.parseInt(menuPrincipalC.getTextFCantidad().getText()); // Corrección del campo de cantidad
        float precio = Float.parseFloat(menuPrincipalC.getTextFPrecio().getText());
        return new Producto(menuPrincipalC.getTextFNombreDelProducto().getText(), id, precio, cantidadInventario);
    }


    private boolean validacionDeInsertar() {
        boolean id = validacionDeInserciones.comprobarEntradaDeID(menuPrincipalC.getTextFId().getText());
        boolean nombreProducto = validacionDeInserciones.comprobarEntradaNombreDeProducto(menuPrincipalC.getTextFNombreDelProducto().getText());
        boolean cantidad = validacionDeInserciones.comprobarEntradaCantidadEnInventario(menuPrincipalC.getTextFCantidad().getText());
        boolean precio = validacionDeInserciones.comprobarEntradaPrecio(menuPrincipalC.getTextFPrecio().getText());
        boolean noDuplicado = !arbol.buscar(new Producto(Integer.parseInt(menuPrincipalC.getTextFId().getText())));
        if (!noDuplicado) {
            Validaciones.mensajeDeInfo("Este producto ya esta en la tabla", "Producto duplicado");
        } else {
            Validaciones.mensajeDeInfo("El producto ha sido insertado", "Producto insertado");
        }
        return (id && nombreProducto && cantidad && precio && noDuplicado);
    }


    private void actualizarTabla(List<Producto> productos) {
        TableView<Producto> tabla = this.menuPrincipalC.getTablePrincipal();
        ObservableList<Producto> data = FXCollections.observableArrayList(productos);
        tabla.setItems(data);
        tabla.refresh();
    }


}
