package org.example.Model;

public class LineaEvolutiva {

    private Pokemon faseActual;
    private int expAcumulada;
    private int size;

    public LineaEvolutiva() {

        faseActual = null;

        expAcumulada = 0;
    }

    public int getExpAcumulada() {
        return expAcumulada;
    }

    public void setExpAcumulada(int expAcumulada) {
        this.expAcumulada = expAcumulada;
    }

    public Pokemon getFaseActual() {
        return faseActual;
    }

    public void setFaseActual(Pokemon faseActual) {
        this.faseActual = faseActual;
    }

    public void agregarPokemon(Pokemon pokemon) {

        if (faseActual == null) {

            faseActual = pokemon;
        } else {
            pokemon.setNext(faseActual);
            faseActual = pokemon;
        }

        size++;

    }

    public void mecanismoEvolucion(int exp) {

            this.expAcumulada += exp;

            if (faseActual == null) { throw new IllegalStateException("La linea evolutiva tiene referencia nula");}

            while (faseActual.getSiguienteEvolucion() != null && expAcumulada >= faseActual.getExpRequerida())
            {
                faseActual = faseActual.getSiguienteEvolucion();

            }
        }

        @Override
        public String toString () {

            String mensaje = "";

            if (faseActual == null) {
                return "Lista vacia";
            }

            Pokemon referencia = faseActual;

            while (referencia != null) {

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

