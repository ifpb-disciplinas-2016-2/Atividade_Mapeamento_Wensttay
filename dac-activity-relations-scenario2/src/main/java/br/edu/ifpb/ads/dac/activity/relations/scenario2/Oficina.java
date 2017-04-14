package br.edu.ifpb.ads.dac.activity.relations.scenario2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 16:52:03
 */
@Entity
public class Oficina implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nome;
    private Double saldo;
    
    @Embedded
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "oficina_id")
    private List<Funcionario> funcionarios;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "oficina_id")
    private List<Conserto> consertos;

    public Oficina() {
    }

    
    public Oficina(String nome, Endereco endereco) {
        this.saldo = 0.0;
        this.nome = nome;
        this.endereco = endereco;
        this.funcionarios = new ArrayList<>();
        this.consertos = new ArrayList<>();
    }
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionarios() {
        return Collections.unmodifiableList(funcionarios);
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public List<Conserto> getConsertos() {
        return Collections.unmodifiableList(consertos);
    }

    public void addConserto(Conserto conserto) {
        saldo += conserto.getValor();
        this.consertos.add(conserto);
    }

}
