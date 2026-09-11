package org.example.Model;

import java.util.Objects;

public class Pokemon {

    private String nombre;
    private int puntosVidaMax;
    private int ataque;
    private int defensa;
    private int expRequerida;
    private Pokemon siguienteEvolucion;

    public Pokemon(String nombre, int puntosVidaMax, int ataque, int defensa, int expRequerida) {
        this.nombre = nombre;
        this.puntosVidaMax = puntosVidaMax;
        this.ataque = ataque;
        this.defensa = defensa;
        this.expRequerida = expRequerida;
        this.siguienteEvolucion = null;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosVidaMax() {
        return puntosVidaMax;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public Pokemon getSiguienteEvolucion() {
        return siguienteEvolucion;
    }

    public int getExpRequerida() {
        return expRequerida;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pokemon pokemon)) return false;
        return puntosVidaMax == pokemon.puntosVidaMax && ataque == pokemon.ataque && defensa == pokemon.defensa && expRequerida == pokemon.expRequerida && Objects.equals(nombre, pokemon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, puntosVidaMax, ataque, defensa, expRequerida);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre +
                ", puntosVidaMax=" + puntosVidaMax +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", expRequerida=" + expRequerida +
                '}';
    }

    public void setNext(Pokemon faseActual) {
        this.siguienteEvolucion = faseActual;
    }

}