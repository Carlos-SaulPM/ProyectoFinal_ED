package fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Producto implements Comparable<Producto> {
    private SimpleStringProperty nombreDelProducto;
    private SimpleIntegerProperty id;
    private SimpleFloatProperty precio;
    private SimpleIntegerProperty cantidadEnInventario;

    public Producto(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public Producto(String nombreDelProducto, int id, float precio, int cantidadEnInventario) {
        this.nombreDelProducto = new SimpleStringProperty(nombreDelProducto);
        this.id = new SimpleIntegerProperty(id);
        this.precio = new SimpleFloatProperty(precio);
        this.cantidadEnInventario = new SimpleIntegerProperty(cantidadEnInventario);
    }

    @Override
    public int compareTo(Producto o) {
        return Integer.compare(this.getId(), o.getId());
    }


    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNombreDelProducto() {
        return nombreDelProducto.get();
    }

    public SimpleStringProperty nombreDelProductoProperty() {
        return nombreDelProducto;
    }

    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto.set(nombreDelProducto);
    }

    public float getPrecio() {
        return precio.get();
    }

    public SimpleFloatProperty precioProperty() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio.set(precio);
    }

    public int getCantidadEnInventario() {
        return cantidadEnInventario.get();
    }

    public SimpleIntegerProperty cantidadEnInventarioProperty() {
        return cantidadEnInventario;
    }

    public void setCantidadEnInventario(int cantidadEnInventario) {
        this.cantidadEnInventario.set(cantidadEnInventario);
    }
}
