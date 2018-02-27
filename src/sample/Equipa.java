package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;
import java.util.Vector;

/**
 * Esta classe é utilizada na criação das equipas, esta contem 4 atributos que destiguem as equipas umas nas outras e contem 3 métodos para a criação , edição e eliminação de uma equipa para participar no calendário de jogos do torneio tartaruga.
 */
public class Equipa {

    //region Atributos

    /**
     * É uma variável do tipo long que recebe o id das equipas, pois as equipas que podem ser criadas são infinitas ou seja o id pode chegar a ter vários digitos, logo tem de ser um long.
     */
    private long id;

    /**
     * É uma varíavel do tipo String que atribui um nome de cada equipa.
     */
    private String nome;

    /**
     * É uma variável do tipo boolean que verifica se a equipa está ou não convocada para o torneio tartaruga, se sim a equipa é adicionada à lista de equipas, se não a equipa continua na lista de equipas criadas, mas não se encontra adicionada no torneio.
     */
    private boolean convocada;

    /**
     * É uma variável do tipo long que recebe o lugar em que a equipa ficou no decorrer do torneio tartaruga, o motivo para esta ser um long deve-se ao facto de o id também ser um long e como o número de equipas que podem ser criadas é infinito, então a posição em que a equipa se encontra no torneio também pode chegar a conter bastantes digitos, o que leva esta variável a ser um long.
     */
    private long classificacao;

    // Atributos de Relação
    private List<Jogador> jogadorList;
    private List<Treinador> treinadorList;

    //endregion

    //region Construtores
    /**
     * Construtor para criar um jogador com todos os atributos
     * @param nome Nome da Equipa
     * @param convocada Está convocada para o próximo jogo ou não
     * @param classificacao Classificação da equipa
     */
    public Equipa(String nome, boolean convocada, long classificacao) {
        this.setNome(nome);
        this.setConvocada(convocada);
        this.setClassificacao(classificacao);
    }

    /**
     * Construtor para criar um jogador com todos os atributos
     * @param nome Nome da Equipa
     * @param convocada Está convocada para o próximo jogo ou não
     * @param classificacao Classificação da equipa
     * @param jogadorList Lista de Jogadores
     * @param treinadorList Lista de Treinadores
     */
    public Equipa(String nome, boolean convocada, long classificacao, List jogadorList, List treinadorList) {
        this.setNome(nome);
        this.setConvocada(convocada);
        this.setClassificacao(classificacao);
        this.jogadorList = jogadorList;
        this.treinadorList = treinadorList;
    }
    //endregion

    //region Métodos
    /**
     * Esté é um método que está encarregado da adição das equipas na lista, este tem como parâmetros de entrada os jogadores e os treinadores, e tem como método de saída void.
     * @param jogador Recebe o jogador do tipo classe Jogador para ser criada a equipa
     * @param treinador Recebe o treinador do tipo classe Treinador para ser criada
     */
    public void Add(Jogador jogador, Treinador treinador, List<Equipa> listaEquipa) {
        //textBoxNome.Text.Trim();
        //textBoxConvocada.Text.Trim(); ;
        //textBoxLiga.Text.Trim();
    }

    /**
     * Esté é um método que está encarregado da edição das equipas na lista, anteriormente criadas, este tem como parâmetros de entrada os jogadores e os treinadores, e tem como método de saída void.
     * @param jogador Recebe o jogador do tipo classe Jogador para ser editado
     * @param treinador Recebe o treinador do tipo classe Treinador para ser editado
     */
    public void Edit(Jogador jogador, Treinador treinador, List<Equipa> listaEquipa) {
    }

    /**
     * Esté é um método que está encarregado de eliminar equipas na lista,anteriormente criadas ou editadas, este tem como parâmetros de entrada os jogadores e os treinadores, e tem como método de saída void.
     * @param jogador Recebe o jogador do tipo classe Jogador
     * @param treinador Recebe o treinador do tipo classe Treinador
     */
    public void Delete(Jogador jogador, Treinador treinador, List<Equipa> listaEquipa) {
    }

    //endregion

    //region Getters & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isConvocada() {
        return convocada;
    }

    public void setConvocada(boolean convocada) {
        this.convocada = convocada;
    }

    public long getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(long classificacao) {
        this.classificacao = classificacao;
    }
    //endregion
}