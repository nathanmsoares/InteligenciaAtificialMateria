package br.com.univille.inteligencia.artificial.jogo;

import br.com.univille.inteligencia.artificial.deque.Carta;
import br.com.univille.inteligencia.artificial.deque.DequeFactory;

import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    private boolean jogadorParou;
    private boolean casaParou;
    private Jogador jogador;
    private Casa casa;
    private Deque<Carta> deque;

    public void iniciarJogo(){
        setGame();
        Scanner scanner = new Scanner(System.in);
        while (true){
            getCasa().mostrarMao();
            getJogador().mostrarMao();
            System.out.println("Deseja pedir mais cartas?\n\t Digite '1' para mais uma carta ou qualquer outra tecla para parar");
            String input = scanner.nextLine();
            getMoreCards(input);
        }
    }

    public void setGame(){
        setDeque((new DequeFactory()).generateDeque());
        setJogador(new Jogador(deque, this));
        setCasa(new Casa(deque, this));
        getCasa().pedirPrimeiraMao();
        getJogador().pedirCarta();
        getJogador().pedirCarta();
    }

    public void getMoreCards(String input){
        if (input.equals("1")){
            getJogador().pedirCarta();
        } else {
            setJogadorParou(true);
            checkWhoWins();
            System.exit(0);
        }
    }

    public void checkWhoWins(){
        while(!casaParou){
            getCasa().pedirCartaAte();
        }
        if (getJogador().somarMao() > getCasa().somarMao()){
            System.out.println("Jogador ganhou");
        } else if (getJogador().somarMao() < getCasa().somarMao()){
            System.out.println("Casa ganhou");
        } else {
            System.out.println("Empate");
        }
        System.out.println("Pontuação final");
        getCasa().mostrarMao();
        System.out.println("Soma casa -> " + getCasa().somarMao());
        getJogador().mostrarMao();
        System.out.println("Soma Jogador -> "+ getJogador().somarMao());
    }

    public Deque<Carta> getDeque() {
        return deque;
    }

    public void setDeque(Deque<Carta> deque) {
        this.deque = deque;
    }

    public boolean isJogadorParou() {
        return jogadorParou;
    }

    public void setJogadorParou(boolean jogadorParou) {
        this.jogadorParou = jogadorParou;
    }

    public boolean isCasaParou() {
        return casaParou;
    }

    public void setCasaParou(boolean casaParou) {
        this.casaParou = casaParou;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public void encerrarJogo(){

    }
}
