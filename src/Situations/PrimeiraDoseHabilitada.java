package Situations;

import models.Pessoa;

public class PrimeiraDoseHabilitada implements Situacao {

    @Override
    public void setSituacao(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " não pode passar para a próxima etapa do processo de vacinação sem ter tomado a primeira dose da vacina.\n\n");
    }

    @Override
    public void vacinar(Pessoa pessoa) {
        pessoa.setSituacao(new PrimeiraDoseTomada());
        System.out.println(pessoa.getNome() + " tomou a primeira dose da vacina e em alguns dias estará habilitada a tomar a segunda dose.\n\n");

    }

    @Override
    public String toString(){
        return "Esta pessoa está habilitada a tomar a primiera dose da vacina.";
    }
}
