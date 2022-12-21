package Servicios;

import Entidades.Ahorcado;

import java.util.*;

public class AhorcadoServicios {

    Ahorcado a1 = new Ahorcado();
    Scanner sc = new Scanner(System.in);
    String[] vectorPalabraOculta;
    String[] vectorLetrasEncontradas;
    String palabraOcultaString;
    String pistaPalabraOculta;
    String letrasEquivocadas = " ";
    String palabrasEquivocadas = " ";
    int cantLetrasEncontradas = 0;
    String[] palabrasNivelFacil = {"Solo", "Sin Compañía", "Via", "Sinónimo De Camino", "Amor", "Sentimiento", "Paz", "Paloma Blanca", "Luna", "La Pareja Del Sol", "Luz", "Ilumina", "Sol", "La Pareja De La Luna", "Mes", "Son Doce En El Año", "Lana", "Material De La Oveja", "Loco", "Le Falta Un Tornillo", "Java", "Lenguaje De Programación", "Fuga", "Sinónimo De Escapar", "Fosil", "Lo Dejaron Los Dinos", "Ajeno", "Lo Que No Es Tuyo", "Angel", "Humano Con Alas", "Atras", "Antónimo De Adelante", "Sucio", "Lugar poco limpio", "Heroe", "Salva A Las Personas", "Unico", "Solo Hay Uno", "Joven", "Dejó De Ser Infantil", "Linea", "Es Recta", "Niñez", "Primera Etapa Del Ser", "Obvio", "Demasiado Lógico", "Paris", "Venden Croissants"};
    String[] palabrasNivelMedio = {"soldado", "pintura", "ciclo", "mundo", "verdad", "dinero", "salud", "recibir", "galaxia", "refugio", "general", "sesenta", "girasol", "genesis", "sonrisa", "honrado", "beatriz", "hoguera", "bolivia", "todavia", "uruguay", "campeon", "invento", "interes", "vencido", "leyenda", "lechuza", "mezclar", "cultivo", "deducir", "obtener", "oracion", "empezar", "enrique", "piscina", "excepto", "ficcion"};
    String[] palabrasNivelDificil = {"celular", "bateria", "bacteria", "enfermedad", "felicidad", "creatividad", "compromiso", "absoluto", "absolver", "absorber", "fundacion", "advertir", "reconocer", "guitarra", "relojeria", "resolver", "realizar", "semaforo", "almohada", "analisis", "gimnasia", "siguiente", "simpatico", "antigüedad", "sustantivo", "holandes", "secuencia", "biblioteca", "servicio", "bienvenido", "subrayar", "suficiente", "hemisferio", "hermosura", "horizonte", "imaginar", "valdivia", "cantimplora", "indigena", "vacaciones", "carretilla", "invasion", "velocidad", "ventajoso", "ciencias", "invitacion", "valiente", "cincuenta", "civilizar", "importancia", "ventanal", "venezuela", "colectivo", "colombia", "violencia", "combinar", "zanahoria", "comprension", "confianza", "longitud", "conquista", "mediodia", "constanza", "matematica", "construir", "conversacion", "necesario", "convertir", "cumpleaños", "obediente", "obsequio", "observar", "demasiado", "despacio", "perseguir", "enrollar", "estomago", "patricio", "excelente", "exquisito", "precioso", "extranjero", "principal", "ferrocarril", "prohibir"};

    public Ahorcado crearJuego() {

        int dificultad;

        do {
            System.out.println("Elige la dificulad");
            System.out.println("1. Facil");
            System.out.println("2. Intermedio");
            System.out.println("3. Difícil");
            dificultad = sc.nextInt();
        } while (dificultad < 1 || dificultad > 3);

        switch (dificultad) {
            case 1:
                int posicionPalabraOcultaFacil = (int) (Math.random() * palabrasNivelFacil.length);
                if (posicionPalabraOcultaFacil == 0 || posicionPalabraOcultaFacil % 2 == 0) {
                    pistaPalabraOculta = palabrasNivelFacil[(posicionPalabraOcultaFacil + 1)];
                } else {
                    pistaPalabraOculta = palabrasNivelFacil[posicionPalabraOcultaFacil];
                    posicionPalabraOcultaFacil -= 1;
                }
                palabraOcultaString = palabrasNivelFacil[posicionPalabraOcultaFacil];
                break;
            case 2:
                int posicionPalabraOcultaIntermedio = (int) (Math.random() * palabrasNivelMedio.length);
                if (posicionPalabraOcultaIntermedio == 0 || posicionPalabraOcultaIntermedio % 2 == 0) {
                    pistaPalabraOculta = palabrasNivelMedio[(posicionPalabraOcultaIntermedio + 1)];
                } else {
                    pistaPalabraOculta = palabrasNivelMedio[posicionPalabraOcultaIntermedio];
                    posicionPalabraOcultaIntermedio -= 1;
                }
                palabraOcultaString = palabrasNivelMedio[posicionPalabraOcultaIntermedio];
                break;
            case 3:
                int posicionPalabraOcultaDificil = (int) (Math.random() * palabrasNivelDificil.length);
                if (posicionPalabraOcultaDificil == 0 || posicionPalabraOcultaDificil % 2 == 0) {
                    pistaPalabraOculta = palabrasNivelDificil[(posicionPalabraOcultaDificil + 1)];
                } else {
                    pistaPalabraOculta = palabrasNivelDificil[posicionPalabraOcultaDificil];
                    posicionPalabraOcultaDificil -= 1;
                }
                palabraOcultaString = palabrasNivelDificil[posicionPalabraOcultaDificil];
                break;
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

        longitud();

        for (int i = 0; i < vectorPalabraOculta.length; i++) {
            vectorLetrasEncontradas[i] = " _ ";
            System.out.print(vectorLetrasEncontradas[i]);
        }
        System.out.println();

        return a1;
    }

    public void longitud() {

        a1.setTamPalabraOculta(vectorPalabraOculta.length);
        System.out.println("La palabra tiene " + a1.getTamPalabraOculta() + " letras");

    }

    public boolean esLaPalabra() {

        boolean esCorrecta = a1.getLetraIngresada().equalsIgnoreCase(palabraOcultaString);

        return esCorrecta;

    }

    public void buscar() {

        boolean letraEncontrada = false;

        System.out.println("Ingresa la letra que crees que pertenece a la palabra oculta");
        System.out.println("Si crees saber la palabra, puedes escribirla");
        if (a1.getCantidadIntentosMax() == 1) {
            System.out.println("LA PISTA DE LA PALABRA ES '" + pistaPalabraOculta.toUpperCase() + "'");
        }
        a1.setLetraIngresada(sc.next().toUpperCase());
        if (a1.getLetraIngresada().length() > 2) {

            if (palabrasEquivocadas.contains(a1.getLetraIngresada())) {
                System.out.println("La palabra " + a1.getLetraIngresada() + " ya fue ingresada");
            } else if (esLaPalabra()) {
                System.out.println("Increíble! Has adivinado la palabra y te han quedado " + a1.getCantidadIntentosMax() + " intentos");
            } else {
                System.out.println("Lo siento, no has conseguido adivinar la palabra en un solo intento :(");
                a1.setCantidadIntentosMax(a1.getCantidadIntentosMax() - 1);
                palabrasEquivocadas = palabrasEquivocadas.concat(a1.getLetraIngresada() + " ");
            }
        } else {
            while (a1.getLetraIngresada().length() == 2) {
                System.out.println("Dato incorrecto, solo debes ingresar una letra o una palabra con mínimo 3 letras. Inténtalo de nuevo");
                a1.setLetraIngresada(sc.next().toUpperCase());
            }

            for (int i = 0; i < vectorPalabraOculta.length; i++) {

                if (vectorPalabraOculta[i].equalsIgnoreCase(a1.getLetraIngresada())) {
                    letraEncontrada = true;
                }
            }

            if (letrasEquivocadas.contains(a1.getLetraIngresada())) {

                System.out.println("La letra " + a1.getLetraIngresada() + " ya fue ingresada");
            }

            if (!letraEncontrada) {
                a1.setCantidadIntentosMax(a1.getCantidadIntentosMax() - 1);
                letrasEquivocadas = letrasEquivocadas.concat(a1.getLetraIngresada() + "  ");
            }
        }
    }


    public boolean encontradas() {

        boolean encontradas = false;

        System.out.println("\nPalabra oculta con letras encontradas");

        if (esLaPalabra()) {
            for (int i = 0; i < vectorPalabraOculta.length; i++) {
                System.out.print(" " + vectorPalabraOculta[i].toUpperCase() + " ");
            }
            System.out.println();
        } else {

            for (int i = 0; i < vectorPalabraOculta.length; i++) {

                if (vectorLetrasEncontradas[i].equalsIgnoreCase(" " + a1.getLetraIngresada() + " ")) {
                    System.out.println("La letra " + a1.getLetraIngresada() + " ya había sido ingresada");
                } else if (vectorPalabraOculta[i].equalsIgnoreCase(a1.getLetraIngresada())) {
                    vectorLetrasEncontradas[i] = " " + a1.getLetraIngresada() + " ";
                    cantLetrasEncontradas += 1;
                    encontradas = true;
                }

                System.out.print(vectorLetrasEncontradas[i]);
            }
            System.out.println();
        }

        System.out.println("Letras equivocadas");
        System.out.println(letrasEquivocadas);

        System.out.println("Palabras equivocadas");
        System.out.println(palabrasEquivocadas);

        a1.setLetrasEncontradas(cantLetrasEncontradas);
        int cantLetrasRestantes = a1.getTamPalabraOculta() - a1.getLetrasEncontradas();

        if (esLaPalabra()) {
            System.out.println("Has encontrado toda la palabra :D");
            System.out.println("La cantidad de letras que faltan por ser encontradas es CERO");
        } else {
            System.out.println("Cantidad de letras (Encontradas,Restantes) (" + cantLetrasEncontradas + "," + cantLetrasRestantes + ")");
        }

        return encontradas;

    }

    public void intentos() {

        if (esLaPalabra()) {
            System.out.println("Te sobraron " + a1.getCantidadIntentosMax() + " intentos");
        } else {
            System.out.println("Te quedan " + a1.getCantidadIntentosMax() + " intentos");
        }
    }

    public void juego() {

        crearJuego();


        do {

            buscar();
            longitud();
            encontradas();
            intentos();

        } while (a1.getCantidadIntentosMax() != 0 && cantLetrasEncontradas != a1.getTamPalabraOculta() && !esLaPalabra());

        if (cantLetrasEncontradas == a1.getTamPalabraOculta() || esLaPalabra()) {
            System.out.println("Felicitaciones, has encontrado la palabra oculta que siempre fue '" + palabraOcultaString.toUpperCase() + "'");
        } else {
            System.out.println("Qué mal! No has logrado adivinar la palabra ocultaque siempre fue '" + palabraOcultaString.toUpperCase() + "'. Suerte en la próxima");
        }


    }

}
