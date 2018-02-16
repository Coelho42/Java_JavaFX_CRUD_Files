package sample;

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
     * Construtor Default
     */
    public Treinador() {
    }

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
        this.categoria = categoria;
    }
    /**
     * Esté é um método que está encarregado da criação dos treinadores na lista, este não tem parâmetros de entrada, e tem como método de saída void.
     */
    public void Add(List<Treinador> listaTreinador) {
        throw new UnsupportedOperationException();
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
}