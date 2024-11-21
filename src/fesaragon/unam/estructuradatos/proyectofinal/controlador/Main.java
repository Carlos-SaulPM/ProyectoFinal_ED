package fesaragon.unam.estructuradatos.proyectofinal.controlador;

import fesaragon.unam.estructuradatos.proyectofinal.modelo.adts.ArbolBinarioBusqueda;
import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.Producto;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        ControladorPrincipal p = new ControladorPrincipal();
        p.setArbol(insercionDeDatos());
        p.iniciar();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private static ArbolBinarioBusqueda<Producto> insercionDeDatos() {
        ArbolBinarioBusqueda<Producto> ar = new ArbolBinarioBusqueda<>();
        LinkedList<Producto> inventario = new LinkedList<>();
        inventario.add(new Producto("Harina de trigo", 101, 20.00f, 50));
        inventario.add(new Producto("Aceite de oliva", 102, 15.00f, 30));
        inventario.add(new Producto("Queso Oaxaca", 103, 50.00f, 10));
        inventario.add(new Producto("Tomates", 104, 30.00f, 100));
        inventario.add(new Producto("Pechugas de pollo", 105, 120.00f, 80));
        inventario.add(new Producto("Arroz", 106, 25.00f, 60));
        inventario.add(new Producto("Frijoles negros", 107, 35.00f, 70));
        inventario.add(new Producto("Leche", 108, 50.00f, 100));
        inventario.add(new Producto("Mantequilla", 109, 75.00f, 25));
        inventario.add(new Producto("Huevos", 110, 40.00f, 500));
        inventario.add(new Producto("Azúcar", 111, 20.00f, 40));
        inventario.add(new Producto("Sal", 112, 10.00f, 25));
        inventario.add(new Producto("Pimienta negra", 113, 30.00f, 10));
        inventario.add(new Producto("Zanahorias", 114, 15.00f, 60));
        inventario.add(new Producto("Papas", 115, 25.00f, 100));
        inventario.add(new Producto("Cebollas", 116, 20.00f, 75));
        inventario.add(new Producto("Lechuga", 117, 18.00f, 50));
        inventario.add(new Producto("Ajo", 118, 40.00f, 20));
        inventario.add(new Producto("Pan", 119, 60.00f, 200));
        inventario.add(new Producto("Vino tinto", 120, 500.00f, 50));
        for (Producto p : inventario) {
            ar.insertar(p);
        }
        return ar;
    }
}
