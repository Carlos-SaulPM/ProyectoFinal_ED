module ProyectoFinal {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    exports fesaragon.unam.estructuradatos.proyectofinal.controlador to javafx.graphics;
    exports fesaragon.unam.estructuradatos.proyectofinal.controlador.vistas to javafx.fxml;

    opens fesaragon.unam.estructuradatos.proyectofinal.controlador.vistas to javafx.fxml;
    opens fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema to javafx.base;
}
