package fesaragon.unam.estructuradatos.proyectofinal.modelo.adts;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda<T extends Comparable<T>> {

    private NodoArbolBinario<T> raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }


    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoArbolBinario<T> insertarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) return new NodoArbolBinario<>(valor);
        if (valor.compareTo(nodo.getData()) == 0) return nodo;
        if (valor.compareTo(nodo.getData()) < 0) {
            nodo.setHijoIzquierdo(insertarRecursivo(nodo.getHijoIzquierdo(), valor));
        } else if (valor.compareTo(nodo.getData()) > 0) {
            nodo.setHijoDerecho(insertarRecursivo(nodo.getHijoDerecho(), valor));
        }
        return nodo; // No duplicados
    }

    public boolean buscar(T valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) return false;
        if (valor.compareTo(nodo.getData()) == 0) return true;

        return valor.compareTo(nodo.getData()) < 0
                ? buscarRecursivo(nodo.getHijoIzquierdo(), valor)
                : buscarRecursivo(nodo.getHijoDerecho(), valor);
    }

    public T obtener(T valor) {
        return obtenerRecursivo(raiz, valor);
    }

    private T obtenerRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) return null;
        if (valor.compareTo(nodo.getData()) == 0) return nodo.getData();

        return valor.compareTo(nodo.getData()) < 0
                ? obtenerRecursivo(nodo.getHijoIzquierdo(), valor)
                : obtenerRecursivo(nodo.getHijoDerecho(), valor);
    }


    public void eliminar(T valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private NodoArbolBinario<T> eliminarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) return null;
        if (valor.compareTo(nodo.getData()) < 0) {
            nodo.setHijoIzquierdo(eliminarRecursivo(nodo.getHijoIzquierdo(), valor));
        } else if (valor.compareTo(nodo.getData()) > 0) {
            nodo.setHijoDerecho(eliminarRecursivo(nodo.getHijoDerecho(), valor));
        } else {
            //encontrado
            if (nodo.getHijoIzquierdo() == null) {
                return nodo.getHijoDerecho();
            } else if (nodo.getHijoDerecho() == null) {
                return nodo.getHijoIzquierdo();
            }

            T minValue = encontrarMinimo(nodo.getHijoDerecho());
            nodo.setData(minValue);
            nodo.setHijoDerecho(eliminarRecursivo(nodo.getHijoDerecho(), minValue));
        }
        return nodo;
    }

    private T encontrarMinimo(NodoArbolBinario<T> nodo) {
        T minValue = nodo.getData();
        while (nodo.getHijoIzquierdo() != null) {
            nodo = nodo.getHijoIzquierdo();
            minValue = nodo.getData();
        }
        return minValue;
    }

    public void recorrerEnOrden() {
        recorrerEnOrdenRecursivo(raiz);
        System.out.println();
    }

    private void recorrerEnOrdenRecursivo(NodoArbolBinario<T> nodo) {
        if (nodo != null) {
            recorrerEnOrdenRecursivo(nodo.getHijoIzquierdo());
            System.out.print(nodo.getData() + " ");
            recorrerEnOrdenRecursivo(nodo.getHijoDerecho());
        }
    }

    public void recorrerEnPreOrden() {
        recorrerEnPreOrdenRecursivo(raiz);
        System.out.println();
    }

    private void recorrerEnPreOrdenRecursivo(NodoArbolBinario<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getData() + " ");
            recorrerEnPreOrdenRecursivo(nodo.getHijoIzquierdo());
            recorrerEnPreOrdenRecursivo(nodo.getHijoDerecho());
        }
    }

    public void recorrerPosOrden() {
        recorrerEnPosOrdenRecursivo(raiz);
        System.out.println();
    }

    private void recorrerEnPosOrdenRecursivo(NodoArbolBinario<T> nodo) {
        if (nodo != null) {
            recorrerEnPosOrdenRecursivo(nodo.getHijoIzquierdo());
            recorrerEnPosOrdenRecursivo(nodo.getHijoDerecho());
            System.out.print(nodo.getData() + " ");
        }
    }

    public List<T> obtenerDataInOrder() {
        List<T> dataList = new ArrayList<>();
        obtenerDataInOrderRecursivo(raiz, dataList);
        return dataList;
    }

    private void obtenerDataInOrderRecursivo(NodoArbolBinario<T> nodo, List<T> dataList) {
        if (nodo != null) {
            obtenerDataInOrderRecursivo(nodo.getHijoIzquierdo(), dataList);
            dataList.add(nodo.getData());
            obtenerDataInOrderRecursivo(nodo.getHijoDerecho(), dataList);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "raiz=" + raiz +
                '}';
    }
}