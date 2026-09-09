package org.example;

import lombok.extern.log4j.Log4j2;
import org.example.Model.LineaEvolutiva;
import org.example.Model.Pokemon;
import org.example.Service.ServicioSimulacion;
import org.example.Util.PerformanceReporter;

@Log4j2
public class Main {
    static void main(String[] args) {
        LineaEvolutiva miPokemon = new LineaEvolutiva();


        ServicioSimulacion servicio = new ServicioSimulacion();

        Pokemon[] horda = servicio.crearHorda(100_000);

        System.out.println("Pokemon inicial: " + miPokemon.getFaseActual().getNombre());

        String resultado = servicio.iniciarEntrenamientoMasivo(miPokemon, horda);

        System.out.println(resultado);
        System.out.println("\nPokemon final: " + miPokemon.getFaseActual().getNombre());
        System.out.println("Experiencia acumulada: " + miPokemon.getExpAcumulada());

        LineaEvolutiva lista = new LineaEvolutiva();
        lista = new LineaEvolutiva();
        System.out.println("\n Linea Evolutiva = \n"+lista);

        PerformanceReporter.medirPesoObjeto(miPokemon, "miPokemon");
        PerformanceReporter.medirPesoObjeto(lista, "lineaEvolutiva");

        PerformanceReporter.reportarMemoriaSistema();

    }
}