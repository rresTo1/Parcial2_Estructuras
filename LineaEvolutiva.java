package org.example.Model;

public class LineaEvolutiva {

    private Pokemon faseActual;
    private int expAcumulada;

    public LineaEvolutiva(Pokemon a1, Pokemon a2, Pokemon a3)
    {
        Pokemon pokemon1 = a1;
        Pokemon pokemon2 = a2;
        Pokemon pokemon3 = a3;

        pokemon1.setNext(pokemon2);
        pokemon2.setNext(pokemon3);

        this.faseActual = pokemon1;
        this.expAcumulada = 0;
    }


    public void mecanismoEvolucion(int exp){

        this.expAcumulada += exp;

        if ( faseActual.getSiguienteEvolucion() != null && expAcumulada >= faseActual.getExpRequerida()){

            faseActual = faseActual.getSiguienteEvolucion();

        }
    }

    public Pokemon getFaseActual() {
        return faseActual;
    }

    public int getExpAcumulada() {
        return expAcumulada;
    }

    @Override
    public String toString(){

        String mensaje = "";

        if ( faseActual == null ) { return "Lista vacia"; }

        Pokemon referencia = faseActual;

        while ( referencia != null ){

            mensaje += "[" + referencia.getNombre() + "] - ";
            mensaje += "[" + referencia.getPuntosVidaMax() + "] - ";
            mensaje += "[" + referencia.getDefensa() + "] - ";
            mensaje += "[" + referencia.getAtaque() + "] - ";
            mensaje += "[" + referencia.getExpRequerida() + "] -> ";

            referencia = referencia.getSiguienteEvolucion();

        }

        return mensaje;

    }
}
