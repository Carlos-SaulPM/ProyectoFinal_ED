package fesaragon.unam.estructuradatos.proyectofinal.modelo.adts;

import java.util.Objects;

public class NodoArbolBinario<T extends Comparable<T>> implements Comparable<NodoArbolBinario<T>> {
    private T data;
    private NodoArbolBinario<T> hijoIzquierdo;
    private NodoArbolBinario<T> hijoDerecho;

    public NodoArbolBinario() {
    }

    public NodoArbolBinario(T data) {
        this.data = data;
    }

    public NodoArbolBinario(T data, NodoArbolBinario<T> hijoIzquierdo, NodoArbolBinario<T> hijoDerecho) {
        this.data = data;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }

    @Override
    public int compareTo(NodoArbolBinario<T> o) {
        return this.getData().compareTo(o.getData());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodoArbolBinario<?> that = (NodoArbolBinario<?>) o;
        return Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getData());
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoArbolBinario<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbolBinario<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoArbolBinario<T> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoArbolBinario<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }


}
