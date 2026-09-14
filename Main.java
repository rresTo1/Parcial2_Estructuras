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
    public static void main(String[] args) {

        Pokemon Charmander = new Pokemon("Charmander", 39,52, 43, 2500);
        Pokemon Charmeleon = new Pokemon("Charmeleon", 58,64, 58, 5000);
        Pokemon Charizard = new Pokemon("Charizard", 78,84, 78, -1);

        LineaEvolutiva miPokemon1 = new LineaEvolutiva();

        miPokemon1.agregarPokemon(Charizard);
        miPokemon1.agregarPokemon(Charmeleon);
        miPokemon1.agregarPokemon(Charmander);

        System.out.println(miPokemon1);

        Pokemon Bulbasaur = new Pokemon("Bulbasaur", 45,49, 49, 2500);
        Pokemon Ivisaur = new Pokemon("Ivisaur", 60,62, 63, 5000);
        Pokemon Venusaur = new Pokemon("Venusaur", 80,82, 83, -1);

        LineaEvolutiva miPokemon2 = new LineaEvolutiva();

        miPokemon2.agregarPokemon(Venusaur);
        miPokemon2.agregarPokemon(Ivisaur);
        miPokemon2.agregarPokemon(Bulbasaur);

        System.out.println(miPokemon2);

        Pokemon Squirtle = new Pokemon("Squirtle", 44,48, 65, 2500);
        Pokemon Wartortle = new Pokemon("Wartortle", 59,63, 80, 5000);
        Pokemon Blastoise = new Pokemon("Blastoise", 79,83, 100, -1);

        LineaEvolutiva miPokemon3 = new LineaEvolutiva();

        miPokemon3.agregarPokemon(Blastoise);
        miPokemon3.agregarPokemon(Wartortle);
        miPokemon3.agregarPokemon(Squirtle);

        System.out.println(miPokemon3);

        Queue <LineaEvolutiva> equipoPokemon = new LinkedList<>();

        equipoPokemon.add(miPokemon2);
        equipoPokemon.add(miPokemon1);
        equipoPokemon.add(miPokemon3);

        System.out.println(equipoPokemon);

        ServicioSimulacion servicio = new ServicioSimulacion();


        Pokemon [] enemigos = servicio.crearHorda(250,"Caterpie",45,30,35,0);

        String resultadosBatallas = servicio.iniciarEntrenamientoMasivo(equipoPokemon,enemigos,50);

        System.out.println(resultadosBatallas);


        PerformanceReporter.medirPesoObjeto(miPokemon1, "miPokemon");

        PerformanceReporter.reportarMemoriaSistema();


    }
}