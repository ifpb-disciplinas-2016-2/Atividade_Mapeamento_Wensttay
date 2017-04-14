package br.edu.ifpb.ads.dac.activity.relations.scenario3;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 19:11:53
 */
@Entity
@DiscriminatorValue("ALUNO")
public class Aluno extends Pessoa {

    private String matricula;

    @Temporal(TemporalType.DATE)
    private Date dataIngresso;
    private String turma;

    public Aluno() {
    }

    public Aluno(String matricula, Date dataIngresso, String turma, String nome, String cpf, int idade, Date dataDeNascimento, Endereco endereco) {
        super(nome, cpf, idade, dataDeNascimento, endereco);
        this.matricula = matricula;
        this.dataIngresso = dataIngresso;
        this.turma = turma;
    }    
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

}
