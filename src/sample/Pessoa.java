package sample;

import java.io.Serializable;

/**
 * Classe pessoa que contêm as informações básicas referentes a uma Pessoa, esta é uma super classe e partilha os seus atributos com as classes Jogador e Treinador.
 */
public class Pessoa implements Serializable {
    /**
     * É uma varíavel do tipo String que atribui um nome de cada jogador.
     */
    private String nome;
    /**
     * Esta variável é um int encarregue atribuição da idade a cada jogador, a variável é do tipo int e não do tipo long porque os jogadores no máximo tem dois digitos no valor da idade, e não é DateTime, pois não é necessário a informação que diz respeito aos meses e dias, ou seja não são crianças com idades inferiores a 1 ano.
     */
    private int idade;
    /**
     * É uma variável do tipo double que recebe a altura dos jogadores, pois as alturas têm no máximo 3 digitos mas tem números décimais, logo tem de ser um double.
     */
    private double altura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}


