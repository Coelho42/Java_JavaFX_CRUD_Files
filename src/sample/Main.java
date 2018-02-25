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
                    Equipa graficosAdd = new Equipa(Custom, Cancel);
                });
                Edit.setOnAction(A -> {
                    Equipa graficosEdit = new Equipa(Custom, Cancel);
                });
                Delete.setOnAction(A -> {
                    Equipa graficosDelete = new Equipa(Custom, Cancel);
                });
                Close.setOnAction(A -> {
                    primaryStage.show();
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

                });
                Edit.setOnAction(A -> {

                });
                Delete.setOnAction(A -> {

                });
                Close.setOnAction(A -> {
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

                });
                Edit.setOnAction(A -> {

                });
                Delete.setOnAction(A -> {

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
}