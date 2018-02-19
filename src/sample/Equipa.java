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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;
import java.util.Vector;

/**
 * Esta classe é utilizada na criação das equipas, esta contem 4 atributos que destiguem as equipas umas nas outras e contem 3 métodos para a criação , edição e eliminação de uma equipa para participar no calendário de jogos do torneio tartaruga.
 */
public class Equipa {
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

    /**
     * 1 jogador pode ter 0 ou 1 equipa, e uma equipa tem 1 ou mais jogadores.
     *
     * (Nota: Proteção para a aplicação - A equipa não pode ser criada enquanto a equipa não tiver pelo menos um jogador).
     */

    /**
     * Construtor Default
     */
    public Equipa() {
    }

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
     * Esté é um método que está encarregado da adição das equipas na lista, este tem como parâmetros de entrada os jogadores e os treinadores, e tem como método de saída void.
     * @param jogador Recebe o jogador do tipo classe Jogador para ser criada a equipa
     * @param treinador Recebe o treinador do tipo classe Treinador para ser criada
     */
    public void Add(Jogador jogador, Treinador treinador, List<Equipa> listaEquipa) {
        throw new UnsupportedOperationException();
    }

    /**
     * Esté é um método que está encarregado da edição das equipas na lista, anteriormente criadas, este tem como parâmetros de entrada os jogadores e os treinadores, e tem como método de saída void.
     * @param jogador Recebe o jogador do tipo classe Jogador para ser editado
     * @param treinador Recebe o treinador do tipo classe Treinador para ser editado
     */
    public void Edit(Jogador jogador, Treinador treinador, List<Equipa> listaEquipa) {
        throw new UnsupportedOperationException();
    }

    /**
     * Esté é um método que está encarregado de eliminar equipas na lista,anteriormente criadas ou editadas, este tem como parâmetros de entrada os jogadores e os treinadores, e tem como método de saída void.
     * @param jogador Recebe o jogador do tipo classe Jogador
     * @param treinador Recebe o treinador do tipo classe Treinador
     */
    public void Delete(Jogador jogador, Treinador treinador, List<Equipa> listaEquipa) {
        throw new UnsupportedOperationException();
    }

    public void ParteGrafica(Button Custom, Button Cancel){

        GridPane gridPaneEquipas = new GridPane();					// layout para a região central
        gridPaneEquipas.setAlignment(Pos.CENTER);
        gridPaneEquipas.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneEquipas.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        gridPaneEquipas.add(labelNome, 0, 0);		// célula col 0,linha 0
        TextField textoNome = new TextField();					    // Campo de texto vazio
        gridPaneEquipas.add(textoNome, 1, 0);       // célula: col 1, linha 0

        // Convocada
        Label labelConvocada = new Label("Convocada:");				// Nova Label
        gridPaneEquipas.add(labelConvocada, 0, 1);		// célula col 0,linha 1
        TextField textoConvocada = new TextField();					    // Campo de texto vazio
        gridPaneEquipas.add(textoConvocada, 1, 1);		// célula: col 1, linha 1

        // Classificação
        Label labelClassificacao = new Label("Classificação:");			// Nova Label
        gridPaneEquipas.add(labelClassificacao, 0, 2);		// célula col 0,linha 2
        TextField textoClassificacao = new TextField();					    // Campo de texto vazio
        gridPaneEquipas.add(textoClassificacao, 1, 2);		// célula: col 1, linha 2

        // Criação do objeto da classe TableView: null
        TableView<Equipa> tableJogadoresTreinadores = new TableView<>();

        // Coluna Jogador
        TableColumn<Equipa, String> colunaNomeJogadores = new TableColumn<>("Jogadores");
        colunaNomeJogadores.setMinWidth(20);
        colunaNomeJogadores.setCellValueFactory(new PropertyValueFactory<>("jogadores"));

        // Coluna Treinador
        TableColumn<Equipa, String> colunaNomeTreinadores = new TableColumn<>("Treinadores");
        colunaNomeTreinadores.setMinWidth(20);
        colunaNomeTreinadores.setCellValueFactory(new PropertyValueFactory<>("treinadores"));

        // Associar as colunas à tabela
        tableJogadoresTreinadores.getColumns().addAll(colunaNomeJogadores, colunaNomeTreinadores);

        // Lista de alunos do tipo ObservableList<Classe>
        // A inicialização é sempre feita desta forma.
        ObservableList<Equipa> listaJogadoresTreinadores = FXCollections.observableArrayList();

        // Carregamento de dados
        listaJogadoresTreinadores.add(new Equipa("Dude", true, 12));

        // Adição da ObservableList à tableView
        tableJogadoresTreinadores.setItems(listaJogadoresTreinadores);

        BorderPane borderPaneEquipas = new BorderPane();
        HBox Butoes = new HBox(40);
        Butoes.getChildren().addAll(Custom, Cancel);

        borderPaneEquipas.setTop(gridPaneEquipas);
        borderPaneEquipas.setCenter(tableJogadoresTreinadores);
        borderPaneEquipas.setBottom(Butoes);
        Butoes.setPadding(new Insets(20,20,20,20));

        Scene formEntidadeEquipasDetalhes = new Scene(borderPaneEquipas,481, 489);
        Stage entidadeEquipas = new Stage();
        entidadeEquipas.setScene(formEntidadeEquipasDetalhes);
        entidadeEquipas.initModality(Modality.APPLICATION_MODAL);
        entidadeEquipas.setTitle("Equipas Detalhes");
        entidadeEquipas.setResizable(false);
        entidadeEquipas.show();
    }


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
}