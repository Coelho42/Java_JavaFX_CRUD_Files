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

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/**
 * Esta classe é utilizada na criação dos Jogadores, esta contem 1 atributo que destiguemos trienadores uns dos outros e contem 3 métodos para a criação , edição e eliminação de um ou mais treinadores para que estes participem no calendário de jogos do torneio tartaruga.
 */
public class Treinador extends Pessoa implements Serializable {

    //region Atributos

    // Id do treinador
    private int id;
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
        id = id + 1;
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

    //region Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Equipa getEquipa() { return equipa; }

    public void setEquipa(Equipa equipa) { this.equipa = equipa; }
    //endregion
}