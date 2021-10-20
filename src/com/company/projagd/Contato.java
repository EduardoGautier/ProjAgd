package com.company.projagd;

public class Contato {
    
    private String nome;
    private String fone;
    private Data objData;



    public Contato(String nome, String fone) {
        this.nome = nome;
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }


    public void setFone(String fone) {
        this.fone = fone;
    }

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
                + "Telefone: " + fone + "\n"
                + "Data: " + objData;
    }

}
