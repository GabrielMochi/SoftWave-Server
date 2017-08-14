/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.sofwave.server.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
    , @NamedQuery(name = "Comentario.findById", query = "SELECT c FROM Comentario c WHERE c.comentarioPK.id = :id")
    , @NamedQuery(name = "Comentario.findByTexto", query = "SELECT c FROM Comentario c WHERE c.texto = :texto")
    , @NamedQuery(name = "Comentario.findByVisible", query = "SELECT c FROM Comentario c WHERE c.visible = :visible")
    , @NamedQuery(name = "Comentario.findByComentador", query = "SELECT c FROM Comentario c WHERE c.comentarioPK.comentador = :comentador")
    , @NamedQuery(name = "Comentario.findByBlogId", query = "SELECT c FROM Comentario c WHERE c.comentarioPK.blogId = :blogId")
    , @NamedQuery(name = "Comentario.findByReceptor", query = "SELECT c FROM Comentario c WHERE c.comentarioPK.receptor = :receptor")
    , @NamedQuery(name = "Comentario.findByBlogareaConhecimentoid", query = "SELECT c FROM Comentario c WHERE c.comentarioPK.blogareaConhecimentoid = :blogareaConhecimentoid")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComentarioPK comentarioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "texto")
    private String texto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visible")
    private short visible;
    @JoinColumn(name = "blog_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Blog blog;
    @JoinColumn(name = "blog_areaConhecimento_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Areaconhecimento areaconhecimento;
    @JoinColumn(name = "comentador", referencedColumnName = "prontuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "receptor", referencedColumnName = "prontuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Comentario() {
    }

    public Comentario(ComentarioPK comentarioPK) {
        this.comentarioPK = comentarioPK;
    }

    public Comentario(ComentarioPK comentarioPK, String texto, short visible) {
        this.comentarioPK = comentarioPK;
        this.texto = texto;
        this.visible = visible;
    }

    public Comentario(int id, int comentador, int blogId, int receptor, int blogareaConhecimentoid) {
        this.comentarioPK = new ComentarioPK(id, comentador, blogId, receptor, blogareaConhecimentoid);
    }

    public ComentarioPK getComentarioPK() {
        return comentarioPK;
    }

    public void setComentarioPK(ComentarioPK comentarioPK) {
        this.comentarioPK = comentarioPK;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public short getVisible() {
        return visible;
    }

    public void setVisible(short visible) {
        this.visible = visible;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
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

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comentarioPK != null ? comentarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.comentarioPK == null && other.comentarioPK != null) || (this.comentarioPK != null && !this.comentarioPK.equals(other.comentarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.Comentario[ comentarioPK=" + comentarioPK + " ]";
    }
    
}
