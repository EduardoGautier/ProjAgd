package com.company.projagd.controller;

import com.company.projagd.model.Contato;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Eduardo Jose Gautier
 *
 */

public class Agenda {

    private List<Contato> listaDeContato;

    public Agenda() {
        this.listaDeContato = new LinkedList<>();
    }

    public List<Contato> getListaDeContato() {
        return listaDeContato;
    }

    public List<Contato> pesquisarAniversarianteMes(byte mes) {
        List<Contato> encontrados = new LinkedList<>();

        for (final Contato contato : listaDeContato) {
            if (contato.getObjData().getMes() == mes) {
                encontrados.add(contato);
            }
        }

        return encontrados;
    }

    public Contato alteraracaoContatoPorNome(String nome) {

        for (final Contato contato : listaDeContato) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public boolean cadastrarContato(final Contato contato) {
        if (Objects.nonNull(pesquisarContatoNome(contato.getNome()))) {
            return false;
        }
        listaDeContato.add(contato);
        return true;
    }


    public Contato pesquisarContatoNome(String nome) {

        for (final Contato contato : listaDeContato) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }

        return null;
    }


    public Contato pesquisarContatoPorCPf(String cpf) {

        for (final Contato contato : listaDeContato) {
            if (contato.getCpf().equalsIgnoreCase(cpf)) {
                return contato;
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

        for (final Contato contato : listaDeContato) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarCadastroCpf(String cpf) {

        for (final Contato contato : listaDeContato) {
            if (contato.getCpf().equalsIgnoreCase(cpf)) {
                return true;
            }
        }
        return false;
    }

    public int mostrarQtdContatos() {
        return listaDeContato.size();
    }
}
