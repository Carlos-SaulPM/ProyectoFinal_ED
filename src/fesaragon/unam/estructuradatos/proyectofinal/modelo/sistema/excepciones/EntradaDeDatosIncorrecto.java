package fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.excepciones;

import fesaragon.unam.estructuradatos.proyectofinal.modelo.sistema.validaciones.Validaciones;

public class EntradaDeDatosIncorrecto extends RuntimeException {
    public EntradaDeDatosIncorrecto(String message) {
        super(message);
        Validaciones.mensajeDeError(message);
    }
}
