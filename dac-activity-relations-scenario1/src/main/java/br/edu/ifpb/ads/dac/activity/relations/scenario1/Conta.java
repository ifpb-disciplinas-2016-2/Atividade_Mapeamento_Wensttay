package br.edu.ifpb.ads.dac.activity.relations.scenario1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 09:20:09
 */
@Entity
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long codigo;
    private String numero;
    private String agencia;
    private String digitoAgencia;
    private String digitoConta;
    private String senha;
    private Double saldo;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<Entrada> entradas;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    public List<Entrada> getEntradas() {
        return Collections.unmodifiableList(entradas);
    }

    public Conta() {
        entradas = new ArrayList<>();
    }

    public boolean addEntrada(Entrada entrada) {
        return this.entradas.add(entrada);
    }
    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getDigitoAgencia() {
        return digitoAgencia;
    }

    public void setDigitoAgencia(String digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    public String getDigitoConta() {
        return digitoConta;
    }

    public void setDigitoConta(String digitoConta) {
        this.digitoConta = digitoConta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Conta{" + "codigo=" + codigo + ", numero=" + numero + ", agencia=" + agencia + ", digitoAgencia=" + digitoAgencia + ", digitoConta=" + digitoConta + ", senha=" + senha + ", saldo=" + saldo + ", tipo=" + tipo + '}';
    }

}
