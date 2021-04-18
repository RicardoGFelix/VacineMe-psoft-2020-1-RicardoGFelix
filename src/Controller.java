import Situations.*;
import models.Pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Controller {

    private Map<String, Pessoa> pessoasCadastradas;

    private Set<String> comorbidades;

    private Set<String> profissoes;

    private int idadeMinima;

    public Controller(){
        this.pessoasCadastradas = new HashMap<String, Pessoa>();
        this.comorbidades = new TreeSet<String>();
        this.profissoes = new TreeSet<String>();
        this.idadeMinima = 90;
    }
    public void addPessoa(String nome, String cpf, int idade,String endereco, String cartaoSUS, String telefone, String profissao, String comorbidades){
        if(pessoasCadastradas.containsKey(cpf)){
            System.out.println("Esta pessoa já está cadastrada no sistema.\n\n");
        }
        else{

            Pessoa pessoa = new Pessoa(nome, cpf, idade, endereco, cartaoSUS,  telefone,  profissao, comorbidades);
            updateSituacao(pessoa);
            pessoasCadastradas.put(cpf, pessoa);
        }
    }

    public void addComorbidadeHabilitada(String comorbidade){
        this.comorbidades.add(comorbidade);
        updateSituacoes();
    }

    public void addProfissaoHabilitada(String profissao){
        this.profissoes.add(profissao);
        updateSituacoes();
    }

    public void setIdadeMinimaHabilitada(int idade){
        this.idadeMinima = idade;
        updateSituacoes();
    }

    public void setPessoaComorbidades(String cpf, String comorbidades){
        this.pessoasCadastradas.get(cpf).setComorbidades(comorbidades);
    }

    public void setProfissao(String cpf, String profissao){
        this.pessoasCadastradas.get(cpf).setProfissao(profissao);
    }

    public void avancarEtapa(String cpf){
        if(!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("Esta pessoa não está cadastrada no sistema.");
        }else if(isHabilitado(this.pessoasCadastradas.get(cpf))){
            this.pessoasCadastradas.get(cpf).avancarEtapa();
        }else{
            System.out.println("A pessoa não está habilitada para tomar a vacina.");
        }
    }

    public void vacinar(String cpf){
        if(!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("Esta pessoa não está cadastrada no sistema.");
        }else{
            this.pessoasCadastradas.get(cpf).vacinar();
        }
    }

    public void listarPessoasNaoHabilitadas(){
        String result = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof NaoHabilitado) {
                result += pessoa.toString();
            }
        }
        System.out.print(result);
    }

    public void listarPessoasHabilitadasPrimeiraDose(){
        String result = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof PrimeiraDoseHabilitada) {
                result += pessoa.toString();
            }
        }
        System.out.print(result);
    }

    public void listarPessoasVacinadasPrimeiraDose(){
        String result = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof PrimeiraDoseTomada) {
                result += pessoa.toString();
            }
        }
        System.out.print(result);
    }


    public void listarPessoasHabilitadasSegundaDose(){
        String result = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof SegundaDoseHabilitada) {
                result += pessoa.toString();
            }
        }
        System.out.print(result);
    }

    public void listarPessoasImunes(){
        String result = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof Imune) {
                result += pessoa.toString();
            }
        }
        System.out.print(result);
    }

    public void getSituacao(String cpf) {
        if(!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("Esta pessoa não está cadastrada no sistema.\n\n");
        }else{
            System.out.println(this.pessoasCadastradas.get(cpf).toString() + " \n\n");
        }
    }

    public void listarComorbidadesHabilitadas(){
        String result = "Pessoas com estas comorbidades: \n";
        for(String comorbidade : this.comorbidades){
            result += comorbidade + "\n";
        }
        System.out.print(result);
    }

    public void listarProfissoesHabilitadas(){
        String result = "Pessoas destas profissões estão habilitados a tomar a vacina: \n";
        for(String profissao : this.profissoes){
            result += profissao + "\n";
        }
        System.out.print(result);
    }

    public void getIdadeMinimaVacinacao(){
        System.out.println("A idade miníma para vacinação é " + this.idadeMinima + " anos.");
    }

    public void getDetalhes(){
        listarComorbidadesHabilitadas();
        listarProfissoesHabilitadas();
        getIdadeMinimaVacinacao();
    }

    private void updateSituacoes() {
        for (Pessoa pessoa : this.pessoasCadastradas.values()){
            updateSituacao(pessoa);
        }
    }

    private void updateSituacao(Pessoa pessoa) {
        if (pessoa.getSituacao() instanceof NaoHabilitado && isHabilitado(pessoa)){
            pessoa.getSituacao().setSituacao(pessoa);
        }
    }

    private boolean isHabilitado(Pessoa pessoa) {
        if (pessoa.getIdade() >= idadeMinima) return true;
        if ( this.profissoes.contains(pessoa.getProfissao()))return true;
        for(String comorbidade : pessoa.getComorbidades()){
            if(comorbidades.contains(comorbidade))return true;
        }
        return false;

    }

    public Map<String, Pessoa> getPessoasCadastradas() {
        return this.pessoasCadastradas;
    }

    public void setPessoasCadastradas(Map<String, Pessoa> pessoasCadastradas) {
        this.pessoasCadastradas = pessoasCadastradas;
    }

    public Set<String> getComorbidades() {
        return this.comorbidades;
    }

    public void setComorbidades(Set<String> comorbidades) {
        this.comorbidades = comorbidades;
    }

    public Set<String> getProfissoes() {
        return this.profissoes;
    }

    public void setProfissoes(Set<String> profissoes) {
        this.profissoes = profissoes;
    }

    public int getIdadeMinima() {
        return this.idadeMinima;
    }
}
