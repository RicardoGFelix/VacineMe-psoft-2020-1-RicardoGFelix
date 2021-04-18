package Situations;

import models.Pessoa;

public class PrimeiraDoseTomada implements Situacao {

    @Override
    public void setSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new SegundaDoseHabilitada());
        System.out.print(pessoa.getNome() + " está habilitada para tomar a segunda dose da vacina.\n\n");
    }

    @Override
    public void vacinar(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " não está habilitado(a) a tomar a segunda dose da vacina agora.\n\n");
    }

    @Override
    public String toString(){
        return "Esta pessoa tomou a primeira dose da vacina e está na fila de espera para tomar a segunda dose.";
    }
}
