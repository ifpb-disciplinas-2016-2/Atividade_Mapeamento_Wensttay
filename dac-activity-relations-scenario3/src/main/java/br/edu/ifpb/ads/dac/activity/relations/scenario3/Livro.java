package br.edu.ifpb.ads.dac.activity.relations.scenario3;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 19:11:35
 */
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String titulo;
    private String ISBN;
    
    @Temporal(TemporalType.DATE)
    private Date lancamento;
    
    @ManyToMany(mappedBy = "livros")
    private List<Autor> autors;

    public Livro() {
    }

    public Livro(String titulo, String ISBN, Date lancamento, List<Autor> autors) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.lancamento = lancamento;
        this.autors = autors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public List<Autor> getAutors() {
        return autors;
    }

    public void setAutors(List<Autor> autors) {
        this.autors = autors;
    }
    
}
