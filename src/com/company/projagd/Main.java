package com.company.projagd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static boolean autentication() {

        Scanner leia = new Scanner(System.in);
        Seguranca seguranca = new Seguranca();
        do {

            System.out.println("Usuario: ");
            String usuario = leia.nextLine();

            System.out.println("Senha: ");
            String senha = leia.nextLine();


            if (seguranca.autenticar(usuario, senha) == false) {
                System.out.println("\nUsuario ou senha Invalidos!\nDigite Novamente!\n");
                continue;
            }

            System.out.println("Usuario autenticado com sucesso!");
            break;

        } while (true);

        return true;
    }


    private static void menu() {


        System.out.print("\n┌----------------------------------------------------------┐\n"
                + "│                       SISTEMA DE AGENDA                  │\n"
                + "│----------------------------------------------------------│\n"
                + "│ 1 - CADASTRAR CONTATO                                    │\n"
                + "│ 2 - MOSTRAR TODOS OS CONTATOS                            │\n"
                + "│ 3 - MOSTRAR QUANTIDADE DE CONTATOS                       │\n"
                + "│ 4 - PESQUISAR ANIVERSARIANTES DO MÊS                     │\n"
                + "│ 5 - PESQUISAR ANIVERSARIANTES DO NOME                    │\n"
                + "│ 6 - ALTERAR TELEFONE                                     │\n"
                + "│ 7 - REMOVER CONTATO  POR NOME                            │\n"
                + "│ 8 - EXCLUIR TODOS OS CONTATOS                            │\n"
                + "│ 0 - SAIR                                                 │\n"
                + "└----------------------------------------------------------┘\n"
                + "Digite a opção desejada:  ");
    }

    private static Contato cadastrar(final Agenda agenda) {

        Scanner leia = new Scanner(System.in);
        String nome;


        do {
            System.out.println("┌---------------------------┐\n"
                    + "│Informe os dados do contato│\n"
                    + "└---------------------------┘");
            System.out.print("Primeiro Nome: ");
            nome = leia.nextLine();
            if (agenda.verificarCadastro(nome)) {
                System.out.println("\nJá existe um contato com esse nome!\nInicie novamente o cadastro");
                continue;
            }
            break;
        } while (true);

        System.out.print("Telefone: ");
        final String fone = leia.next();

        final Contato contato = new Contato(nome, fone);

        do {
            System.out.println("┌----------------------------┐\n"
                    + "│Informe a data de nascimento│\n"
                    + "└----------------------------┘");
            System.out.print("Dia: ");
            final int dia = leia.nextByte();
            System.out.print("Mês: ");
            final int mes = leia.nextByte();
            System.out.print("Ano: ");
            final int ano = leia.nextInt();
            if (!(Data.validarData(dia, mes, ano))) {
                System.out.println("\nData inválida\nDigite novamente");
                continue;
            }
            contato.setObjData(new Data(dia, mes, ano));
            break;
        } while (true);
        agenda.cadastrarContato(contato);
        return contato;
    }

    private static void exibirContatos(final Agenda agenda) {

        final List<Contato> lista = agenda.getListaDeContato();

        if (lista.isEmpty()) {
            System.out.println("Não existem contatos registrados");
            return;
        }
        String contatos = "┌-----------------┐\n"
                + "│Lista de contatos│\n"
                + "└-----------------┘\n";
        for (Contato contato : lista) {
            contatos += "\n┌---------┐\n"
                    + "│CONTATO  " + "│\n"
                    + "└---------┘" + contato + "\n";
        }
        System.out.println(contatos);
    }

    private static void mostrarQtdContatos(final Agenda agenda) {

        final List<Contato> lista = agenda.getListaDeContato();

        if (lista.isEmpty()) {
            System.out.println("Não existem contatos registrados");
            return;
        }

        System.out.print("A quantidade de contatos é: " + agenda.mostrarQtdContatos());


    }


    private static List<Contato> pesquisarContatoPorMes(final Agenda agenda) {

        Scanner leia = new Scanner(System.in);

        if (agenda.getListaDeContato().isEmpty()) {
            System.out.println("Não existem contatos cadastrados");
            return Collections.emptyList();
        }
        System.out.print("Digite o mês do aniversariante que deseja procurar: ");
        List<Contato> resultadoDoPesquisarPorMes = agenda.pesquisarAniversarianteMes(leia.nextByte());

        if (resultadoDoPesquisarPorMes.isEmpty()) {
            System.out.println("Nenhum aniversariante encontrado");
        } else {
            System.out.println("Lista de aniversariantes encontrados: " + resultadoDoPesquisarPorMes);
        }
        return resultadoDoPesquisarPorMes;

    }

    private static List<Contato> pesquisarContatoPorNome(final Agenda agenda) {
        Scanner leia = new Scanner(System.in);

        if (agenda.getListaDeContato().isEmpty()) {
            System.out.println("Não existem contatos cadastrados");
            return Collections.emptyList();
        } else {
            System.out.print("Digite o nome do contato que deseja: ");
            Contato busca = agenda.pesquisarContatoNome(leia.next());
            if (busca == null) {
                System.out.println("Contato não cadastrado");
            } else {
                System.out.println("O contato é: " + busca);

            }
        }
        return new ArrayList<>(0);
    }


    private static List<Contato> alterarContatoPorNome(final Agenda agenda) {
        Scanner leia = new Scanner(System.in);
        String fone;
        if (agenda.getListaDeContato().isEmpty()) {
            System.out.println("Não existem contatos cadastrados");
            return Collections.emptyList();
        } else {
            System.out.print("Digite o nome do contato que deseja alterar: ");
            Contato busca = agenda.alteraracaoContatoPorNome(leia.nextLine());
            if (busca == null) {
                System.out.println("Contato não cadastrado");
            } else {

                System.out.print("Digite o novo telefone: ");
                busca.setFone(leia.next());
                System.out.println("Telefone Alterado Com Sucesso");
            }
        }
        return new ArrayList<>(0);
    }


    private static void excluirContatoPorNome(final Agenda agenda) {
        Scanner leia = new Scanner(System.in);

        byte op;

        if (agenda.getListaDeContato().isEmpty()) {
            System.out.println("Não existem contatos cadastrados");
            return;
        }
        System.out.print("Digite o nome do contato que deseja excluir: ");
        Contato busca = agenda.pesquisarContatoNome(leia.next());
        if (busca == null) {
            System.out.println("Contato não cadastrado");
            return;
        }
        do {
            System.out.print("┌-------------------┐\n"
                    + "│EXCLUSÃO DO CONTATO│\n"
                    + "└-------------------┘\n"
                    + "Você tem certeza que deseja excluir o contato?\n"
                    + "[1] - Sim\n"
                    + "[2] - Não\n"
                    + "Digite aqui a opção: ");
            op = leia.nextByte();
            switch (op) {
                case 1:
                    agenda.removerContato(busca);
                    System.out.println("O contato foi excluído com sucesso!");
                    break;
                case 2:
                    System.out.println("Exclusão cancelada");
                    break;
                default:
                    System.out.println("Opção inválida\nDigite novamente");
            }
        } while (op != 1 && op != 2);
    }


    private static void excluirTodosContatos(final Agenda agenda) {

        Scanner leia = new Scanner(System.in);

        List<Contato> lista = agenda.getListaDeContato();

        byte op;

        if (lista.isEmpty()) {
            System.out.println("Não existem contatos a serem excluídos");
            return;
        }
        do {
            System.out.print("┌-------------------┐\n"
                    + "│EXCLUSÃO DO CONTATO│\n"
                    + "└-------------------┘\n"
                    + "Você tem certeza que deseja excluir todos os contatos?\n"
                    + "[1] - Sim\n"
                    + "[2] - Não\n"
                    + "Digite aqui a opção: ");
            op = leia.nextByte();
            switch (op) {
                case 1:
                    agenda.limparListaContato();
                    System.out.println("Dados dos contatos excluídos com sucesso!");
                    break;
                case 2:
                    System.out.println("Exclusão cancelada");
                    break;
                default:
                    System.out.println("Opção inválida\nDigite novamente");
            }
        } while (op != 1 && op != 2);

    }


    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        final Agenda agenda = new Agenda();

        byte op = 1;

        final boolean authenticated = autentication();

        while (authenticated && op != 0) {
            menu();
            op = leia.nextByte();


            switch (op) {

                case 1:

                    cadastrar(agenda);

                    break;
                case 2:

                    exibirContatos(agenda);

                    break;
                case 3:

                    mostrarQtdContatos(agenda);

                    break;
                case 4:

                    pesquisarContatoPorMes(agenda);

                    break;
                case 5:

                    pesquisarContatoPorNome(agenda);

                    break;
                case 6:

                    alterarContatoPorNome(agenda);

                    break;
                case 7:

                    excluirContatoPorNome(agenda);

                    break;
                case 8:

                    excluirTodosContatos(agenda);

                    break;
                case 0:

                    System.out.println("SISTEMA ENCERRADO");
                    break;
                default:
                    System.out.println("Opção inválida\nDigite novamente");
            }
        }
    }
}
