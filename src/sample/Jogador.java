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

    /**
     * É uma variável do tipo string que indica a posição do jogador no campo
     * (base, extremo, poste etc... ) em cada equipa.
     */
    private String posicao;

    /**
     * Construtor Default
     */
    public Jogador() {
    }

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
        this.setPosicao(posicao);
    }

    /**
     * 1 jogador pode ter 0 ou 1 equipa, e uma equipa tem 1 ou mais jogadores.
     *
     * (Nota: Proteção para a aplicação - A equipa não pode ser criada enquanto a equipa não tiver pelo menos um jogador).
     */

    /**
     * Esté é um método que está encarregado da criação dos jogadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Add(List<Jogador> listaJogador) {
        throw new UnsupportedOperationException();
    }

    /**
     * Esté é um método que está encarregado da edição dos jogadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Edit(List<Jogador> listaJogador) {
        throw new UnsupportedOperationException();
    }

    /**
     * Esté é um método que está encarregado da eliminação dos jogadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Delete(List<Jogador> listaJogador) {
        throw new UnsupportedOperationException();
    }

    public void ParteGrafica(Button Custom, Button Cancel) {

        GridPane gridPaneJogadores = new GridPane();					// layout para a região central
        gridPaneJogadores.setAlignment(Pos.CENTER);
        gridPaneJogadores.setPadding(new Insets(20,20,20,20));
        gridPaneJogadores.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneJogadores.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        gridPaneJogadores.add(labelNome, 0, 0);		// célula col 0,linha 0
        TextField textoNome = new TextField();					    // Campo de texto vazio
        gridPaneJogadores.add(textoNome, 1, 0);       // célula: col 1, linha 0

        // Convocada
        Label labelConvocada = new Label("Convocada:");				// Nova Label
        gridPaneJogadores.add(labelConvocada, 0, 1);		// célula col 0,linha 1
        TextField textoConvocada = new TextField();					    // Campo de texto vazio
        gridPaneJogadores.add(textoConvocada, 1, 1);		// célula: col 1, linha 1

        // Classificação
        Label labelClassificacao = new Label("Classificação:");			// Nova Label
        gridPaneJogadores.add(labelClassificacao, 0, 2);		// célula col 0,linha 2
        TextField textoClassificacao = new TextField();					    // Campo de texto vazio
        gridPaneJogadores.add(textoClassificacao, 1, 2);		// célula: col 1, linha 2

        // Equipa
        Label labelJogador = new Label("Equipa:");				// Nova Label
        gridPaneJogadores.add(labelJogador, 0, 3);		// célula col 0,linha 1
        TextField textoJogadores = new TextField();					    // Campo de texto vazio
        gridPaneJogadores.add(textoJogadores, 1, 3);		// célula: col 1, linha 1

        HBox Butoes = new HBox(40);
        Butoes.getChildren().addAll(Custom, Cancel);
        gridPaneJogadores.add(Butoes,1,4);

        BorderPane borderPaneJogadores = new BorderPane();
        borderPaneJogadores.setCenter(gridPaneJogadores);

        Scene formEntidadeJogadoresDetalhes = new Scene(borderPaneJogadores,481, 489);
        Stage entidadeJogadores = new Stage();
        entidadeJogadores.setScene(formEntidadeJogadoresDetalhes);
        entidadeJogadores.initModality(Modality.APPLICATION_MODAL);
        entidadeJogadores.setTitle("Jogadores Detalhes");
        entidadeJogadores.setResizable(false);
        entidadeJogadores.show();
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
}
