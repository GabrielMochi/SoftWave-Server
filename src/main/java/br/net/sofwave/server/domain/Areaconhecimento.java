package br.net.sofwave.server.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "areaconhecimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areaconhecimento.findAll", query = "SELECT a FROM Areaconhecimento a"),
    @NamedQuery(name = "Areaconhecimento.findById", query = "SELECT a FROM Areaconhecimento a WHERE a.id = :id"),
    @NamedQuery(name = "Areaconhecimento.findByNome", query = "SELECT a FROM Areaconhecimento a WHERE a.nome = :nome")
})
public class Areaconhecimento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaconhecimento")
    private Collection<Blog> blogCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaconhecimento")
    private Collection<Comentario> comentarioCollection;

    public Areaconhecimento() {
    }

    public Areaconhecimento(Integer id) {
        this.id = id;
    }

    public Areaconhecimento(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Blog> getBlogCollection() {
        return blogCollection;
    }

    public void setBlogCollection(Collection<Blog> blogCollection) {
        this.blogCollection = blogCollection;
    }

    @XmlTransient
    public Collection<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Areaconhecimento)) {
            return false;
        }
        Areaconhecimento other = (Areaconhecimento) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.Areaconhecimento[ id=" + id + " ]";
    }
    
}
