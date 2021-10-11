package com.company.projagd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {




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
        final Contato contato = new Contato();
        contato.setNome(nome);
        System.out.print("Telefone: ");
        contato.setFone(leia.next());

        do {
            System.out.println("┌----------------------------┐\n"
                    + "│Informe a data de nascimento│\n"
                    + "└----------------------------┘");
            System.out.print("Dia: ");
            contato.getObjData().setDia(leia.nextByte());
            System.out.print("Mês: ");
            contato.getObjData().setMes(leia.nextByte());
            System.out.print("Ano: ");
            contato.getObjData().setAno(leia.nextInt());

            if (!(contato.getObjData().validarData())) {
                System.out.println("\nData inválida\nDigite novamente");
            }

        } while (!contato.getObjData().validarData());
        agenda.cadastrarContato(contato);
        Tela.limparTela();
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
        for (int i = 0; i < lista.size(); i++) {
            contatos += "\n┌---------┐\n"
                    + "│CONTATO " + (i + 1) + "│\n"
                    + "└---------┘" + lista.get(i) + "\n";
        }
        System.out.println(contatos);
    }

    private static void mostrarQtdCtt(final Agenda agenda) {

        final List<Contato> lista = agenda.getListaDeContato();

        if (lista.isEmpty()) {
            System.out.println("Não existem contatos registrados");
            return;
        }
        System.out.print("A quantidade de contatos é: " + lista.size());

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

        if (agenda.getListaDeContato().isEmpty()) {
            System.out.println("Não existem contatos cadastrados");
            return Collections.emptyList();
        } else {
            System.out.print("Digite o nome do contato que deseja alterar: ");
            Contato busca = agenda.pesquisarContatoNome(leia.next());
            if (busca == null) {
                System.out.println("Contato não cadastrado");
            } else {
                System.out.print("Digite o novo telefone: ");
                busca.setFone(leia.next());
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
            Tela.limparTela();
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
            Tela.limparTela();
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

        byte op;


        do {

            menu();
            op = leia.nextByte();
            Tela.limparTela();

            switch (op) {

                case 1:
                    cadastrar(agenda);
                    break;
                case 2:
                    exibirContatos(agenda);
                    break;
                case 3:
                    mostrarQtdCtt(agenda);
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

        } while (op != 0);
    }
}
