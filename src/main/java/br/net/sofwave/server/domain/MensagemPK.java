package br.net.sofwave.server.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class MensagemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "transmissor")
    private int transmissor;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "receptor")
    private int receptor;

    public MensagemPK() {
    }

    public MensagemPK(int transmissor, int receptor) {
        this.transmissor = transmissor;
        this.receptor = receptor;
    }

    public int getTransmissor() {
        return transmissor;
    }

    public void setTransmissor(int transmissor) {
        this.transmissor = transmissor;
    }

    public int getReceptor() {
        return receptor;
    }

    public void setReceptor(int receptor) {
        this.receptor = receptor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) transmissor;
        hash += (int) receptor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MensagemPK)) {
            return false;
        }
        MensagemPK other = (MensagemPK) object;
        if (this.transmissor != other.transmissor) {
            return false;
        }
        return this.receptor == other.receptor;
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.MensagemPK[ transmissor=" + transmissor + ", receptor=" + receptor + " ]";
    }
    
}
