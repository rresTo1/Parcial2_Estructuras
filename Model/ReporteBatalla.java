package org.example.Model;


public class ReporteBatalla {

    private String  nombrePokemon;

    private String nombreEnemigo;

    private int cantidadDerrotados;

    public ReporteBatalla(String nombrePokemon, String nombreEnemigo, int cantidadDerrotados) {
        this.nombrePokemon = nombrePokemon;
        this.nombreEnemigo = nombreEnemigo;
        this.cantidadDerrotados = cantidadDerrotados;
    }

    public void sumarDerrotados(){
        this.cantidadDerrotados++;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public String getNombreEnemigo() {
        return nombreEnemigo;
    }

    public int getCantidadDerrotados() {
        return cantidadDerrotados;
    }


    @Override
    public String toString() {
        return "(" + nombrePokemon + " vs " + nombreEnemigo + ": " + cantidadDerrotados + ")";
    }


}
