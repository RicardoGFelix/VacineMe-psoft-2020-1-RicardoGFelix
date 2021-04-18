package Situations;

import models.Pessoa;

public class Imune implements Situacao {

    @Override
    public void setSituacao(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " finalizou seu processo de vacinação e está imune.\n\n");
    }

    @Override
    public void vacinar(Pessoa pessoa) {
        System.out.println("A pessoa já finalizou seu processo de vacinação.\n\n");
    }

    @Override
    public String toString(){
        return "Esta pessoa está imune.";
    }
}
