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
import java.util.Vector;

/**
 * Esta classe é utilizada na criação dos Jogadores, esta contem 1 atributo que destiguemos trienadores uns dos outros e contem 3 métodos para a criação , edição e eliminação de um ou mais treinadores para que estes participem no calendário de jogos do torneio tartaruga.
 */
public class Treinador extends Pessoa {

    //region Atributos
    /**
     * É uma variável do tipo stirng que recebe uma string que indica a categoria do treinador na equipa.
     */
    private String categoria;

    // Objeto Equipa do Tipo Equipa
    private Equipa equipa;
    //endregion

    //region Construtores
    /**
     * Construtor para criar um jogador com todos os atributos
     * @param nome Nome do Treinador
     * @param idade Idade do Treinador
     * @param altura Altura do Treinador
     * @param categoria A categoria do Treinador
     */
    public Treinador(String nome, int idade, double altura, String categoria) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setAltura(altura);
        this.setCategoria(categoria);
    }

    /**
     * Construtor para criar um jogador com todos os atributos
     * @param nome Nome do Jogador
     * @param idade Idade do Jogador
     * @param altura Altura do Jogador
     * @param categoria Posição no campo do Jogador
     * @param equipa Objeto Equipa
     */
    public Treinador(String nome, int idade, double altura, String categoria, Equipa equipa) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setAltura(altura);
        this.setCategoria(categoria);
        this.equipa = equipa;
    }
    //endregion

    //region Métodos
    /**
     * Esté é um método que está encarregado da criação dos treinadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Add(List<Treinador> listaTreinador) {
    }

    /**
     * Esté é um método que está encarregado da edição dos treinadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Edit(List<Treinador> listaTreinador) {
    }

    /**
     * Esté é um método que está encarregado da eliminação dos treinadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Delete(List<Treinador> listaTreinador) {
    }
    //endregion

    //region Getters & Setters
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    //endregion
}