package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Personaje {
    private String nombre;
    private Equipo color;
    private List<Integer> jugadas;
    private Integer posicion;
    private Integer meta;
    private Integer movimientos;

    public Personaje(String nombre, Equipo color) {
        this.nombre = nombre;
        this.color = color;
        movimientos=0;
        jugadas = new ArrayList<>();
        switch (color){
            case AZUL: case ROJO:
                posicion = 100;
                meta=0;
                break;
            case NEGRO: case AMARILLO:
                posicion = 0;
                meta=100;
                break;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Equipo getColor() {
        return color;
    }

    public List<Integer> getJugadas() {
        return jugadas;
    }

    public Boolean llegoALaMeta(){
        return (meta==0)?posicion<=meta:posicion>=meta;
    }

    public Boolean jugar(){
        Random random = new Random();
        int movimientos = random.nextInt(4)+1;
        posicion=(meta==0)?posicion-movimientos:posicion+movimientos;
        jugadas.add(posicion);
        return llegoALaMeta();
    }

    public Integer faltaParaLaMeta(){
        if (llegoALaMeta()) return 0;
        else return Math.abs(meta-posicion);
    }
}
