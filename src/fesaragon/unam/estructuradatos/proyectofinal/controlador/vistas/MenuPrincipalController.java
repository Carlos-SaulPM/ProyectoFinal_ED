package fesaragon.unam.estructuradatos.proyectofinal.controlador.vistas;

import fesaragon.unam.estructuradatos.proyectofinal.controlador.BotonController;
import fesaragon.unam.estructuradatos.proyectofinal.controlador.BotonesLateralesController;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class MenuPrincipalController {
    private BotonController botonController;
    private BotonesLateralesController botonesLateralesController;
    @FXML
    Button buttonBuscar;
    @FXML
    Button buttonInsertar;
    @FXML
    Button buttonEliminar;
    @FXML
    Button buttonListar;
    @FXML
    Button buttonDinamico;

    //Texts
    @FXML
    Text textDinamico;
    @FXML
    Text lblId, lblNombreDelProducto, lblCantidad, lblPrecio;
    //Table
    @FXML
    TableView<Producto> tablePrincipal;
    @FXML
    TableColumn<Producto, Integer> tableColumnId;
    @FXML
    TableColumn<Producto, String> tableColumnNombreDelProducto;
    @FXML
    TableColumn<Producto, Integer> tableColumnCantidadEnInventario;
    @FXML
    TableColumn<Producto, Float> tableColumnPrecio;

    //TextFields
    @FXML
    TextField textFId, textFNombreDelProducto, textFCantidad, textFPrecio;

    @FXML
    private void initialize() {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnNombreDelProducto.setCellValueFactory(new PropertyValueFactory<>("nombreDelProducto"));
        tableColumnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tableColumnCantidadEnInventario.setCellValueFactory(new PropertyValueFactory<>("cantidadEnInventario")); }

    @FXML
    public void buttonDinamicoAccion(){
        if (botonController != null) {botonController.accionarBoton(); }
    }

    @FXML
    public void buttonActionBuscar(){
        if (botonesLateralesController != null) botonesLateralesController.cambiarMenuBuscar();
        limpiarTabla();

    }

    @FXML
    public void buttonActionInsertar(){
        if (botonesLateralesController != null) botonesLateralesController.cambiarMenuInsertar();
        limpiarTabla();

    }

    @FXML
    public void buttonActionEliminar(){
        if (botonesLateralesController != null) botonesLateralesController.cambiarMenuEliminar();
        limpiarTabla();


    }
    @FXML
    public void buttonActionListar(){
        if (botonesLateralesController != null) botonesLateralesController.cambiarMenuListar();
        limpiarTabla();

    }

    private void limpiarTabla() {
        getTablePrincipal().getItems().clear();
        getTablePrincipal().refresh();
    }


    public Button getButtonBuscar() {
        return buttonBuscar;
    }

    public Button getButtonInsertar() {
        return buttonInsertar;
    }

    public Button getButtonEliminar() {
        return buttonEliminar;
    }

    public Button getButtonListar() {
        return buttonListar;
    }

    public Button getButtonDinamico() {
        return buttonDinamico;
    }

    public Text getTextDinamico() {
        return textDinamico;
    }

    public Text getLblId() {
        return lblId;
    }

    public Text getLblNombreDelProducto() {
        return lblNombreDelProducto;
    }

    public Text getLblCantidad() {
        return lblCantidad;
    }

    public Text getLblPrecio() {
        return lblPrecio;
    }

    public TableView<Producto> getTablePrincipal() {
        return tablePrincipal;
    }


    public TextField getTextFId() {
        return textFId;
    }

    public TextField getTextFNombreDelProducto() {
        return textFNombreDelProducto;
    }

    public TextField getTextFCantidad() {
        return textFCantidad;
    }

    public TextField getTextFPrecio() {
        return textFPrecio;
    }

    public BotonController getBotonController() {
        return botonController;
    }

    public void setBotonController(BotonController botonController) {
        this.botonController = botonController;
    }

    public void setBotonesLateralesController(BotonesLateralesController botonesLateralesController) {
        this.botonesLateralesController = botonesLateralesController;
    }
}
