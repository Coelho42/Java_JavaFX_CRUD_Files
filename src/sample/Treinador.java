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

    /**
     * É uma variável do tipo stirng que recebe uma string que indica a categoria do treinador na equipa.
     */
    private String categoria;

    /**
     * 1 treinador tem 1 ou mais equipas, e uma equipa tem 1 ou mais treinadores.
     *
     * (Nota: Proteção para a aplicação - A equipa não pode ser criada enquanto a equipa não tiver pelo menos um treinador).
     */

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

    public Treinador(Button Custom, Button Cancel) {
        GridPane gridPaneTreinadores = new GridPane();					// layout para a região central
        gridPaneTreinadores.setAlignment(Pos.CENTER);
        gridPaneTreinadores.setPadding(new Insets(20,20,20,20));
        gridPaneTreinadores.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneTreinadores.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        gridPaneTreinadores.add(labelNome, 0, 0);		// célula col 0,linha 0
        TextField textoNome = new TextField();					    // Campo de texto vazio
        gridPaneTreinadores.add(textoNome, 1, 0);       // célula: col 1, linha 0

        // Convocada
        Label labelConvocada = new Label("Convocada:");				// Nova Label
        gridPaneTreinadores.add(labelConvocada, 0, 1);		// célula col 0,linha 1
        TextField textoConvocada = new TextField();					    // Campo de texto vazio
        gridPaneTreinadores.add(textoConvocada, 1, 1);		// célula: col 1, linha 1

        // Classificação
        Label labelClassificacao = new Label("Classificação:");			// Nova Label
        gridPaneTreinadores.add(labelClassificacao, 0, 2);		// célula col 0,linha 2
        TextField textoClassificacao = new TextField();					    // Campo de texto vazio
        gridPaneTreinadores.add(textoClassificacao, 1, 2);		// célula: col 1, linha 2

        // Equipa
        Label labelTreinadores = new Label("Equipa:");				// Nova Label
        gridPaneTreinadores.add(labelTreinadores, 0, 3);		// célula col 0,linha 1
        TextField textoTreinadores = new TextField();					    // Campo de texto vazio
        gridPaneTreinadores.add(textoTreinadores, 1, 3);		// célula: col 1, linha 1

        HBox Butoes = new HBox(40);
        Butoes.getChildren().addAll(Custom, Cancel);
        gridPaneTreinadores.add(Butoes,1,4);

        BorderPane borderPaneTreinadores = new BorderPane();
        borderPaneTreinadores.setCenter(gridPaneTreinadores);

        Scene formEntidadeTreinadoresDetalhes = new Scene(borderPaneTreinadores,481, 489);
        Stage entidadeTreinadores = new Stage();
        entidadeTreinadores.setScene(formEntidadeTreinadoresDetalhes);
        entidadeTreinadores.initModality(Modality.APPLICATION_MODAL);
        entidadeTreinadores.setTitle("Treinadores Detalhes");
        entidadeTreinadores.setResizable(false);
        entidadeTreinadores.show();
    }

    /**
     * Esté é um método que está encarregado da criação dos treinadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Add(List<Treinador> listaTreinador) {

    }

    /**
     * Esté é um método que está encarregado da edição dos treinadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Edit(List<Treinador> listaTreinador) {
        throw new UnsupportedOperationException();
    }

    /**
     * Esté é um método que está encarregado da eliminação dos treinadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Delete(List<Treinador> listaTreinador) {
        throw new UnsupportedOperationException();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}