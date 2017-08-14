/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.sofwave.server.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "mensagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensagem.findAll", query = "SELECT m FROM Mensagem m")
    , @NamedQuery(name = "Mensagem.findByEnviada", query = "SELECT m FROM Mensagem m WHERE m.enviada = :enviada")
    , @NamedQuery(name = "Mensagem.findByRecebida", query = "SELECT m FROM Mensagem m WHERE m.recebida = :recebida")
    , @NamedQuery(name = "Mensagem.findByTransmissor", query = "SELECT m FROM Mensagem m WHERE m.mensagemPK.transmissor = :transmissor")
    , @NamedQuery(name = "Mensagem.findByReceptor", query = "SELECT m FROM Mensagem m WHERE m.mensagemPK.receptor = :receptor")})
public class Mensagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MensagemPK mensagemPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "texto")
    private String texto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enviada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enviada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recebida")
    private short recebida;
    @JoinColumn(name = "receptor", referencedColumnName = "prontuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "transmissor", referencedColumnName = "prontuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Mensagem() {
    }

    public Mensagem(MensagemPK mensagemPK) {
        this.mensagemPK = mensagemPK;
    }

    public Mensagem(MensagemPK mensagemPK, String texto, Date enviada, short recebida) {
        this.mensagemPK = mensagemPK;
        this.texto = texto;
        this.enviada = enviada;
        this.recebida = recebida;
    }

    public Mensagem(int transmissor, int receptor) {
        this.mensagemPK = new MensagemPK(transmissor, receptor);
    }

    public MensagemPK getMensagemPK() {
        return mensagemPK;
    }

    public void setMensagemPK(MensagemPK mensagemPK) {
        this.mensagemPK = mensagemPK;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getEnviada() {
        return enviada;
    }

    public void setEnviada(Date enviada) {
        this.enviada = enviada;
    }

    public short getRecebida() {
        return recebida;
    }

    public void setRecebida(short recebida) {
        this.recebida = recebida;
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
        hash += (mensagemPK != null ? mensagemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensagem)) {
            return false;
        }
        Mensagem other = (Mensagem) object;
        if ((this.mensagemPK == null && other.mensagemPK != null) || (this.mensagemPK != null && !this.mensagemPK.equals(other.mensagemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.Mensagem[ mensagemPK=" + mensagemPK + " ]";
    }
    
}
