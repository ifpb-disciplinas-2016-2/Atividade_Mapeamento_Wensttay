package br.edu.ifpb.ads.dac.activity.relations.scenario3;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 19:13:07
 */
@Entity
public class Telefone implements Serializable{
    
    @Id
    private long id;
    private String numero;
    
    @Enumerated(EnumType.STRING)
    private TelefoneType tipo;

    public Telefone(String numero, TelefoneType tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Telefone() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneType getTipo() {
        return tipo;
    }

    public void setTipo(TelefoneType tipo) {
        this.tipo = tipo;
    }
    
    
}
