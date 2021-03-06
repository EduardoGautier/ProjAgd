package com.company.projagd.model;


/**
 * @author Eduardo Jose Gautier
 *
 */


public class Data {

    private byte dia;
    private byte mes;
    private int ano;

    public Data(final int dia, final int mes, final int ano) {
        if (!(validarData(dia, mes, ano))) {
            throw new RuntimeException("Data Inválida!");
        }
        this.ano = ano;
        this.mes = (byte) mes;
        this.dia = (byte) dia;
    }

    public static boolean validarData(final int dia, final int mes, final int ano) {
        return ((dia >= 1 && mes >= 1 && mes <= 12 && ano > 0) && ((((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia <= 31)) || (mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia <= 30)) || (((mes == 2) && (dia <= 28)) || ((mes == 2 && dia <= 29) && (ano % 4 == 0)) && ((ano % 100 != 0) || (ano % 400 == 0)))));
    }


    public byte getMes() {
        return mes;
    }



    @Override
    public String toString() {
        return +dia + "/" + mes + "/" + ano;
    }


}