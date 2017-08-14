package br.net.sofwave.server.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ComentarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "comentador")
    private int comentador;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "blog_id")
    private int blogId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "receptor")
    private int receptor;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "blog_areaConhecimento_id")
    private int blogareaConhecimentoid;

    public ComentarioPK() {
    }

    public ComentarioPK(int id, int comentador, int blogId, int receptor, int blogareaConhecimentoid) {
        this.id = id;
        this.comentador = comentador;
        this.blogId = blogId;
        this.receptor = receptor;
        this.blogareaConhecimentoid = blogareaConhecimentoid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComentador() {
        return comentador;
    }

    public void setComentador(int comentador) {
        this.comentador = comentador;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getReceptor() {
        return receptor;
    }

    public void setReceptor(int receptor) {
        this.receptor = receptor;
    }

    public int getBlogareaConhecimentoid() {
        return blogareaConhecimentoid;
    }

    public void setBlogareaConhecimentoid(int blogareaConhecimentoid) {
        this.blogareaConhecimentoid = blogareaConhecimentoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) comentador;
        hash += (int) blogId;
        hash += (int) receptor;
        hash += (int) blogareaConhecimentoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ComentarioPK)) {
            return false;
        }
        ComentarioPK other = (ComentarioPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.comentador != other.comentador) {
            return false;
        }
        if (this.blogId != other.blogId) {
            return false;
        }
        if (this.receptor != other.receptor) {
            return false;
        }
        return this.blogareaConhecimentoid == other.blogareaConhecimentoid;
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.ComentarioPK[ id=" + id + ", comentador=" + comentador + ", blogId=" + blogId + ", receptor=" + receptor + ", blogareaConhecimentoid=" + blogareaConhecimentoid + " ]";
    }
    
}
