package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

/**
 * Esta classe é utilizada na criação dos Jogadores, esta contem 1 atributo que destigue os jogadores uns dos outros e contem 3 métodos para a criação , edição e eliminação de um ou mais jogadores para que estes participem no calendário de jogos do torneio tartaruga.
 */
public class Jogador extends Pessoa {

    //region Atributos

    /**
     * É uma variável do tipo string que indica a posição do jogador no campo
     * (base, extremo, poste etc... ) em cada equipa.
     */
    private String posicao;

    // Atributo de Relação
    private Equipa equipa;

    //endregion

    //region Construtores
    /**
     * Construtor para criar um jogador com todos os atributos
     * @param nome Nome do Jogador
     * @param idade Idade do Jogador
     * @param altura Altura do Jogador
     * @param posicao Posição no campo do Jogador
     */
    public Jogador(String nome, int idade, double altura, String posicao) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setAltura(altura);
        this.posicao = posicao;
    }

    /**
     * Construtor para criar um jogador com todos os atributos
     * @param nome Nome do Jogador
     * @param idade Idade do Jogador
     * @param altura Altura do Jogador
     * @param posicao Posição no campo do Jogador
     * @param equipa Objeto Equipa atributo de relação
     */
    public Jogador(String nome, int idade, double altura, String posicao, Equipa equipa) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setAltura(altura);
        this.posicao = posicao;
        this.equipa = equipa;
    }
    //endregion

    //region Métodos
    /**
     * Esté é um método que está encarregado da criação dos jogadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Add(List<Jogador> listaJogador) {

    }

    /**
     * Esté é um método que está encarregado da edição dos jogadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Edit(List<Jogador> listaJogador) {
    }

    /**
     * Esté é um método que está encarregado da eliminação dos jogadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Delete(List<Jogador> listaJogador) {
    }
    //endregion

    //region Getters & Setters
    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    //endregion
}
