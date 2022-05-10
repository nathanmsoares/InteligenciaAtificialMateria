package br.com.univille.inteligencia.artificial.jogo;

import br.com.univille.inteligencia.artificial.deque.Carta;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private int somaMao;

    private List<Carta> mao = new ArrayList<>();

    public List<Carta> getMao() {
        return mao;
    }

    public int somarMao(){
        getMao().forEach(carta -> this.somaMao += carta.getPeso());
        return this.somaMao;
    }

    public void pedirCarta(List<Carta> deque){
        getMao().add(deque.remove(deque.size()-1));
        if(somarMao() > 21) {
            System.out.println(String.format("%s perdeu, sua mão é maior que 21", this.getClass().getName()));
            System.exit(0);
        }
    }

    public void mostrarMao(){
        System.out.println("Mão "+mao);
    }
}
