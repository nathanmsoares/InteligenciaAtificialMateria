package br.com.univille.inteligencia.artificial.jogo;

import br.com.univille.inteligencia.artificial.deque.Carta;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Jogador {

    private List<Carta> mao = new ArrayList<>();

    private Deque<Carta> deque;

    private Jogo jogo;

    public Jogador(Deque<Carta> deque, Jogo jogo) {
        this.deque = deque;
        this.jogo = jogo;
    }

    public List<Carta> getMao() {
        return mao;
    }

    public int somarMao(){
        return getMao().stream()
                .mapToInt(carta -> carta.getPeso()).sum();
    }

    public void pedirCarta(){
        getMao().add(deque.removeLast());
        if(somarMao() > 21) {

            System.out.println("Jogador perdeu, sua mão é maior que 21");
            System.exit(0);
        }
    }

    public void mostrarMao(){
        System.out.println("Jogador Mão -> "+mao);
    }
}
