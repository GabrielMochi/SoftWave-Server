/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.sofwave.server.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class BlogPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_prontuario")
    private int usuarioProntuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "areaConhecimento_id")
    private int areaConhecimentoid;

    public BlogPK() {
    }

    public BlogPK(int id, int usuarioProntuario, int areaConhecimentoid) {
        this.id = id;
        this.usuarioProntuario = usuarioProntuario;
        this.areaConhecimentoid = areaConhecimentoid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioProntuario() {
        return usuarioProntuario;
    }

    public void setUsuarioProntuario(int usuarioProntuario) {
        this.usuarioProntuario = usuarioProntuario;
    }

    public int getAreaConhecimentoid() {
        return areaConhecimentoid;
    }

    public void setAreaConhecimentoid(int areaConhecimentoid) {
        this.areaConhecimentoid = areaConhecimentoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) usuarioProntuario;
        hash += (int) areaConhecimentoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BlogPK)) {
            return false;
        }
        BlogPK other = (BlogPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.usuarioProntuario != other.usuarioProntuario) {
            return false;
        }
        if (this.areaConhecimentoid != other.areaConhecimentoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.BlogPK[ id=" + id + ", usuarioProntuario=" + usuarioProntuario + ", areaConhecimentoid=" + areaConhecimentoid + " ]";
    }
    
}
