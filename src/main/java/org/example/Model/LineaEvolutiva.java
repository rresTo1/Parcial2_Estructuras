package org.example.Model;

public class LineaEvolutiva {

    private Pokemon faseActual;
    private int expAcumulada;

    public LineaEvolutiva()
    {
        Pokemon Charmander = new Pokemon("Charmander", 39,52, 43, 1500);
        Pokemon Charmeleon = new Pokemon("Charmeleon", 58,64, 58, 5000);
        Pokemon Charizard = new Pokemon("Charizard", 78,84, 78, -1);

        Charmander.setNext(Charmeleon);
        Charmeleon.setNext(Charizard);

        this.faseActual = Charmander;
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
