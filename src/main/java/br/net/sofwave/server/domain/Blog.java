package br.net.sofwave.server.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "blog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blog.findAll", query = "SELECT b FROM Blog b"),
    @NamedQuery(name = "Blog.findById", query = "SELECT b FROM Blog b WHERE b.blogPK.id = :id"),
    @NamedQuery(name = "Blog.findByTitulo", query = "SELECT b FROM Blog b WHERE b.titulo = :titulo"),
    @NamedQuery(name = "Blog.findByVisible", query = "SELECT b FROM Blog b WHERE b.visible = :visible"),
    @NamedQuery(name = "Blog.findByUsuarioProntuario", query = "SELECT b FROM Blog b WHERE b.blogPK.usuarioProntuario = :usuarioProntuario"),
    @NamedQuery(name = "Blog.findByAreaConhecimentoid", query = "SELECT b FROM Blog b WHERE b.blogPK.areaConhecimentoid = :areaConhecimentoid")
})
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected BlogPK blogPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2048)
    @Column(name = "titulo")
    private String titulo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "visible")
    private short visible;
    
    @JoinColumn(name = "areaConhecimento_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Areaconhecimento areaconhecimento;
    
    @JoinColumn(name = "usuario_prontuario", referencedColumnName = "prontuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blog")
    private Collection<Comentario> comentarioCollection;

    public Blog() {
    }

    public Blog(BlogPK blogPK) {
        this.blogPK = blogPK;
    }

    public Blog(BlogPK blogPK, String titulo, short visible) {
        this.blogPK = blogPK;
        this.titulo = titulo;
        this.visible = visible;
    }

    public Blog(int id, int usuarioProntuario, int areaConhecimentoid) {
        this.blogPK = new BlogPK(id, usuarioProntuario, areaConhecimentoid);
    }

    public BlogPK getBlogPK() {
        return blogPK;
    }

    public void setBlogPK(BlogPK blogPK) {
        this.blogPK = blogPK;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public short getVisible() {
        return visible;
    }

    public void setVisible(short visible) {
        this.visible = visible;
    }

    public Areaconhecimento getAreaconhecimento() {
        return areaconhecimento;
    }

    public void setAreaconhecimento(Areaconhecimento areaconhecimento) {
        this.areaconhecimento = areaconhecimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (blogPK != null ? blogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Blog)) {
            return false;
        }
        Blog other = (Blog) object;
        return !((this.blogPK == null && other.blogPK != null) || (this.blogPK != null && !this.blogPK.equals(other.blogPK)));
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.Blog[ blogPK=" + blogPK + " ]";
    }
    
}
