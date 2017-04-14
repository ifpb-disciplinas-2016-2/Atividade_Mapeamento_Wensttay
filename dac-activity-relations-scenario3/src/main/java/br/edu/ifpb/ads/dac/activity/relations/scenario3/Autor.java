package br.edu.ifpb.ads.dac.activity.relations.scenario3;

import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 19:11:29
 */
@Entity
@DiscriminatorValue("AUTOR")
public class Autor extends Pessoa {

    private String instituicaoVinculada;

    @ManyToMany
    private List<Livro> livros;

    public Autor() {
    }

    public Autor(String instituicaoVinculada, List<Livro> livros, String nome, String cpf, int idade, Date dataDeNascimento, Endereco endereco) {
        super(nome, cpf, idade, dataDeNascimento, endereco);
        this.instituicaoVinculada = instituicaoVinculada;
        this.livros = livros;
    }

    public String getInstituicaoVinculada() {
        return instituicaoVinculada;
    }

    public void setInstituicaoVinculada(String instituicaoVinculada) {
        this.instituicaoVinculada = instituicaoVinculada;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
