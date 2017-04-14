package br.edu.ifpb.ads.dac.activity.relations.scenario1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 14:40:24
 */
@Entity
public class Entrada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private Double valor;
    private Double taxa;

    @Enumerated(EnumType.STRING)
    private TipoDeEntrada tipoDeEntrada;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Entrada() {
    }

    public Entrada(Double valor, Double taxa, TipoDeEntrada tipoDeEntrada) {
        this.valor = valor;
        this.taxa = taxa;
        this.tipoDeEntrada = tipoDeEntrada;
        this.date = new Date();
    }

    public TipoDeEntrada getTipoDeEntrada() {
        return tipoDeEntrada;
    }

    public void setTipoDeEntrada(TipoDeEntrada tipoDeEntrada) {
        this.tipoDeEntrada = tipoDeEntrada;
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

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
