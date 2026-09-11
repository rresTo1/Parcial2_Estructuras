package org.example.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Model.LineaEvolutiva;
import org.example.Model.Pokemon;

import java.util.Queue;

import static java.lang.Math.max;

public class ServicioSimulacion {

    private static final Logger log = LogManager.getLogger("tiempos");

    public Pokemon[] crearHorda(int numeroHorda){

        Pokemon[] hordaEnemigos = new Pokemon[numeroHorda];

        for (int i = 0; i < hordaEnemigos.length; i++) {

            hordaEnemigos[i] = new Pokemon("Caterpie", 45, 30, 35, 50);
        }

        return hordaEnemigos;
    }

    public String iniciarEntrenamientoMasivo(Queue<LineaEvolutiva> cola, Pokemon[] hordaEnemigos){


        String mensajeBatalla = "";
        String mensajeTiempo = "";

        int c = 0;

        long startTime = System.nanoTime();

        for(Pokemon enemigo : hordaEnemigos){



            Pokemon pokemonActual = cola.peek().getFaseActual();



            LineaEvolutiva linea = cola.peek();

            int contador = 0;
            int vidaEnemigo = enemigo.getPuntosVidaMax();
            int vidaPokemonActual = pokemonActual.getPuntosVidaMax();



            while (vidaEnemigo >0){

                contador++;

                int danoInflingido = max(1, pokemonActual.getAtaque() - enemigo.getDefensa());

                vidaEnemigo -= danoInflingido;

                if(vidaEnemigo < 0){
                    vidaEnemigo = 0;
                }

                mensajeBatalla += "\n" +"Turno "+ contador +" "+ linea.getFaseActual().getNombre()  + " ataca. Daño = " + danoInflingido +". "+ enemigo.getNombre() + " queda con " + vidaEnemigo;

                contador++;



                if(vidaEnemigo > 0){

                    int danoRecibido = max(1, enemigo.getAtaque() - pokemonActual.getDefensa());

                    vidaPokemonActual -= danoRecibido;

                    mensajeBatalla +="\n" +"Turno "+ contador + " "+ enemigo.getNombre() + " ataca. Daño = " + danoRecibido +". "+ linea.getFaseActual().getNombre()  + " queda con " + vidaPokemonActual;

                }

            }

            c++;

            if (c > 50){

                c = 0;

                LineaEvolutiva lineaTerminada = cola.poll();

                lineaTerminada.mecanismoEvolucion(50);

                cola.offer(lineaTerminada);

            }

            linea.mecanismoEvolucion(50);

            mensajeBatalla += "\n" + linea.getFaseActual().getNombre() + " Gana\n";

        }

        long endTime = System.nanoTime();

        mensajeTiempo = "\n" + "Tiempo de ejecucion " + (endTime-startTime) + "ns";

        log.info(mensajeTiempo);

        return mensajeBatalla;

    }
}
