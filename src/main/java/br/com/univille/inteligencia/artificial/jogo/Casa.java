package br.com.univille.inteligencia.artificial.jogo;

import br.com.univille.inteligencia.artificial.deque.Carta;

import java.util.ArrayList;
import java.util.List;

public class Casa {

    private int somaMao;

    private boolean casaParou;

    private boolean jogadorParou;

    private boolean estadoInicialJogo = true;

    private List<Carta> mao = new ArrayList<>();

    public List<Carta> getMao() {
        return mao;
    }

    public int somarMao(){
        getMao().forEach(carta -> this.somaMao += carta.getPeso());
        return this.somaMao;
    }

    public void pedirCarta(List<Carta> deque){
        getMao().add(
                deque.remove(deque.size()-1));
        if (jogadorParou) {
            mostrarMao();
        }
        if(somarMao() > 21 && !estadoInicialJogo) {
            System.out.println(String.format("%s perdeu, sua mão é maior que 21", this.getClass().getName()));
            System.exit(0);
        }
    }

    public void mostrarMaoInicial(){
        System.out.println(String.format("{%s, X}", mao.get(0)) );

    }

    public boolean isJogadorParou() {
        return jogadorParou;
    }

    public void setJogadorParou(boolean jogadorParou) {
        this.jogadorParou = jogadorParou;
    }

    public void mostrarMao(){
        System.out.println("Mão "+mao);
    }

    public void pedirCartaAte(List<Carta> deque){
        if(somarMao() > 18 && somarMao() <= 20) {
            this.casaParou = true;
        } else {
            pedirCarta(deque);
        }
    }
}
