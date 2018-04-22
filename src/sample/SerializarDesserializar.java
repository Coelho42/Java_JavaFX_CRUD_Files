package sample;

import java.io.Serializable;
import java.util.List;


public class SerializarDesserializar implements Serializable {

    private List<Equipa> listaEquipas;

    private List<Jogador> listaJogadores;

    private  List<Treinador> listaTreinadores;

    public SerializarDesserializar(List<Equipa> listaEquipas, List<Jogador> listaJogadores, List<Treinador> listaTreinadores) {
        this.listaEquipas = listaEquipas;
        this.listaJogadores = listaJogadores;
        this.listaTreinadores = listaTreinadores;
    }

    public List<Equipa> getListaEquipas() { return listaEquipas; }

    public void setListaEquipas(List<Equipa> listaEquipas) { this.listaEquipas = listaEquipas; }

    public List<Jogador> getListaJogadores() { return listaJogadores; }

    public void setListaJogadores(List<Jogador> listaJogadores) { this.listaJogadores = listaJogadores; }

    public List<Treinador> getListaTreinadores() { return listaTreinadores; }

    public void setListaTreinadores(List<Treinador> listaTreinadores) { this.listaTreinadores = listaTreinadores; }
}
