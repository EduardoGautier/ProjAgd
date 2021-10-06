package com.company.projagd;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contato> listaDeContato;

    public Agenda() {
        this.listaDeContato = new ArrayList<>();
    }

    public ArrayList<Contato> getListaDeContato() {
        return listaDeContato;
    }

    public void setListaDeContato(ArrayList<Contato> listaDeContato) {
        this.listaDeContato = listaDeContato;
    }

    public ArrayList<Contato> pesquisarAniversarianteMes(byte mes) {
        ArrayList<Contato> encontrados = new ArrayList<>();
        for (int i = 0; i < this.listaDeContato.size(); i++) {
            if (this.listaDeContato.get(i).getObjData().getMes() == mes) {
                encontrados.add(this.listaDeContato.get(i));
            }
        }
        return encontrados;
    }

    public Contato pesquisarContatoNome(String nome) {
        for (int i = 0; i < this.listaDeContato.size(); i++) {
            if (this.listaDeContato.get(i).getNome().equalsIgnoreCase(nome)) {
                return this.listaDeContato.get(i);
            }
        }
        return null;
    }

    public String mostrarTodosOsContatos() {
        String contatos = "┌-----------------┐\n"
                + "│Lista de contatos│\n"
                + "└-----------------┘\n";
        for (int i = 0; i < this.listaDeContato.size(); i++) {
            contatos += "\n┌---------┐\n"
                    + "│CONTATO " + (i + 1) + "│\n"
                    + "└---------┘" + this.listaDeContato.get(i) + "\n";
        }
        return contatos;
    }

    public boolean verificarCadastro(String nome) {
        for (int i = 0; i < this.listaDeContato.size(); i++) {
            if (this.listaDeContato.get(i).getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n"
                + "Lista de Contato: " + this.mostrarTodosOsContatos();
    }

}
