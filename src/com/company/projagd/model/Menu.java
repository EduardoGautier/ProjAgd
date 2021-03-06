package com.company.projagd.model;

public class Menu<T> {

    private T objetoMenu;

    public Menu(T objetoMenu) {
        this.objetoMenu = objetoMenu;
    }

    @Override
    public String toString() {
        return objetoMenu + (" ┌----------------------------------------------------------┐\n" +
                " │                       SISTEMA DE AGENDA                  │ \n" +
                " │----------------------------------------------------------│\n" +
                " │ 1 - CADASTRAR CONTATO                                    │\n" +
                " │ 2 - MOSTRAR TODOS OS CONTATOS                            │\n" +
                " │ 3 - MOSTRAR QUANTIDADE DE CONTATOS                       │\n" +
                " │ 4 - PESQUISAR CONTATO POR MÊS                            │\n" +
                " │ 5 - PESQUISAR CONTATO POR CPF                            │\n" +
                " │ 6 - PESQUISAR CONTATO POR NOME                           │\n" +
                " │ 7 - ALTERAR CONTATO                                      │\n" +
                " │ 8 - REMOVER CONTATO  POR NOME                            │\n" +
                " │ 9 - EXCLUIR TODOS OS CONTATOS                            │\n" +
                " │ 0 - SAIR                                                 │\n" +
                " └----------------------------------------------------------┘\n" +
                " Digite a opção desejada:  ");
    }
}
