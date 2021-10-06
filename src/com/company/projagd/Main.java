package com.company.projagd;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Agenda objAgenda = new Agenda();

        ArrayList<Contato> lista = objAgenda.getListaDeContato();

        byte op;

        do {
            System.out.print("\n┌----------------------------------------------------------┐\n"
                    + "│                       SISTEMA DE AGENDA                  │\n"
                    + "│----------------------------------------------------------│\n"
                    + "│ 1 - CADASTRAR CONTATO                                    │\n"
                    + "│ 2 - MOSTRAR TODOS OS CONTATOS                            │\n"
                    + "│ 3 - MOSTRAR QUANTIDADE DE CONTATOS                       │\n"
                    + "│ 4 - PESQUISAR ANIVERSARIANTES DO MÊS                     │\n"
                    + "│ 5 - PESQUISAR CONTATO POR NOME                           │\n"
                    + "│ 6 - ALTERAR TELEFONE DO CONTATO PESQUISANDO POR NOME     │\n"
                    + "│ 7 - REMOVER CONTATO PESQUISANDO POR NOME                 │\n"
                    + "│ 8 - EXCLUIR TODOS OS CONTATOS                            │\n"
                    + "│ 0 - SAIR                                                 │\n"
                    + "└----------------------------------------------------------┘\n"
                    + "Digite a opção desejada:  ");
            op = leia.nextByte();
            Tela.limparTela();

            switch (op) {
                case 1:
                    Contato objContato = new Contato();
                    String nome;
                    boolean nomeExiste;

                    do {
                        System.out.println("┌---------------------------┐\n"
                                + "│Informe os dados do contato│\n"
                                + "└---------------------------┘");
                        System.out.print("Primeiro Nome: ");
                        nome = leia.next();

                        nomeExiste = objAgenda.verificarCadastro(nome);

                        if (nomeExiste) {
                            System.out.println("\nJá existe um contato com esse nome!\nInicie novamente o cadastro");
                        }
                    } while (nomeExiste);
                    objContato.setNome(nome);
                    System.out.print("Telefone: ");
                    objContato.setFone(leia.next());

                    do {
                        System.out.println("┌----------------------------┐\n"
                                + "│Informe a data de nascimento│\n"
                                + "└----------------------------┘");
                        System.out.print("Dia: ");
                        objContato.getObjData().setDia(leia.nextByte());
                        System.out.print("Mês: ");
                        objContato.getObjData().setMes(leia.nextByte());
                        System.out.print("Ano: ");
                        objContato.getObjData().setAno(leia.nextInt());

                        if (objContato.getObjData().validarData()) {
                        } else {
                            System.out.println("\nData inválida\nDigite novamente");
                        }

                    } while (!objContato.getObjData().validarData());
                    lista.add(objContato);
                    Tela.limparTela();
                    break;
                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("Não existem contatos registrados");
                    } else {
                        System.out.print(objAgenda.mostrarTodosOsContatos());
                    }
                    break;
                case 3:
                    if (lista.isEmpty()) {
                        System.out.println("Não existem contatos registrados");
                    } else {
                        System.out.print("A quantidade de contatos é: " + lista.size());
                    }
                    break;
                case 4:
                    if (lista.isEmpty()) {
                        System.out.println("Não existem contatos cadastrados");
                    } else {
                        System.out.print("Digite o mês do aniversariante que deseja procurar: ");
                        ArrayList<Contato> resultadoDoPesquisarPorMes = objAgenda.pesquisarAniversarianteMes(leia.nextByte());

                        if (resultadoDoPesquisarPorMes == null) {
                            System.out.println("Nenhum aniversariante encontrado");
                        } else {
                            System.out.println("Lista de aniversariantes encontrados: " + resultadoDoPesquisarPorMes);
                        }
                    }
                    break;
                case 5:
                case 6:
                case 7:
                    if (lista.isEmpty()) {
                        System.out.println("Não existem contatos cadastrados");
                    } else {
                        System.out.print("Digite o nome do contato que deseja: ");
                        Contato busca = objAgenda.pesquisarContatoNome(leia.next());
                        if (busca == null) {
                            System.out.println("Contato não cadastrado");
                        } else {
                            System.out.println("O contato é: " + busca);
                            if (op == 6) {
                                System.out.print("Digite o novo telefone: ");
                                busca.setFone(leia.next());
                            } else if (op == 7) {
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
                                            lista.remove(busca);
                                            System.out.println("O contato foi excluído com sucesso!");
                                            break;
                                        case 2:
                                            System.out.println("Exclusão cancelada");
                                            break;
                                        default:
                                            System.out.println("Opção inválida\nDigite novamente");
                                    }
                                } while (op < 1 || op > 2);
                            }
                        }
                    }
                    break;
                case 8:
                    if (lista.isEmpty()) {
                        System.out.println("Não existem contatos a serem excluídos");
                    } else {
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
                                    lista.clear();
                                    System.out.println("Dados dos contatos excluídos com sucesso!");
                                    break;
                                case 2:
                                    System.out.println("Exclusão cancelada");
                                    break;
                                default:
                                    System.out.println("Opção inválida\nDigite novamente");
                            }
                        } while (op < 1 || op > 2);

                    }
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
