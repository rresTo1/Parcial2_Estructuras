package org.example;

import lombok.extern.log4j.Log4j2;
import org.example.Model.LineaEvolutiva;
import org.example.Model.Pokemon;
import org.example.Service.ServicioSimulacion;
import org.example.Util.PerformanceReporter;

import java.util.LinkedList;
import java.util.Queue;


@Log4j2
public class Main {


    static void main(String[] args) {
        Pokemon Charmander = new Pokemon("Charmander", 39,52, 43, 1500);
        Pokemon Charmeleon = new Pokemon("Charmeleon", 58,64, 58, 5000);
        Pokemon Charizard = new Pokemon("Charizard", 78,84, 78, -1);

        LineaEvolutiva miPokemon = new LineaEvolutiva(Charmander, Charmeleon, Charizard);

        Pokemon Balbasaur = new Pokemon("Balbasaur", 39,52, 43, 1500);
        Pokemon Balbasaur2 = new Pokemon("Balbasaur2", 58,64, 58, 5000);
        Pokemon Balbasaur3 = new Pokemon("Balbasaur3", 78,84, 78, -1);

        LineaEvolutiva miPokemon2 = new LineaEvolutiva(Balbasaur, Balbasaur2, Balbasaur3);

        Pokemon Squirtle = new Pokemon("Squirtle", 39,52, 43, 1500);
        Pokemon Squirtle2 = new Pokemon("Squirtle2", 58,64, 58, 5000);
        Pokemon Squirtle3 = new Pokemon("Squirtle3", 78,84, 78, -1);

        LineaEvolutiva miPokemon3 = new LineaEvolutiva(Squirtle, Squirtle2, Squirtle3);

        Queue<LineaEvolutiva> cola = new LinkedList<>();

        cola.add(miPokemon);
        cola.add(miPokemon2);
        cola.add(miPokemon3);


        ServicioSimulacion servicio = new ServicioSimulacion();

        Pokemon[] horda = servicio.crearHorda(460);


        String resultado = servicio.iniciarEntrenamientoMasivo(cola, horda);

        System.out.println(resultado);
        System.out.println("Experiencia acumulada: " + miPokemon.getExpAcumulada());


        LineaEvolutiva lista = new LineaEvolutiva(Charmander, Charmeleon, Charizard);
        lista = new LineaEvolutiva(Charmander, Charmeleon, Charizard);

        PerformanceReporter.medirPesoObjeto(miPokemon, "miPokemon");

        PerformanceReporter.reportarMemoriaSistema();

    }
}