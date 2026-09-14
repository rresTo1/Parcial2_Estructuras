package org.example.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Model.LineaEvolutiva;
import org.example.Model.Pokemon;
import org.example.Model.ReporteBatalla;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ServicioSimulacion {

   private static final Logger log = LogManager.getLogger("tiempos");
   private static final Logger logCaja = LogManager.getLogger("cajaNegra");

    public Pokemon[] crearHorda(int cantidadEnemigos, String nombreEnemigo, int vidaEnemigo,int ataqueEnemigo,int defensaEnemigo,int expRequeridaE )
    {
        Pokemon [] hordaEnemigos = new Pokemon[cantidadEnemigos];

        for(int i=0;i<hordaEnemigos.length; i++)
        {
            hordaEnemigos[i] = new Pokemon(nombreEnemigo,vidaEnemigo,ataqueEnemigo,defensaEnemigo,expRequeridaE);
        }

        return hordaEnemigos;

    }

    public String iniciarEntrenamientoMasivo(Queue<LineaEvolutiva> miPokemon, Pokemon[] hordaEnemigos, int turnoCampo) {

        LinkedList<ReporteBatalla> cajaNegra = new LinkedList<>();

        // Para poder sacar de a 50
        int turnosEnemigo = 0;

        // mensajeBatalla de pelea
        String mensajeBatalla = "";

        // mensajeTiempo de logs
        String mensajeTiempo = "";


        String mensajeCaja = "";

        long startTime = System.nanoTime();

        while (turnosEnemigo < hordaEnemigos.length) {



            int inicio = turnosEnemigo;

            int fin = min(inicio + turnoCampo, hordaEnemigos.length);

            // lineaPrueba para extraer de la cola cada lista de pokemon y como evoluciona
            LineaEvolutiva lineaPrueba = miPokemon.poll();



            for (int i = inicio; i< fin; i++) {

                Pokemon pokemonEnemigo = hordaEnemigos[i];

                // contador para los turnos de pelea individuales
                int contador = 0;

                // pokemonPrueba para extraer de la lista el pokemon que pelea
                Pokemon pokemonPrueba = lineaPrueba.getFaseActual();

                // pokemonActaul es el pokemon prueba puede ser redundante pero por seguridad
                Pokemon pokemonActual = pokemonPrueba;

                // vidaEnemigos de la horda
                int vidaEnemigo = pokemonEnemigo.getPuntosVidaMax();

                // vida de mi pokemon
                int vidaPokemonActual = pokemonActual.getPuntosVidaMax();

                while (vidaEnemigo > 0) {

                    contador++;

                    int danoInflingido = max(1, pokemonActual.getAtaque() - pokemonEnemigo.getDefensa());

                    vidaEnemigo -= danoInflingido;

                    if (vidaEnemigo < 0 || vidaEnemigo== 0) {
                        vidaEnemigo = 0;

                        registrarPeleas(cajaNegra, lineaPrueba.getFaseActual().getNombre(), pokemonEnemigo.getNombre());
                    }

                    mensajeBatalla += "\n" + "Turno " + contador + " " + lineaPrueba.getFaseActual().getNombre() + " ataca. Dano = " + danoInflingido + ". " + pokemonEnemigo.getNombre() + " queda con " + vidaEnemigo;

                    contador++;

                    if (vidaEnemigo > 0) {

                        int danoRecibido = max(1, pokemonEnemigo.getAtaque() - pokemonActual.getDefensa());

                        vidaPokemonActual -= danoRecibido;

                        mensajeBatalla += "\n" + "Turno " + contador + " " + pokemonEnemigo.getNombre() + " ataca. Dano = " + danoRecibido + ". " + lineaPrueba.getFaseActual().getNombre() + " queda con " + vidaPokemonActual;

                    }

                }


                lineaPrueba.mecanismoEvolucion(50);

                mensajeBatalla += "\n" + lineaPrueba.getFaseActual().getNombre() + " Gana\n";

            }

            logCaja.info(cajaNegra);

            miPokemon.add(lineaPrueba);

            turnosEnemigo = fin;


        }


        long endTime = System.nanoTime();

        mensajeTiempo = "\n" + "Tiempo de ejecucion " + (endTime-startTime) + "ns";

        log.info(mensajeTiempo);

        return mensajeBatalla;


    }

    public static void registrarPeleas(LinkedList<ReporteBatalla> cajaNegra, String nombrePokemon, String nombreEnemigo) {


        if(!cajaNegra.isEmpty()){
            ReporteBatalla ultimo = cajaNegra.getLast();

            if (ultimo.getNombrePokemon().equals(nombrePokemon) && ultimo.getNombreEnemigo().equals(nombreEnemigo)){

                ultimo.sumarDerrotados();


                return;
            }
        }

        if (cajaNegra.size() >= 3){
            cajaNegra.removeFirst();
        }



        cajaNegra.add(new ReporteBatalla(nombrePokemon, nombreEnemigo, 1));



    }


}