package com.company.projagd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Agenda {

    private List<Contato> listaDeContato;

    public Agenda() {
        this.listaDeContato = new LinkedList<>();
    }

    public List<Contato> getListaDeContato() {
        return listaDeContato;
    }

    public void setListaDeContato(ArrayList<Contato> listaDeContato) {
        this.listaDeContato = listaDeContato;
    }

    public List<Contato> pesquisarAniversarianteMes(byte mes) {
        List<Contato> encontrados = new ArrayList<>();
        for (int i = 0; i < this.listaDeContato.size(); i++) {
            if (this.listaDeContato.get(i).getObjData().getMes() == mes) {
                encontrados.add(this.listaDeContato.get(i));
            }
        }
        return encontrados;
    }

    public boolean cadastrarContato(final Contato contato) {
        if (Objects.nonNull(pesquisarContatoNome(contato.getNome()))) {
            return false;
        }
        listaDeContato.add(contato);
        return true;
    }

    public Contato pesquisarContatoNome(String nome) {
        for (int i = 0; i < this.listaDeContato.size(); i++) {
            if (this.listaDeContato.get(i).getNome().equalsIgnoreCase(nome)) {
                return this.listaDeContato.get(i);
            }
        }
        return null;
    }

    public boolean removerContato(Contato objCcontato) {
        return listaDeContato.remove(objCcontato);
    }

    public void limparListaContato() {
        listaDeContato.clear();
    }

    public boolean verificarCadastro(String nome) {
        for (int i = 0; i < this.listaDeContato.size(); i++) {
            if (this.listaDeContato.get(i).getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

}
