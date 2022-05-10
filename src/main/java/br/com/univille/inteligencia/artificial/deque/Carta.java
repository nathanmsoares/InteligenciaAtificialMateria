package br.com.univille.inteligencia.artificial.deque;

import java.util.Objects;

public class Carta {

    private String numero;
    private String naipe;
    private int peso;

    public Carta(String numero, String naipe, int peso) {
        this.numero = numero;
        this.naipe = naipe;
        this.peso = peso;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carta)) return false;
        Carta carta = (Carta) o;
        return getPeso() == carta.getPeso() && Objects.equals(getNumero(), carta.getNumero()) && Objects.equals(getNaipe(), carta.getNaipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero(), getNaipe(), getPeso());
    }

    @Override
    public String toString() {
        return "Carta{" +
                "numero='" + numero + '\'' +
                ", naipe='" + naipe + '\'' +
                '}';
    }
}
