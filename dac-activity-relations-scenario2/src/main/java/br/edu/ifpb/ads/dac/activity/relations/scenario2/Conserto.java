package br.edu.ifpb.ads.dac.activity.relations.scenario2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 17:00:10
 */
@Entity
public class Conserto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private Double valor;
    
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @OneToOne
    private Funcionario funcionario;

    public Conserto() {
    }

    public Conserto(Double valor, Date data, Funcionario funcionario) {
        this.valor = valor;
        this.data = data;
        this.funcionario = funcionario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Conserto{" + "id=" + id + ", valor=" + valor + ", data=" + data + ", funcionario=" + funcionario + '}';
    }
    
}
