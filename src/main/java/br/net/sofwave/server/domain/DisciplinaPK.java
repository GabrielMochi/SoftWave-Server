package br.net.sofwave.server.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class DisciplinaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "turma_numero")
    private int turmaNumero;

    public DisciplinaPK() {
    }

    public DisciplinaPK(int id, int turmaNumero) {
        this.id = id;
        this.turmaNumero = turmaNumero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurmaNumero() {
        return turmaNumero;
    }

    public void setTurmaNumero(int turmaNumero) {
        this.turmaNumero = turmaNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) turmaNumero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DisciplinaPK)) {
            return false;
        }
        DisciplinaPK other = (DisciplinaPK) object;
        if (this.id != other.id) {
            return false;
        }
        return this.turmaNumero == other.turmaNumero;
    }

    @Override
    public String toString() {
        return "br.net.sofwave.server.domain.DisciplinaPK[ id=" + id + ", turmaNumero=" + turmaNumero + " ]";
    }
    
}
