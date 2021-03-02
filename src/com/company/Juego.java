package com.company;

import java.util.List;

public class Juego {
    private List<Personaje> personajes;
    private Dificultad dificultad;
    private Integer cantidadJugadores;
    private Integer topeCasillas=101;

    public Juego(List<Personaje> personajes, Dificultad dificultad) {
        this.personajes = personajes;
        this.dificultad = dificultad;

        //ValidarEquipos(); //valida jugadores >1 y que esten repartidos en 2 equipos

        cantidadJugadores=personajes.size();
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }


    public String Jugar() {
        Boolean hayUnGanador=false;
        String ganador = "";
        while (!hayUnGanador){
            for (Personaje p:personajes) {
                hayUnGanador = p.jugar();
                if (hayUnGanador) {
                    ganador=p.getNombre();
                    break;
                }
            }
        }
        return ganador;
    }


    public void MostrarTablaResultados() {
    }
}
