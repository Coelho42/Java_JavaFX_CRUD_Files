package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.text.Normalizer;
import java.util.List;

/**
 * Class de controlo, esta é a mais importante de todas as classes é esta classe que controla a adição das equipas, dos jogadores e dos treinadores no torneio tartaruga estas tarefas são realizadas através da ajuda de 3 métodos: adicionar, editar e eliminar. Esta contém 3 atributos que são listas: lista de equipas, lista de jogadores e lista de treinadores, estas por sua vez são utilizadas pelos métodos referidos anteriormente para depois serem adicionadas no torneio.
 *
 * Concluindo, o programa consiste na criação de jogadores, treinadores e equipas, os jogadores e treinadores por sua vez serão inseridos numa equipa e assim que a equipa criada estiver cheia com jogadores e no mínimo 1 treinador, então será adicionado ao torneio tartaruga.
 */

public class Main extends Application {

    //region Listas
    List<Equipa> listaEquipas;
    List<Jogador> listaJogadores;
    List<Treinador> listaTreinadores;
    //endregion

    //region Labels
    Label labelEquipa = new Label("Equipas");
    Label labelJogadores = new Label("Jogadores");
    Label labelTreinadores = new Label("Treinadores");
    //endregion

    //region Botões
    Button Add = new Button("Adicionar");
    Button Edit = new Button("Editar");
    Button Delete = new Button("Eliminar");
    Button Close = new Button("Fechar Lista");
    Button Custom = new Button("'Custom'");
    Button Cancel = new Button("Cancel");
    //endregion

    //region TextFields
    TextField textoNomeEquipas = new TextField();					    // Campo de texto vazio
    TextField textoConvocada = new TextField();					    // Campo de texto vazio
    TextField textoClassificacao = new TextField();					    // Campo de texto vazio

    TextField textoNomeJogadores = new TextField();					    // Campo de texto vazio
    TextField textoIdadeJogadores = new TextField();					    // Campo de texto vazio
    TextField textoAlturaJogadores = new TextField();					    // Campo de texto vazio
    TextField textoPosicao = new TextField();					    // Campo de texto vazio
    TextField textoJogadores = new TextField();					    // Campo de texto vazio

    TextField textoNomeTreinadores = new TextField();					    // Campo de texto vazio
    TextField textoIdadeTreinadores  = new TextField();					    // Campo de texto vazio
    TextField textoAlturaTreinadores  = new TextField();					    // Campo de texto vazio
    TextField textoCategoria = new TextField();					    // Campo de texto vazio
    TextField textoTreinadores = new TextField();					    // Campo de texto vazio
    //endregion

    //region Opções do MenuStrip
    Menu menuFile = new Menu("_Principal");      // Menu Principal
    Menu menuEdit = new Menu("_About Me");      // Menu About Me
    MenuItem menuItemFileOpcaoEquipas = new MenuItem("Equipas");
    MenuItem menuItemFileOpcaoJogadores = new MenuItem("Jogadores");
    MenuItem menuItemFileOpcaoTreinadores = new MenuItem("Treinadores");
    //endregion

    //region TableView e respetivas Colunas
    TableView<Equipa> tableEquipas = new TableView<>();
    TableColumn<Equipa, String> colunaNomeEquipas = new TableColumn<>("Nome");
    TableColumn<Equipa, Boolean> colunaConvocada = new TableColumn<>("Convocada");
    TableColumn<Equipa, Long> colunaClassificacao = new TableColumn<>("Classificação");

    TableView<Jogador> tableJogadores = new TableView<>();
    TableColumn<Jogador, String> colunaNomeJogadores = new TableColumn<>("Nome");
    TableColumn<Jogador, Integer> colunaIdadeJogadores = new TableColumn<>("Idade");
    TableColumn<Jogador, Double> colunaAlturaJogadores = new TableColumn<>("Altura");
    TableColumn<Jogador, String> colunaPosicao = new TableColumn<>("Posição");

    TableView<Treinador> tableTreinadores = new TableView<>();
    TableColumn<Treinador, String> colunaNomeTreinadores = new TableColumn<>("Nome");
    TableColumn<Treinador, Integer> colunaIdadeTreinadores = new TableColumn<>("Idade");
    TableColumn<Treinador, Double> colunaAlturaTreinadores = new TableColumn<>("Altura");
    TableColumn<Treinador, String> colunaCategoria = new TableColumn<>("Categoria");

    //endregion

    //region strAction e selectedIndex
    String strAction;
    int selectedIndex;
    //endregion

    /**
     * Método da classe Application (Super)
     * Responsável pela criação do programa. Quando termina a sua tarefa, chama o método Start
     *
     * @param args Array de strings que podem ser introduzidas, como argumentos, pelo User, no arranque da app.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Método da classe Application (super)
     * Responsável pelo arranque do programa
     *
     * @param primaryStage Recebe uma janela windows pré definida na classe (Application)
     * @throws Exception Caso seja apanhado algum erro, imprime-o para a consola
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        try {

            //region Estilo e fonte das Labels
            labelEquipa.setFont(new Font("Cambria", 40));
            labelEquipa.setStyle("-fx-font-weight: bold");
            labelJogadores.setFont(new Font("Cambria", 40));
            labelJogadores.setStyle("-fx-font-weight: bold");
            labelTreinadores.setFont(new Font("Cambria", 40));
            labelTreinadores.setStyle("-fx-font-weight: bold");
            //endregion

            //region Tamanho dos Botões
            Add.setPrefSize(130, 60);
            Edit.setPrefSize(130, 60);
            Delete.setPrefSize(130, 60);
            Close.setPrefSize(130, 60);
            //endregion

            menuItemFileOpcaoEquipas.setOnAction(e -> {

                //region Propriedades das Colunas da TableView Equipas
                // Coluna Nome
                colunaNomeEquipas.setMinWidth(20);
                colunaNomeEquipas.setCellValueFactory(new PropertyValueFactory<>("nome"));

                //Coluna Convocada
                colunaConvocada.setMinWidth(20);
                colunaConvocada.setCellValueFactory(new PropertyValueFactory<>("convocada"));

                //Coluna Numero
                colunaConvocada.setMinWidth(20);
                colunaConvocada.setCellValueFactory(new PropertyValueFactory<>("classificacao"));
                //endregion

                //region TableView e ObservableList Stuff
                // Associação das colunas à TableView
                tableEquipas.getColumns().addAll(colunaNomeEquipas, colunaConvocada, colunaClassificacao);

                // Inicialização da ObservableList
                ObservableList<Equipa> listaEquipas = FXCollections.observableArrayList();

                // Carregamento de dados
                listaEquipas.add(new Equipa("Dude", true, 12));

                // Adição da ObservableList à tableView
                tableEquipas.setItems(listaEquipas);
                //endregion

                //region Botões Add, Edit e Delete
                Add.setOnAction(A -> {
                    parteGraficaEquipa();
                });
                Edit.setOnAction(A -> {
                    parteGraficaEquipa();
                });
                Delete.setOnAction(A -> {
                    parteGraficaEquipa();
                });
                Close.setOnAction(A -> {
                });
                //endregion

                //region Preparação da janela
                BorderPane borderPaneEquipa = new BorderPane();
                HBox Butoes = new HBox(40);

                borderPaneEquipa.setTop(labelEquipa);
                borderPaneEquipa.setCenter(tableEquipas);
                borderPaneEquipa.setBottom(Butoes);

                Butoes.setPadding(new Insets(10, 20, 20, 20));
                Butoes.getChildren().addAll(Add, Edit, Delete, Close);

                StackPane stackPaneEquipa = new StackPane();                    // Layout para organizar verticalmente os objetos
                stackPaneEquipa.setPadding(new Insets(20, 20, 20, 20));            // espessura interna de cada bordo interno
                stackPaneEquipa.getChildren().add(borderPaneEquipa);

                Scene formEntidadeEquipas = new Scene(stackPaneEquipa, 726, 561);            // Tratamento da janela
                Stage entidadeEquipas = new Stage();
                entidadeEquipas.setScene(formEntidadeEquipas);
                entidadeEquipas.initModality(Modality.APPLICATION_MODAL);
                entidadeEquipas.setTitle("Equipas");
                entidadeEquipas.setResizable(false);
                entidadeEquipas.show();
                //endregion
            });
            menuItemFileOpcaoJogadores.setOnAction(e -> {

                //region Propriedades das Colunas da TableView Jogadores
                // Coluna Nome
                colunaNomeJogadores.setMinWidth(20);
                colunaNomeJogadores.setCellValueFactory(new PropertyValueFactory<>("nome"));

                //Coluna Idade
                colunaIdadeJogadores.setMinWidth(20);
                colunaIdadeJogadores.setCellValueFactory(new PropertyValueFactory<>("idade"));

                //Coluna Altura
                colunaAlturaJogadores.setMinWidth(20);
                colunaAlturaJogadores.setCellValueFactory(new PropertyValueFactory<>("altura"));

                //Coluna Posição
                colunaPosicao.setMinWidth(20);
                colunaPosicao.setCellValueFactory(new PropertyValueFactory<>("posicao"));
                //endregion

                //region TableView e ObservableList Stuff
                // Associar as colunas à tabela
                tableJogadores.getColumns().addAll(colunaNomeJogadores, colunaIdadeJogadores, colunaAlturaJogadores, colunaPosicao);

                // Inicialização da ObservableList
                ObservableList<Jogador> listaJogadores = FXCollections.observableArrayList();

                // Carregamento de dados
                listaJogadores.add(new Jogador("Jogador", 8, 4, "seila"));

                // Adição da ObservableList à tableView
                tableJogadores.setItems(listaJogadores);
                //endregion

                //region Botões Add, Edit e Delete
                Add.setOnAction(A -> {
                    parteGraficaJogador();
                });
                Edit.setOnAction(A -> {
                    parteGraficaJogador();
                });
                Delete.setOnAction(A -> {
                    parteGraficaJogador();
                });
                Close.setOnAction(A -> {
                    parteGraficaJogador();
                });
                //endregion

                //region Preparação da janela
                BorderPane borderPaneJogadores = new BorderPane();
                HBox Butoes = new HBox(40);

                borderPaneJogadores.setTop(labelJogadores);
                borderPaneJogadores.setCenter(tableJogadores);
                borderPaneJogadores.setBottom(Butoes);

                Butoes.setPadding(new Insets(10, 20, 20, 20));
                Butoes.getChildren().addAll(Add, Edit, Delete, Close);

                StackPane stackPane = new StackPane();                    // Layout para organizar verticalmente os objetos
                stackPane.setPadding(new Insets(20, 20, 20, 20));            // espessura interna de cada bordo interno
                stackPane.getChildren().add(borderPaneJogadores);

                Scene formEntidadeJogadores = new Scene(stackPane, 726, 561);            // Tratamento da janela
                Stage entidadeJogadores = new Stage();
                entidadeJogadores.setScene(formEntidadeJogadores);
                entidadeJogadores.initModality(Modality.APPLICATION_MODAL);
                entidadeJogadores.setTitle("Jogadores");
                entidadeJogadores.setResizable(false);
                entidadeJogadores.show();
                //endregion
            });
            menuItemFileOpcaoTreinadores.setOnAction(e -> {

                //region Propriedades das Colunas da TableView Treinadores
                // Coluna Nome
                colunaNomeTreinadores.setMinWidth(20);
                colunaNomeTreinadores.setCellValueFactory(new PropertyValueFactory<>("nome"));

                //Coluna Idade
                colunaIdadeTreinadores.setMinWidth(20);
                colunaIdadeTreinadores.setCellValueFactory(new PropertyValueFactory<>("idade"));

                //Coluna Altura
                colunaAlturaTreinadores.setMinWidth(20);
                colunaAlturaTreinadores.setCellValueFactory(new PropertyValueFactory<>("altura"));

                //Coluna Posição
                colunaCategoria.setMinWidth(20);
                colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
                //endregion

                //region TableView e ObservableList Stuff
                // Associar as colunas à tabela
                tableTreinadores.getColumns().addAll(colunaNomeTreinadores, colunaIdadeTreinadores, colunaAlturaTreinadores, colunaCategoria);

                // Lista de alunos do tipo ObservableList<Classe>
                // A inicialização é sempre feita desta forma.
                ObservableList<Treinador> listaTreinadores = FXCollections.observableArrayList();

                // Carregamento de dados
                listaTreinadores.add(new Treinador("Treinador", 12, 12, "ABRE"));

                // Adição da ObservableList à tableView
                tableTreinadores.setItems(listaTreinadores);
                //endregion

                //region Botões Add, Edit e Delete
                Add.setOnAction(A -> {
                    parteGraficaTreinador();
                });
                Edit.setOnAction(A -> {
                    parteGraficaTreinador();
                });
                Delete.setOnAction(A -> {
                    parteGraficaTreinador();
                });
                Close.setOnAction(A -> {
                    primaryStage.show();
                });
                //endregion

                //region Preparação da janela
                BorderPane borderPaneTreinadores = new BorderPane();
                HBox Butoes = new HBox(40);

                borderPaneTreinadores.setTop(labelTreinadores);
                borderPaneTreinadores.setCenter(tableTreinadores);
                borderPaneTreinadores.setBottom(Butoes);

                Butoes.setPadding(new Insets(10, 20, 20, 20));
                Butoes.getChildren().addAll(Add, Edit, Delete, Close);

                StackPane stackPaneTreinadores = new StackPane();                    // Layout para organizar verticalmente os objetos
                stackPaneTreinadores.setPadding(new Insets(20, 20, 20, 20));            // espessura interna de cada bordo interno
                stackPaneTreinadores.getChildren().add(borderPaneTreinadores);

                Scene formEntidadeTreinadores = new Scene(stackPaneTreinadores, 726, 561);            // Tratamento da janela
                Stage entidadeTreinadores = new Stage();
                entidadeTreinadores.setScene(formEntidadeTreinadores);
                entidadeTreinadores.initModality(Modality.APPLICATION_MODAL);
                entidadeTreinadores.setTitle("Jogadores");
                entidadeTreinadores.setResizable(false);
                entidadeTreinadores.show();
                //endregion
            });

            //region Adição dos MenuItems ao menuFile.
            menuFile.getItems().addAll(
                    menuItemFileOpcaoEquipas,
                    menuItemFileOpcaoJogadores,
                    menuItemFileOpcaoTreinadores);
            //endregion

            //region Criação do menuBar e associação dos Menus
            MenuBar menuBar = new MenuBar();
            menuBar.getMenus().addAll(menuFile, menuEdit);
            BorderPane rootLayout = new BorderPane();       // Layout Principal
            rootLayout.setTop(menuBar);     // Associar o menu à região TOP do rootLayout
            //endregion

            //region Preparação da janela
            Scene Controlo = new Scene(rootLayout, 1204, 731);   // Tratamento da janela
            primaryStage.setScene(Controlo);
            primaryStage.setTitle("Torneio Tartaruga");
            primaryStage.setResizable(false);
            primaryStage.show();

            //endregion

        } catch (Exception e) {
            e.printStackTrace();        // qq exceção é exibida
        }
    }

    public void parteGraficaEquipa() {

        GridPane gridPaneEquipas = new GridPane();					// layout para a região central
        gridPaneEquipas.setAlignment(Pos.CENTER);
        gridPaneEquipas.setPadding(new Insets(20,20,20,20));
        gridPaneEquipas.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneEquipas.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        gridPaneEquipas.add(labelNome, 0, 0);		// célula col 0,linha 0
        gridPaneEquipas.add(textoNomeEquipas, 1, 0);       // célula: col 1, linha 0

        // Convocada
        Label labelConvocada = new Label("Convocada:");				// Nova Label
        gridPaneEquipas.add(labelConvocada, 0, 1);		// célula col 0,linha 1
        gridPaneEquipas.add(textoConvocada, 1, 1);		// célula: col 1, linha 1

        // Classificação
        Label labelClassificacao = new Label("Classificação:");			// Nova Label
        gridPaneEquipas.add(labelClassificacao, 0, 2);		// célula col 0,linha 2
        gridPaneEquipas.add(textoClassificacao, 1, 2);		// célula: col 1, linha 2

        // Criação da TableView
        TableView<Equipa> tableJogadoresTreinadores = new TableView<>();

        // Coluna Jogador
        TableColumn<Equipa, String> colunaNomeJogadoresDetalhes = new TableColumn<>("Jogadores");
        colunaNomeJogadores.setMinWidth(20);
        colunaNomeJogadores.setCellValueFactory(new PropertyValueFactory<>("jogadores"));

        // Coluna Treinador
        TableColumn<Equipa, String> colunaNomeTreinadoresDetalhes = new TableColumn<>("Treinadores");
        colunaNomeTreinadores.setMinWidth(20);
        colunaNomeTreinadores.setCellValueFactory(new PropertyValueFactory<>("treinadores"));

        // Associar as colunas à tabela
        tableJogadoresTreinadores.getColumns().addAll(colunaNomeJogadoresDetalhes, colunaNomeTreinadoresDetalhes);

        // A inicialização é sempre feita desta forma.
        ObservableList<Equipa> listaJogadoresTreinadores = FXCollections.observableArrayList();

        // Carregamento de dados
        listaJogadoresTreinadores.add(new Equipa("Dude", true, 12));

        // Adição da ObservableList à tableView
        tableJogadoresTreinadores.setItems(listaJogadoresTreinadores);

        BorderPane borderPaneEquipas = new BorderPane();
        HBox Butoes = new HBox(40);
        Butoes.setAlignment(Pos.CENTER);
        Butoes.setPadding(new Insets(10,20,20,20));
        Butoes.getChildren().addAll(Custom, Cancel);

        StackPane stackPaneEquipas = new StackPane();					// Layout para organizar verticalmente os objetos
        stackPaneEquipas.setPadding(new Insets(20,20,20,20));			// espessura interna de cada bordo interno
        stackPaneEquipas.getChildren().add(borderPaneEquipas);

        borderPaneEquipas.setTop(gridPaneEquipas);
        borderPaneEquipas.setCenter(tableJogadoresTreinadores);
        borderPaneEquipas.setBottom(Butoes);

        Scene formEntidadeEquipasDetalhes = new Scene(stackPaneEquipas,481, 489);
        Stage entidadeEquipas = new Stage();
        entidadeEquipas.setScene(formEntidadeEquipasDetalhes);
        entidadeEquipas.initModality(Modality.APPLICATION_MODAL);
        entidadeEquipas.setTitle("Equipas Detalhes");
        entidadeEquipas.setResizable(false);
        entidadeEquipas.show();
    }

    public void parteGraficaJogador(){

        GridPane gridPaneJogadores = new GridPane();					// layout para a região central
        gridPaneJogadores.setAlignment(Pos.CENTER);
        gridPaneJogadores.setPadding(new Insets(20,20,20,20));
        gridPaneJogadores.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneJogadores.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        gridPaneJogadores.add(labelNome, 0, 0);		// célula col 0,linha 0
        gridPaneJogadores.add(textoNomeJogadores, 1, 0);       // célula: col 1, linha 0

        // Idade
        Label labelIdade = new Label("Convocada:");				// Nova Label
        gridPaneJogadores.add(labelIdade, 0, 1);		// célula col 0,linha 1
        gridPaneJogadores.add(textoIdadeJogadores, 1, 1);		// célula: col 1, linha 1

        // Altura
        Label labelAltura = new Label("Classificação:");			// Nova Label
        gridPaneJogadores.add(labelAltura, 0, 2);		// célula col 0,linha 2
        gridPaneJogadores.add(textoAlturaJogadores, 1, 2);		// célula: col 1, linha 2

        // Posição
        Label labelPosicao = new Label("Posicao:");			// Nova Label
        gridPaneJogadores.add(labelPosicao, 0, 3);		// célula col 0,linha 2
        gridPaneJogadores.add(textoPosicao, 1, 3);		// célula: col 1, linha 2

        // Jogador
        Label labelJogador = new Label("Equipa:");				// Nova Label
        gridPaneJogadores.add(labelJogador, 0, 3);		// célula col 0,linha 1
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

    public void parteGraficaTreinador(){

        GridPane gridPaneTreinadores = new GridPane();					// layout para a região central
        gridPaneTreinadores.setAlignment(Pos.CENTER);
        gridPaneTreinadores.setPadding(new Insets(20,20,20,20));
        gridPaneTreinadores.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneTreinadores.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        gridPaneTreinadores.add(labelNome, 0, 0);		// célula col 0,linha 0
        gridPaneTreinadores.add(textoNomeTreinadores, 1, 0);       // célula: col 1, linha 0

        // Idade
        Label labelIdade = new Label("Convocada:");				// Nova Label
        gridPaneTreinadores.add(labelIdade, 0, 1);		// célula col 0,linha 1
        gridPaneTreinadores.add(textoIdadeTreinadores, 1, 1);		// célula: col 1, linha 1

        // Altura
        Label labelAltura = new Label("Classificação:");			// Nova Label
        gridPaneTreinadores.add(labelAltura, 0, 2);		// célula col 0,linha 2
        gridPaneTreinadores.add(textoAlturaTreinadores, 1, 2);		// célula: col 1, linha 2

        // Categoria
        Label labelCategoria = new Label("Categoria:");			// Nova Label
        gridPaneTreinadores.add(labelCategoria, 0, 2);		// célula col 0,linha 2
        gridPaneTreinadores.add(textoCategoria, 1, 2);		// célula: col 1, linha 2

        // Treinadores
        Label labelTreinadores = new Label("Treinador:");				// Nova Label
        gridPaneTreinadores.add(labelTreinadores, 0, 3);		// célula col 0,linha 1
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

    public void acercaDe(){


        Scene sceneAcercaDe = new Scene(borderPaneTreinadores,481, 489);
        Stage stageAcercaDe = new Stage();
        stageAcercaDe.setScene(sceneAcercaDe);
        stageAcercaDe.initModality(Modality.APPLICATION_MODAL);
        stageAcercaDe.setTitle("Acerca De");
        stageAcercaDe.setResizable(false);
        stageAcercaDe.show();
    }
}