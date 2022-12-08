package Servicios;

import Entidades.Ahorcado;

import java.util.Scanner;

public class AhorcadoServicios {

    Ahorcado a1 = new Ahorcado();
    Scanner sc = new Scanner(System.in);
    String[] vectorPalabraOculta;
    String[] vectorLetrasEncontradas;
    String palabraOcultaString;
    String letrasEquivocadas = " ";
    int cantLetrasEncontradas = 0;

    String[] palabrasNivelFacil = {"solo", "via", "amor", "paz", "luna", "luz", "sol", "mes", "lana", "loco", "java"};
    String[] palabrasNivelMedio = {"soldado", "pintura", "ciclo", "mundo", "verdad", "dinero", "salud"};
    String[] palabrasNivelDificil = {"celular", "bateria", "bacteria", "enfermedad", "felicidad", "creatividad", "compromiso"};

    public Ahorcado crearJuego() {
        System.out.println("Ingresa la dificulad ");
        System.out.println("1. Facil");
        System.out.println("2. Intermedio");
        System.out.println("3. Difícil");
        int dificultad = sc.nextInt();

        while (dificultad < 1 || dificultad > 3) {
            System.out.println("Ingresa un número válido");
            System.out.println("1. Facil");
            System.out.println("2. Intermedio");
            System.out.println("3. Difícil");
            dificultad = sc.nextInt();
        }

        switch (dificultad) {
            case 1:
                palabraOcultaString = palabrasNivelFacil[(int) (Math.random() * palabrasNivelFacil.length)];
            case 2:
                palabraOcultaString = palabrasNivelMedio[(int) (Math.random() * palabrasNivelMedio.length)];
            case 3:
                palabraOcultaString = palabrasNivelDificil[(int) (Math.random() * palabrasNivelDificil.length)];
            default:
        }

        a1.setTamPalabraOculta(palabraOcultaString.length());
        vectorPalabraOculta = new String[a1.getTamPalabraOculta()];
        for (int i = 0; i < vectorPalabraOculta.length; i++) {
            vectorPalabraOculta[i] = String.valueOf(palabraOcultaString.charAt(i));
        }

        a1.setPalabraOculta(vectorPalabraOculta);

        a1.setCantidadIntentosMax(7);
        System.out.println("La cantidad de intentos que tienes es " + a1.getCantidadIntentosMax());

        a1.setLetrasEncontradas(0);

        System.out.println("Palabra Oculta");

        vectorLetrasEncontradas = new String[a1.getTamPalabraOculta()];

        for (int i = 0; i < vectorPalabraOculta.length; i++) {
            vectorLetrasEncontradas[i] = " _ ";
            System.out.print(vectorLetrasEncontradas[i]);
        }
        System.out.println();

        return a1;
    }

    public void longitud() {

        a1.setTamPalabraOculta(vectorPalabraOculta.length);

        System.out.println("La longitud de la palabra es " + a1.getTamPalabraOculta());

    }

    public void buscar() {

        System.out.println("Ingresa la letra que crees que pertenece a la palabra oculta");
        a1.setLetraIngresada(sc.next());

        while (a1.getLetraIngresada().length() > 1) {
            System.out.println("Dato incorrecto, solo debes ingresar una letra. Inténtalo de nuevo");
            a1.setLetraIngresada(sc.next());
        }

        boolean letraEncontrada = false;

        for (int i = 0; i < vectorPalabraOculta.length; i++) {

            if (vectorPalabraOculta[i].equalsIgnoreCase(a1.getLetraIngresada())) {
                letraEncontrada = true;
            }
        }

        if (letrasEquivocadas.contains(a1.getLetraIngresada())) {

            System.out.println("La letra " + a1.getLetraIngresada() + " ya fue ingresada");
        }

        if (letraEncontrada) {
            System.out.println("La letra ingresada es parte de la palabra oculta");
        } else if (!letrasEquivocadas.contains(a1.getLetraIngresada()) && !letraEncontrada) {
            System.out.println("La letra ingresada no es parte de la palabra oculta");
            a1.setCantidadIntentosMax(a1.getCantidadIntentosMax() - 1);
            letrasEquivocadas = letrasEquivocadas.concat(a1.getLetraIngresada() + "  ");
        }

    }

    public boolean encontradas() {

        boolean encontradas = false;

        System.out.println("\nPalabra oculta con letras encontradas");

        for (int i = 0; i < vectorPalabraOculta.length; i++) {

            if (vectorLetrasEncontradas[i].equalsIgnoreCase(" " + a1.getLetraIngresada() + " ")) {
                System.out.println("La letra " + a1.getLetraIngresada() + "ya había sido ingresada");
            } else if (vectorPalabraOculta[i].equalsIgnoreCase(a1.getLetraIngresada())) {
                vectorLetrasEncontradas[i] = " " + a1.getLetraIngresada() + " ";
                cantLetrasEncontradas += 1;
                encontradas = true;
            }

            System.out.print(vectorLetrasEncontradas[i]);
        }
        System.out.println();

        System.out.println("\nLetras equivocadas");
        System.out.println(letrasEquivocadas);

        System.out.println();

        a1.setLetrasEncontradas(cantLetrasEncontradas);
        int cantLetrasRestantes = a1.getTamPalabraOculta() - a1.getLetrasEncontradas();

        System.out.println("La cantidad de letras encontradas es " + cantLetrasEncontradas);

        System.out.println("La cantidad de letras que faltan por ser encontradas es " + cantLetrasRestantes);

        return encontradas;

    }

    public void intentos() {

        System.out.println("La cantidad de intentos que te quedan es " + a1.getCantidadIntentosMax());

    }

    public void juego() {

        crearJuego();


        do {

            buscar();
            longitud();
            encontradas();
            intentos();

        } while (a1.getCantidadIntentosMax() != 0 && cantLetrasEncontradas != a1.getTamPalabraOculta());

        if (cantLetrasEncontradas == a1.getTamPalabraOculta()) {
            System.out.println("Felicitaciones, has encontrado la palabra oculta que siempre fue '" + palabraOcultaString.toUpperCase() + "'");
        } else {
            System.out.println("Qué mal! No has logrado adivinar la palabra ocultaque siempre fue '" + palabraOcultaString.toUpperCase() + "'. Suerte en la próxima");
        }


    }

}
