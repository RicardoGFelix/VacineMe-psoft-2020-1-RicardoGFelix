package models;

import Situations.NaoHabilitado;
import Situations.PrimeiraDoseHabilitada;
import Situations.Situacao;

import java.util.Set;
import java.util.TreeSet;

public class Pessoa {

    private String nome;
    private String cpf;
    private int idade;
    private String endereco;
    private String cartaoSUS;
    private String telefone;
    private String profissao;
    private Set<String> comorbidades;
    private Situacao situacao;

    public Pessoa(String nome, String cpf, int idade, String endereco, String cartaoSUS, String telefone, String profissao, String comorbidades) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
        this.cartaoSUS = cartaoSUS;
        this.telefone = telefone;
        this.profissao = profissao;
        this.situacao = new NaoHabilitado();
        setComorbidades(comorbidades);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCartaoSUS() {
        return this.cartaoSUS;
    }

    public void setCartaoSUS(String cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Set<String> getComorbidades() {
        return this.comorbidades;
    }

    public void addComorbidade(String comorbidade) {
        this.comorbidades.add(comorbidade);
    }

    public void setComorbidades(String comorbidades){
        Set<String> aux = new TreeSet<String>();
        for (String comorbidade : comorbidades.split(" ")){
            aux.add(comorbidade);
        }
        this.comorbidades = aux;
    }

    public void setSituacao(Situacao situacao){
        this.situacao = situacao;
    }
    public String getSituacaoTextual(){
        return this.nome + "se encontra na situação: " + this.situacao.toString() + "\n\n";
    }
    public Situacao getSituacao(){
        return this.situacao;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int idade){
        this.idade =idade;
    }

    public void avancarEtapa(){
        this.situacao.setSituacao(this);
    }
    public void vacinar(){
        this.situacao.vacinar(this);
    }
    @Override
    public String toString(){
        return this.nome + "\n" +
                "CPF: " + this.cpf + "\n" +
                "Endereço: " + this.endereco + "\n" +
                "Situação: " + this.situacao.toString() + "\n";
    }
}
