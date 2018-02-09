package sample;

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
     * 1 jogador pode ter 0 ou 1 equipa, e uma equipa tem 1 ou mais jogadores.
     *
     * (Nota: Proteção para a aplicação - A equipa não pode ser criada enquanto a equipa não tiver pelo menos um jogador).
     */
    public Equipa tem;

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
}