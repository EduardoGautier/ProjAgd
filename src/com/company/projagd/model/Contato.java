package com.company.projagd.model;
/**
 * @author Eduardo Jose Gautier
 *
 */


public class Contato<T> {

    private String nome;
    private String cpf;
    private String fone;
    private Data objData;



    public Contato(String nome,String cpf, String fone) {
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setNome(String nome) { this.nome = nome; }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public Data getObjData() {
        return objData;
    }

    public void setObjData(Data objData) {
        this.objData = objData;
    }

    @Override
    public String toString() {
        return "\n"
                + "Nome: " + nome + "\n"
                + "CPF: " + cpf + "\n"
                + "Telefone: " + fone + "\n"
                + "Data: " + objData;
    }

}
