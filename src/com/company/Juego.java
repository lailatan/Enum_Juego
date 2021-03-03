package com.company;

import java.util.List;

public class Juego {
    private List<Personaje> personajes;
    private Dificultad dificultad;
    private Integer cantidadJugadores;
    private String ganador="";
    private Integer movidasTotalesGanador=0;

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

    public Integer getCantidadJugadores() {
        return cantidadJugadores;
    }

    public String getGanador() {
        return ganador;
    }

    public Integer getMovidasTotalesGanador() {
        return movidasTotalesGanador;
    }

    public void jugar() {
        Boolean hayUnGanador=false;
        ganador = "";
        movidasTotalesGanador=0;
        while (!hayUnGanador){
            movidasTotalesGanador++;
            for (Personaje p:personajes) {
                hayUnGanador = p.jugar();
                if (hayUnGanador) {
                    ganador=p.getNombre();
                    break;
                }
            }
        }
    }


    public void mostrarTablaResultados() {
        for (Personaje p :personajes)
            System.out.printf("%-20s",p.getNombre());
        System.out.println();
        for (int i=0;i<movidasTotalesGanador;i++){
            for (Personaje p :personajes) {
                System.out.printf("%-20s", p.getJugadas().get(i));
                if (p.getNombre()==ganador && i==movidasTotalesGanador-1) break;;
            }
            System.out.println();
        }
        System.out.println();

        mostrarRanking();
    }

    private void mostrarRanking() {
        System.out.println("GANADOR= " + ganador + " en " + movidasTotalesGanador + " movidas");
        System.out.println("");
        for (Personaje p :personajes)
            System.out.println(p.getNombre() + " " + p.getColor() + " " + p.faltaParaLaMeta());
    }
}
