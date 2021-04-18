package Situations;

import models.Pessoa;

public class NaoHabilitado implements Situacao {

    @Override
    public void setSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new PrimeiraDoseHabilitada());
        System.out.println(pessoa.getNome() + " está habilitado(a) para tomar a primeira dose da vacina. \n\n");
    }

    @Override
    public void vacinar(Pessoa pessoa) {
        System.out.println(pessoa.getNome()+ " ainda não está habilitad0(a) para tomar a primeira dose da vacina.\n\n");

    }
    @Override
    public String toString() {
        return "Esta pessoa não está habilitada a tomar a primeira dose da vacina ainda.";
    }
}
