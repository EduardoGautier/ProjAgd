package com.company.projagd.view.model;
public class Menu<T> {

    private T objetoMenu;

    public Menu(T objetoMenu) {
        this.objetoMenu = objetoMenu;
    }



    /*public void exeMenu(){

        System.out.println("┌----------------------------------------------------------┐\n" +
                "│                       SISTEMA DE AGENDA                  │\n" +
                "│----------------------------------------------------------│\n" +
                "│ 1 - CADASTRAR CONTATO                                    │\n" +
                "│ 2 - MOSTRAR TODOS OS CONTATOS                            │\n" +
                "│ 3 - MOSTRAR QUANTIDADE DE CONTATOS                       │\n" +
                "│ 4 - PESQUISAR CONTATO POR MÊS                            │\n" +
                "│ 5 - PESQUISAR CONTATO POR CPF                            │\n" +
                "│ 6 - PESQUISAR CONTATO POR NOME                           │\n" +
                "│ 7 - ALTERAR TELEFONE                                     │\n" +
                "│ 8 - REMOVER CONTATO  POR NOME                            │\n" +
                "│ 9 - EXCLUIR TODOS OS CONTATOS                            │\n" +
                "│ 0 - SAIR                                                 │\n" +
                "└----------------------------------------------------------┘\n" +
                "Digite a opção desejada:  ");

    }*/

    @Override
    public String toString() {
        return " ┌----------------------------------------------------------┐\n" +
                " │                       SISTEMA DE AGENDA                  │ \n" +
                " │----------------------------------------------------------│\n" +
                " │ 1 - CADASTRAR CONTATO                                    │\n" +
                " │ 2 - MOSTRAR TODOS OS CONTATOS                            │\n" +
                " │ 3 - MOSTRAR QUANTIDADE DE CONTATOS                       │\n" +
                " │ 4 - PESQUISAR CONTATO POR MÊS                            │\n" +
                " │ 5 - PESQUISAR CONTATO POR CPF                            │\n" +
                " │ 6 - PESQUISAR CONTATO POR NOME                           │\n" +
                " │ 7 - ALTERAR TELEFONE                                     │\n" +
                " │ 8 - REMOVER CONTATO  POR NOME                            │\n" +
                " │ 9 - EXCLUIR TODOS OS CONTATOS                            │\n" +
                " │ 0 - SAIR                                                 │\n" +
                " └----------------------------------------------------------┘\n" +
                " Digite a opção desejada:  " + objetoMenu;
    }
}

