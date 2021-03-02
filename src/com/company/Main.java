package com.company;

import java.util.ArrayList;
import java.util.List;

/*
Crear un sistema que permita iniciar un juego con cuatro personajes y la dificultad de la partida.

Cada personaje debe tener un nombre y un color de equipo.
Los equipos son: ROJO, AZUL, AMARILLO y NEGRO.

Cuando comienza el juego, los equipos rojo y azul están en la posición 100 y los equipos amarillo y negro están en la posición cero.

La meta de los equipos rojo y azul es llegar a la casa de los equipos amarillo y negro.

La meta de los equipos amarillo y negro es llegar a la casa de los equipos rojo y azul.

Cada equipo avanza 1 vez por turno a un paso aleatorio entre 1 y 5.

Se debe llevar la cuenta de cuántos movimientos hace cada equipo.

El juego finaliza cuando un equipo alcanza su meta.

Se debe informar el paso a paso y al finalizar, una tabla de posiciones, ordenada por cantidad de pasos.


 */
public class Main {

    public static void main(String[] args) {
        List<Personaje> jugadores = new ArrayList<>();
        jugadores.add(new Personaje("Jugador 1",Equipo.AMARILLO));
        jugadores.add(new Personaje("Jugador 2",Equipo.NEGRO));
        jugadores.add(new Personaje("Jugador 3",Equipo.ROJO));
        jugadores.add(new Personaje("Jugador 4",Equipo.AZUL));

        Juego juego = new Juego(jugadores,Dificultad.MEDIA);

        String ganador= juego.Jugar();
        System.out.println(ganador);
        juego.MostrarTablaResultados();
    }
}
