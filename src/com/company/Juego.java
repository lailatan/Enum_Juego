package com.company;

import java.util.*;

public class Juego {
    private Scanner scanner = new Scanner(System.in);;
    private List<Personaje> personajes;
    private Dificultad dificultad;
    private Integer cantidadJugadores=0;
    private String ganador="";
    private Integer movidasTotalesGanador=0;

    public Juego( Dificultad dificultad) {
        this.personajes = new ArrayList<>();
        this.dificultad = dificultad;
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

    public void iniciar() {
        String nombre;
        Equipo equipo;
        System.out.println("Bienvenido al juego 1 al 100");
        System.out.println("Se puede jugar de a 2, 3 o 4.");

        do {
            System.out.print("Ingrese la cantidad de jugadores: ");
            cantidadJugadores = Integer.parseInt(scanner.nextLine());
            if (cantidadJugadores<2 || cantidadJugadores>4) System.out.println("Cantidad inválida.");
        } while (cantidadJugadores<2 || cantidadJugadores>4);

        for (int i = 0; i < cantidadJugadores; i++) {
            System.out.print("Indique el nombre del jugador #" + (i+1) + ": ");
            nombre = scanner.nextLine();
            equipo = Equipo.values()[i];
            personajes.add(new Personaje(nombre, equipo));
            System.out.println(nombre + " tiene el color " + equipo + ".");
        }
    }

    public void jugar() {
        Boolean hayUnGanador=false;
        ganador = "";
        movidasTotalesGanador=0;

        iniciar();
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
        System.out.printf("%-10s","Turno");
        String separador= "--------- ";
        for (Personaje p :personajes) {
            System.out.printf("%-20s", p.getNombre());
            separador+="------------------- ";
        }
        System.out.println();
        System.out.println(separador);
        for (int i=0;i<movidasTotalesGanador;i++){
            System.out.printf("%-10s","#" + (i+1));
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
        Integer i =0;
        Double posicionEmpate = 0.1;
        TreeMap<Double, Personaje> tablaDePosiciones = new TreeMap<>();
        for(Personaje jugador : personajes){
            Double key= jugador.faltaParaLaMeta().doubleValue();
            //Para que admita posiciones repetidas
            if (tablaDePosiciones.containsKey(key)) {
                tablaDePosiciones.put(key + posicionEmpate, jugador);
                posicionEmpate+=0.1;
            }
            else tablaDePosiciones.put(key, jugador);
        }
        //System.out.println(tablaDePosiciones);
        System.out.println("GANADOR= " + ganador + " en " + movidasTotalesGanador + " movidas");
        System.out.println("");
        System.out.println("Tabla de posiciones");
        System.out.println("___________________");

        Iterator iterador = tablaDePosiciones.keySet().iterator();
        while(iterador.hasNext()){
            Double key = (Double) iterador.next();
            Personaje jugador = tablaDePosiciones.get(key);
            if (key-jugador.faltaParaLaMeta()==0) i++;
                System.out.println("#" + i + ": " + jugador.getNombre() + " ("
                        + jugador.getColor() + ") - Pasos Faltantes: " + jugador.faltaParaLaMeta());
        }
    }
}
