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

    String strAction;
    int selectedIndex;

    MenuBar menuBar = new MenuBar();
    StackPane stackPane = new StackPane();                    // Layout para organizar verticalmente os objetos
    BorderPane rootLayout = new BorderPane();       // Layout Principal
    Scene Controlo = new Scene(rootLayout, 1204, 731);   // Tratamento da janela

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

            // Criação das Labels
            Label labelEquipa = new Label("Equipas");
            labelEquipa.setFont(new Font("Cambria", 40));
            labelEquipa.setStyle("-fx-font-weight: bold");

            Label labelJogadores = new Label("Jogadores");
            labelJogadores.setFont(new Font("Cambria", 40));
            labelJogadores.setStyle("-fx-font-weight: bold");

            Label labelTreinadores = new Label("Treinadores");
            labelTreinadores.setFont(new Font("Cambria", 40));
            labelTreinadores.setStyle("-fx-font-weight: bold");


            // Criação dos botões
            Button Add = new Button("Adicionar");
            Button Edit = new Button("Editar");
            Button Delete = new Button("Eliminar");
            Button Close = new Button("Fechar Lista");
            Button Custom = new Button("'Custom'");
            Button Cancel = new Button("Cancel");

            Add.setPrefSize(130, 60);
            Edit.setPrefSize(130, 60);
            Delete.setPrefSize(130, 60);
            Close.setPrefSize(130, 60);

            // Construtor recebe uma string com o nome do menu
            Menu menuFile = new Menu("_Principal");      // Menu Principal
            Menu menuEdit = new Menu("_About Me");      // Menu About Me

            // Opções do Menu Strip
            MenuItem menuItemFileOpcaoEquipas = new MenuItem("Equipas");
            MenuItem menuItemFileOpcaoJogadores = new MenuItem("Jogadores");
            MenuItem menuItemFileOpcaoTreinadores = new MenuItem("Treinadores");

            // Listeners - Com as funções de cada opção do menu Strip
            menuItemFileOpcaoEquipas.setOnAction(e -> {

                //////////////////////////////////////////////////////////////////////////////////////
                //  Criação da TableView
                //////////////////////////////////////////////////////////////////////////////////////

                // Criação do objeto da classe TableView: null
                TableView<Equipa> tableEquipas = new TableView<>();    //

                // Coluna Nome
                TableColumn<Equipa, String> colunaNome = new TableColumn<>("Nome");
                colunaNome.setMinWidth(20);
                colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

                //Coluna Convocada
                TableColumn<Equipa, Boolean> colunaConvocada = new TableColumn<>("Convocada");
                colunaConvocada.setMinWidth(20);
                colunaConvocada.setCellValueFactory(new PropertyValueFactory<>("convocada"));

                //Coluna Numero
                TableColumn<Equipa, Long> colunaClassificacao = new TableColumn<>("Classificação");
                colunaConvocada.setMinWidth(20);
                colunaConvocada.setCellValueFactory(new PropertyValueFactory<>("classificacao"));

                // Associar as colunas à tabela
                tableEquipas.getColumns().addAll(colunaNome, colunaConvocada, colunaClassificacao);

                // Lista de alunos do tipo ObservableList<Classe>
                // A inicialização é sempre feita desta forma.
                ObservableList<Equipa> listaEquipas = FXCollections.observableArrayList();

                // Carregamento de dados
                listaEquipas.add(new Equipa("Dude", true, 12));

                // Adição da ObservableList à tableView
                tableEquipas.setItems(listaEquipas);

                Add.setOnAction(A -> {
                    Equipa equipaAdd = new Equipa();
                    equipaAdd.ParteGrafica(Custom, Cancel);
                });
                Edit.setOnAction(A -> {
                    Equipa equipaEdit = new Equipa();
                    equipaEdit.ParteGrafica(Custom, Cancel);
                });
                Delete.setOnAction(A -> {
                    Equipa equipaDelete = new Equipa();
                    equipaDelete.ParteGrafica(Custom, Cancel);
                });
                Close.setOnAction(A -> {
                    primaryStage.show();
                });

                //////////////////////////////////////////////////////////////////////////////////////
                // Preparação da janela
                //////////////////////////////////////////////////////////////////////////////////////

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
            });
            menuItemFileOpcaoJogadores.setOnAction(e -> {

                //////////////////////////////////////////////////////////////////////////////////////
                //  Criação da TableView
                //////////////////////////////////////////////////////////////////////////////////////

                // Criação do objeto da classe TableView: null
                TableView<Jogador> tableJogadores = new TableView<>();    //

                // Coluna Nome
                TableColumn<Jogador, String> colunaNome = new TableColumn<>("Nome");
                colunaNome.setMinWidth(20);
                colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

                //Coluna Idade
                TableColumn<Jogador, Integer> colunaIdade = new TableColumn<>("Idade");
                colunaIdade.setMinWidth(20);
                colunaIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));

                //Coluna Altura
                TableColumn<Jogador, Double> colunaAltura = new TableColumn<>("Altura");
                colunaAltura.setMinWidth(20);
                colunaAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));

                //Coluna Posição
                TableColumn<Jogador, String> colunaPosicao = new TableColumn<>("Posição");
                colunaPosicao.setMinWidth(20);
                colunaPosicao.setCellValueFactory(new PropertyValueFactory<>("posicao"));

                // Associar as colunas à tabela
                tableJogadores.getColumns().addAll(colunaNome, colunaIdade, colunaAltura, colunaPosicao);

                // Lista de alunos do tipo ObservableList<Classe>
                // A inicialização é sempre feita desta forma.
                ObservableList<Jogador> listaJogadores = FXCollections.observableArrayList();

                // Carregamento de dados
                listaJogadores.add(new Jogador("Jogador", 8, 4, "seila"));

                // Adição da ObservableList à tableView
                tableJogadores.setItems(listaJogadores);

                Add.setOnAction(A -> {
                    Jogador jogadorAdd = new Jogador();
                    jogadorAdd.ParteGrafica(Custom, Cancel);
                });
                Edit.setOnAction(A -> {
                    Jogador jogadorEdit = new Jogador();
                    jogadorEdit.ParteGrafica(Custom, Cancel);
                });
                Delete.setOnAction(A -> {
                    Jogador jogadorDelete = new Jogador();
                    jogadorDelete.ParteGrafica(Custom, Cancel);
                });
                Close.setOnAction(A -> {
                    primaryStage.setScene(Controlo);
                    primaryStage.show();
                });

                //////////////////////////////////////////////////////////////////////////////////////
                // Preparação da janela
                //////////////////////////////////////////////////////////////////////////////////////

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
            });
            menuItemFileOpcaoTreinadores.setOnAction(e -> {

                //////////////////////////////////////////////////////////////////////////////////////
                //  Criação da TableView
                //////////////////////////////////////////////////////////////////////////////////////

                // Criação do objeto da classe TableView: null
                TableView<Treinador> tableTreinadores = new TableView<>();    //

                // Coluna Nome
                TableColumn<Treinador, String> colunaNome = new TableColumn<>("Nome");
                colunaNome.setMinWidth(20);
                colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

                //Coluna Idade
                TableColumn<Treinador, Integer> colunaIdade = new TableColumn<>("Idade");
                colunaIdade.setMinWidth(20);
                colunaIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));

                //Coluna Altura
                TableColumn<Treinador, Double> colunaAltura = new TableColumn<>("Altura");
                colunaAltura.setMinWidth(20);
                colunaAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));

                //Coluna Posição
                TableColumn<Treinador, String> colunaCategoria = new TableColumn<>("Categoria");
                colunaCategoria.setMinWidth(20);
                colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

                // Associar as colunas à tabela
                tableTreinadores.getColumns().addAll(colunaNome, colunaIdade, colunaAltura, colunaCategoria);

                // Lista de alunos do tipo ObservableList<Classe>
                // A inicialização é sempre feita desta forma.
                ObservableList<Treinador> listaTreinadores = FXCollections.observableArrayList();

                // Carregamento de dados
                listaTreinadores.add(new Treinador("Treinador", 12, 12, "ABRE"));

                // Adição da ObservableList à tableView
                tableTreinadores.setItems(listaTreinadores);

                Add.setOnAction(A -> {
                    Treinador TreinadorAdd = new Treinador();
                    TreinadorAdd.ParteGrafica(Custom, Cancel);
                });
                Edit.setOnAction(A -> {
                    Treinador TreinadorEdit = new Treinador();
                    TreinadorEdit.ParteGrafica(Custom, Cancel);
                });
                Delete.setOnAction(A -> {
                    Treinador TreinadorDelete = new Treinador();
                    TreinadorDelete.ParteGrafica(Custom, Cancel);
                });
                Close.setOnAction(A -> {
                    primaryStage.show();
                });

                //////////////////////////////////////////////////////////////////////////////////////
                // Preparação da janela
                //////////////////////////////////////////////////////////////////////////////////////

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
            });

            // Adicionar os MenuItems ao menuFile.
            menuFile.getItems().addAll(
                    menuItemFileOpcaoEquipas,
                    menuItemFileOpcaoJogadores,
                    menuItemFileOpcaoTreinadores);

            ///////////////////////////////////////////////////////////////////////////////
            // Passo 3 - Criar o menuBar e associar os menus
            ///////////////////////////////////////////////////////////////////////////////

            menuBar.getMenus().addAll(menuFile, menuEdit);
            // Associar o menu à região TOP do rootLayout
            rootLayout.setTop(menuBar);

            ///////////////////////////////////////////////////////////////////////////////
            // Associar o rootLayout à Scene e esta à Stage
            ///////////////////////////////////////////////////////////////////////////////

            primaryStage.setScene(Controlo);
            primaryStage.setTitle("Torneio Tartaruga");
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();        // qq exceção é exibida
        }
    }
}