package sample;

import com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.invoke.empty.Empty;

import java.util.ArrayList;
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
    Label labelJogador = new Label("Jogadores");
    Label labelTreinador = new Label("Treinadores");
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
    TextField textoNomeEquipa = new TextField();					    // Campo de texto vazio
    TextField textoConvocada = new TextField();					    // Campo de texto vazio
    TextField textoClassificacao = new TextField();					    // Campo de texto vazio

    TextField textoNomeJogador = new TextField();					    // Campo de texto vazio
    TextField textoIdadeJogador = new TextField();					    // Campo de texto vazio
    TextField textoAlturaJogador = new TextField();					    // Campo de texto vazio
    TextField textoPosicao = new TextField();					    // Campo de texto vazio
    TextField textoEquipaJogador = new TextField();					    // Campo de texto vazio

    TextField textoNomeTreinador = new TextField();					    // Campo de texto vazio
    TextField textoIdadeTreinador = new TextField();					    // Campo de texto vazio
    TextField textoAlturaTreinador  = new TextField();					    // Campo de texto vazio
    TextField textoCategoria = new TextField();					    // Campo de texto vazio
    TextField textoEquipaTreinador = new TextField();					    // Campo de texto vazio
    //endregion

    //region HBoxes
    HBox butoesEquipa = new HBox(40);
    HBox butoesJogador = new HBox(40);
    HBox butoesTreinador = new HBox(40);
    //endregion

    // region StackPanes
    StackPane stackPaneEquipa = new StackPane();
    StackPane stackPaneJogador = new StackPane();                    // Layout para organizar verticalmente os objetos
    StackPane stackPaneTreinador = new StackPane();                    // Layout para organizar verticalmente os objetos
    //endregion

    //region BorderPane
    BorderPane borderPaneControlo = new BorderPane();       // Layout Principal
    BorderPane borderPaneEquipa = new BorderPane();
    BorderPane borderPaneJogador = new BorderPane();
    BorderPane borderPaneTreinador = new BorderPane();
    //endregion

    //region Scenes & Stages
    Scene formControlo = new Scene(borderPaneControlo, 800, 600);   // Tratamento da janela
    Scene formEntidadeEquipa = new Scene(stackPaneEquipa, 726, 561);            // Tratamento da janela
    Stage entidadeEquipa = new Stage();
    Scene formEntidadeJogador = new Scene(stackPaneJogador, 726, 561);            // Tratamento da janela
    Stage entidadeJogador = new Stage();
    Scene formEntidadeTreinador = new Scene(stackPaneTreinador, 726, 561);            // Tratamento da janela
    Stage entidadeTreinador = new Stage();
    //endregion

    //region Opções do MenuStrip
    MenuBar menuBar = new MenuBar();
    Menu menuPrincipal = new Menu("_Principal");      // Menu Principal
    Menu menuHelp = new Menu("_Ajuda");      // Menu About Me
    MenuItem menuItemFileOpcaoEquipa = new MenuItem("Equipas");
    MenuItem menuItemFileOpcaoJogador = new MenuItem("Jogadores");
    MenuItem menuItemFileOpcaoTreinador = new MenuItem("Treinadores");
    MenuItem menuItemFileAcercaDe = new MenuItem("Acerca De:");
    //endregion

    //region TableView e respetivas Colunas
    TableView<Equipa> tableEquipa = new TableView<>();
    TableColumn<Equipa, String> colunaNomeEquipa = new TableColumn<>("Nome");
    TableColumn<Equipa, Boolean> colunaConvocada = new TableColumn<>("Convocada");
    TableColumn<Equipa, Long> colunaClassificacao = new TableColumn<>("Classificação");

    TableView<Jogador> tableJogador = new TableView<>();
    TableColumn<Jogador, String> colunaNomeJogador = new TableColumn<>("Nome");
    TableColumn<Jogador, Integer> colunaIdadeJogador = new TableColumn<>("Idade");
    TableColumn<Jogador, Double> colunaAlturaJogador = new TableColumn<>("Altura");
    TableColumn<Jogador, String> colunaPosicao = new TableColumn<>("Posição");

    TableView<Treinador> tableTreinador = new TableView<>();
    TableColumn<Treinador, String> colunaNomeTreinador = new TableColumn<>("Nome");
    TableColumn<Treinador, Integer> colunaIdadeTreinador = new TableColumn<>("Idade");
    TableColumn<Treinador, Double> colunaAlturaTreinador = new TableColumn<>("Altura");
    TableColumn<Treinador, String> colunaCategoria = new TableColumn<>("Categoria");
    //endregion

    //region Outras Variáveis
    boolean convocada;
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
            //region Inicialização das listas
            listaEquipas = new ArrayList<>();
            listaJogadores = new ArrayList<>();
            listaTreinadores = new ArrayList<>();
            //endregion

            //region Estilo e fonte das Labels
            labelEquipa.setFont(new Font("Cambria", 40));
            labelEquipa.setStyle("-fx-font-weight: bold");
            labelJogador.setFont(new Font("Cambria", 40));
            labelJogador.setStyle("-fx-font-weight: bold");
            labelTreinador.setFont(new Font("Cambria", 40));
            labelTreinador.setStyle("-fx-font-weight: bold");
            //endregion

            //region Tamanho dos Botões
            Add.setPrefSize(130, 60);
            Edit.setPrefSize(130, 60);
            Delete.setPrefSize(130, 60);
            Close.setPrefSize(130, 60);
            //endregion

            menuItemFileOpcaoEquipa.setOnAction(e -> {

                //region Propriedades das Colunas da TableView Equipas
                // Coluna Nome
                colunaNomeEquipa.setMinWidth(20);
                colunaNomeEquipa.setCellValueFactory(new PropertyValueFactory<>("nome"));

                //Coluna Convocada
                colunaConvocada.setMinWidth(20);
                colunaConvocada.setCellValueFactory(new PropertyValueFactory<>("convocada"));

                //Coluna Numero
                colunaClassificacao.setMinWidth(20);
                colunaClassificacao.setCellValueFactory(new PropertyValueFactory<>("classificacao"));
                //endregion

                //region TableView e ObservableList Stuff
                // Associação das colunas à TableView
                tableEquipa.getColumns().addAll(colunaNomeEquipa, colunaConvocada, colunaClassificacao);
                //endregion

                //region Botões Add, Edit e Delete
                Add.setOnAction(A -> {
                    ParteGraficaEquipaDetalhes();
                    Custom.setText("Adicionar");
                    Custom.setOnAction(AE -> {
                        AddEquipas();
                        ObservableList<Equipa> observableListEquipas = FXCollections.observableArrayList(listaEquipas);
                        tableEquipa.setItems(observableListEquipas);    // Adição da ObservableList à tableView
                    });
                });
                Edit.setOnAction(E -> {
                    if (tableEquipa.getSelectionModel().getSelectedItem() != null) {
                        ParteGraficaEquipaDetalhes();
                        Custom.setText("Edit");
                        Custom.setOnAction(EE -> {
                            EditEquipas();
                        });
                    }
                    else {
                    AlertBox.Show("Erro","Selecione uma Equipa antes de tentar editar");
                    }
                });
                Delete.setOnAction(DE -> {
                    ParteGraficaEquipaDetalhes();
                    Custom.setText("Delete");
                });
                Close.setOnAction(A -> {
                    entidadeEquipa.close();
                });
                //endregion

                //region Preparação da janela
                borderPaneEquipa.setTop(labelEquipa);
                borderPaneEquipa.setCenter(tableEquipa);
                borderPaneEquipa.setBottom(butoesEquipa);

                butoesEquipa.setPadding(new Insets(10, 20, 20, 20));
                butoesEquipa.getChildren().addAll(Add, Edit, Delete, Close);

                stackPaneEquipa.setPadding(new Insets(20, 20, 20, 20));            // espessura interna de cada bordo interno
                stackPaneEquipa.getChildren().add(borderPaneEquipa);

                entidadeEquipa.setScene(formEntidadeEquipa);
                entidadeEquipa.initModality(Modality.APPLICATION_MODAL);
                entidadeEquipa.setTitle("Equipas");
                entidadeEquipa.setResizable(false);
                entidadeEquipa.show();
                //endregion
            });
            menuItemFileOpcaoJogador.setOnAction(e -> {

                //region Propriedades das Colunas da TableView Jogadores
                // Coluna Nome
                colunaNomeJogador.setMinWidth(20);
                colunaNomeJogador.setCellValueFactory(new PropertyValueFactory<>("nome"));

                //Coluna Idade
                colunaIdadeJogador.setMinWidth(20);
                colunaIdadeJogador.setCellValueFactory(new PropertyValueFactory<>("idade"));

                //Coluna Altura
                colunaAlturaJogador.setMinWidth(20);
                colunaAlturaJogador.setCellValueFactory(new PropertyValueFactory<>("altura"));

                //Coluna Posição
                colunaPosicao.setMinWidth(20);
                colunaPosicao.setCellValueFactory(new PropertyValueFactory<>("posicao"));
                //endregion

                //region TableView e ObservableList Stuff
                // Associar as colunas à tabela
                tableJogador.getColumns().addAll(colunaNomeJogador, colunaIdadeJogador, colunaAlturaJogador, colunaPosicao);

                // Inicialização da ObservableList
                ObservableList<Jogador> listaJogadores = FXCollections.observableArrayList();

                // Carregamento de dados
                listaJogadores.add(new Jogador("Jogador", 8, 4, "seila"));

                // Adição da ObservableList à tableView
                tableJogador.setItems(listaJogadores);
                //endregion

                //region Botões Add, Edit e Delete
                Add.setOnAction(A -> {
                    ParteGraficaJogadorDetalhes();
                });
                Edit.setOnAction(A -> {
                    ParteGraficaJogadorDetalhes();
                });
                Delete.setOnAction(A -> {
                    ParteGraficaJogadorDetalhes();
                });
                Close.setOnAction(A -> {
                    ParteGraficaJogadorDetalhes();
                });
                //endregion

                //region Preparação da janela
                borderPaneJogador.setTop(labelJogador);
                borderPaneJogador.setCenter(tableJogador);
                borderPaneJogador.setBottom(butoesJogador);

                butoesJogador.setPadding(new Insets(10, 20, 20, 20));
                butoesJogador.getChildren().addAll(Add, Edit, Delete, Close);

                stackPaneJogador.setPadding(new Insets(20, 20, 20, 20));            // espessura interna de cada bordo interno
                stackPaneJogador.getChildren().add(borderPaneJogador);

                entidadeJogador.setScene(formEntidadeJogador);
                entidadeJogador.initModality(Modality.APPLICATION_MODAL);
                entidadeJogador.setTitle("Jogadores");
                entidadeJogador.setResizable(false);
                entidadeJogador.show();
                //endregion
            });
            menuItemFileOpcaoTreinador.setOnAction(e -> {

                //region Propriedades das Colunas da TableView Treinadores
                // Coluna Nome
                colunaNomeTreinador.setMinWidth(20);
                colunaNomeTreinador.setCellValueFactory(new PropertyValueFactory<>("nome"));

                //Coluna Idade
                colunaIdadeTreinador.setMinWidth(20);
                colunaIdadeTreinador.setCellValueFactory(new PropertyValueFactory<>("idade"));

                //Coluna Altura
                colunaAlturaTreinador.setMinWidth(20);
                colunaAlturaTreinador.setCellValueFactory(new PropertyValueFactory<>("altura"));

                //Coluna Posição
                colunaCategoria.setMinWidth(20);
                colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
                //endregion

                //region TableView e ObservableList Stuff
                // Associar as colunas à tabela
                tableTreinador.getColumns().addAll(colunaNomeTreinador, colunaIdadeTreinador, colunaAlturaTreinador, colunaCategoria);

                // Lista de alunos do tipo ObservableList<Classe>
                // A inicialização é sempre feita desta forma.
                ObservableList<Treinador> listaTreinadores = FXCollections.observableArrayList();

                // Carregamento de dados
                listaTreinadores.add(new Treinador("Treinador", 12, 12, "ABRE"));

                // Adição da ObservableList à tableView
                tableTreinador.setItems(listaTreinadores);
                //endregion

                //region Botões Add, Edit e Delete
                Add.setOnAction(A -> {
                    ParteGraficaTreinadorDetalhes();
                });
                Edit.setOnAction(A -> {
                    ParteGraficaTreinadorDetalhes();
                });
                Delete.setOnAction(A -> {
                    ParteGraficaTreinadorDetalhes();
                });
                Close.setOnAction(A -> {
                    primaryStage.show();
                });
                //endregion

                //region Preparação da janela

                borderPaneTreinador.setTop(labelTreinador);
                borderPaneTreinador.setCenter(tableTreinador);
                borderPaneTreinador.setBottom(butoesTreinador);

                butoesTreinador.setPadding(new Insets(10, 20, 20, 20));
                butoesTreinador.getChildren().addAll(Add, Edit, Delete, Close);

                stackPaneTreinador.setPadding(new Insets(20, 20, 20, 20));            // espessura interna de cada bordo interno
                stackPaneTreinador.getChildren().add(borderPaneTreinador);

                entidadeTreinador.setScene(formEntidadeTreinador);
                entidadeTreinador.initModality(Modality.APPLICATION_MODAL);
                entidadeTreinador.setTitle("Jogadores");
                entidadeTreinador.setResizable(false);
                entidadeTreinador.show();
                //endregion
            });

            menuItemFileAcercaDe.setOnAction(e -> {
                AcercaDe();
            });

            //region Adição dos MenuItems ao menuFile.
            menuPrincipal.getItems().addAll(
                    menuItemFileOpcaoEquipa,
                    menuItemFileOpcaoJogador,
                    menuItemFileOpcaoTreinador);

            menuHelp.getItems().add(menuItemFileAcercaDe);
            //endregion

            //region Criação do menuBar e associação dos Menus
            menuBar.getMenus().addAll(menuPrincipal, menuHelp);
            borderPaneControlo.setTop(menuBar);     // Associar o menu à região TOP do rootLayout
            //endregion

            //region Preparação da janela
            primaryStage.setScene(formControlo);
            primaryStage.setTitle("Torneio Tartaruga");
            primaryStage.setResizable(false);
            primaryStage.show();

            //endregion

        } catch (Exception e) {
            e.printStackTrace();        // qq exceção é exibida
        }
    }

    public void ParteGraficaEquipaDetalhes() {

        GridPane gridPaneEquipas = new GridPane();					// layout para a região central
        gridPaneEquipas.setAlignment(Pos.CENTER);
        gridPaneEquipas.setPadding(new Insets(20,20,20,20));
        gridPaneEquipas.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneEquipas.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        gridPaneEquipas.add(labelNome, 0, 0);		// célula col 0,linha 0
        gridPaneEquipas.add(textoNomeEquipa, 1, 0);       // célula: col 1, linha 0

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
        colunaNomeJogador.setMinWidth(20);
        colunaNomeJogador.setCellValueFactory(new PropertyValueFactory<>("jogadores"));

        // Coluna Treinador
        TableColumn<Equipa, String> colunaNomeTreinadoresDetalhes = new TableColumn<>("Treinadores");
        colunaNomeTreinador.setMinWidth(20);
        colunaNomeTreinador.setCellValueFactory(new PropertyValueFactory<>("treinadores"));

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

    public void ParteGraficaJogadorDetalhes(){

        GridPane gridPaneJogadores = new GridPane();					// layout para a região central
        gridPaneJogadores.setAlignment(Pos.CENTER);
        gridPaneJogadores.setPadding(new Insets(20,20,20,20));
        gridPaneJogadores.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneJogadores.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        gridPaneJogadores.add(labelNome, 0, 0);		// célula col 0,linha 0
        gridPaneJogadores.add(textoNomeJogador, 1, 0);       // célula: col 1, linha 0

        // Idade
        Label labelIdade = new Label("Convocada:");				// Nova Label
        gridPaneJogadores.add(labelIdade, 0, 1);		// célula col 0,linha 1
        gridPaneJogadores.add(textoIdadeJogador, 1, 1);		// célula: col 1, linha 1

        // Altura
        Label labelAltura = new Label("Classificação:");			// Nova Label
        gridPaneJogadores.add(labelAltura, 0, 2);		// célula col 0,linha 2
        gridPaneJogadores.add(textoAlturaJogador, 1, 2);		// célula: col 1, linha 2

        // Posição
        Label labelPosicao = new Label("Posicao:");			// Nova Label
        gridPaneJogadores.add(labelPosicao, 0, 3);		// célula col 0,linha 2
        gridPaneJogadores.add(textoPosicao, 1, 3);		// célula: col 1, linha 2

        // Jogador
        Label labelJogador = new Label("Equipa:");				// Nova Label
        gridPaneJogadores.add(labelJogador, 0, 4);		// célula col 0,linha 1
        gridPaneJogadores.add(textoEquipaJogador, 1, 4);		// célula: col 1, linha 1

        HBox Butoes = new HBox(40);
        Butoes.getChildren().addAll(Custom, Cancel);
        gridPaneJogadores.add(Butoes,1,5);

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

    public void ParteGraficaTreinadorDetalhes(){

        GridPane gridPaneTreinadores = new GridPane();					// layout para a região central
        gridPaneTreinadores.setAlignment(Pos.CENTER);
        gridPaneTreinadores.setPadding(new Insets(20,20,20,20));
        gridPaneTreinadores.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneTreinadores.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        gridPaneTreinadores.add(labelNome, 0, 0);		// célula col 0,linha 0
        gridPaneTreinadores.add(textoNomeTreinador, 1, 0);       // célula: col 1, linha 0

        // Idade
        Label labelIdade = new Label("Convocada:");				// Nova Label
        gridPaneTreinadores.add(labelIdade, 0, 1);		// célula col 0,linha 1
        gridPaneTreinadores.add(textoIdadeTreinador, 1, 1);		// célula: col 1, linha 1

        // Altura
        Label labelAltura = new Label("Classificação:");			// Nova Label
        gridPaneTreinadores.add(labelAltura, 0, 2);		// célula col 0,linha 2
        gridPaneTreinadores.add(textoAlturaTreinador, 1, 2);		// célula: col 1, linha 2

        // Categoria
        Label labelCategoria = new Label("Categoria:");			// Nova Label
        gridPaneTreinadores.add(labelCategoria, 0, 3);		// célula col 0,linha 2
        gridPaneTreinadores.add(textoCategoria, 1, 3);		// célula: col 1, linha 2

        // Treinadores
        Label labelEquipaTreinador = new Label("Treinador:");				// Nova Label
        gridPaneTreinadores.add(labelEquipaTreinador, 0, 4);		// célula col 0,linha 1
        gridPaneTreinadores.add(textoEquipaTreinador, 1, 4);		// célula: col 1, linha 1

        HBox Butoes = new HBox(40);
        Butoes.getChildren().addAll(Custom, Cancel);
        gridPaneTreinadores.add(Butoes,1,5);

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

    public void AcercaDe(){

        Image logo = new Image("file:Logo.jpg");
        ImageView imageViewLogo = new ImageView();
        imageViewLogo.setImage(logo);
        imageViewLogo.setPreserveRatio(true);
        imageViewLogo.setFitHeight(150);

        Image profilePhoto = new Image("file:Profile.png");
        ImageView imageViewProfilePhoto = new ImageView();
        imageViewProfilePhoto.setImage(profilePhoto);
        imageViewProfilePhoto.setPreserveRatio(true);
        imageViewProfilePhoto.setFitHeight(300);

        TextArea textoAcercaDe = new TextArea();
        textoAcercaDe.setMaxSize(515, 180);
        textoAcercaDe.setEditable(false);
        textoAcercaDe.setText("Escola Secundária Ferreira Dias \n" +
                " TGPSI - Curso técnico de gestão e programação de sistemas informáticos \n" +
                " Trabalho realizado no ambito da disciplina de PSI \n" +
                " 11º ano - 2ºGI\n" +
                "\n" +
                " Realizado por:\n" +
                " Gonçalo Coelho Nº 7 ");

        HBox HBoxAcercaDe = new HBox();
        HBoxAcercaDe.setAlignment(Pos.CENTER);
        HBoxAcercaDe.setSpacing(20);
        HBoxAcercaDe.getChildren().addAll(imageViewLogo, textoAcercaDe, imageViewProfilePhoto);

        Scene sceneAcercaDe = new Scene(HBoxAcercaDe,1000, 500);
        Stage stageAcercaDe = new Stage();
        stageAcercaDe.setScene(sceneAcercaDe);
        stageAcercaDe.initModality(Modality.APPLICATION_MODAL);
        stageAcercaDe.setTitle("Acerca De");
        stageAcercaDe.setResizable(false);
        stageAcercaDe.show();
    }

    /**
     * Esté é um método que está encarregado da adição das equipas na lista, este tem como parâmetros de entrada os jogadores e os treinadores, e tem como método de saída void.
     */
    public void AddEquipas() {

        if (textoNomeEquipa.getText().isEmpty() || textoConvocada.getText().isEmpty()|| textoClassificacao.getText().isEmpty())
        {
            AlertBox.Show("Erro","A Equipa não pode ser criada, porfavor preencha todos os espaços.");
        }
        else
        {
            if (textoConvocada.getText().equals("Sim") || textoConvocada.getText().equals("sim"))
            {
                if (Valida.number(textoClassificacao.getText()))
                {
                    AlertBox.Show("Erro","A classificação só pode ser demonstrada através de múmeros, porfavor introduza novos dados");
                }
                else
                {
                    convocada = true;
                    Equipa Equipa = new Equipa(textoNomeEquipa.getText(), convocada, Long.parseLong(textoClassificacao.getText()));
                    listaEquipas.add(Equipa);
                }
            }
            else if (textoConvocada.getText().equals("Não") || textoConvocada.getText().equals("não"))
            {
                if (Valida.number(textoClassificacao.getText()))
                {
                    AlertBox.Show("Erro","A classificação só pode ser demonstrada através de múmeros, porfavor introduza novos dados");
                }
                else
                {
                    convocada = false;
                    Equipa Equipa = new Equipa(textoNomeEquipa.getText(), convocada, Long.parseLong(textoClassificacao.getText()));
                    listaEquipas.add(Equipa);
                }
            }
            else
            {
                AlertBox.Show("Erro","O que introduziu não se encontra de acordo com os parâmetros que são requeridos ... ");
            }
        }
        textoNomeEquipa.clear();
        textoConvocada.clear();
        textoClassificacao.clear();
    }

    public void EditEquipas() {

        textoNomeEquipa.setText(tableEquipa.getSelectionModel().getSelectedItem().getNome());
        if (tableEquipa.getSelectionModel().getSelectedItem().getConvocada() == true)
        {
            textoConvocada.setText("Sim");
        }
        else
        {
            textoConvocada.setText("Não");
        }
        textoConvocada.setText(String.valueOf(tableEquipa.getSelectionModel().getSelectedItem().getClassificacao()));
    }
}