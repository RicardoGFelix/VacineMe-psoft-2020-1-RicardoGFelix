package Situations;

import models.Pessoa;

public class SegundaDoseHabilitada implements Situacao {

    @Override
    public void setSituacao(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " não pode passar para a próxima etapa do processo de vacinação sem ter tomado a segunda dose da vacina.\n\n");
    }

    @Override
    public void vacinar(Pessoa pessoa) {
        pessoa.setSituacao(new Imune());
        System.out.println(pessoa.getNome() + " tomou a segunda dose da vacina e em alguns dias estará imune.\n\n");
    }

    @Override
    public String toString(){
        return "Esta pessoa está habilitada para tomar a segunda dose da vacina.";
    }
}
