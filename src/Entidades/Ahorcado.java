package Entidades;

public class Ahorcado {

    private int tamPalabraOculta;
    private String[] palabraOculta = new String[tamPalabraOculta];

    private int letrasEncontradas;

    private int cantidadIntentosMax;

    private String letraIngresada;

    public Ahorcado() {
    }

    public Ahorcado(int tamPalabraOculta, String[] palabraOculta, int letrasEncontradas, int cantidadIntentosMax, String letraIngresada) {
        this.tamPalabraOculta = tamPalabraOculta;
        this.palabraOculta = palabraOculta;
        this.letrasEncontradas = letrasEncontradas;
        this.cantidadIntentosMax = cantidadIntentosMax;
        this.letraIngresada = letraIngresada;
    }

    public int getTamPalabraOculta() {
        return tamPalabraOculta;
    }

    public void setTamPalabraOculta(int tamPalabraOculta) {
        this.tamPalabraOculta = tamPalabraOculta;
    }

    public String[] getPalabraOculta() {
        return palabraOculta;
    }

    public void setPalabraOculta(String[] palabraOculta) {
        this.palabraOculta = palabraOculta;
    }

    public int getLetrasEncontradas() {
        return letrasEncontradas;
    }

    public void setLetrasEncontradas(int letrasEncontradas) {
        this.letrasEncontradas = letrasEncontradas;
    }

    public int getCantidadIntentosMax() {
        return cantidadIntentosMax;
    }

    public void setCantidadIntentosMax(int cantidadIntentosMax) {
        this.cantidadIntentosMax = cantidadIntentosMax;
    }

    public String getLetraIngresada() {
        return letraIngresada;
    }

    public void setLetraIngresada(String letraIngresada) {
        this.letraIngresada = letraIngresada;
    }
}
