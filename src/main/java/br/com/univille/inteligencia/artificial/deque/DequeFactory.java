package br.com.univille.inteligencia.artificial.deque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DequeFactory {

    List<Carta> deque = new ArrayList<>();

    public List<Carta> generateDeque(){
        generateDequeByNaipe("Espadas");
        generateDequeByNaipe("Paus");
        generateDequeByNaipe("Copas");
        generateDequeByNaipe("Ouro");
        Collections.shuffle(deque);
        return deque;
    }

    private void generateDequeByNaipe(String naipe){
        for (int i = 1; i <= 13; i++) {
            if(i == 1){
                setCarta("A", naipe, 11);
            } else if(i == 11){
                setCarta("J", naipe, 10);
            } else if (i == 12) {
                setCarta("Q", naipe, 10);
            } else if (i == 13) {
                setCarta("K", naipe, 10);
            } else {
                setCarta(String.format("%d", i), naipe, i);
            }
        }
    }

    private void setCarta(String numero, String naipe, int peso){
        deque.add(new Carta(numero, naipe, peso));
    }
}
