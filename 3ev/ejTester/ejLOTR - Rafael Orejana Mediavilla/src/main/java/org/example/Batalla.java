package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Batalla {
    // Métodos
    private int eleccionBando(){
        Scanner sc = new Scanner(System.in);
        int eleccionBando = 0;
        do {
            System.out.println("Elige con qué bando deseas jugar:" +
                    "\n1. Luz " +
                    "\n2. Oscuridad\n");

            try {
                eleccionBando = Integer.parseInt(sc.nextLine());
                if (eleccionBando != 1 && eleccionBando != 2) {
                    throw new Exception("Número inválido\n");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }while(eleccionBando != 1 && eleccionBando != 2);
        return eleccionBando;
    }

    private int menuAcciones(Personaje p){
        Scanner sc = new Scanner(System.in);
        int accionJugador = 0;

        do {
            if (p instanceof Mago && p.getVida() < 90) {
                System.out.println("\n¿Qué acción quieres realizar?" +
                        "\n1. Atacar" +
                        "\n2. Defender" +
                        "\n3. Curarse" +
                        "\n4. Salir del juego\n");
            } else {
                System.out.println("\n¿Qué acción quieres realizar?" +
                        "\n1. Atacar" +
                        "\n2. Defender" +
                        "\n4. Salir del juego\n");
            }
            try {
                accionJugador = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.err.println("Introduzca una opción válida.\n");
            }
        }while(accionJugador<1 && accionJugador>4);
        return accionJugador;
    }

    private int eleccionPosicionArray(Personaje[] lista){
        Scanner sc = new Scanner(System.in);
        int eleccion = 0;
        System.out.println("\n¿Con qué personaje quieres jugar?");
        // En función del bando muestras una lista de los personajes
        for(int i=0;i<lista.length;i++){
            System.out.println();
            System.out.println((i+1) + ". " + lista[i].getNombre() + ": " +
             "\nVida:       " + lista[i].getVida() + "\nAtaque:     " + lista[i].getAtaque() + "\nDefensa:    "
                    + lista[i].getDefensa() + "\nClase:      " + lista[i].getClass().getSimpleName());
        }
        do {
            try {
                eleccion = sc.nextInt();
                if (eleccion < 1 || eleccion > 4) {
                    throw new ArrayIndexOutOfBoundsException("Debe elegir un número entre 1 y 4.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            } catch (InputMismatchException e){
                System.err.println("Por favor, introduzca un número entre 1 y 4.");
            }finally {
                sc.nextLine();
            }
        }while(eleccion < 1 || eleccion > 4);
        // No se contempla en este punto si el personaje elegido está vivo o muerto
        return (eleccion-1);
    }

    private Personaje eleccionCampeonJugador(boolean esLuz, Personaje []luz, Personaje []oscuridad){
        Personaje campeonJugador;
        int posicionArrayJugador;
        boolean estaMuerto;

        do {
            estaMuerto = false;
            // Elección de personaje
            if(esLuz) {
                posicionArrayJugador = eleccionPosicionArray(luz);
                if (luz[posicionArrayJugador].isDead()) {  // Se valida si el personaje está vivo
                    System.out.println("El personaje que intentas escoger está muerto, elige otro por favor.");
                    estaMuerto = true;
                }
            }else{
                posicionArrayJugador = eleccionPosicionArray(oscuridad);
                if (oscuridad[posicionArrayJugador].isDead()) {    // Se valida si el personaje está vivo
                    System.out.println("El personaje que intentas escoger está muerto, elige otro por favor.");
                    estaMuerto = true;
                }
            }
        } while (estaMuerto);

        if (esLuz) {
            campeonJugador = luz[posicionArrayJugador];
        } else {
            campeonJugador = oscuridad[posicionArrayJugador];
        }
        return campeonJugador;
    }

    private Personaje elegirEnfrentamientoEnemigo(boolean esluz, Personaje []luz, Personaje []oscuridad){
        Random r = new Random();
        Personaje p;
        // Si el jugador elige la luz, el adversario jugará con oscuridad y viceversa
        if(esluz){
            do {
                p = oscuridad[r.nextInt(0, 4)];
            }while (p.isDead());
        }else{
            do {
                p = luz[r.nextInt(0, 4)];
            }while (p.isDead());
        }
        return p;
    }

        private int accionEnemigo(Personaje enemigo){
        Random r = new Random();
        int accionEnemigo;
        if(enemigo instanceof Mago && enemigo.getVida()<90){
            accionEnemigo = r.nextInt(1,4);
        }else{
            accionEnemigo = r.nextInt(1,3);
        }
        return accionEnemigo;
    }

    private void funcionAtaque(int accionEnemigo, Personaje jugador, Personaje enemigo) throws Exception {

        switch (accionEnemigo){
            case 1:
                int ataqueE = enemigo.atacar();
                jugador.setVida(jugador.getVida() - ataqueE);
                if(jugador.isDead()){
                    System.out.println(enemigo.getNombre() + " ha hecho " + ataqueE + " puntos de daño, y ha matado a " + jugador.getNombre()+".");
                    jugador.setVida(0);
                }else {
                    System.out.println(enemigo.getNombre() + " ha hecho " + ataqueE + " puntos de daño, " + jugador.getNombre() + " tiene " + jugador.getVida() + " puntos de vida.");
                    int ataqueJ = jugador.atacar();
                    enemigo.setVida(enemigo.getVida() - ataqueJ);
                    if(enemigo.isDead()){
                        System.out.println(jugador.getNombre() + " ha hecho " + ataqueJ + " puntos de daño, y ha matado a " + enemigo.getNombre()+".");
                        enemigo.setVida(0);
                    }else{
                        System.out.println(jugador.getNombre() + " ha hecho " + ataqueJ + " puntos de daño, " + enemigo.getNombre() + " tiene " + enemigo.getVida() + " puntos de vida.");
                    }
                }
                break;
            case 2:
                int defensaE = enemigo.defender();
                int ataqueJ = jugador.atacar();
                if(defensaE>=ataqueJ){
                    System.out.println(enemigo.getNombre() + " se ha defendido este turno y no ha recibido daño.");
                }else{
                    enemigo.setVida(enemigo.getVida() - (ataqueJ - defensaE));
                    if(enemigo.isDead()){
                        System.out.println(jugador.getNombre() + " ha hecho " + ataqueJ + " puntos de daño, y ha matado a " + enemigo.getNombre()+".");
                        enemigo.setVida(0);
                    }else {
                        System.out.println(jugador.getNombre() + " ha atacado con " + ataqueJ + " puntos y " + enemigo.getNombre() + " se ha defendido con " + defensaE + " puntos. La vida de " +
                                enemigo.getNombre() + " es de " + enemigo.getVida()+".");
                    }
                }
                break;
            case 3:
                ataqueJ = jugador.atacar();
                if(enemigo instanceof Mago && enemigo.getVida()<90){
                    enemigo.setVida(enemigo.getVida() - ataqueJ);
                    if(enemigo.isDead()){
                        System.out.println(jugador.getNombre() + " ha hecho " + ataqueJ + " puntos de daño, y ha matado a " + enemigo.getNombre()+".");
                        enemigo.setVida(0);
                    }else {
                        System.out.println(jugador.getNombre() + " ha hecho " + ataqueJ + " puntos de daño, " + enemigo.getNombre() + " tiene " + enemigo.getVida() + " puntos de vida.");
                        int curaE = ((Mago) enemigo).curacion();
                        System.out.println(enemigo.getNombre() + " ha decidido curarse.");
                        enemigo.setVida(enemigo.getVida() + curaE);
                        if (curaE > 0) {
                            System.out.println(enemigo.getNombre() + " se ha curado 10 puntos de salud y ahora tiene " + enemigo.getVida() + " puntos de vida.");
                        } else {
                            System.out.println("La curación de " + enemigo.getNombre() + " ha fallado.");
                        }
                    }
                }
                break;
        }
    }

    private void funcionDefensa(Personaje jugador, Personaje enemigo){  // Obligo al enemigo a atacar
        int defensaJ = jugador.defender();
        int ataqueE = enemigo.atacar();
        if(defensaJ>=ataqueE){
            System.out.println(jugador.getNombre() + " se ha defendido este turno y no ha recibido daño.");
        }else{
            jugador.setVida(jugador.getVida() - (ataqueE - defensaJ));
            System.out.println(jugador.getNombre() + " se ha defendido con " + defensaJ + " puntos.");
            if(jugador.isDead()){
                System.out.println(enemigo.getNombre() + " ha hecho " + ataqueE + " puntos de daño, y ha matado a " + jugador.getNombre()+".");
                jugador.setVida(0);
            }else {
                System.out.println(enemigo.getNombre() + " ha hecho " + ataqueE + " puntos de daño, " + jugador.getNombre() + " tiene " + jugador.getVida() + " puntos de vida.");
            }
        }
    }

    private void funcionCuracion(int accionEnemigo, Personaje jugador, Personaje enemigo) throws Exception {
        if(jugador instanceof Mago) {
            try {
                int curaJ = ((Mago) jugador).curacion();
                switch (accionEnemigo) {
                    case 1:
                        int ataqueE = enemigo.atacar();
                        jugador.setVida(jugador.getVida() - ataqueE);
                        if (jugador.isDead()) {
                            System.out.println(enemigo.getNombre() + " ha hecho " + ataqueE + " puntos de daño, y ha matado a " + jugador.getNombre() + ".");
                            jugador.setVida(0);
                        } else {
                            System.out.println(enemigo.getNombre() + " ha hecho " + ataqueE + " puntos de daño, " + jugador.getNombre() + " tiene " + jugador.getVida() + " puntos de vida.");
                            jugador.setVida(jugador.getVida() + curaJ);
                            if (curaJ > 0) {
                                System.out.println(jugador.getNombre() + " se ha curado 10 puntos de salud y ahora tiene " + jugador.getVida() + " puntos de vida.");
                            } else {
                                System.out.println("La curación de " + jugador.getNombre() + " ha fallado.");
                            }
                        }
                        break;
                    case 2:
                        System.out.println(enemigo.getNombre() + " se ha defendido este turno.");
                        jugador.setVida(jugador.getVida() + curaJ);
                        if (curaJ > 0) {
                            System.out.println(jugador.getNombre() + " se ha curado 10 puntos de salud y ahora tiene " + jugador.getVida() + " puntos de vida.");
                        } else {
                            System.out.println("La curación de " + jugador.getNombre() + " ha fallado.");
                        }
                        break;
                    case 3:
                        if (enemigo instanceof Mago) {
                            int curaE = ((Mago) enemigo).curacion();
                            System.out.println(enemigo.getNombre() + " ha decidido curarse.");
                            enemigo.setVida(enemigo.getVida() + curaE);
                            if (curaE > 0) {
                                System.out.println(enemigo.getNombre() + " se ha curado 10 puntos de salud y ahora tiene " + enemigo.getVida() + " puntos de vida.");
                            } else {
                                System.out.println("La curación de " + enemigo.getNombre() + " ha fallado.");
                            }
                            jugador.setVida(jugador.getVida() + curaJ);
                            if (curaJ > 0) {
                                System.out.println(jugador.getNombre() + " se ha curado 10 puntos de salud y ahora tiene " + jugador.getVida() + " puntos de vida.");
                            } else {
                                System.out.println("La curación de " + jugador.getNombre() + " ha fallado.");
                            }
                        }
                        break;
                }
            }catch (Exception e){   // Capturo la excepción
                System.err.println(e.getMessage());
            }
        }
    }

    private boolean hayPerdedor(Personaje []lista){
        boolean equipoDerrotado = false;
        int contadorMuertos = 0;

        for(int i =0;i<lista.length;i++){
            if(lista[i].isDead()){
                contadorMuertos++;
            }
        }

        // Si el número de muertos es igual a la longitud del array, ese equipo ha perdido
        if(contadorMuertos==lista.length){
            equipoDerrotado = true;
        }
        return equipoDerrotado;
    }


    // Programa principal
    public void juego() throws Exception {
        // Variables
        boolean esLuz, equipoDerrotado;
        Personaje campeonEnemigo, campeonJugador;
        int accionJugador, accionEnemigo, ganador;

        // Instancio los personajes
        Personaje Gandalf = new Mago(25, 10, 100, "Gandalf");
        Personaje Aragorn = new Guerrero(20, 20, 100, "Aragorn");
        Personaje Legolas = new Guerrero(15, 20, 100, "Legolas");
        Personaje Gimli = new Guerrero(15, 25, 100, "Gimli");

        Personaje Saruman = new Mago(25, 10, 100, "Saruman");
        Personaje Balrog = new Mago(30, 10, 100, "Balrog");
        Personaje Lurtz = new Guerrero(25, 15, 100, "Lurtz");
        Personaje Orco = new Guerrero(15, 5, 100, "Orco");

        // Meto a los personajes en sus arrays correspondientes
        Personaje []luz = {Gandalf, Aragorn, Legolas, Gimli};
        Personaje []oscuridad = {Saruman, Balrog, Lurtz, Orco};

        // Bienvenida
        System.out.println("\nTe doy la bienvenida al juego de la batalla del Señor de los Anillos.\n");

        // Elección de bando
        int eleccionBando = eleccionBando();
        esLuz = (eleccionBando == 1);

        // Elegir y mostrar el jugador
        campeonJugador = eleccionCampeonJugador(esLuz, luz, oscuridad);
        System.out.println("El jugador ha elegido a  " + campeonJugador.getNombre()+".");

        // Elegir y mostrar el enemigo
        campeonEnemigo = elegirEnfrentamientoEnemigo(esLuz, luz, oscuridad);
        System.out.println("El campeon enemigo es " + campeonEnemigo.getNombre()+".");

        // Combate 4v4
        do {
            // Combate 1v1
            do {
                ganador = 0;    // Se resetea el ganador para volver a realizar el bucle de pelea
                accionJugador = menuAcciones(campeonJugador);
                accionEnemigo = accionEnemigo(campeonEnemigo);

                switch (accionJugador) {
                    case 1:
                        funcionAtaque(accionEnemigo, campeonJugador, campeonEnemigo);
                        break;
                    case 2:
                        // En caso de elegir defenderte, el enemigo siempre ataca
                        funcionDefensa(campeonJugador, campeonEnemigo);
                        break;
                    case 3:
                        funcionCuracion(accionEnemigo, campeonJugador, campeonEnemigo);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa, gracias por jugar!");
                        ganador = 3;
                        break;
                    default:
                        System.out.println("No se reconoce su acción, por favor, elija una opción válida");
                }

                if (campeonEnemigo.isDead()) {
                    ganador = 1;
                } else if (campeonJugador.isDead()) {
                    ganador = 2;
                }

            } while (ganador == 0);

            // Se valida inmediatamente después del enfrentamiento si hay un ganador de la batalla 4v4
            equipoDerrotado = hayPerdedor(luz);
            if(equipoDerrotado){
                System.out.println("\nHA GANADO EL BANDO DE LA OSCURIDAD!");
                if(esLuz){
                    System.out.println("EL JUGADOR HA SIDO DERROTADO!");
                }else{
                    System.out.println("EL JUGADOR HA SALIDO VENCEDOR!");
                }
                break;
            }
            equipoDerrotado = hayPerdedor(oscuridad);
            if(equipoDerrotado){
                System.out.println("\nHA GANADO EL BANDO DE LA LUZ!");
                if(esLuz){
                    System.out.println("EL JUGADOR HA SALIDO VENCEDOR!");
                }else{
                    System.out.println("EL JUGADOR HA SIDO DERROTADO!");
                }
                break;
            }

            // Si no hay ganador de la batalla 4v4, se elige al nuevo contendiente en función de quién fuera derrotado en el 1v1
            if(ganador == 1){   // Método para que el enemigo elija a otro campeón
                campeonEnemigo = elegirEnfrentamientoEnemigo(esLuz, luz, oscuridad);
                System.out.println("El campeon enemigo es " + campeonEnemigo.getNombre()+".");
            }else if (ganador == 2){  // Método para que el jugador elija a otro campeón
                campeonJugador = eleccionCampeonJugador(esLuz, luz, oscuridad);
                System.out.println("El jugador ha elegido a  " + campeonJugador.getNombre()+".");
            }else{  // En caso de ganador == 3, se sale del juego
                equipoDerrotado = true;
            }

        }while(!equipoDerrotado);

    }

}
