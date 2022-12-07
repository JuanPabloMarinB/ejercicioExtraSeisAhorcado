package Servicios;

import Entidades.Ahorcado;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.util.Scanner;

public class AhorcadoServicios {

    Ahorcado a1 = new Ahorcado();
    Scanner sc = new Scanner(System.in);
    String[] vectorPalabraOculta;
    String[] vectorLetrasEncontradas;
    int cantLetrasEncontradas = 0;

    public Ahorcado crearJuego() {

        System.out.println("Ingresa la palabra oculta");
        String palabraOcultaString = sc.next();
        a1.setTamPalabraOculta(palabraOcultaString.length());
        vectorPalabraOculta = new String[a1.getTamPalabraOculta()];
        for (int i = 0; i < vectorPalabraOculta.length; i++) {
            vectorPalabraOculta[i] = String.valueOf(palabraOcultaString.charAt(i));
        }

        a1.setPalabraOculta(vectorPalabraOculta);

        System.out.println("Ingresa la cantidad de intentos para adivinar");
        a1.setCantidadIntentosMax(sc.nextInt());

        while (a1.getCantidadIntentosMax() < a1.getTamPalabraOculta()) {
            System.out.println("La cantidad de intentos mínimos debe ser " + a1.getTamPalabraOculta());
            System.out.println("Ingresa la cantidad de intentos para adivinar nuevamente");
            a1.setCantidadIntentosMax(sc.nextInt());
        }

        a1.setLetrasEncontradas(0);

        System.out.println("Palabra Oculta");

        vectorLetrasEncontradas = new String[palabraOcultaString.length()];

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

        if (letraEncontrada) {
            System.out.println("La letra ingresada es parte de la palabra oculta");
        } else {
            System.out.println("La letra ingresada no es parte de la palabra oculta");
        }

    }

    public boolean encontradas() {

        boolean encontradas = false;

        System.out.println("\nPalabra oculta con letras encontradas");

        for (int i = 0; i < vectorPalabraOculta.length; i++) {

            if (vectorPalabraOculta[i].equalsIgnoreCase(a1.getLetraIngresada())) {
                vectorLetrasEncontradas[i] = " " + a1.getLetraIngresada() + " ";
                cantLetrasEncontradas += 1;
                encontradas = true;
            }
            System.out.print(vectorLetrasEncontradas[i]);
        }
        System.out.println();

        a1.setLetrasEncontradas(cantLetrasEncontradas);
        int cantLetrasRestantes = a1.getTamPalabraOculta() - a1.getLetrasEncontradas();

        System.out.println("La cantidad de letras encontradas es " + cantLetrasEncontradas);

        System.out.println("La cantidad de letras que faltan por ser encontradas es " + cantLetrasRestantes);

        a1.setCantidadIntentosMax(a1.getCantidadIntentosMax() - 1);
        System.out.println("La cantidad de intentos que te quedan es " + a1.getCantidadIntentosMax());

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

        } while (a1.getCantidadIntentosMax() != 0);

        if (cantLetrasEncontradas == a1.getTamPalabraOculta()) {
            System.out.println("Felicitaciones, has encontrado la palabra oculta :D");
        } else {
            System.out.println("Qué mal! No has logrado adivinar la palabra oculta. Suerte en la próxima :D");
        }


    }

}
