package br.com.univille.inteligencia.artificial.jogo;

import br.com.univille.inteligencia.artificial.deque.Carta;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public class Casa {

    private boolean casaParou;

    private boolean estadoInicialJogo = true;

    private List<Carta> mao = new ArrayList<>();

    private Deque<Carta> deque;

    private Jogo jogo;

    public Casa(Deque<Carta> deque, Jogo jogo) {
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
        if(somarMao() > 21 && !estadoInicialJogo) {
            mostrarMao();
            System.out.println("Casa perdeu, mão é maior que 21");
            System.exit(0);
        }
    }

    public void pedirCartaAte(){
        int somaMao = somarMao();
        if(somaMao > 18 && somaMao <= 21) {
            setCasaParou();
        } else if (somaMao > 16 && somaMao <= 18){
            if (checkIfItWantsToOrderAnotherCard()){
                pedirCarta();
            } else {
                setCasaParou();
            }
        } else {
            pedirCarta();
        }
        mostrarMao();
    }

    public void pedirPrimeiraMao(){
        pedirCarta();
        pedirCarta();
        estadoInicialJogo = false;
    }

    private void setCasaParou(){
        this.casaParou = true;
        getJogo().setCasaParou(true);
    }

    public boolean isCasaParou() {
        return casaParou;
    }

    private boolean checkIfItWantsToOrderAnotherCard(){
        Random rand = new Random();
        rand.nextInt(10);
        if(rand.nextInt(10) > 8){
            return true;
        }
        return false;
    }

    public void mostrarMaoInicial(){
        System.out.println(String.format("Casa Mão -> {%s, X}", mao.get(0)) );
    }

    public void mostrarMao(){
        if(getJogo().isJogadorParou()){
            System.out.println("Casa Mão -> "+mao);
        } else {
            mostrarMaoInicial();
        }

    }

    public Jogo getJogo() {
        return jogo;
    }
}
