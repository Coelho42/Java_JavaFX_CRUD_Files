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

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    //region Botões
    Button addEquipa = new Button("Adicionar");
    Button editEquipa = new Button("Editar");
    Button deleteEquipa = new Button("Eliminar");
    Button closeEquipa = new Button("Fechar Lista");
    Button cemRegistosEquipa = new Button("100 Registos");
    Button customEquipa = new Button("'Custom'");
    Button cancelEquipa = new Button("Cancel");
    Button associarJogador = new Button("Associar Jogador");
    Button associarTreinador = new Button("Associar Treinador");
    Button desassociarJogador = new Button("Desassociar Jogador");
    Button desassociarTreinador = new Button ("Desassociar Treinador");



    Button addJogador = new Button("Adicionar");
    Button editJogador = new Button("Editar");
    Button deleteJogador = new Button("Eliminar");
    Button closeJogador = new Button("Fechar Lista");
    Button cemRegistosJogador = new Button("100 Registos");
    Button customJogador = new Button("'Custom'");
    Button cancelJogador= new Button("Cancel");
    Button associarJogadorGraf = new Button("Associar");
    Button cancelAssociarJogadorGraf = new Button ("Cancelar");

    Button addTreinador = new Button("Adicionar");
    Button editTreinador = new Button("Editar");
    Button deleteTreinador= new Button("Eliminar");
    Button closeTreinador = new Button("Fechar Lista");
    Button cemRegistosTreinador = new Button("100 Registos");
    Button customTreinador = new Button("'Custom'");
    Button cancelTreinador = new Button("Cancel");
    Button associarTreinadorGraf = new Button("Associar");
    Button cancelAssociarTreinadorGraf = new Button ("Cancelar");
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

    //region Scenes & Stages
    Stage entidadeEquipaLista = new Stage();
    Stage entidadeEquipaDetalhes = new Stage();
    Stage entidadeJogadorLista = new Stage();
    Stage entidadeJogadorDetalhes = new Stage();
    Stage entidadeTreinadorLista = new Stage();
    Stage entidadeTreinadorDetalhes = new Stage();
    //endregion

    //region TableView e respetivas Colunas
    TableView<Equipa> tableEquipa = new TableView<>();
    ObservableList<Equipa> observableListEquipas;
    TableView<Jogador> tableJogador = new TableView<>();
    ObservableList<Jogador> observableListJogadores;
    TableView<Treinador> tableTreinador = new TableView<>();
    ObservableList<Treinador> observableListTreinadores;
    TableView<Jogador> tableEquipaJogadores = new TableView<>();
    ObservableList<Jogador> observableListEquipaJogadores;
    TableView<Treinador> tableEquipaTreinadores = new TableView<>();
    ObservableList<Treinador> observableListEquipaTreinadores;
    //endregion

    //region Outras Variáveis
    boolean convocada;
    Equipa equipaSelecionada;
    Jogador jogadorSelecionado;
    Treinador treinadorSelecionado;
    String fileAndLocation = "D:\\Users\\a50445\\Desktop\\Valores.bin\\";
    //String fileAndLocation = "C:\\Users\\MSI\\Desktop\\Valores.bin\\";
    SerializarDesserializar listas;
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

            //region Inicialização das Partes Gráficas
            ParteGraficaEquipa();
            ParteGraficaEquipaDetalhes();
            ParteGraficaJogador();
            ParteGraficaJogadorDetalhes();
            ParteGraficaTreinador();
            ParteGraficaTreinadorDetalhes();
            //endregion

            //region Adição dos MenuItems ao menuFile.
            Menu menuPrincipal = new Menu("_Principal");      // Menu Principal
            Menu menuHelp = new Menu("_Ajuda");      // Menu About Me
            MenuItem menuItemFileOpcaoEquipa = new MenuItem("Equipas");
            MenuItem menuItemFileOpcaoJogador = new MenuItem("Jogadores");
            MenuItem menuItemFileOpcaoTreinador = new MenuItem("Treinadores");
            MenuItem menuItemFileOpcaoSave = new MenuItem("Save");
            MenuItem menuItemFileOpcaoLoad = new MenuItem("Load");
            MenuItem menuItemFileOpcaoSair = new MenuItem("Sair");
            MenuItem menuItemFileAcercaDe = new MenuItem("Acerca De:");
            menuPrincipal.getItems().addAll(
                    menuItemFileOpcaoEquipa,
                    menuItemFileOpcaoJogador,
                    menuItemFileOpcaoTreinador,
                    menuItemFileOpcaoSave,
                    menuItemFileOpcaoLoad,
                    menuItemFileOpcaoSair);

            menuHelp.getItems().add(menuItemFileAcercaDe);
            //endregion

            //region Criação do menuBar e associação dos Menus
            MenuBar menuBar = new MenuBar();
            menuBar.getMenus().addAll(menuPrincipal, menuHelp);
            //endregion

            //region Preparação da janela
            BorderPane borderPaneControlo = new BorderPane();       // Layout Principal
            borderPaneControlo.setTop(menuBar);     // Associar o menu à região TOP do rootLayout
            Scene formControlo = new Scene(borderPaneControlo, 800, 600);   // Tratamento da janela
            primaryStage.setScene(formControlo);
            primaryStage.setTitle("Torneio Tartaruga");
            primaryStage.setResizable(false);
            primaryStage.show();

            menuItemFileOpcaoEquipa.setOnAction(e -> {
                associarJogador.setDisable(true);
                associarTreinador.setDisable(true);
                desassociarTreinador.setDisable(true);
                desassociarJogador.setDisable(true);
                tableEquipaTreinadores.setDisable(true);
                tableEquipaJogadores.setDisable(true);
                observableListEquipas = FXCollections.observableArrayList(listaEquipas);
                tableEquipa.setItems(observableListEquipas);    // Adição da ObservableList à tableView
                tableEquipa.refresh();
                entidadeEquipaLista.show();
                //region Botões Add, Edit e Delete
                addEquipa.setOnAction(AE -> {
                    textoNomeEquipa.setEditable(true);
                    textoConvocada.setEditable(true);
                    textoClassificacao.setEditable(true);
                    textoNomeEquipa.clear();
                    textoConvocada.clear();
                    textoClassificacao.clear();
                    tableEquipaTreinadores.setDisable(true);
                    tableEquipaJogadores.setDisable(true);
                    entidadeEquipaDetalhes.show();
                    customEquipa.setText("Adicionar");
                    customEquipa.setOnAction(CE -> {
                        AddEquipas();
                    });
                    cancelEquipa.setOnAction(Cancel -> {
                        entidadeEquipaDetalhes.close();
                    });
                });
                editEquipa.setOnAction(EE -> {
                    associarJogador.setDisable(false);
                    associarTreinador.setDisable(false);
                    desassociarJogador.setDisable(false);
                    desassociarTreinador.setDisable(false);
                    tableEquipaTreinadores.setDisable(false);
                    tableEquipaJogadores.setDisable(false);
                    textoNomeEquipa.setEditable(true);
                    textoConvocada.setEditable(true);
                    textoClassificacao.setEditable(true);

                    if (tableEquipa.getSelectionModel().getSelectedItem() != null) {
                        entidadeEquipaDetalhes.show();
                        equipaSelecionada = tableEquipa.getSelectionModel().getSelectedItem();
                        textoNomeEquipa.setText(equipaSelecionada.getNome());
                        if (equipaSelecionada.getConvocada() == true) {
                            textoConvocada.setText("Sim");
                        }
                        else {
                            textoConvocada.setText("Não");
                        }
                        textoClassificacao.setText(String.valueOf(equipaSelecionada.getClassificacao()));
                        observableListEquipaJogadores = FXCollections.observableArrayList(equipaSelecionada.getJogadorList());
                        tableEquipaJogadores.setItems(observableListEquipaJogadores);    // Adição da ObservableList à tableView
                        tableEquipaJogadores.refresh();
                        observableListEquipaTreinadores = FXCollections.observableArrayList(equipaSelecionada.getTreinadorList());
                        tableEquipaTreinadores.setItems(observableListEquipaTreinadores);    // Adição da ObservableList à tableView
                        tableEquipaTreinadores.refresh();
                        customEquipa.setText("Edit");
                        customEquipa.setOnAction(CE -> {
                            EditEquipas();
                        });

                        associarJogador.setOnAction(aE -> {
                            addJogador.setVisible(false);
                            editJogador.setVisible(false);
                            deleteJogador.setVisible(false);
                            cemRegistosJogador.setVisible(false);
                            closeJogador.setVisible(false);
                            associarJogadorGraf.setVisible(true);
                            cancelAssociarJogadorGraf.setVisible(true);
                            for (Jogador jogador : equipaSelecionada.getJogadorList()) {
                                observableListJogadores.remove(jogador);
                                tableJogador.setItems(observableListJogadores);
                                tableJogador.refresh();
                            }
                            entidadeJogadorLista.show();

                            associarJogadorGraf.setOnAction(aJ -> {
                                if (tableJogador.getSelectionModel().getSelectedItem() != null) {
                                    jogadorSelecionado = tableJogador.getSelectionModel().getSelectedItem();
                                    equipaSelecionada.getJogadorList().add(jogadorSelecionado);
                                    tableJogador.getSelectionModel().getSelectedItem().setEquipa(equipaSelecionada);
                                    observableListEquipaJogadores = FXCollections.observableArrayList(equipaSelecionada.getJogadorList());
                                    tableEquipaJogadores.setItems(observableListEquipaJogadores);    // Adição da ObservableList à tableView
                                    tableEquipaJogadores.refresh();
                                    entidadeJogadorLista.close();
                                }
                                else {
                                    AlertBox.Show("Erro", "Não selecionou nenhum jogador para associar à equipa, porfavor selecione um Jogador.");
                                }
                            });
                            cancelAssociarJogadorGraf.setOnAction(cA -> {
                                entidadeJogadorLista.close();
                            });
                        });
                        associarTreinador.setOnAction(aE -> {
                            addTreinador.setVisible(false);
                            editTreinador.setVisible(false);
                            deleteTreinador.setVisible(false);
                            cemRegistosTreinador.setVisible(false);
                            closeTreinador.setVisible(false);
                            associarTreinadorGraf.setVisible(true);
                            cancelAssociarTreinadorGraf.setVisible(true);
                            for (Treinador treinador : equipaSelecionada.getTreinadorList()) {
                                observableListTreinadores.remove(treinador);
                                tableTreinador.setItems(observableListTreinadores);
                                tableTreinador.refresh();
                            }
                            entidadeTreinadorLista.show();

                            associarTreinadorGraf.setOnAction(aT -> {
                                if (tableTreinador.getSelectionModel().getSelectedItem() != null) {
                                    treinadorSelecionado = tableTreinador.getSelectionModel().getSelectedItem();
                                    equipaSelecionada.getTreinadorList().add(treinadorSelecionado);
                                    tableTreinador.getSelectionModel().getSelectedItem().setEquipa(equipaSelecionada);
                                    observableListEquipaTreinadores = FXCollections.observableArrayList(equipaSelecionada.getTreinadorList());
                                    tableEquipaTreinadores.setItems(observableListEquipaTreinadores);    // Adição da ObservableList à tableView
                                    tableEquipaTreinadores.refresh();
                                    entidadeTreinadorLista.close();
                                }
                                else {
                                    AlertBox.Show("Erro", "Não selecionou nenhum jogador para associar à equipa, porfavor selecione um Jogador.");
                                }
                            });
                            cancelAssociarTreinadorGraf.setOnAction(cA -> {
                                entidadeTreinadorLista.close();
                            });
                        });

                        desassociarJogador.setOnAction(dJ -> {
                            if (tableJogador.getSelectionModel().getSelectedItem() != null) {
                                equipaSelecionada.getJogadorList().remove(tableEquipaJogadores.getSelectionModel().getSelectedItem());
                                observableListJogadores.add(tableEquipaJogadores.getSelectionModel().getSelectedItem());
                                tableJogador.setItems(observableListJogadores);
                                tableJogador.refresh();
                                observableListEquipaJogadores = FXCollections.observableArrayList(equipaSelecionada.getJogadorList());
                                tableEquipaJogadores.setItems(observableListEquipaJogadores);    // Adição da ObservableList à tableView
                                tableEquipaJogadores.refresh();
                            }
                            else {
                                AlertBox.Show("Erro", "Não selecionou nenhum jogador para desassociar à equipa.");
                            }
                        });
                        desassociarTreinador.setOnAction(dJ -> {
                            if (tableTreinador.getSelectionModel().getSelectedItem() != null) {
                                equipaSelecionada.getTreinadorList().remove(tableEquipaTreinadores.getSelectionModel().getSelectedItem());
                                observableListTreinadores.add(tableEquipaTreinadores.getSelectionModel().getSelectedItem());
                                tableTreinador.setItems(observableListTreinadores);
                                tableTreinador.refresh();
                                observableListEquipaTreinadores = FXCollections.observableArrayList(equipaSelecionada.getTreinadorList());
                                tableEquipaTreinadores.setItems(observableListEquipaTreinadores);    // Adição da ObservableList à tableView
                                tableEquipaTreinadores.refresh();
                            }
                            else {
                                AlertBox.Show("Erro", "Não selecionou nenhum treinador para desassociar à equipa.");
                            }
                        });
                        cancelEquipa.setOnAction(Cancel -> {
                            entidadeEquipaDetalhes.close();
                        });
                    }
                    else {
                        AlertBox.Show("Erro","Selecione uma Equipa antes de tentar editar");
                    }
                });

                deleteEquipa.setOnAction(DE -> {
                    associarJogador.setDisable(true);
                    associarTreinador.setDisable(true);
                    desassociarJogador.setDisable(true);
                    desassociarTreinador.setDisable(true);
                    tableEquipaTreinadores.setDisable(true);
                    tableEquipaJogadores.setDisable(true);
                    entidadeJogadorLista.close();
                    if (tableEquipa.getSelectionModel().getSelectedItem() != null) {
                        entidadeEquipaDetalhes.show();
                        equipaSelecionada = tableEquipa.getSelectionModel().getSelectedItem();
                        textoNomeEquipa.setText(equipaSelecionada.getNome());
                        textoNomeEquipa.setEditable(false);
                        if (equipaSelecionada.getConvocada() == true) {
                            textoConvocada.setText("Sim");
                        }
                        else {
                            textoConvocada.setText("Não");
                        }
                        textoConvocada.setEditable(false);
                        textoClassificacao.setText(String.valueOf(equipaSelecionada.getClassificacao()));
                        textoClassificacao.setEditable(false);
                        observableListEquipaJogadores = FXCollections.observableArrayList(equipaSelecionada.getJogadorList());
                        tableEquipaJogadores.setItems(observableListEquipaJogadores);    // Adição da ObservableList à tableView
                        tableEquipaJogadores.refresh();
                        observableListEquipaTreinadores = FXCollections.observableArrayList(equipaSelecionada.getTreinadorList());
                        tableEquipaTreinadores.setItems(observableListEquipaTreinadores);    // Adição da ObservableList à tableView
                        tableEquipaTreinadores.refresh();
                        customEquipa.setText("Delete");
                        customEquipa.setOnAction(CE -> {
                            DeleteEquipas();
                        });
                        cancelEquipa.setOnAction(Cancel -> {
                            entidadeEquipaDetalhes.close();
                        });
                    }
                    else {
                        AlertBox.Show("Erro", "Selecione uma Equipa antes de tentar Eliminar");
                    }
                });
                cemRegistosEquipa.setOnAction(CR -> {
                    for(int i = 0; i <= 99; i++) {
                        listaEquipas.add(new Equipa("Equipa", true, 12));
                    }
                    observableListEquipas = FXCollections.observableArrayList(listaEquipas);
                    tableEquipa.setItems(observableListEquipas);    // Adição da ObservableList à tableView
                    tableEquipa.refresh();
                });
                closeEquipa.setOnAction(CE -> {
                    entidadeEquipaLista.close();
                });
                //endregion
            });
            menuItemFileOpcaoJogador.setOnAction(e -> {
                addJogador.setVisible(true);
                editJogador.setVisible(true);
                deleteJogador.setVisible(true);
                cemRegistosJogador.setVisible(true);
                closeJogador.setVisible(true);
                associarJogadorGraf.setVisible(false);
                cancelAssociarJogadorGraf.setVisible(false);
                observableListJogadores = FXCollections.observableArrayList(listaJogadores);
                tableJogador.setItems(observableListJogadores);    // Adição da ObservableList à tableView
                tableJogador.refresh();
                entidadeJogadorLista.show();

                //region Botões Add, Edit e Delete
                addJogador.setOnAction(AJ -> {
                    textoNomeJogador.setEditable(true);
                    textoIdadeJogador.setEditable(true);
                    textoAlturaJogador.setEditable(true);
                    textoPosicao.setEditable(true);
                    textoEquipaJogador.setEditable(false);
                    textoNomeJogador.clear();
                    textoIdadeJogador.clear();
                    textoAlturaJogador.clear();
                    textoPosicao.clear();
                    entidadeJogadorDetalhes.show();
                    customJogador.setText("Adicionar");
                    customJogador.setOnAction(CE -> {
                        AddJogadores();
                    });
                    cancelJogador.setOnAction(CE -> {
                        entidadeJogadorDetalhes.close();
                    });
                });

                editJogador.setOnAction(EJ -> {
                    textoNomeJogador.setEditable(true);
                    textoIdadeJogador.setEditable(true);
                    textoAlturaJogador.setEditable(true);
                    textoPosicao.setEditable(true);
                    textoEquipaJogador.setEditable(false);
                    if (tableJogador.getSelectionModel().getSelectedItem() != null) {
                        entidadeJogadorDetalhes.show();
                        jogadorSelecionado = tableJogador.getSelectionModel().getSelectedItem();
                        textoNomeJogador.setText(jogadorSelecionado.getNome());
                        textoIdadeJogador.setText(String.valueOf(jogadorSelecionado.getIdade()));
                        textoAlturaJogador.setText(String.valueOf(jogadorSelecionado.getAltura()));
                        textoPosicao.setText(jogadorSelecionado.getPosicao());
                        if (jogadorSelecionado.getEquipa() == null){
                            textoEquipaJogador.setText(null);
                        }
                        else {
                            textoEquipaJogador.setText(jogadorSelecionado.getEquipa().getNome());
                        }
                        customJogador.setText("Edit");
                        customJogador.setOnAction(CE -> {
                            EditJogadores();
                            System.out.println(jogadorSelecionado.getEquipa());
                        });
                        cancelJogador.setOnAction(CE -> {
                            entidadeJogadorDetalhes.close();
                        });
                    }
                    else {
                        AlertBox.Show("Erro","Selecione um Jogador antes de tentar editar");
                    }
                });
                deleteJogador.setOnAction(DJ -> {
                    if (tableJogador.getSelectionModel().getSelectedItem() != null) {
                        entidadeJogadorDetalhes.show();
                        jogadorSelecionado = tableJogador.getSelectionModel().getSelectedItem();
                        textoNomeJogador.setText(jogadorSelecionado.getNome());
                        textoNomeJogador.setEditable(false);
                        textoIdadeJogador.setText(String.valueOf(jogadorSelecionado.getIdade()));
                        textoIdadeJogador.setEditable(false);
                        textoAlturaJogador.setText(String.valueOf(jogadorSelecionado.getAltura()));
                        textoAlturaJogador.setEditable(false);
                        textoPosicao.setText(jogadorSelecionado.getPosicao());
                        textoPosicao.setEditable(false);
                        if (jogadorSelecionado.getEquipa() == null){
                            textoEquipaJogador.setText(null);
                        }
                        else {
                            textoEquipaJogador.setText(jogadorSelecionado.getEquipa().getNome());
                        }
                        textoEquipaJogador.setEditable(false);
                        customJogador.setText("Delete");
                        customJogador.setOnAction(CE -> {
                            DeleteJogadores();
                        });
                        cancelJogador.setOnAction(CE -> {
                            entidadeJogadorDetalhes.close();
                        });
                    }
                    else {
                        AlertBox.Show("Erro", "Selecione um Jogador antes de tentar Eliminar");
                    }
                });
                cemRegistosJogador.setOnAction(CR -> {
                    for(int i = 0; i <= 99; i++)
                    {
                        listaJogadores.add(new Jogador("Jogador", 16,24.4,"extremo"));
                    }
                    observableListJogadores = FXCollections.observableArrayList(listaJogadores);
                    tableJogador.setItems(observableListJogadores);    // Adição da ObservableList à tableView
                    tableJogador.refresh();
                });
                closeJogador.setOnAction(CJ -> {
                    entidadeJogadorLista.close();
                });
                //endregion
            });
            menuItemFileOpcaoTreinador.setOnAction(e -> {
                addTreinador.setVisible(true);
                editTreinador.setVisible(true);
                deleteTreinador.setVisible(true);
                cemRegistosTreinador.setVisible(true);
                closeTreinador.setVisible(true);
                associarTreinadorGraf.setVisible(false);
                cancelAssociarTreinadorGraf.setVisible(false);
                observableListTreinadores = FXCollections.observableArrayList(listaTreinadores);
                tableTreinador.setItems(observableListTreinadores);    // Adição da ObservableList à tableView
                tableTreinador.refresh();
                entidadeTreinadorLista.show();
                //region Botões Add, Edit e Delete
                addTreinador.setOnAction(A -> {
                    textoNomeTreinador.setEditable(true);
                    textoIdadeTreinador.setEditable(true);
                    textoAlturaTreinador.setEditable(true);
                    textoCategoria.setEditable(true);
                    textoEquipaTreinador.setEditable(false);
                    textoNomeTreinador.clear();
                    textoIdadeTreinador.clear();
                    textoAlturaTreinador.clear();
                    textoCategoria.clear();
                    entidadeTreinadorDetalhes.show();
                    customTreinador.setText("Adicionar");
                    customTreinador.setOnAction(CE -> {
                        AddTreinadores();
                    });
                    cancelTreinador.setOnAction(CE -> {
                        entidadeTreinadorDetalhes.close();
                    });
                });
                editTreinador.setOnAction(A -> {
                    textoNomeTreinador.setEditable(true);
                    textoIdadeTreinador.setEditable(true);
                    textoAlturaTreinador.setEditable(true);
                    textoCategoria.setEditable(true);
                    textoEquipaTreinador.setEditable(false);
                    if (tableTreinador.getSelectionModel().getSelectedItem() != null) {
                        entidadeTreinadorDetalhes.show();
                        treinadorSelecionado = tableTreinador.getSelectionModel().getSelectedItem();
                        textoNomeTreinador.setText(treinadorSelecionado.getNome());
                        textoIdadeTreinador.setText(String.valueOf(treinadorSelecionado.getIdade()));
                        textoAlturaTreinador.setText(String.valueOf(treinadorSelecionado.getAltura()));
                        textoCategoria.setText(treinadorSelecionado.getCategoria());
                        if (treinadorSelecionado.getEquipa() == null){
                            textoEquipaTreinador.setText(null);
                        }
                        else {
                            textoEquipaTreinador.setText(treinadorSelecionado.getEquipa().getNome());
                        }
                        customTreinador.setText("Edit");
                        customTreinador.setOnAction(CE -> {
                            EditTreinadores();
                            System.out.println(treinadorSelecionado.getEquipa());
                        });
                        cancelTreinador.setOnAction(CE -> {
                            entidadeTreinadorDetalhes.close();
                        });
                    }
                    else {
                        AlertBox.Show("Erro","Selecione um Treinador antes de tentar editar");
                    }
                });
                deleteTreinador.setOnAction(A -> {
                    if (tableTreinador.getSelectionModel().getSelectedItem() != null) {
                        entidadeTreinadorDetalhes.show();
                        treinadorSelecionado = tableTreinador.getSelectionModel().getSelectedItem();
                        textoNomeTreinador.setText(treinadorSelecionado.getNome());
                        textoNomeTreinador.setEditable(false);
                        textoIdadeTreinador.setText(String.valueOf(treinadorSelecionado.getIdade()));
                        textoIdadeTreinador.setEditable(false);
                        textoAlturaTreinador.setText(String.valueOf(treinadorSelecionado.getAltura()));
                        textoAlturaTreinador.setEditable(false);
                        textoCategoria.setText(treinadorSelecionado.getCategoria());
                        textoCategoria.setEditable(false);
                        if (treinadorSelecionado.getEquipa() == null){
                            textoEquipaTreinador.setText(null);
                        }
                        else {
                            textoEquipaTreinador.setText(treinadorSelecionado.getEquipa().getNome());
                        }
                        textoEquipaTreinador.setEditable(false);
                        //textoEquipaTreinador.setText();
                        customTreinador.setText("Delete");
                        customTreinador.setOnAction(CE -> {
                            DeleteTreinadores();
                        });
                        cancelTreinador.setOnAction(CE -> {
                            entidadeTreinadorDetalhes.close();
                        });
                    }
                    else {
                        AlertBox.Show("Erro", "Selecione um Treinador antes de tentar Eliminar");
                    }
                });
                cemRegistosTreinador.setOnAction(CR -> {
                    for(int i = 0; i <= 99; i++)
                    {
                        listaTreinadores.add(new Treinador("Treinador", 16,24.4,"Superior"));
                    }
                    observableListTreinadores = FXCollections.observableArrayList(listaTreinadores);
                    tableTreinador.setItems(observableListTreinadores);    // Adição da ObservableList à tableView
                    tableTreinador.refresh();
                });
                closeTreinador.setOnAction(A -> {
                    entidadeTreinadorLista.close();
                });
                //endregion
            });
            //region Btn Gravar e Ler Ciêntifica

            //String fileAndLocation = "C:\\Users\\newma\\Desktop\\Valores.bin\\";
            menuItemFileOpcaoSave.setOnAction(SA -> {
                listas = new SerializarDesserializar(listaEquipas, listaJogadores, listaTreinadores);
                Serialization.Serializar(fileAndLocation, listas);
                AlertBox.Show("Resultado:", "Serializado com sucesso");
            });

            menuItemFileOpcaoLoad.setOnAction(LO ->{
                File fileAndLocationFile = new File(fileAndLocation);
                if(fileAndLocationFile.exists()) {
                    listas = (SerializarDesserializar) Serialization.Desserializar(fileAndLocation);
                    listaEquipas = listas.getListaEquipas();
                    listaJogadores = listas.getListaJogadores();
                    listaTreinadores = listas.getListaTreinadores();
                } else{
                    AlertBox.Show("Aviso", "Não existe nada para ser lido!");
                }
            });
            menuItemFileOpcaoSair.setOnAction(e -> {
                primaryStage.close();
                    });
            menuItemFileAcercaDe.setOnAction(e -> {
                AcercaDe();
            });
            //endregion

        } catch (Exception e) {
            e.printStackTrace();        // qq exceção é exibida
        }
    }

    public void ParteGraficaEquipa() {

        //region Tamanho dos Butões
        addEquipa.setPrefSize(130, 60);
        editEquipa.setPrefSize(130, 60);
        deleteEquipa.setPrefSize(130, 60);
        cemRegistosEquipa.setPrefSize(130,60);
        closeEquipa.setPrefSize(130, 60);
        //endregion

        //region Estilo e fonte das Labels
        Label labelEquipa = new Label("Equipas");
        labelEquipa.setFont(new Font("Cambria", 40));
        labelEquipa.setStyle("-fx-font-weight: bold");
        //endregion

        //region Propriedades das Colunas da TableView Equipas
        // Coluna Nome
        TableColumn<Equipa, String> colunaNomeEquipa = new TableColumn<>("Nome");
        colunaNomeEquipa.setMinWidth(180);
        colunaNomeEquipa.setResizable(false);
        colunaNomeEquipa.setCellValueFactory(new PropertyValueFactory<>("nome"));

        //Coluna Convocada
        TableColumn<Equipa, Boolean> colunaConvocada = new TableColumn<>("Convocada");
        colunaConvocada.setMinWidth(150);
        colunaConvocada.setResizable(false);
        colunaConvocada.setCellValueFactory(new PropertyValueFactory<>("convocada"));

        //Coluna Numero
        TableColumn<Equipa, Long> colunaClassificacao = new TableColumn<>("Classificação");
        colunaClassificacao.setMinWidth(150);
        colunaClassificacao.setResizable(false);
        colunaClassificacao.setCellValueFactory(new PropertyValueFactory<>("classificacao"));
        //endregion

        //region TableView e ObservableList Stuff
        // Associação das colunas à TableView
        tableEquipa.getColumns().addAll(colunaNomeEquipa, colunaConvocada, colunaClassificacao);
        //endregion

        //region Preparação da janela
        HBox butoesEquipa = new HBox(40);
        BorderPane borderPaneEquipa = new BorderPane();
        borderPaneEquipa.setTop(labelEquipa);
        borderPaneEquipa.setCenter(tableEquipa);
        borderPaneEquipa.setBottom(butoesEquipa);

        butoesEquipa.setPadding(new Insets(10, 20, 20, 20));
        butoesEquipa.getChildren().addAll(addEquipa, editEquipa, deleteEquipa, cemRegistosEquipa, closeEquipa);

        StackPane stackPaneEquipa = new StackPane();
        stackPaneEquipa.setPadding(new Insets(20, 20, 20, 20));            // espessura interna de cada bordo interno
        stackPaneEquipa.getChildren().add(borderPaneEquipa);

        Scene formentidadeEquipaLista = new Scene(stackPaneEquipa, 726, 561);            // Tratamento da janela
        entidadeEquipaLista.setScene(formentidadeEquipaLista);
        entidadeEquipaLista.initModality(Modality.APPLICATION_MODAL);
        entidadeEquipaLista.setTitle("Equipas");
        entidadeEquipaLista.setResizable(false);
        //endregion
    }

    public void ParteGraficaEquipaDetalhes() {

        GridPane gridPaneEquipas = new GridPane();					// layout para a região central
        gridPaneEquipas.setAlignment(Pos.CENTER);
        gridPaneEquipas.setPadding(new Insets(20,20,20,20));
        gridPaneEquipas.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneEquipas.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        textoNomeEquipa.setMinWidth(220);
        gridPaneEquipas.add(labelNome, 0, 0);		// célula col 0,linha 0
        gridPaneEquipas.add(textoNomeEquipa, 1, 0);       // célula: col 1, linha 0

        // Convocada
        Label labelConvocada = new Label("Convocada:");				// Nova Label
        textoConvocada.setMaxWidth(60);
        gridPaneEquipas.add(labelConvocada, 0, 1);		// célula col 0,linha 1
        gridPaneEquipas.add(textoConvocada, 1, 1);		// célula: col 1, linha 1

        // Classificação
        Label labelClassificacao = new Label("Classificação:");			// Nova Label
        textoClassificacao.setMaxWidth(60);
        gridPaneEquipas.add(labelClassificacao, 0, 2);		// célula col 0,linha 2
        gridPaneEquipas.add(textoClassificacao, 1, 2);		// célula: col 1, linha 2

        // Table Jogador
        // Coluna Nome
        TableColumn<Jogador, String> colunaNomeEquipaJogador = new TableColumn<>("Nome");
        colunaNomeEquipaJogador.setMinWidth(100);
        colunaNomeEquipaJogador.setResizable(false);
        colunaNomeEquipaJogador.setCellValueFactory(new PropertyValueFactory<>("nome"));

        //Coluna Idade
        TableColumn<Jogador, Integer> colunaIdadeEquipaJogador = new TableColumn<>("Idade");
        colunaIdadeEquipaJogador.setMinWidth(90);
        colunaIdadeEquipaJogador.setResizable(false);
        colunaIdadeEquipaJogador.setCellValueFactory(new PropertyValueFactory<>("idade"));

        //Coluna Altura
        TableColumn<Jogador, Double> colunaAlturaEquipaJogador = new TableColumn<>("Altura");
        colunaAlturaEquipaJogador.setMinWidth(90);
        colunaAlturaEquipaJogador.setResizable(false);
        colunaAlturaEquipaJogador.setCellValueFactory(new PropertyValueFactory<>("altura"));

        //Coluna Posição
        TableColumn<Jogador, String> colunaPosicaoJogador = new TableColumn<>("Posição");
        colunaPosicaoJogador.setMinWidth(90);
        colunaPosicaoJogador.setResizable(false);
        colunaPosicaoJogador.setCellValueFactory(new PropertyValueFactory<>("posicao"));

        // Table Treinador
        // Coluna Nome
        TableColumn<Treinador, String> colunaNomeEquipaTreinador = new TableColumn<>("Nome");
        colunaNomeEquipaTreinador.setMinWidth(100);
        colunaNomeEquipaTreinador.setResizable(false);
        colunaNomeEquipaTreinador.setCellValueFactory(new PropertyValueFactory<>("nome"));

        //Coluna Idade
        TableColumn<Treinador, Integer> colunaIdadeEquipaTreinador = new TableColumn<>("Idade");
        colunaIdadeEquipaTreinador.setMinWidth(90);
        colunaIdadeEquipaTreinador.setResizable(false);
        colunaIdadeEquipaTreinador.setCellValueFactory(new PropertyValueFactory<>("idade"));

        //Coluna Altura
        TableColumn<Treinador, Double> colunaAlturaEquipaTreinador = new TableColumn<>("Altura");
        colunaAlturaEquipaTreinador.setMinWidth(90);
        colunaAlturaEquipaTreinador.setResizable(false);
        colunaAlturaEquipaTreinador.setCellValueFactory(new PropertyValueFactory<>("altura"));

        //Coluna Posição
        TableColumn<Treinador, String> colunaCategoriaTreinador = new TableColumn<>("Categoria");
        colunaCategoriaTreinador.setMinWidth(90);
        colunaCategoriaTreinador.setResizable(false);
        colunaCategoriaTreinador.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        // Associar as colunas à tabela
        tableEquipaJogadores.getColumns().addAll(colunaNomeEquipaJogador, colunaIdadeEquipaJogador, colunaAlturaEquipaJogador, colunaPosicaoJogador);
        tableEquipaTreinadores.getColumns().addAll(colunaNomeEquipaTreinador, colunaIdadeEquipaTreinador, colunaAlturaEquipaTreinador, colunaCategoriaTreinador);

        BorderPane borderPaneEquipas = new BorderPane();
        HBox tabelaButoes = new HBox (40);
        HBox butoesBaixo = new HBox(40);
        VBox butoesDireita = new VBox(40);
        butoesBaixo.setAlignment(Pos.CENTER);
        butoesBaixo.setPadding(new Insets(10,20,20,20));
        butoesBaixo.getChildren().addAll(customEquipa, cancelEquipa);
        butoesDireita.setAlignment(Pos.CENTER);
        butoesDireita.setPadding(new Insets(10,20,20,20));
        butoesDireita.getChildren().addAll(associarJogador, associarTreinador, desassociarJogador, desassociarTreinador);
        tabelaButoes.setAlignment(Pos.CENTER);
        tabelaButoes.setPadding(new Insets(10,20,20,20));
        tabelaButoes.getChildren().addAll(tableEquipaJogadores, tableEquipaTreinadores, butoesDireita);

        StackPane stackPaneEquipas = new StackPane();					// Layout para organizar verticalmente os objetos
        stackPaneEquipas.setPadding(new Insets(20,20,20,20));			// espessura interna de cada bordo interno
        stackPaneEquipas.getChildren().add(borderPaneEquipas);

        borderPaneEquipas.setTop(gridPaneEquipas);
        borderPaneEquipas.setCenter(tabelaButoes);
        borderPaneEquipas.setBottom(butoesBaixo);

        Scene formentidadeEquipaDetalhes = new Scene(stackPaneEquipas,1100, 700);
        entidadeEquipaDetalhes.setScene(formentidadeEquipaDetalhes);
        entidadeEquipaDetalhes.initModality(Modality.APPLICATION_MODAL);
        entidadeEquipaDetalhes.setTitle("Equipas Detalhes");
        entidadeEquipaDetalhes.setResizable(false);
    }

    public void ParteGraficaJogador(){

        //region Tamanho dos Butões
        addJogador.setPrefSize(130, 60);
        editJogador.setPrefSize(130, 60);
        deleteJogador.setPrefSize(130, 60);
        cemRegistosJogador.setPrefSize(130,60);
        closeJogador.setPrefSize(130, 60);
        associarJogadorGraf.setPrefSize(130, 60);
        cancelAssociarJogadorGraf.setPrefSize(130, 60);
        //endregion

        //region Estilo e fonte das Labels
        Label labelJogador = new Label("Jogadores");
        labelJogador.setFont(new Font("Cambria", 40));
        labelJogador.setStyle("-fx-font-weight: bold");
        //endregion

        //region Propriedades das Colunas da TableView Jogadores
        // Coluna Nome
        TableColumn<Jogador, String> colunaNomeJogador = new TableColumn<>("Nome");
        colunaNomeJogador.setMinWidth(180);
        colunaNomeJogador.setResizable(false);
        colunaNomeJogador.setCellValueFactory(new PropertyValueFactory<>("nome"));

        //Coluna Idade
        TableColumn<Jogador, Integer> colunaIdadeJogador = new TableColumn<>("Idade");
        colunaIdadeJogador.setMinWidth(120);
        colunaIdadeJogador.setResizable(false);
        colunaIdadeJogador.setCellValueFactory(new PropertyValueFactory<>("idade"));

        //Coluna Altura
        TableColumn<Jogador, Double> colunaAlturaJogador = new TableColumn<>("Altura");
        colunaAlturaJogador.setMinWidth(120);
        colunaAlturaJogador.setResizable(false);
        colunaAlturaJogador.setCellValueFactory(new PropertyValueFactory<>("altura"));

        //Coluna Posição
        TableColumn<Jogador, String> colunaPosicao = new TableColumn<>("Posição");
        colunaPosicao.setMinWidth(120);
        colunaPosicao.setResizable(false);
        colunaPosicao.setCellValueFactory(new PropertyValueFactory<>("posicao"));

        // Associar as colunas à tabela
        tableJogador.getColumns().addAll(colunaNomeJogador, colunaIdadeJogador, colunaAlturaJogador, colunaPosicao);

        //region Preparação da janela
        HBox butoesJogador = new HBox(30);
        HBox butoesAssociacaoJogador = new HBox(30);
        VBox tablebutoesAssociacaoJogador = new VBox (10);
        BorderPane borderPaneJogador = new BorderPane();
        butoesAssociacaoJogador.getChildren().addAll(associarJogadorGraf, cancelAssociarJogadorGraf);
        butoesAssociacaoJogador.setPadding(new Insets(0, 0, 0, 205));
        butoesJogador.getChildren().addAll(addJogador, editJogador, deleteJogador, cemRegistosJogador, closeJogador);
        butoesJogador.setPadding(new Insets(0, 20, 20, 20));
        tablebutoesAssociacaoJogador.getChildren().addAll(tableJogador, butoesAssociacaoJogador);
        borderPaneJogador.setTop(labelJogador);
        borderPaneJogador.setCenter(tablebutoesAssociacaoJogador);
        borderPaneJogador.setBottom(butoesJogador);

        StackPane stackPaneJogador = new StackPane();
        stackPaneJogador.setPadding(new Insets(20, 20, 20, 20));            // espessura interna de cada bordo interno
        stackPaneJogador.getChildren().add(borderPaneJogador);

        Scene formentidadeJogadorLista = new Scene(stackPaneJogador, 726, 561);            // Tratamento da janela
        entidadeJogadorLista.setScene(formentidadeJogadorLista);
        entidadeJogadorLista.initModality(Modality.APPLICATION_MODAL);
        entidadeJogadorLista.setTitle("Jogadores");
        entidadeJogadorLista.setResizable(false);
        //endregion
    }

    public void ParteGraficaJogadorDetalhes(){

        GridPane gridPaneJogadores = new GridPane();					// layout para a região central
        gridPaneJogadores.setAlignment(Pos.CENTER);
        gridPaneJogadores.setPadding(new Insets(20,20,0,20));
        gridPaneJogadores.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneJogadores.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        textoNomeJogador.setMinWidth(220);
        gridPaneJogadores.add(labelNome, 0, 0);		// célula col 0,linha 0
        gridPaneJogadores.add(textoNomeJogador, 1, 0);       // célula: col 1, linha 0

        // Idade
        Label labelIdade = new Label("Idade:");				// Nova Label
        textoIdadeJogador.setMaxWidth(60);
        gridPaneJogadores.add(labelIdade, 0, 1);		// célula col 0,linha 1
        gridPaneJogadores.add(textoIdadeJogador, 1, 1);		// célula: col 1, linha 1

        // Altura
        Label labelAltura = new Label("Altura:");			// Nova Label
        textoAlturaJogador.setMaxWidth(60);
        gridPaneJogadores.add(labelAltura, 0, 2);		// célula col 0,linha 2
        gridPaneJogadores.add(textoAlturaJogador, 1, 2);		// célula: col 1, linha 2

        // Posição
        Label labelPosicao = new Label("Posição:");			// Nova Label
        textoPosicao.setMaxWidth(160);
        gridPaneJogadores.add(labelPosicao, 0, 3);		// célula col 0,linha 2
        gridPaneJogadores.add(textoPosicao, 1, 3);		// célula: col 1, linha 2

        // Equipa
        Label labelEquipaJogador = new Label("Equipa:");				// Nova Label
        textoEquipaJogador.setMinWidth(220);
        gridPaneJogadores.add(labelEquipaJogador, 0, 4);		// célula col 0,linha 1
        gridPaneJogadores.add(textoEquipaJogador, 1, 4);		// célula: col 1, linha 1

        HBox Butoes = new HBox(40);
        Butoes.getChildren().addAll(customJogador, cancelJogador);
        Butoes.setAlignment(Pos.CENTER);
        Butoes.setPadding(new Insets(10,20,20,20));

        BorderPane borderPaneJogadores = new BorderPane();
        borderPaneJogadores.setCenter(gridPaneJogadores);
        borderPaneJogadores.setBottom(Butoes);

        Scene formentidadeJogadorListaesDetalhes = new Scene(borderPaneJogadores,320, 320);
        entidadeJogadorDetalhes.setScene(formentidadeJogadorListaesDetalhes);
        entidadeJogadorDetalhes.initModality(Modality.APPLICATION_MODAL);
        entidadeJogadorDetalhes.setTitle("Jogadores Detalhes");
        entidadeJogadorDetalhes.setResizable(false);
    }

    public void ParteGraficaTreinador(){

        //region Tamanho dos Butões
        addTreinador.setPrefSize(130, 60);
        editTreinador.setPrefSize(130, 60);
        deleteTreinador.setPrefSize(130, 60);
        cemRegistosTreinador.setPrefSize(130,60);
        closeTreinador.setPrefSize(130, 60);
        associarTreinadorGraf.setPrefSize(130, 60);
        cancelAssociarTreinadorGraf.setPrefSize(130, 60);
        //endregion

        //region Estilo e fonte das Labels
        Label labelTreinador = new Label("Treinadores");
        labelTreinador.setFont(new Font("Cambria", 40));
        labelTreinador.setStyle("-fx-font-weight: bold");
        //endregion

        //region Propriedades das Colunas da TableView Treinadores
        // Coluna Nome
        TableColumn<Treinador, String> colunaNomeTreinador = new TableColumn<>("Nome");
        colunaNomeTreinador.setMinWidth(180);
        colunaNomeTreinador.setResizable(false);
        colunaNomeTreinador.setCellValueFactory(new PropertyValueFactory<>("nome"));

        //Coluna Idade
        TableColumn<Treinador, Integer> colunaIdadeTreinador = new TableColumn<>("Idade");
        colunaIdadeTreinador.setMinWidth(120);
        colunaIdadeTreinador.setResizable(false);
        colunaIdadeTreinador.setCellValueFactory(new PropertyValueFactory<>("idade"));

        //Coluna Altura
        TableColumn<Treinador, Double> colunaAlturaTreinador = new TableColumn<>("Altura");
        colunaAlturaTreinador.setMinWidth(120);
        colunaAlturaTreinador.setResizable(false);
        colunaAlturaTreinador.setCellValueFactory(new PropertyValueFactory<>("altura"));

        //Coluna Posição
        TableColumn<Treinador, String> colunaCategoria = new TableColumn<>("Categoria");
        colunaCategoria.setMinWidth(120);
        colunaCategoria.setResizable(false);
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        //region TableView e ObservableList Stuff
        // Associar as colunas à tabela
        tableTreinador.getColumns().addAll(colunaNomeTreinador, colunaIdadeTreinador, colunaAlturaTreinador, colunaCategoria);
        //endregion

        //region Preparação da janela
        HBox butoesTreinador = new HBox(40);
        HBox butoesAssociacaoTreinador = new HBox(30);
        VBox tablebutoesAssociacaoTreinador = new VBox (10);
        BorderPane borderPaneTreinador = new BorderPane();
        butoesAssociacaoTreinador.getChildren().addAll(associarTreinadorGraf, cancelAssociarTreinadorGraf);
        butoesAssociacaoTreinador.setPadding(new Insets(0, 0, 0, 205));
        butoesTreinador.setPadding(new Insets(0, 20, 20, 20));
        butoesTreinador.getChildren().addAll(addTreinador, editTreinador, deleteTreinador, cemRegistosTreinador, closeTreinador);
        tablebutoesAssociacaoTreinador.getChildren().addAll(tableTreinador, butoesAssociacaoTreinador);
        borderPaneTreinador.setTop(labelTreinador);
        borderPaneTreinador.setCenter(tablebutoesAssociacaoTreinador);
        borderPaneTreinador.setBottom(butoesTreinador);

        StackPane stackPaneTreinador = new StackPane();
        stackPaneTreinador.setPadding(new Insets(20, 20, 20, 20));            // espessura interna de cada bordo interno
        stackPaneTreinador.getChildren().add(borderPaneTreinador);

        Scene formentidadeTreinadorLista = new Scene(stackPaneTreinador, 726, 561);            // Tratamento da janela
        entidadeTreinadorLista.setScene(formentidadeTreinadorLista);
        entidadeTreinadorLista.initModality(Modality.APPLICATION_MODAL);
        entidadeTreinadorLista.setTitle("Treinadores");
        entidadeTreinadorLista.setResizable(false);
        //endregion
    }

    public void ParteGraficaTreinadorDetalhes(){

        GridPane gridPaneTreinadores = new GridPane();					// layout para a região central
        gridPaneTreinadores.setAlignment(Pos.CENTER);
        gridPaneTreinadores.setPadding(new Insets(20,20,0,20));
        gridPaneTreinadores.setVgap(12);								// espaço entre colunas (pixeis)
        gridPaneTreinadores.setHgap(10);								// espaço entre linhas

        // Nome
        Label labelNome = new Label("Nome:");			        // Nova Label
        textoNomeTreinador.setMinWidth(220);
        gridPaneTreinadores.add(labelNome, 0, 0);		// célula col 0,linha 0
        gridPaneTreinadores.add(textoNomeTreinador, 1, 0);       // célula: col 1, linha 0

        // Idade
        Label labelIdade = new Label("Idade:");				// Nova Label
        textoIdadeTreinador.setMaxWidth(60);
        gridPaneTreinadores.add(labelIdade, 0, 1);		// célula col 0,linha 1
        gridPaneTreinadores.add(textoIdadeTreinador, 1, 1);		// célula: col 1, linha 1

        // Altura
        Label labelAltura = new Label("Altura:");			// Nova Label
        textoAlturaTreinador.setMaxWidth(60);
        gridPaneTreinadores.add(labelAltura, 0, 2);		// célula col 0,linha 2
        gridPaneTreinadores.add(textoAlturaTreinador, 1, 2);		// célula: col 1, linha 2

        // Categoria
        Label labelCategoria = new Label("Categoria:");			// Nova Label
        textoCategoria.setMinWidth(160);
        gridPaneTreinadores.add(labelCategoria, 0, 3);		// célula col 0,linha 2
        gridPaneTreinadores.add(textoCategoria, 1, 3);		// célula: col 1, linha 2

        // Equipa
        Label labelEquipaTreinador = new Label("Equipa:");				// Nova Label
        textoEquipaTreinador.setMaxWidth(220);
        gridPaneTreinadores.add(labelEquipaTreinador, 0, 4);		// célula col 0,linha 1
        gridPaneTreinadores.add(textoEquipaTreinador, 1, 4);		// célula: col 1, linha 1

        HBox Butoes = new HBox(40);
        Butoes.getChildren().addAll(customTreinador, cancelTreinador);
        Butoes.setAlignment(Pos.CENTER);
        Butoes.setPadding(new Insets(10,20,20,20));

        BorderPane borderPaneTreinadores = new BorderPane();
        borderPaneTreinadores.setCenter(gridPaneTreinadores);
        borderPaneTreinadores.setBottom(Butoes);

        Scene formentidadeTreinadorListaesDetalhes = new Scene(borderPaneTreinadores,320, 320);
        entidadeTreinadorDetalhes.setScene(formentidadeTreinadorListaesDetalhes);
        entidadeTreinadorDetalhes.initModality(Modality.APPLICATION_MODAL);
        entidadeTreinadorDetalhes.setTitle("Treinadores Detalhes");
        entidadeTreinadorDetalhes.setResizable(false);
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
                "\n" +
                " Trabalho realizado no ambito da disciplina de Programação de Sistemas Informáticos \n" +
                " Projeto do Módulo 10\n" +
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
                    AlertBox.Show("Erro","A classificação só pode ter números, porfavor introduza novamente os dados");
                }
                else
                {
                    convocada = true;
                    Equipa equipa = new Equipa(textoNomeEquipa.getText(), convocada, Long.parseLong(textoClassificacao.getText()));
                    listaEquipas.add(equipa);
                    observableListEquipas = FXCollections.observableArrayList(listaEquipas);
                    tableEquipa.setItems(observableListEquipas);    // Adição da ObservableList à tableView
                    tableEquipa.refresh();
                    entidadeEquipaDetalhes.close();
                }
            }
            else if (textoConvocada.getText().equals("Não") || textoConvocada.getText().equals("não"))
            {
                if (Valida.number(textoClassificacao.getText()))
                {
                    AlertBox.Show("Erro","A classificação só pode ter números, porfavor introduza novamente os dados");
                }
                else
                {
                    convocada = false;
                    Equipa equipa = new Equipa(textoNomeEquipa.getText(), convocada, Long.parseLong(textoClassificacao.getText()));
                    listaEquipas.add(equipa);
                    observableListEquipas = FXCollections.observableArrayList(listaEquipas);
                    tableEquipa.setItems(observableListEquipas);    // Adição da ObservableList à tableView
                    tableEquipa.refresh();
                    entidadeEquipaDetalhes.close();
                }
            }
            else
            {
                AlertBox.Show("Erro","O que introduziu não se encontra de acordo com os parâmetros que são requeridos ... ");
            }
        }
    }

    public void EditEquipas() {

        if (textoNomeEquipa.getText().isEmpty() || textoConvocada.getText().isEmpty()|| textoClassificacao.getText().isEmpty())
        {
            AlertBox.Show("Erro","A Equipa não pode ser editada, porfavor preencha todos os espaços.");
        }
        else
        {
            if (textoConvocada.getText().equals("Sim") || textoConvocada.getText().equals("sim"))
            {
                if (Valida.number(textoClassificacao.getText()))
                {
                    AlertBox.Show("Erro","A classificação só pode ter números, porfavor introduza novamente os dados");
                }
                else
                {
                    convocada = true;
                    Equipa equipaSelecionada = tableEquipa.getSelectionModel().getSelectedItem() ;
                    equipaSelecionada.setNome(textoNomeEquipa.getText());
                    equipaSelecionada.setConvocada(convocada);
                    equipaSelecionada.setClassificacao(Long.parseLong(textoClassificacao.getText()));
                    observableListEquipas = FXCollections.observableArrayList(listaEquipas);
                    tableEquipa.setItems(observableListEquipas);    // Adição da ObservableList à tableView
                    tableEquipa.refresh();
                    entidadeEquipaDetalhes.close();
                }
            }
            else if (textoConvocada.getText().equals("Não") || textoConvocada.getText().equals("não"))
            {
                if (Valida.number(textoClassificacao.getText()))
                {
                    AlertBox.Show("Erro","A classificação só pode ter números, porfavor introduza novamente os dados");
                }
                else
                {
                    convocada = false;
                    Equipa equipaSelecionada = tableEquipa.getSelectionModel().getSelectedItem();
                    equipaSelecionada.setNome(textoNomeEquipa.getText());
                    equipaSelecionada.setConvocada(convocada);
                    equipaSelecionada.setClassificacao(Long.parseLong(textoClassificacao.getText()));
                    observableListEquipas = FXCollections.observableArrayList(listaEquipas);
                    tableEquipa.setItems(observableListEquipas);    // Adição da ObservableList à tableView
                    tableEquipa.refresh();
                    entidadeEquipaDetalhes.close();
                }
            }
            else
            {
                AlertBox.Show("Erro","O que introduziu não se encontra de acordo com os parâmetros que são requeridos ... ");
            }
        }
    }

    public void DeleteEquipas() {
        if (observableListEquipaJogadores.isEmpty() && observableListEquipaTreinadores.isEmpty()) {
            listaEquipas.remove(equipaSelecionada);
            tableEquipa.getItems().remove(equipaSelecionada);
            tableEquipa.refresh();
            entidadeEquipaDetalhes.close();
        } else {
            DialogBox.Show("VIR Alert", "A equipa que pretende eliminar contem relações, pretende eliminar esta equipa?");
            if (DialogBox.resposta == true) {
                for (Jogador jogador : equipaSelecionada.getJogadorList()){
                    jogador.setEquipa(null);
                }
                for (Treinador treinador : equipaSelecionada.getTreinadorList()){
                    treinador.setEquipa(null);
                }
                equipaSelecionada.getJogadorList().clear();
                equipaSelecionada.getTreinadorList().clear();
                listaEquipas.remove(equipaSelecionada);
                tableEquipa.getItems().remove(equipaSelecionada);
                tableEquipa.refresh();
                entidadeEquipaDetalhes.close();
            }
        }
    }


    public void AddJogadores() {

        if (textoNomeJogador.getText().isEmpty() || textoIdadeJogador.getText().isEmpty() || textoAlturaJogador.getText().isEmpty() || textoPosicao.getText().isEmpty())
        {
            AlertBox.Show("Erro","O Jogador não pode ser criado, porfavor preencha todos os espaços.");
        }
        else
        {
            if (Valida.number(textoIdadeJogador.getText()))
            {
                AlertBox.Show("Erro","A Idade não pode ter letras, porfavor introduza novamente os dados");
            }
            else
            {
                if (Valida.number(textoAlturaJogador.getText()))
                {
                    AlertBox.Show("Erro","A altura só pode ter números, porfavor introduza novamente os dados");
                }
                else
                {
                    if (Valida.number(textoPosicao.getText()))
                    {
                        Jogador jogador = new Jogador(textoNomeJogador.getText(), Integer.parseInt(textoIdadeJogador.getText()),Double.parseDouble(textoAlturaJogador.getText()), textoPosicao.getText());
                        listaJogadores.add(jogador);
                        observableListJogadores = FXCollections.observableArrayList(listaJogadores);
                        tableJogador.setItems(observableListJogadores);    // Adição da ObservableList à tableView
                        tableJogador.refresh();
                        entidadeJogadorDetalhes.close();
                    }
                    else
                    {
                        AlertBox.Show("Erro","A posição não pode conter números, porfavor introduza novos dados");
                    }
                }
            }
        }
    }

    public void EditJogadores(){
        if (textoNomeJogador.getText().isEmpty() || textoIdadeJogador.getText().isEmpty() || textoAlturaJogador.getText().isEmpty() || textoPosicao.getText().isEmpty())
        {
            AlertBox.Show("Erro","O Jogador não pode ser editado, porfavor preencha todos os espaços.");
        }
        else
        {
            if (Valida.number(textoIdadeJogador.getText()))
            {
                AlertBox.Show("Erro","A idade só pode ter números, porfavor introduza novamente os dados");
            }
            else
            {
                if (Valida.number(textoPosicao.getText()))
                {
                    Jogador jogadorSelecionado = tableJogador.getSelectionModel().getSelectedItem() ;
                    jogadorSelecionado.setNome(textoNomeJogador.getText());
                    jogadorSelecionado.setIdade(Integer.parseInt(textoIdadeJogador.getText()));
                    jogadorSelecionado.setAltura(Double.parseDouble(textoAlturaJogador.getText()));
                    jogadorSelecionado.setPosicao(textoPosicao.getText());
                    observableListJogadores = FXCollections.observableArrayList(listaJogadores);
                    tableJogador.setItems(observableListJogadores);    // Adição da ObservableList à tableView
                    tableJogador.refresh();
                    entidadeJogadorDetalhes.close();
                }
                else
                {
                    AlertBox.Show("Erro","A posição não pode conter números, porfavor introduza novos dados");
                }
            }
        }
    }

    public void DeleteJogadores() {
        if (jogadorSelecionado.getEquipa() == null) {
            tableJogador.getItems().remove(jogadorSelecionado);
            listaJogadores.remove(jogadorSelecionado);
            tableJogador.refresh();
            entidadeJogadorDetalhes.close();
        } else {
            DialogBox.Show("VIR Alert", "O Jogador que pretende eliminar contem relações, pretende eliminar este Jogador?");
            jogadorSelecionado.getEquipa().getJogadorList().remove(jogadorSelecionado);
            tableJogador.getItems().remove(jogadorSelecionado);
            listaJogadores.remove(jogadorSelecionado);
            tableJogador.refresh();
            entidadeJogadorDetalhes.close();
        }
    }


    public void AddTreinadores() {

        if (textoNomeTreinador.getText().isEmpty() || textoIdadeTreinador.getText().isEmpty() || textoAlturaTreinador.getText().isEmpty() || textoCategoria.getText().isEmpty())
        {
            AlertBox.Show("Erro","O Treinador não pode ser criado, porfavor preencha todos os espaços.");
        }
        else
        {
            if (Valida.number(textoIdadeTreinador.getText()))
            {
                AlertBox.Show("Erro","A Idade não pode ter letras, porfavor introduza novamente os dados");
            }
            else
            {
                if (Valida.number(textoAlturaTreinador.getText()))
                {
                    AlertBox.Show("Erro","A altura só pode ter números, porfavor introduza novamente os dados");
                }
                else
                {
                    if (Valida.number(textoCategoria.getText()))
                    {
                        Treinador treinador = new Treinador(textoNomeTreinador.getText(), Integer.parseInt(textoIdadeTreinador.getText()),Double.parseDouble(textoAlturaTreinador.getText()), textoCategoria.getText(), equipaSelecionada);
                        listaTreinadores.add(treinador);
                        observableListTreinadores = FXCollections.observableArrayList(listaTreinadores);
                        tableTreinador.setItems(observableListTreinadores);    // Adição da ObservableList à tableView
                        tableTreinador.refresh();
                        entidadeTreinadorDetalhes.close();
                    }
                    else
                    {
                        AlertBox.Show("Erro","A categoria não pode conter números, porfavor introduza novos dados");
                    }
                }
            }
        }
    }

    public void EditTreinadores(){
        if (textoNomeTreinador.getText().isEmpty() || textoIdadeTreinador.getText().isEmpty() || textoAlturaTreinador.getText().isEmpty() || textoCategoria.getText().isEmpty())
        {
            AlertBox.Show("Erro","O Treinador não pode ser editado, porfavor preencha todos os espaços.");
        }
        else
        {
            if (Valida.number(textoIdadeTreinador.getText()))
            {
                AlertBox.Show("Erro","A idade só pode ter números, porfavor introduza novamente os dados");
            }
            else
            {
                if (Valida.number(textoCategoria.getText()))
                {
                    Treinador treinadorSelecionado = tableTreinador.getSelectionModel().getSelectedItem() ;
                    treinadorSelecionado.setNome(textoNomeTreinador.getText());
                    treinadorSelecionado.setIdade(Integer.parseInt(textoIdadeTreinador.getText()));
                    treinadorSelecionado.setAltura(Double.parseDouble(textoAlturaTreinador.getText()));
                    treinadorSelecionado.setCategoria(textoCategoria.getText());
                    observableListTreinadores = FXCollections.observableArrayList(listaTreinadores);
                    tableTreinador.setItems(observableListTreinadores);    // Adição da ObservableList à tableView
                    tableTreinador.refresh();
                    entidadeTreinadorDetalhes.close();
                }
                else
                {
                    AlertBox.Show("Erro","A categoria não pode conter números, porfavor introduza novos dados");
                }
            }
        }
    }

    public void DeleteTreinadores(){

        if (treinadorSelecionado.getEquipa() == null) {
            tableTreinador.getItems().remove(treinadorSelecionado);
            listaTreinadores.remove(treinadorSelecionado);
            tableTreinador.refresh();
            entidadeTreinadorDetalhes.close();
        } else {
            DialogBox.Show("VIR Alert", "O Jogador que pretende eliminar contem relações, pretende eliminar este Jogador?");
            treinadorSelecionado.getEquipa().getTreinadorList().remove(treinadorSelecionado);
            tableTreinador.getItems().remove(treinadorSelecionado);
            listaTreinadores.remove(treinadorSelecionado);
            tableTreinador.refresh();
            entidadeTreinadorDetalhes.close();
        }
    }
}