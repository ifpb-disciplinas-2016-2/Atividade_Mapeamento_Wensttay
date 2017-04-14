package br.edu.ifpb.ads.dac.activity.relations.scenario3;

import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 19:12:00
 */
@Entity
@DiscriminatorValue("PROFESSOR")
public class Professor extends Pessoa{
    private Double salario;
    
    @OneToMany
    @JoinColumn(name = "professor_id")
    private List<Telefone> telefone;

    public Professor() {
    }

    public Professor(Double salario, List<Telefone> telefone, String nome, String cpf, int idade, Date dataDeNascimento, Endereco endereco) {
        super(nome, cpf, idade, dataDeNascimento, endereco);
        this.salario = salario;
        this.telefone = telefone;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }
    
    
}
