package br.com.univille.inteligencia.artificial;

import br.com.univille.inteligencia.artificial.deque.Carta;
import br.com.univille.inteligencia.artificial.deque.DequeFactory;
import br.com.univille.inteligencia.artificial.jogo.Casa;
import br.com.univille.inteligencia.artificial.jogo.Jogador;

import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DequeFactory dequeFactory = new DequeFactory();
        List<Carta> deque = dequeFactory.generateDeque();
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        Casa casa = new Casa();
        jogador1.pedirCarta(deque);
        jogador1.pedirCarta(deque);
        casa.pedirCarta(deque);
        casa.pedirCarta(deque);
    }
}